package datamodel;

/**
 * Student.java
 * This class in the datamodel package represents a Student object
 *  @author Tanner Beaulieu, and starter base via Ramesh Fadatare at https://github.com/RameshMF/jsp-servlet-jdbc-mysql-crud-tutorial
 *
 */
public class Student {
	protected int id;
	protected String name;
	protected String university;
	protected String major;
	protected String grade;
	
	public Student() {
	}
	
	public Student(String name, String university, String major, String grade) {
		super();
		this.name = name;
		this.university = university;
		this.major = major;
		this.grade = grade;
	}

	public Student(int id, String name, String university, String major, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.university = university;
		this.major = major;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
