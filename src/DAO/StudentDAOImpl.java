package DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.ConnectionProvider;
import DTO.StudentDTO;

public class StudentDAOImpl implements StudentDAO{	
	static Connection con = ConnectionProvider.getCon();
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public boolean DAO_REGISTER(StudentDTO dto) {
		String query = "INSERT INTO STUDENT (STDNAME, PWD, STDNUM, CLASSNAME, STDCODE) VALUES(?,?,?,?,?)";
		//System.out.println(query);
		boolean check = false;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getStdName());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getStdNum());
			pstmt.setString(4, dto.getClassName());
			pstmt.setString(5, dto.getStdCode());
			
			int x = pstmt.executeUpdate();
			//executeUpdate 다음에 바로 check=true해도 될듯 어차피 오류생기면 캐치로 넘어가니까
			if(x<1) {
				System.out.println("x error");
			}
			else {
				check = true;
			}
			pstmt.close();
		} catch(SQLException e) {
			System.out.println("SQL error: " + e.getLocalizedMessage());
		}
		System.out.println("check= " + check);
		return check;
	}
	
	public boolean DAO_SELECT(String cookieValue) {
		String query = "SELECT * FROM STUDENT WHERE STDCODE='" + cookieValue + "'";
		StudentDTO dto = new StudentDTO();
		boolean check=false;
		
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setStdName(rs.getString("STDNAME"));
				dto.setStdNum(rs.getString("STDNUM"));
				dto.setClassName(rs.getString("CLASSNAME"));
				dto.setStdCode(rs.getString("STDCODE"));
				dto.setPwd(rs.getString("PWD"));
				check=true;
			}
			pstmt.close();
			
		} catch (SQLException e) {
			System.out.println("SQL error: " + e.getLocalizedMessage());
		}
		return check;
	}
	
	public boolean DAO_ATTENDANCE(String stdCode) {
		String query = "insert into ATTENDANCE (STDCODE) values(?)";
		boolean check = false;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, stdCode);
			
			int x = pstmt.executeUpdate();
			
			if(x<1) {
				System.out.println("x error");
			}
			else {
				check = true;
			}
			
			pstmt.close();
		} catch(SQLException e) {
			System.out.println("SQL error: " + e.getLocalizedMessage());
		}
			return check;
	}
	
	public void close() {
		try {
			if(con!=null) {
			con.close();
			con=null;
			}
		} catch(SQLException e) {
			System.out.println("SQL error: " + e.getLocalizedMessage());
		}
	}
}