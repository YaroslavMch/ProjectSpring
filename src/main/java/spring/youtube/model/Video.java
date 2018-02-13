package spring.youtube.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "youtube")
public class Video implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String id_video;
	private String video_name;
	private String description;
	private String link;

	public Video() {
	}

	public Video(String id_video, String video_name, String description) {
		super();
		this.id_video = id_video;
		this.video_name = video_name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getId_video() {
		return id_video;
	}

	public String getVideo_name() {
		return video_name;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId_video(String id_video) {
		this.id_video = id_video;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((id_video == null) ? 0 : id_video.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((video_name == null) ? 0 : video_name.hashCode());
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
		Video other = (Video) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (id_video == null) {
			if (other.id_video != null)
				return false;
		} else if (!id_video.equals(other.id_video))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (video_name == null) {
			if (other.video_name != null)
				return false;
		} else if (!video_name.equals(other.video_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", id_video=" + id_video + ", video_name=" + video_name + ", description=" + description + ", link=" + link + "]";
	}

}
