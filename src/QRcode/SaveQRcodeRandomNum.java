package QRcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveQRcode")
public class SaveQRcodeRandomNum extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String randNum = request.getParameter("RandNum");
		
		ServletContext application = request.getServletContext();
		application.setAttribute("key", randNum);
	}
}
