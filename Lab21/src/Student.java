import java.io.*;

public class Student implements Comparable<Student>, Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	int id;

	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public int getID() {
		return this.id;
	}

	@Override
	public int compareTo(Student student) {
		if (id < student.getID()) {
			return -1;
		} else if (id > student.getID()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return String.format("%s\t%d", name, id);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Student) {
			Student student = (Student) object;
			return compareTo(student) == 0;
		}
		return false;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Student copy = (Student) super.clone();
		return copy;
	}
}
