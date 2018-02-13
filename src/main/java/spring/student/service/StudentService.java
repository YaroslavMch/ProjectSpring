package spring.student.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.student.dao.StudentDAO;
import spring.student.model.Student;
import spring.youtube.service.VideoService;

@Service
@Transactional
public class StudentService {

	private final StudentDAO studentDAO;
	@Autowired
	private VideoService videoService;

	public StudentService(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}

	public List<Student> findAll() {
		List<Student> list = new ArrayList();
		for (Student student : studentDAO.findAll()) {
			list.add(student);
		}
		return list;
	}

	public List<String> findAllLikeVideo(int id) {
		List<String> list = new ArrayList();
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("ID " + id);
		String video_id = studentDAO.findVideoById(id);
		logger.info("VIDEO_ID " + video_id);
		String str[] = video_id.split(" ");

		for (int i = 1; i < str.length; i++) {

			logger.info("STR " + str[i]);
			list.add(videoService.getVideoNameById(Integer.valueOf(str[i])));
		}
		return list;
	}

	public void save(Student student) {
		studentDAO.save(student);
	}

	public void delete(int id) throws SQLException {
		studentDAO.delete(id);

	}

	public void likeVideo(int id, String video_name) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setId(id);
		student.setName(studentDAO.findById(id));
		student.setId_video(studentDAO.findVideoById(id) + " " + videoService.getIdByName(video_name));
		studentDAO.save(student);
	}
}
