package exercise;

public enum CourseType {
	REQUIRED('R'),
	ELECTIVE('E'),
	PRACTICE('P');
	
	char code;
	
	private CourseType(char code) {
		this.code = code;
	}
}
