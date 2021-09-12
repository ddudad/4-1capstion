package service;

import DTO.ClassDTO;

public interface ProfessorService {
	public boolean SERVICE_Register(ClassDTO dto);
	public boolean SERVICE_Search(String className);
}
