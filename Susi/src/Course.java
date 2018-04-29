
public class Course implements Subject, Comparable<Course>{
	private String id;
	private String name;
	private double credits;
	private double grade;
	CourseType type;
	
	Course(){
		this.id = new String(" ");
		this.name = new String(" ");
		this.credits = 0;
		this.grade = 0;
		this.type = CourseType.DEFAULT;
	}
	
	Course(String id, String name, double credits, double grade, CourseType type){
		this.id = id;
		this.name = name;
		this.credits = credits;
		if(isGrade(grade)) {
			this.grade = grade;
		}
		this.type = type;
		
	}
	private boolean isGrade(double grade) {
		return (grade>=2 && grade<=6);
	}
	
	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public double getCredits() {
		return this.credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public double getGrade() {
		return this.grade;
	}

	public void setGrade(double grade) {
		if(isGrade(grade)) {
			this.grade = grade;
			return;
		}
		this.grade = 0;
	}

	@Override
	public CourseType getType() {
		return this.type;
	}

	public boolean equals(Course obj) {
		return (this.id.equals(obj.id));
	}
	
	static int countByType(Course[] arr, CourseType type) {
		int countType = 0;
		for(int i = 0; i<arr.length;i++) {
			if(arr[i].getType()==type) {
				countType++;
			}
		}
		return countType;
	}

	@Override
	public int compareTo(Course o) {
		if(this.grade==o.grade) {
			return 0;
		}
		if(this.grade<o.grade) {
			return -1;
		}
		return 1;
	}

	

}
