

public class SusiCockpit {
	private Student[] students;
	private int studentCount;
	
	SusiCockpit(){
		this.students = new Student[1000];
		studentCount = 0;
	}
		
	public boolean registerStudent(Student student) {
		boolean notContains = true;
		for(int i = 0;i<this.studentCount;i++) {
			if(this.students[i].getFacultyNumber()==student.getFacultyNumber()) {
			notContains = false;
			}
		}
		if(notContains) {
			this.students[studentCount]  = new Student(student.getName(), student.getFacultyNumber());
		}
		return notContains;
	}
	int getStudentsCount() {
		return this.studentCount;
	}
	boolean setGrade(Student student, Course course, double grade) {
		for(int i = 0;i<this.studentCount;i++) {
			if(this.students[i].getName().equals(student.getName())){
				for(int j =0;j<students[i].getCourseCounter();j++) {
					if(students[i].getMyCourses()[j].getId().equals(course.getId())) {
						students[i].getMyCourses()[j].setCourseGrade(grade);
						return true;
					}
					//this.students[i].getMyCourses()[getCourseCounter()] = new Course
				}
				
			}
			
	}
		
		
	double getTotalCredits(Student student) {
		double total = 0;
		
	}
	double getGPA(Student student);
}
	
	
}
