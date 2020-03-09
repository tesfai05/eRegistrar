package edu.mum.cs.cs425.eRegistrar.service;

import java.util.List;

import edu.mum.cs.cs425.eRegistrar.model.Student;

public interface IStudentService {
	List<Student> getListStudent();
	Student registerNewStudent(Student student);
//	List<Student> searchStudent(String txt);
	Student getStudent(Long id);
	void deleteStudentRegistration(Long id);
}

