package com.sjs.servlet.middle;

import com.sjs.dao.factory.DAOFactory;
import com.sjs.dao.vo.Teacher_info;

public class Test {
	public static void main(String[] args) {
		Teacher_info teacher_info;
		try {
			teacher_info = DAOFactory.getTeacher_infoDAOInteInstance().findByLoginName("songjunshuang");
			System.out.println(teacher_info.getPerson().getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
