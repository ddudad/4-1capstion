package DAO;

import DTO.StudentDTO;

public interface StudentDAO {
	public boolean DAO_REGISTER(StudentDTO dto);
	public boolean DAO_SELECT(String stdCode);
	public boolean DAO_ATTENDANCE(String stdCode);
}
