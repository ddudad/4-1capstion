package service;

import DTO.StudentDTO;

public interface StudentService {
	public boolean SERVICE_Register(StudentDTO dto);
	public boolean SERVICE_Search(String stdCode);
	public boolean SERVICE_Attendance(String stdCode);
}
