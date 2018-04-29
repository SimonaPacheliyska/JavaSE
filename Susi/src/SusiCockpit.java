
public class SusiCockpit implements Susi {
	private Student[] students;

	public Student[] getStudents() {
		return this.students;
	}
	
	private boolean isContains(Student student) {
		for(int i = 0; i<this.students.length;i++) {
			if(this.students[i].equals(student)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void registerStudent(Student student) throws StudentAlreadyRegisteredException, CapacityExceededException {
		if (this.getStudentsCount() > 1000) {
			throw new CapacityExceededException(1000);
		}
		if(isContains(student)) {
				throw new StudentAlreadyRegisteredException();
			}
		this.students[this.students.length] = student;
	}

	@Override
	public int getStudentsCount() {
		int studentsCount = 0;
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i].getFacultyNumber() == 0) {
				continue;
			}
			studentsCount++;
		}
		return studentsCount;
	}

	@Override
	public void setGrade(Student student, Course course, double grade)
			throws StudentNotFoundException, CapacityExceededException {
		if(!isContains(student)) {
			throw new StudentNotFoundException();
		}
		if(student.getCourses().length>50) {
			throw new CapacityExceededException();
		}
		for(int i = 0;i<this.students.length;i++) {
			if(this.students[i].equals(student)) {
				for(int j = 0;j<this.students[i].getCourses().length;j++) {
					if(this.students[i].getCourses()[j].equals(course)) {
						this.students[i].getCourses()[j].setGrade(grade);
						return;
					}
				}
			}
		}
	}

	@Override
	public double getTotalCredits(Student student) throws StudentNotFoundException{
		
		if(!isContains(student)) {
			throw new StudentNotFoundException();
		}
		double total = 0;
		for (int i = 0; i < student.getCourses().length; i++) {

			total += student.getCourses()[i].getCredits();
		}
		return total;
	}

	@Override
	public double getGPA(Student student) throws StudentNotFoundException{
		if(!isContains(student)) {
			throw new StudentNotFoundException();
		}
		double total = 0;
		for (int i = 0; i < student.getCourses().length; i++) {
			total += student.getCourses()[i].getGrade();
		}
		return total / (double) student.getCourses().length;
	}
	
	@Override
	public double getCreditsPerType(Student student, CourseType type) throws StudentNotFoundException {
		if(!isContains(student)) {
			throw new StudentNotFoundException();
		}
		double creditByTypeCounter = 0;
		for(int i = 0;i<student.getCourses().length;i++) {
			if(student.getCourses()[i].getType()==type) {
				creditByTypeCounter++;
			}
		}
		return creditByTypeCounter;
	}
	

	public static void main(String[] args) {
		SusiCockpit s = new SusiCockpit();
		try {
			s.registerStudent(new Student());
		} catch (StudentAlreadyRegisteredException | CapacityExceededException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("test");
	}

	
}
