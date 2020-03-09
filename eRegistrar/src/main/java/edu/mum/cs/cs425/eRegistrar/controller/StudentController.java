package edu.mum.cs.cs425.eRegistrar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import edu.mum.cs.cs425.eRegistrar.model.Student;
import edu.mum.cs.cs425.eRegistrar.service.Imp.StudentServiceImp;


@Controller
public class StudentController {
	@Autowired
	private StudentServiceImp studentService;
	@GetMapping(value= {"/","/eregistrar","eregistrar/home"})
	public String displayRegistrarHomePage() {
		return "home/index";
		
	}
	@GetMapping(value= {"/about","eregistrar/about"})
	public String displayAboutRegistrar() {
		return "home/about";
		
	}
	

	@GetMapping(value= {"/students/list"})
	public ModelAndView displayListStudents(ModelAndView model) {
		List<Student> students = studentService.getListStudent();
		model.addObject("students",students);
		model.addObject("studentsCount",students.size());
		model.setViewName("student/list");
		return model;
	}
	
	@GetMapping(value= {"/students/newStudent"})
	public String addNewStudent(Model model) {
		model.addAttribute("student", new Student());
		return "student/newStudent";
	}
	
	@PostMapping(value= {"/students/newStudent"})
	public String saveNewStudent(Model model, @Valid Student student,
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("student", student);
			return "student/newStudent";
		}
		else {
			model.addAttribute("student", studentService.registerNewStudent(student));
			
			return "redirect:/students/list";
		}
		
	}
	
	@GetMapping(value="/editstudent/{id}")
	public String edit(@PathVariable Long id,Model model) {
		Student student=studentService.getStudent(id);
		model.addAttribute("student",student);
		return "student/edit";
	}
	
	@PostMapping(value="/editstudent/{id}")
	public String editSave(Model model, @PathVariable("id") Long id,@Valid Student student,
			BindingResult result) {
	
		Student std=studentService.getStudent(id);
		if(result.hasErrors()) {
			model.addAttribute("student", student);
			return "student/edit";
		}
		std.setFirstName(student.getFirstName());
		std.setMiddleName(student.getMiddleName());
		std.setLastName(student.getLastName());
		std.setStudentNumber(student.getStudentNumber());
		std.setEnrollmentDate(student.getEnrollmentDate());
		std.setCgpa(student.getCgpa());
		std.setIsInternational(student.getIsInternational());
		
		studentService.registerNewStudent(std);
		
		return "redirect:/students/list";
	}
		
	@GetMapping(value="/deletestudent/{id}")
	public String deleteStudent(@PathVariable Long id, Model model) {
		studentService.deleteStudentRegistration(id);
		return "redirect:/students/list";
	}
	
//	@GetMapping(value= "/students/search")
//	public String searchStudent(Model model,@RequestParam("txt") String txt) {
//		List<Student> students = studentService.searchStudent(txt);
//		model.addAttribute("students", students);
//		model.addAttribute("studentsCount", students.size());
//		return "student/list";
//	}

}
