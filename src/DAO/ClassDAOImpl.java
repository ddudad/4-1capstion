package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.ConnectionProvider;
import DTO.ClassDTO;

public class ClassDAOImpl implements ClassDAO{
	
	static Connection con = ConnectionProvider.getCon();
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	@Override
	public boolean DAO_REGISTER(ClassDTO dto) {
		String query = "INSERT INTO CLASSINFO (PROFESSORNAME, CLASSNAME) VALUES(?,?)";
		
		boolean check = false;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getProfessorName());
			pstmt.setString(2, dto.getClassName());
			
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
		
		return check;
	}

	@Override
	public boolean DAO_SELECT(String className) {
		
		String query = "SELECT * FROM STUDENT WHERE CLASSNAME='" + className + "'";
		ClassDTO dto = new ClassDTO();
		boolean check=false;
		
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setProfessorName(rs.getString("PROFESSORNAME"));
				dto.setClassName(rs.getString("CLASSNAME"));
			}
			pstmt.close();
			check = true;
			
		} catch (SQLException e) {
			System.out.println("SQL error: " + e.getLocalizedMessage());
		}
		return check;
	}
}
