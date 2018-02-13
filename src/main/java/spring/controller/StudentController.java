package spring.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.student.model.Student;
import spring.student.service.StudentService;

@org.springframework.stereotype.Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/find-all", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> find() {
		return studentService.findAll();
	}

	@RequestMapping(value = "/find-all-like-video", method = RequestMethod.GET)
	@ResponseBody
	public String findAllLikeVideo(@RequestParam("id") int id) {
		return studentService.findAllLikeVideo(id).toString();
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	@ResponseBody
	public String save(@RequestParam("name") String name) {
		Student student = new Student(name);
		studentService.save(student);
		return "add completed";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public String delete(@RequestParam("id") int id) throws SQLException {
		studentService.delete(id);
		return " delete completed";
	}

	@RequestMapping(value = "/like", method = RequestMethod.GET)
	@ResponseBody
	public String likeVideo(@RequestParam("id") int id, @RequestParam("video_name") String video_name) throws SQLException {
		studentService.likeVideo(id, video_name);
		return " update";
	}
}
