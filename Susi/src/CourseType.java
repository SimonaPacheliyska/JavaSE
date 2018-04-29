
enum CourseType {
	DEFAULT ("Default", 'D'),
	REQUIRED("Required", 'R'),
	ELECTIVE("Elective", 'E'), 
	PRACTICE("Practice", 'P');
	
	String name;
	char code;
	
	private CourseType(String name, char code) {
		this.code = code;
		this.name = name;
	}

}
