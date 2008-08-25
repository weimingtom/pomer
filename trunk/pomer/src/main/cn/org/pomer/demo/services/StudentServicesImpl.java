package cn.org.pomer.demo.services;

import org.springframework.stereotype.Component;

import cn.org.pomer.demo.dao.StudentDao;
import cn.org.pomer.flex.remoting.annotation.RemoteObject;

@Component
@RemoteObject
public class StudentServicesImpl implements StudentServices {
	protected StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public String hello(String name) {
		return "hello " + name;
	}

}
