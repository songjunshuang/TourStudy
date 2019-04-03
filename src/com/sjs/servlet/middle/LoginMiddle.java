package com.sjs.servlet.middle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sjs.dao.factory.DAOFactory;
import com.sjs.dao.vo.Manager_info;
import com.sjs.dao.vo.Stu_info;
import com.sjs.dao.vo.Teacher_info;

@WebServlet(name="LoginMiddle",value="/LoginMiddle")
public class LoginMiddle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginMiddle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
		String loginName = java.net.URLDecoder.decode(request.getParameter("loginName"), "utf-8");
		String password = java.net.URLDecoder.decode(request.getParameter("password"), "utf-8");
		String role = java.net.URLDecoder.decode(request.getParameter("role"), "utf-8");
		
		HttpSession session=request.getSession();
		session.setAttribute("loginName", loginName);
		session.setAttribute("password", password);
		session.setAttribute("role", role);
		System.out.println(loginName+password+role);

		//跳转回登录页面
		class Back{
			public void back() throws ServletException, IOException {
				request.setAttribute("message", "用户名、密码或者角色错误，请核对后重新登录");
				request.getRequestDispatcher("login.jsp").forward(request, response); 
				return;
			}
		}
		
		//判断登录角色
		if (role.equals("学生")) {
			try {
				Stu_info stu_info= DAOFactory.getStu_infoDAOInteInstance().findByLoginName(loginName);
				if (stu_info.getPerson().getPassword().equals(password)) {
					request.getRequestDispatcher("firstPage.jsp").forward(request, response);
					return;
				}				
			} catch (Exception e) {	
				e.printStackTrace();
				new Back().back();
			} 
		}else if (role.equals("教师")) {
			try {
				System.out.println("这是教师"); 
				Teacher_info teacher_info = new Teacher_info();
				teacher_info = DAOFactory.getTeacher_infoDAOInteInstance().findByLoginName("songjunshuang");
				System.out.println(teacher_info.getPerson().getPassword());
				if (teacher_info.getPerson().getPassword().equals(password)) {
					request.getRequestDispatcher("firstPage.jsp").forward(request, response);
					return;
				}				
			} catch (Exception e) {	
				e.printStackTrace();
				new Back().back();
			} 
		}else {
			try {
				Manager_info manager_info= DAOFactory.getManager_infoDAOInteInstance().findByLoginName(loginName);
				if (manager_info.getPerson().getPassword().equals(password)) {
					request.getRequestDispatcher("manager.jsp").forward(request, response);
					return;
				}				
			} catch (Exception e) {	
				e.printStackTrace();
				new Back().back();
			} 
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
