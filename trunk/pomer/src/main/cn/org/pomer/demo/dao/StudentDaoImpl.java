package cn.org.pomer.demo.dao;

import org.springframework.stereotype.Component;

import cn.org.pomer.dao.DefaultBaseDaoImpl;
import cn.org.pomer.demo.entity.Student;

@Component
public class StudentDaoImpl extends DefaultBaseDaoImpl<Student> implements
		StudentDao {

	protected Class getEntityClass() {
		return Student.class;
	}

}
