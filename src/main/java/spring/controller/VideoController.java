package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.response.VideoListResponse;
import spring.youtube.service.VideoService;

@Controller
public class VideoController {

	@Autowired
	private VideoService videoService;

	@RequestMapping(value = "/find-all-video", method = RequestMethod.GET)
	@ResponseBody
	public VideoListResponse findAllVideo() {
		VideoListResponse videoListResponse = new VideoListResponse();
		videoListResponse.setStatus(HttpStatus.OK);
		videoListResponse.setMessage("no massage");
		videoListResponse.setVideo(videoService.findAll());

		return videoListResponse;
	}
}
