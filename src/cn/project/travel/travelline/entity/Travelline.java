package cn.project.travel.travelline.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Travelline implements Serializable {

	private String id;

	private String attraction;

	private Timestamp startTime;

	private Timestamp endTime;

	private int costs;

	private String tourist;

	public Travelline() {
		super();
	}

	public Travelline(String id, String attraction, Timestamp startTime, Timestamp endTime, int costs, String tourist) {
		super();
		this.id = id;
		this.attraction = attraction;
		this.startTime = startTime;
		this.endTime = endTime;
		this.costs = costs;
		this.tourist = tourist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAttraction() {
		return attraction;
	}

	public void setAttraction(String attraction) {
		this.attraction = attraction;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getCosts() {
		return costs;
	}

	public void setCosts(int costs) {
		this.costs = costs;
	}

	public String getTourist() {
		return tourist;
	}

	public void setTourist(String tourist) {
		this.tourist = tourist;
	}

}
