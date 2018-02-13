package spring.job;

import java.io.IOException;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import spring.youtube.model.Video;
import spring.youtube.service.VideoService;

@Component
public class YouTubeJob {

	@Autowired
	private VideoService videoDAOService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Scheduled(cron = "0,30 * * * * *")
	private void cronJob() throws SQLException {
		Document doc;
		logger.info("JobStart");
		try {
			doc = Jsoup.connect("https://www.youtube.com/feeds/videos.xml?channel_id=UCLXo7UDZvByw2ixzpQCufnA").get();
			Elements el;
			Elements title;
			for (Element e : doc.select("entry")) {
				if (videoDAOService.checkVideo(e.select("id").text()) == true) {
					Video video = new Video();
					video.setId_video(e.select("id").text());
					video.setVideo_name(e.select("title").text());
					video.setDescription(e.select("media|description").text());
					video.setLink(e.select("link").attr("href").toString());
					videoDAOService.save(video);
				}

			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		logger.info("JobFinish");
	}
}
