import java.util.Arrays;

public class Student implements User{
	private String name;
	private int facultyNumber;
	private Course[] courses;
	
	
	Student(){
		this.name = new String(" ");
		this.facultyNumber  = 0;
		this.courses = null;
	}
	Student(String name, int facultyNumber,Course[] courses){
		this.name = name;
		if(isValidFacultyNum(facultyNumber)) {
			this.facultyNumber = facultyNumber;
		}
		this.courses = courses;
	}
	
	public boolean equals(Student rhs)
	{
		return (this.facultyNumber==rhs.facultyNumber);
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int getFacultyNumber() {
		return this.facultyNumber;
	}
	@Override
	public void setFacultyNumber(int facultyNumber) {
		if(isValidFacultyNum(facultyNumber)) {
			this.facultyNumber = facultyNumber;
		}
		
	}
	public Course[] getCourses() {
		return courses;
	}
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	public void addElectiveDiscipline(Course newCourse) {
		this.courses[this.courses.length] = newCourse;
	}
	private boolean isValidFacultyNum(int facultyNum) {
		int digitCountr = 0;
		while(facultyNum > 0) {
			digitCountr++;
			facultyNum/=10;
		}
		return digitCountr==5 || digitCountr==6;
	}

	public Course[] sortCourses() {
		Arrays.sort(this.courses);
		return this.courses;
	}

}
