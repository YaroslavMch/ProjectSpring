package spring.response;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import spring.youtube.model.Video;

@Component
public class VideoListResponse {

	private HttpStatus status;
	private List<Video> video;
	private String message;

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	public String getMassager() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
