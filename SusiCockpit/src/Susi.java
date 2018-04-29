
public interface Susi {
	boolean registerStudent(Student student);
	int getStudentsCount();
	boolean setGrade(Student student, Course course, double grade);
	double getTotalCredits(Student student);
	double getGPA(Student student);
}
