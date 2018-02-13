package spring.response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import spring.student.model.Student;

@Component
public class StudentResponse {

	private static HttpStatus status;
	private static Student student;
	private static String errorMassage;

	public static HttpStatus getStatus() {
		return status;
	}

	public static Student getStudent() {
		return student;
	}

	public static String getErrorMassage() {
		return errorMassage;
	}

	public static void setStatus(HttpStatus status) {
		StudentResponse.status = status;
	}

	public static void setStudent(Student student) {
		StudentResponse.student = student;
	}

	public static void setErrorMassage(String errorMassage) {
		StudentResponse.errorMassage = errorMassage;
	}

}
