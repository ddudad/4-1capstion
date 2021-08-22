package QRcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkQRcode")
public class CheckCorrectQRcode extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {	
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		//QR�ڵ� ���� ������ �޾ƿ���(������ ������ Ȥ�� ������ ������)
		String randNum = req.getParameter("RandNum");
		
		//���ø����̼� ��ü�κ��� Ű�� �޾ƿ���(�ǹٸ� ������)
		/*
		ServletContext application = request.getServletContext();
		String key = (String)application.getAttribute("key");
		*/
		String key = "aaa";
		
		if(!randNum.equals(key)) {
			out.println("QR�ڵ� ����");
		}
		
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("attendance.do");
			dispatcher.forward(req, resp);
		}
	}
}
