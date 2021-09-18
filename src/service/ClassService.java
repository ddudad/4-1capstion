package service;

import DTO.ClassDTO;

public interface ClassService {
	public boolean SERVICE_Register(ClassDTO dto);
	public boolean SERVICE_Search(String className);
}
