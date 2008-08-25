/*
 * @(#)bb	Aug 23, 2008
 *
 * Copyright 2008 Pomer, All rights reserved.
 * Pomer PROPRIETARY/CONFIDENTIAL. 
 */

package cn.org.pomer.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Struts 2.0 基类
 * @author Linlin Yu
 * @version 1.0
 */
public class ActionBase extends ActionSupport {

	private static final long serialVersionUID = 3698315130345644448L;

	protected static Log logger = LogFactory.getLog(ActionBase.class);

	public ActionBase() {
	}

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	protected void outJsonResponse(String jsonStr) {
		HttpServletResponse response = getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.write(jsonStr);
		} catch (IOException e) {
			logger.error(e);
			throw new RuntimeException(e);
		}
	}

	

	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	protected String getParameter(String para) {
		String value = getRequest().getParameter(para);
		if (StringUtils.isNotEmpty(value)) {
			return value.trim();
		} else {
			return "";
		}
	}

	protected Long getLongParameter(String para) {
		String value = getParameter(para);
		if ("".equals(value)) {
			return null;
		} else {
			return Long.valueOf(value);
		}
	}

	protected Integer getIntParameter(String paraName) {
		String value = getParameter(paraName);
		if ("".equals(value)) {
			return null;
		} else {
			return Integer.valueOf(value);
		}
	}

	protected Boolean getBooleanParameter(String paraName) {
		String value = getParameter(paraName);
		if ("".equals(paraName)) {
			return false;
		} else {
			return Boolean.valueOf(paraName);
		}
	}

//	protected Object getBean(String name) {
//		ApplicationContext ctx = WebApplicationContextUtils
//				.getRequiredWebApplicationContext(ServletActionContext
//						.getServletContext());
//		return ctx.getBean(name);
//	}
//
//	
//
//	protected User getLoginUser() {
//		return WebContext.getCurrentLoginUser();
//	}
}
