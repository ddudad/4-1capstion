package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.StudentDTO;
import service.StudentService;
import service.StudentServiceImpl;
import sub.CreateCookieValue;

@WebServlet("*.do")
public class StudentController extends HttpServlet{
	
	private StudentService studentService = new StudentServiceImpl();
	private String redirectPage = "";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		String uri = req.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		//String page = null;
		
		if(command.trim().equals("register")) {
			StudentDTO dto = new StudentDTO();
			CreateCookieValue createCookie = new CreateCookieValue();
			
			dto.setStdName(req.getParameter("stdName"));
			dto.setStdNum(req.getParameter("stdNum"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setClassName(req.getParameter("className"));
			dto.setStdCode(createCookie.CreateValue());
			
			//service�� ���� dao�� �����ϰ� �� ����� ���� ���� ���� ���� ����
			if(studentService.SERVICE_Register(dto)) {
				//��� �����ϸ� ��Ű ���� �� �����̷�Ʈ(��Ű ������ ������ ���� ������)
				Cookie cookie = new Cookie("stdCode", dto.getStdCode());
				cookie.setPath("/");
				//cookie.setComment(URLEncoder.encode(dto.getStdName(), "UTF-8"));
				cookie.setMaxAge(60*60*24*30*6);
				resp.addCookie(cookie);
				out.println(cookie.getValue());
				
				//resp.sendRedirect("register_success.html");
				redirectPage = "register_success.html";
			}
			else {
				//resp.sendRedirect("register_fail.html");
				redirectPage = "register_fail.html";
			}
		}
		else if(command.trim().equals("attendance")) {
			try {
				Cookie[] cookies = req.getCookies();
				Cookie cookie = null;
				StudentDTO dto = new StudentDTO();
				
				for(int i=0; i<cookies.length; i++) {
					if(cookies[i].getName().equals("stdCode")) {
						cookie=cookies[i];
					}
				} 
				 
				//������ SERVICE_Attendance�� ȣ���� �� �ֵ���
				//Search�� ���ϰ��� dto, Attendance�� ���ϰ��� boolean
				
				if(studentService.SERVICE_Attendance(cookie.getValue())==true) {
					req.setAttribute("stdName", dto.getStdName());
					req.setAttribute("stdNum", dto.getStdNum());
					req.setAttribute("className", dto.getClassName());							
					RequestDispatcher dispatcher = req.getRequestDispatcher("search_success.jsp");
					dispatcher.forward(req, resp);
				}
				/*
				dto = studentService.SERVICE_Search(cookie.getValue());
				
				if(dto.getStdName()!=null && studentService.SERVICE_Attendance(dto.getStdCode())) {
					req.setAttribute("stdName", dto.getStdName());
					req.setAttribute("stdNum", dto.getStdNum());
					req.setAttribute("className", dto.getClassName());							
					RequestDispatcher dispatcher = req.getRequestDispatcher("search_success.jsp");
					dispatcher.forward(req, resp);
				}
				*/
				else {
					//resp.sendRedirect("attendance_fail.html");
					redirectPage = "attendance_fail.html";
				}
				
				
			}catch(Exception e) {
				System.out.println(e+"�߻�!!!!!!!!!!!!!!");
				//resp.sendRedirect("search_fail.html");
				redirectPage = "search_fail.html";
			}	
		}
		else {
			//resp.sendRedirect("commandError.html");
			redirectPage = "commandError.html";
		}
		resp.sendRedirect(redirectPage);
	}
}