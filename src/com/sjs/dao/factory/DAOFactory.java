package com.sjs.dao.factory;

import com.sjs.dao.inter.Class_infoDaoInter;
import com.sjs.dao.inter.Class_signupDaoInter;
import com.sjs.dao.inter.Log_infoDaoInter;
import com.sjs.dao.inter.Log_requireDaoInter;
import com.sjs.dao.inter.Manager_infoDaoInter;
import com.sjs.dao.inter.NewsDaoInter;
import com.sjs.dao.inter.Project_assessDaoInter;
import com.sjs.dao.inter.Project_infoDaoInter;
import com.sjs.dao.inter.Project_typeDaoInter;
import com.sjs.dao.inter.School_infoDaoInter;
import com.sjs.dao.inter.Show_styleDaoInter;
import com.sjs.dao.inter.Stu_infoDaoInter;
import com.sjs.dao.inter.Stu_signupDaoInter;
import com.sjs.dao.inter.Teacher_favoriteDaoInter;
import com.sjs.dao.inter.Teacher_infoDaoInter;
import com.sjs.dao.proxy.Class_infoDaoProxy;
import com.sjs.dao.proxy.Class_signupDaoProxy;
import com.sjs.dao.proxy.Log_infoDaoProxy;
import com.sjs.dao.proxy.Log_requireDaoProxy;
import com.sjs.dao.proxy.Manager_infoDaoProxy;
import com.sjs.dao.proxy.NewsDaoProxy;
import com.sjs.dao.proxy.Project_assessDaoProxy;
import com.sjs.dao.proxy.Project_infoDaoProxy;
import com.sjs.dao.proxy.Project_typeDaoProxy;
import com.sjs.dao.proxy.School_infoDaoProxy;
import com.sjs.dao.proxy.Show_styleDaoProxy;
import com.sjs.dao.proxy.Stu_infoDaoProxy;
import com.sjs.dao.proxy.Stu_signupDaoProxy;
import com.sjs.dao.proxy.Teacher_favoriteDaoProxy;
import com.sjs.dao.proxy.Teacher_infoDaoProxy;

public class DAOFactory {
	
	//获得Class_info表的实例
	public static Class_infoDaoInter getClass_infoDAOInteInstance() throws Exception{
		return new Class_infoDaoProxy();
	}
	
	//获得Class_signup表的实例
	public static Class_signupDaoInter getClass_signupDAOInteInstance() throws Exception{
		return new Class_signupDaoProxy();
	}
	
	//获得Log_info表的实例
	public static Log_infoDaoInter getLog_infoDAOInteInstance() throws Exception{
		return new Log_infoDaoProxy();
	}
	
	//获得Log_require表的实例
	public static Log_requireDaoInter getLog_requireDAOInteInstance() throws Exception{
		return new Log_requireDaoProxy();
	}
	
	//获得Manager_info表的实例
	public static Manager_infoDaoInter getManager_infoDAOInteInstance() throws Exception{
		return new Manager_infoDaoProxy();
	}
	
	//获得News表的实例
	public static NewsDaoInter getNewsDAOInteInstance() throws Exception{
		return new NewsDaoProxy();
	}
	
	//获得Project_assess表的实例
	public static Project_assessDaoInter getProject_assessDAOInteInstance() throws Exception{
		return new Project_assessDaoProxy();
	}
	
	//获得Project_info表的实例
	public static Project_infoDaoInter getProject_infoDAOInteInstance() throws Exception{
		return new Project_infoDaoProxy();
	}
	
	//获得Project_type表的实例
	public static Project_typeDaoInter getProject_typeDAOInteInstance() throws Exception{
		return new Project_typeDaoProxy();
	}
	
	//获得School_info表的实例
	public static School_infoDaoInter getSchool_infoDAOInteInstance() throws Exception{
		return new School_infoDaoProxy();
	}
	
	//获得Show_style表的实例
	public static Show_styleDaoInter getShow_styleDAOInteInstance() throws Exception{
		return new Show_styleDaoProxy();
	}
	
	//获得Stu_info表的实例
	public static Stu_infoDaoInter getStu_infoDAOInteInstance() throws Exception{
		return new Stu_infoDaoProxy();
	}
	
	//获得Stu_signup表的实例
	public static Stu_signupDaoInter getStu_signupDAOInteInstance() throws Exception{
		return new Stu_signupDaoProxy();
	}
	
	//获得Teacher_favorite表的实例
	public static Teacher_favoriteDaoInter getTeacher_favoriteDAOInteInstance() throws Exception{
		return new Teacher_favoriteDaoProxy();
	}
	
	//获得Teacher_info表的实例
	public static Teacher_infoDaoInter getTeacher_infoDAOInteInstance() throws Exception{
		return new Teacher_infoDaoProxy();
	}
	
}


