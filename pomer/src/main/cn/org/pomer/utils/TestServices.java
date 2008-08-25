package cn.org.pomer.utils;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import cn.org.pomer.PageList;
import cn.org.pomer.demo.entity.Student;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService
public class TestServices {
	public String hello(PageList<Student> p,Student s) {
		return "";
	}
}
