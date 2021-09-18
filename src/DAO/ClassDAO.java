package DAO;

import DTO.ClassDTO;

public interface ClassDAO {
	public boolean DAO_REGISTER(ClassDTO dto);
	public boolean DAO_SELECT(String className);
}
