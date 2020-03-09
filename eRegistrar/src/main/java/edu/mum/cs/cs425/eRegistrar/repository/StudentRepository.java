package edu.mum.cs.cs425.eRegistrar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mum.cs.cs425.eRegistrar.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
//	@Query("select student from Student where studentId=? and"
//			+ "(studentNumber like '%\"+txt+\"' or firstName like '%\"+txt+\"'or"
//			+ "or middleName like '%\"+txt+\"'or lastName like '%\"+txt+\"' "
//			+ "or isInternational like '%\"+txt+\"')")
//	List<Student> findAllStudentByString(String txt);
}
