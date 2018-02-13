package spring.youtube.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import spring.youtube.model.Video;

public interface VideoDAO extends CrudRepository<Video, Integer> {

	@Query(value = "SELECT id FROM youtube where id_video=:id_video")
	int findById_video(@Param("id_video") String id_video);

	@Query(value = "SELECT id FROM youtube where video_name=:video_name")
	int findByVideo_name(@Param("video_name") String video_name);

	@Query(value = "SELECT video_name FROM youtube where id=:id")
	String findNameById_video(@Param("id") int id);

}
