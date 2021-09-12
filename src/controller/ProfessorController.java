package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ClassDTO;
import service.ProfessorService;
import service.ProfessorServiceImpl;

@WebServlet("*.prdo")
public class ProfessorController extends HttpServlet{
	
	private ProfessorService professorService = new ProfessorServiceImpl();
	private String redirectPage = "";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		
		String uri = req.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".prdo"));
		
		System.out.println(command + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		if(command.trim().equals("register")) {
			
			ClassDTO dto = new ClassDTO();
			
			dto.setClassName(req.getParameter("className"));
			dto.setProfessorName(req.getParameter("professorName"));
			
			if(professorService.SERVICE_Register(dto)) {	
				//resp.sendRedirect("register_success.html");
				redirectPage = "register_success.html";
			}
			else {
				//out.print("fail");
				//resp.sendRedirect("register_fail.html");
				System.out.println("등록실패@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				redirectPage = "register_fail.html";
			}
		}
		
		resp.sendRedirect(redirectPage);
	}
}
