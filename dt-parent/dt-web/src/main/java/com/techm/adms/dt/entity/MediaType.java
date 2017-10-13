package com.techm.adms.dt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mediatype")
public class MediaType {
	@Id
	@Column(name="MediaTypeID")
	private int mediaTypeID;
	
	@Column(name="MediaType")
	private String mediaType;
	
	public int getMediaTypeID() {
		return mediaTypeID;
	}

	public void setMediaTypeID(int mediaTypeID) {
		this.mediaTypeID = mediaTypeID;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	@Override
	public String toString() {
		return "MediaType [mediaTypeID=" + mediaTypeID + ", mediaType="
				+ mediaType + "]";
	}
	
}
