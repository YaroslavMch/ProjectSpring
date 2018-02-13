package spring.student.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import spring.student.model.Student;

public interface StudentDAO extends CrudRepository<Student, Integer> {

	@Query(value = "SELECT name FROM student where id=:id")
	String findById(@Param("id") int id);

	@Query(value = "SELECT id_video FROM student where id=:id")
	String findVideoById(@Param("id") int id);

}
