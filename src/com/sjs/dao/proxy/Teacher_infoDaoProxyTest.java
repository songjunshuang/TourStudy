package com.sjs.dao.proxy;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sjs.dao.factory.DAOFactory;
import com.sjs.dao.vo.Person;
import com.sjs.dao.vo.Teacher_info;

public class Teacher_infoDaoProxyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindById() throws Exception {
		int id = 1;
		Teacher_info teacher_info= DAOFactory.getTeacher_infoDAOInteInstance().findById(id); 
		System.out.println(teacher_info.getPerson().getName());
	}
	
	@Test
	public void testCreate() throws Exception {
		Teacher_info teacher_info = new Teacher_info();
		Person person = new Person();
		person.setLoginName("yunzhixu");
		person.setName("云直销");
		person.setSex("女");
		person.setPassword("1234");
		person.setTel("15733156006");
		person.setEmail("email");
		teacher_info.setPerson(person);
		teacher_info.setClassId(2);
		teacher_info.setIsheadTeacher(0);
		teacher_info.setPhoto("photo");

		DAOFactory.getTeacher_infoDAOInteInstance().doCreate(teacher_info); 
	}
	@Test
	public void testUpdate() throws Exception {
		Teacher_info teacher_info = new Teacher_info();
		Person person = new Person();
		person.setLoginName("yunzhixu");
		person.setName("云直销");
		person.setSex("女");
		person.setPassword("1234");
		person.setTel("15733156006");
		person.setEmail("email");
		teacher_info.setPerson(person);
		teacher_info.setClassId(2);
		teacher_info.setIsheadTeacher(0);
		teacher_info.setPhoto("photo");
		teacher_info.setTeacherId(2);
		DAOFactory.getTeacher_infoDAOInteInstance().doUpdate(teacher_info);; 
	}
	@Test
	public void testFindAll() throws Exception {
		List<Teacher_info> list = DAOFactory.getTeacher_infoDAOInteInstance().findAll();
		for (Teacher_info info : list) {
			System.out.println(info.getPerson().getName());
		}
	}
	@Test
	public void testDelete() throws Exception {
		int[] arr = {5,6};
		DAOFactory.getTeacher_infoDAOInteInstance().doDelete(arr);
	}

	@Test
	public void testFindByLoginName() throws Exception {
		String loginName = "songjunshuang";
		Teacher_info teacher_info= DAOFactory.getTeacher_infoDAOInteInstance().findByLoginName(loginName); 
		System.out.println(teacher_info.getPerson().getPassword());
	}
}
