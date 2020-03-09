package edu.mum.cs.cs425.eRegistrar.service.Imp;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import edu.mum.cs.cs425.eRegistrar.repository.StudentRepository;
import edu.mum.cs.cs425.eRegistrar.service.IStudentService;

@Service
public class StudentServiceImp implements IStudentService{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getListStudent() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student registerNewStudent(Student student) {
		
		return studentRepository.save(student);
	}
//	@Override
//	public List<Student> searchStudent(String txt) {
//		return studentRepository.findAllStudentByString(txt);
//	}

	@Override
	public Student getStudent(Long id) {

		return studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No student with Id:" + id));
	}
	@Override
	public void deleteStudentRegistration(Long id) {
		studentRepository.deleteById(id);
		
	}
	
}
