package com.sjs.dao.proxy;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.sjs.dao.factory.DAOFactory;
import com.sjs.dao.vo.Class_info;

public class Class_infoDaoProxyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindById() throws Exception {
		int id = 1;
		DAOFactory.getClass_infoDAOInteInstance().findById(id); 
	}
	
	@Test
	public void testCreate() throws Exception {
		Class_info class_info = new Class_info();
		class_info.setSchoolId(4);
		class_info.setName("高二年级三班");
		class_info.setStuCount(80);

		DAOFactory.getClass_infoDAOInteInstance().doCreate(class_info); 
	}
	@Test
	public void testUpdate() throws Exception {
		Class_info class_info = new Class_info();
		class_info.setClassId(1);
		class_info.setSchoolId(2);
		class_info.setName("三年级三班");
		class_info.setStuCount(80);
		DAOFactory.getClass_infoDAOInteInstance().doUpdate(class_info);; 
	}
	@Test
	public void testFindAll() throws Exception {
		List<Class_info> list = DAOFactory.getClass_infoDAOInteInstance().findAll();
		for (Class_info info : list) {
			System.out.println(info.getName());
		}
	}
	@Test
	public void testDelete() throws Exception {
		int[] arr = {6,7};
		DAOFactory.getClass_infoDAOInteInstance().doDelete(arr);
	}
}

















