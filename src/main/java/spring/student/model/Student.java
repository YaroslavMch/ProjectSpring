package spring.student.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "student")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name; // student name
	private String id_video;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_video() {
		return id_video;
	}

	public void setId_video(String id_video) {
		this.id_video = id_video;
	}

	public Student() {
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	/**
	 * Returns student name.
	 * 
	 * @return name student name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Assigns a new value to the variable name.
	 * 
	 * @param name
	 *            new value
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns student id.
	 * 
	 * @return id student id
	 */
	public int getIdStudent() {
		return id;
	}

	/**
	 * Assigns a new value to the variable idStudent.
	 * 
	 * @param id
	 *            new value
	 */
	public void setIdStudent(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}
}
