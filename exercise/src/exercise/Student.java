package exercise;

import java.util.HashMap;
import java.util.Map;

public class Student implements User{

	private String name;
	private int facultyNumber;
	private Map<Course,Double> courses;
	final int maxCourses = 50;
	
	public Student() {
		init();
	}
	
	private void init() {
		name = new String();	
		facultyNumber = 0;
		courses = new HashMap<Course,Double>();
	}

	public Student(String name, int facultyNumber, Map<Course,Double> courses) {
		this.name = name;
		this.facultyNumber = facultyNumber;
		this.courses = courses;
	}

	public Map<Course, Double> getCourses(){
		return courses;
	}
	
	public void setCourses(Map<Course,Double> courses) {
		this.courses = courses;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getFacultyNumber() {
		return facultyNumber;
	}

	@Override
	public void setFacultyNumber(int facultyNumber) {
		this.facultyNumber = facultyNumber;
	}
	
}
