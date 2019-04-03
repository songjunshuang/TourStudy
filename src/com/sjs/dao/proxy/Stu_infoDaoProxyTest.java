package com.sjs.dao.proxy;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.sjs.dao.factory.DAOFactory;
import com.sjs.dao.vo.Person;
import com.sjs.dao.vo.Stu_info;

public class Stu_infoDaoProxyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindAll() throws Exception {
		List<Stu_info> list = DAOFactory.getStu_infoDAOInteInstance().findAll();
		for (Stu_info info : list) {
			System.out.println(info.getPerson().getName());
		}
	}

	@Test
	public void testFindById() throws Exception {
		int id = 1;
		Stu_info stu_info= DAOFactory.getStu_infoDAOInteInstance().findById(id); 
		System.out.println(stu_info.getPerson().getName());
	}

	@Test
	public void testDoCreate() throws Exception {
		Stu_info stu_info = new Stu_info();
		Person person = new Person();
		person.setLoginName("liujia");
		person.setName("刘佳");
		person.setSex("女");
		person.setPassword("1234");
		person.setTel("15733156006");
		person.setEmail("email");
		stu_info.setPerson(person);
		stu_info.setClassId(2);
		stu_info.setParentTel("123456");

		DAOFactory.getStu_infoDAOInteInstance().doCreate(stu_info); 
	}

	@Test
	public void testDoUpdate() throws Exception {
		Stu_info stu_info = new Stu_info();
		Person person = new Person();
		person.setLoginName("liujia");
		person.setName("刘佳");
		person.setSex("女");
		person.setPassword("1234");
		person.setTel("15733156006");
		person.setEmail("email");
		stu_info.setPerson(person);
		stu_info.setClassId(2);
		stu_info.setParentTel("123456");
		stu_info.setStuId(1);
		
		DAOFactory.getStu_infoDAOInteInstance().doUpdate(stu_info); 
	}

	@Test
	public void testDoDelete() throws Exception {
		int[] arr = {4,5};
		DAOFactory.getStu_infoDAOInteInstance().doDelete(arr);
	}
	@Test
	public void testFindByLoginName() throws Exception {
		String loginName = "sj";
		Stu_info stu_info= DAOFactory.getStu_infoDAOInteInstance().findByLoginName(loginName); 
		System.out.println(stu_info.getPerson().getPassword());
	}
}
