package com.techm.adms.dt.dto;

import java.util.Arrays;

public class AssignHMWDTO {


	private int ideaGroupId;
	private String[] hmwList;
	public int getIdeaGroupId() {
		return ideaGroupId;
	}
	public void setIdeaGroupId(int ideaGroupId) {
		this.ideaGroupId = ideaGroupId;
	}
	public String[] getHmwList() {
		return hmwList;
	}
	public void setHmwList(String[] hmwList) {
		this.hmwList = hmwList;
	}
	@Override
	public String toString() {
		return "AssignHMWDTO [ideaGroupId=" + ideaGroupId + ", hmwList="
				+ Arrays.toString(hmwList) + "]";
	}
}
