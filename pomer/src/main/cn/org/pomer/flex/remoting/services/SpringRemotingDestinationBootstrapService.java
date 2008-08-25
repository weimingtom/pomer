package cn.org.pomer.flex.remoting.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.org.pomer.flex.remoting.annotation.RemoteObject;

import flex.messaging.config.ConfigMap;
import flex.messaging.services.AbstractBootstrapService;
import flex.messaging.services.Service;


/**
 * 动态产生flex远程对象，不需要在配置件里配置
 * @author linlinyu badqiu
 *
 */
public class SpringRemotingDestinationBootstrapService extends AbstractBootstrapService {

    public static final String DEFAULT_INCLUDE_END_WITHS = "FlexService";
    
	private String channel;
	private String securityConstraint;
	private String scope;
	private String adapter;
	private String factory;
	private String serviceId;
	private String includeEndsWith;
	/**
     * 被MessageBroker调用
     * @param id Id of the <code>AbstractBootstrapService</code>.
     * @param properties Properties for the <code>AbstractBootstrapService</code>. 
     */
    public void initialize(String id, ConfigMap properties)
    {
    	serviceId = properties.getPropertyAsString("service-id", "remoting-service");
		factory = properties.getPropertyAsString("factory", "spring");
		adapter = properties.getProperty("adapter");
		scope = properties.getProperty("scope");
		securityConstraint = properties.getProperty("security-constraint");
		channel = properties.getProperty("channel");
		
		includeEndsWith = properties.getPropertyAsString("includeEndsWith",DEFAULT_INCLUDE_END_WITHS);
		
		Service remotingService = broker.getService(serviceId);
		if(remotingService == null) {
			throw new RuntimeException("not found Service with serviceId:"+serviceId);
		}
    	
        createSpringDestinations(remotingService);
    }

	private void createSpringDestinations(Service remotingService) {
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(broker.getInitServletContext());
		List<String> addedBeanNames = new ArrayList();
		for(String beanName : wac.getBeanDefinitionNames()) {
			Class type = wac.getType(beanName);
			boolean isCreateSpringDestination = type.isAnnotationPresent(RemoteObject.class) 
										|| beanName.endsWith(includeEndsWith) 
										|| isCreateDestination(beanName,type);
			
			if(isCreateSpringDestination) {
				createSpringDestination(remotingService, beanName);
				addedBeanNames.add(beanName);
				System.out.println("====Remote Serivce: " + beanName);
			}
		}
		System.out.println("[Auto Export Spring to RemotingDestination],beans="+addedBeanNames);
	}

	protected boolean isCreateDestination(String beanName,Class bean) {
		return false;
	}

    
	protected void createSpringDestination(Service service, String destinationId) {
		flex.messaging.services.remoting.RemotingDestination destination = (flex.messaging.services.remoting.RemotingDestination)service.createDestination(destinationId);
        
        destination.setSource(destinationId);
        destination.setFactory(factory);
        
        if(adapter != null) 
        	destination.createAdapter(adapter);
        if(scope != null) 
        	destination.setScope(scope);
        if(securityConstraint != null)
        	destination.setSecurityConstraint(securityConstraint);
        if(channel != null)
        	destination.addChannel(channel);
        
        service.addDestination(destination);
	}

   
    public void start()
    {
        // No-op        
    }

    
    public void stop()
    {
        // No-op        
    }

}
