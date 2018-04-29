package exercise;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SusiTest {

	
	@Test
	public void shouldRegisterStudentAndGetCountOfStudents() {
		Course i = new Course("321","Intro",5.2,CourseType.REQUIRED);
		Course o = new Course("45","OOP",6.4,CourseType.REQUIRED);
		Map<Course,Double> m = new HashMap<>();
		m.put(i, 3.0);
		m.put(o, 5.0);
		
		Student s = new Student("Simona",71684,m);
		SusiCockpit susi = new SusiCockpit();
		try {
			susi.registerStudent(s);
		} catch (StudentAlreadyRegisteredException | CapacityExceededException e) {
			e.printStackTrace();
		}
		
		assertEquals(1, susi.getStudentsCount());
		
	}
}