package application;

public class Student implements Comparable<Student>, Cloneable { // Implementing Comparable and Cloneable interfaces.
	private String name = ""; 
	private int ID = 0;
	// Constructor to declare the name and the id for each student.
	public Student(int id, String name) {
		this.ID = id;
		this.name = name;
	}
	// Getter method for the student's name. 
	public String getName() {
		return this.name;
	}
	// Getter method for the student's id.
	public int getID() {
		return ID;
	}
	// Setter method for the student's name.
	public void setName(String name) {
		this.name = name;
	}
	// Setter method for the student's id.
	public void setID(int id) {
		this.ID = id;
	}
	// Overriding the toString method.
	@Override
	public String toString() { 
		return String.format("%d\t%s", ID, name);
	}
	// Overriding the clone method.
	@Override
	public Object clone() throws CloneNotSupportedException {
		Student copy = (Student) super.clone();
		return copy;
	}
	// Overriding comparTo method and differentiate between objects by students' IDs.
	@Override
	public int compareTo(Student student) {
		if (ID < student.getID()) {
			return -1;
		} else if (ID > student.getID()) {
			return 1;
		} else {
			return 0;
		}
	}
	// Overriding the equals method.
	@Override
	public boolean equals(Object object) {
		if (object instanceof Student) {
			Student student = (Student) object;
			return compareTo(student) == 0;
		}
		return false;
	}

}
