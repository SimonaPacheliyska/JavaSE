package exercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SusiCockpit implements Susi{

	private List<Student> students;
	private final int maxCapacity = 1000;

	public SusiCockpit() {
		this.students = new LinkedList<Student>();
	}
	
	public SusiCockpit(List<Student> students) {
		this.students = students;
	}

	private boolean isContains(Student student) {
		for(Student i:students) {
			if(i.getFacultyNumber()==student.getFacultyNumber()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void registerStudent(Student student) throws StudentAlreadyRegisteredException, CapacityExceededException {
		if(students.size()+1 > maxCapacity) {
			throw new CapacityExceededException();
		}
		if(isContains(student)){
				throw new StudentAlreadyRegisteredException();
		}
		students.add(student);
	}

	@Override
	public void setGrade(Student student, Course course, double grade)
			throws StudentNotFoundException, CapacityExceededException {
		if(!isContains(student)) {
			throw new StudentNotFoundException();
		}
		if(student.getCourses().size() + 1> student.maxCourses) {
			throw new CapacityExceededException();
		}
		for(Student st:students) {
			if(st.getFacultyNumber()==student.getFacultyNumber()) {
				for(Map.Entry<Course, Double> e:student.getCourses().entrySet()) {
					if(e.getKey().equals(course)) {
						e.setValue(grade);
						return;
					}
				}
			}
		}
	}

	
	@Override
	public double getCreditsPerType(Student student, CourseType type) throws StudentNotFoundException {
		if(!isContains(student)) {
			throw new StudentNotFoundException();
		}
		double tCredits = 0;
		for(Student s:students) {
			if(s.equals(student)) {
				for(Course c:s.getCourses().keySet()) {
					if(c.getType()==type) {
						tCredits += c.getCredits();
					}
				}
			}
		}
		return tCredits;
	}

	@Override
	public int getStudentsCount() {
		return students.size();
	}

	@Override
	public double getTotalCredits(Student student) throws StudentNotFoundException {
		if(!isContains(student)) {
			throw new StudentNotFoundException();
		}
		double tCredits = 0;
		for(Course course : student.getCourses().keySet()) {
			tCredits += course.getCredits();
		}
		return tCredits;
	}

	@Override
	public double getGPA(Student student) throws StudentNotFoundException {
		if(!isContains(student)) {
			throw new StudentNotFoundException();
		}
		double sumGrade = 0;
		for(Entry<Course, Double> e:student.getCourses().entrySet()) {
			sumGrade += e.getValue();
		}
		return sumGrade/(student.getCourses().size());
	}


	public static void main(String[] args) {
		Course intro = new Course("245","Intro to programming",2.5,CourseType.ELECTIVE);
		Course OOP = new Course("321","Object-oriented programming",5.1,CourseType.ELECTIVE);
		Map<Course,Double> courses = new HashMap<>();
		courses.put(intro, 3.5);
		courses.put(OOP, 6.0);
		Student si = new Student("Simona",71684, courses);
		Student de = new Student("Dessi",74635,courses);
		List<Student> ls = new LinkedList<>();
		ls.add(si);
		ls.add(de);
		SusiCockpit sus = new SusiCockpit(ls);
		try {
			System.out.println(sus.getGPA(si));
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
		}
	}
}
