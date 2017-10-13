package com.techm.adms.dt.dto;

public class DocumentDTO {

    private String documentName;
    private String documentId;
    private int mediaTypeId;
    private String mediaType;
    private int documentIndex;
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public int getMediaTypeId() {
		return mediaTypeId;
	}
	public void setMediaTypeId(int mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public int getDocumentIndex() {
		return documentIndex;
	}
	public void setDocumentIndex(int documentIndex) {
		this.documentIndex = documentIndex;
	}
	@Override
	public String toString() {
		return "DocumentDTO [documentName=" + documentName + ", documentId="
				+ documentId + ", mediaTypeId=" + mediaTypeId + ", mediaType="
				+ mediaType + ", documentIndex=" + documentIndex + "]";
	}
    
}
