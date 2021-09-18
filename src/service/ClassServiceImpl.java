package service;

import DAO.ClassDAO;
import DAO.ClassDAOImpl;
import DTO.ClassDTO;

public class ClassServiceImpl implements ClassService{

	private ClassDAO dao = new ClassDAOImpl();
	
	@Override
	public boolean SERVICE_Register(ClassDTO dto) {
		return dao.DAO_REGISTER(dto);
	}

	@Override
	public boolean SERVICE_Search(String className) {
		return dao.DAO_SELECT(className);
	}

}
