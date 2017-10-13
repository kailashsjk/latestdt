package com.techm.adms.dt.dto;

import java.util.Arrays;

public class AssignIdeaGroupDTO {

	private int ideaGroupId;
	private String[] ideaList;
	
	public int getIdeaGroupId() {
		return ideaGroupId;
	}
	public void setIdeaGroupId(int ideaGroupId) {
		this.ideaGroupId = ideaGroupId;
	}
	public String[] getIdeaList() {
		return ideaList;
	}
	public void setIdeaList(String[] ideaList) {
		this.ideaList = ideaList;
	}
	@Override
	public String toString() {
		return "AssignIdeaGroupDTO [ideaGroupId=" + ideaGroupId + ", ideaList="
				+ Arrays.toString(ideaList) + "]";
	}
	
}
