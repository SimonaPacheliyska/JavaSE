package exercise;

public class Course implements Subject{

	private String id;
	private String name;
	private double credits;
	CourseType type;
	
	public Course() {
		init();
	}
	
	private void init() {
		id = new String();
		name = new String();
		credits = 0;
		type = CourseType.REQUIRED;
	}
	
	public Course(String id, String name, double credits,CourseType type) {
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.type = type;
	}
	
	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public double getCredits() {
		return credits;
	}
	
	public void setCredits(double credits) {
		this.credits = credits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public CourseType getType() {
		return type;
	}

	
}
