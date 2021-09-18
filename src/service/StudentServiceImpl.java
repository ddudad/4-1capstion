package service;

import DAO.StudentDAO;
import DAO.StudentDAOImpl;
import DTO.StudentDTO;

public class StudentServiceImpl implements StudentService{
	private StudentDAO dao = new StudentDAOImpl();
	
	public boolean SERVICE_Register(StudentDTO dto) {
		return dao.DAO_REGISTER(dto);
	}

	@Override
	public boolean SERVICE_Search(String stdCode) {
		return dao.DAO_SELECT(stdCode);
	}

	@Override	
	public boolean SERVICE_Attendance(String stdCode) {
		if(dao.DAO_SELECT(stdCode)) {
			return dao.DAO_ATTENDANCE(stdCode);
		}
		else {
			return false;
		}
		//return dao.DAO_ATTENDANCE(stdCode);
	}
}
