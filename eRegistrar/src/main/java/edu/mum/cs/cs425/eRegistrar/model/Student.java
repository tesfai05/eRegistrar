package edu.mum.cs.cs425.eRegistrar.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@NotNull(message = "# please student Number")
	@Column(nullable = false)
	@Pattern(regexp = "(0){3}-([0-9]){2}-([0-9]){4}",message = "# please provide a valid Student Id")
	private String studentNumber;
	
	@NotNull(message = "# please Provide First Name")
	@Column(nullable = false)
	private String firstName ;
	
	private String middleName ;
	
	@NotNull(message = "# please Provide Last Name")
	@Column(nullable = false)
	private String lastName;
	
	@Range(min = 0, max = 4)
	private Double cgpa;
	
	@NotNull(message = "# please Provide Enrollment Date")
	@Column(nullable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate enrollmentDate;
	
	@NotNull(message = "# please Select International or Not")
	@Column(nullable = false)
	private String isInternational;

	public Student() {
		
	}
	public Student(Long studentId, @NotNull(message = "* Provide student Number") String studentNumber,
			@NotNull(message = "* Provide First Name") String firstName, String middleName,
			@NotNull(message = "* Provide Last Name") String lastName, Double cgpa,
			@NotNull(message = "* Provide Enrollment Date") LocalDate enrollmentDate,
			@NotNull(message = "* Select International or Not") String isInternational) {
		super();
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.enrollmentDate = enrollmentDate;
		this.isInternational = isInternational;
	}

	public Long getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(String isInternational) {
		this.isInternational = isInternational;
	}
	
	
	
}
