package edu.cssp.beans;

import java.util.Date;

public class Goal {
	private Integer id;
	private String name;
	private int user_id;
	private int type;
	private int dimension_id;
	private Date start_time;
	private Date planned_end_time;
	private Date actual_end_time;
	private float progress;
	private float final_score;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDimension_id() {
		return dimension_id;
	}

	public void setDimension_id(int dimension_id) {
		this.dimension_id = dimension_id;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getPlanned_end_time() {
		return planned_end_time;
	}

	public void setPlanned_end_time(Date planned_end_time) {
		this.planned_end_time = planned_end_time;
	}

	public Date getActual_end_time() {
		return actual_end_time;
	}

	public void setActual_end_time(Date actual_end_time) {
		this.actual_end_time = actual_end_time;
	}

	public float getProgress() {
		return progress;
	}

	public void setProgress(float progress) {
		this.progress = progress;
	}

	public float getFinal_score() {
		return final_score;
	}

	public void setFinal_score(float final_score) {
		this.final_score = final_score;
	}

}
