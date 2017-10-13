package com.techm.adms.dt.dto;

import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

public class NeedsOrInsightsDTO {

	private String description;
	private String descriptionShort;
	private int noiId;
	private int deleteFlag;
	private String needOrInsight;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescriptionShort() {
		return doSubstring(description, 50);
	}
	public void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
	}
	public int getNoiId() {
		return noiId;
	}
	public void setNoiId(int noiId) {
		this.noiId = noiId;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getNeedOrInsight() {
		return needOrInsight;
	}
	public void setNeedOrInsight(String needOrInsight) {
		this.needOrInsight = needOrInsight;
	}
	@Override
	public String toString() {
		return "NeedsOrInsightsDTO [description=" + description
				+ ", descriptionShort=" + descriptionShort + ", noiId=" + noiId
				+ ", deleteFlag=" + deleteFlag + ", needOrInsight="
				+ needOrInsight + "]";
	}
}
