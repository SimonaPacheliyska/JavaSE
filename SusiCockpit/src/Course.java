
public class Course implements Subject{
	private String id;
	private String name;
	private double credits;
	private double grade;
	
	Course(){
		this.id = new String(" ");
		this.name = new String(" ");
		this.credits = 0;
		this.grade = 0;
	}
	
	public void setId(String id) {
		if(id!=null) {
			this.id = id;
			return;
		}
		this.name = new String(" ");
	}
	public String getId() {
		return this.id;
	}
	
	public void setName(String name) {
		if(name!=null) {
			this.name = name;
			return;
		}
		this.name = new String(" ");
	}
	public String getName() {
		return this.name;
	}
	public double getCredits() {
		return this.credits;
	}
	public void setCredits(double credits) {
		if(credits>0) {
			this.credits = credits;
			return;
		}
		this.credits = 0;
	}
	public double getCourseGrade() {
		return this.grade;
	}
	public void setCourseGrade(double grade) {
		if(grade>1) {
			this.grade = grade;
			return;
		}
		this.grade = 0;
	}

}
