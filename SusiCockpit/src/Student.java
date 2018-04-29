
public class Student implements User{
	private String name;
	private int facultyNumber;
	private Course[] myCourses;
	private int courseCounter;
	
	
	Student(){
		this.name = new String(" ");
		this.facultyNumber = 0;
		myCourses = new Course[50];
		courseCounter = 0;
	}
	Student(String name, int facultyNumber){
		if(name!=null) {
			this.name = name;
			this.facultyNumber = facultyNumber;
			return;
		}
		this.name = new String(" ");
		this.facultyNumber = 0;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if(name!=null) {
			this.name= name;
			return;
		}
		this.name = new String(" ");
	}
	public int getFacultyNumber() {
		return this.facultyNumber;
	}
	public void setFacultyNumber(int facultyNumber) {
		this.facultyNumber = facultyNumber;
	}
	public Course[] getMyCourses() {
		return myCourses;
	}
	public void setMyCourses(Course newCourse) {
		
	}
	public int getCourseCounter() {
		return this.courseCounter;
	}
}
