package spring.youtube.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import spring.youtube.dao.VideoDAO;
import spring.youtube.model.Video;

@Service
@Transactional
public class VideoService {

	private final VideoDAO videoDAO;

	public VideoService(VideoDAO videoDAO) {
		super();
		this.videoDAO = videoDAO;
	}

	public List<Video> findAll() {
		List<Video> list = new ArrayList();
		for (Video video : videoDAO.findAll()) {

			list.add(video);
		}
		return list;
	}

	public void save(Video video) {
		videoDAO.save(video);
	}

	public boolean checkVideo(String id) {
		boolean flag = false;
		try {
			videoDAO.findById_video(id);
		} catch (Exception e) {
			flag = true;
		}
		return flag;
	}

	public int getIdByName(String video_name) {
		return videoDAO.findByVideo_name(video_name);
	}

	public String getVideoNameById(int id) {
		return videoDAO.findNameById_video(id);
	}
}
