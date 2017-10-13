package com.techm.adms.dt.entity;
import static com.techm.adms.dt.common.util.StringUtil.doSubstring;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@Table(name="observation")
public class Observation implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@Column(name="ObservationID")
	private int observationID;
	
	@Column(name="ObservationNotes")
	private String observationNotes;
	
	@ManyToOne(targetEntity=ObservationCategory.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "ObservationCategory", referencedColumnName = "ObservationCategoryID")
	private ObservationCategory observationCategory;
	
	@ManyToOne(targetEntity=Media.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "MediaID", referencedColumnName = "MediaID")
	private Media media;

	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumns({
	@JoinColumn(name = "CreatedBy", referencedColumnName = "Id"),
	@JoinColumn(name = "UpdatedBy", referencedColumnName = "Id")
	})
	private User user; 
	
	@Column(name="DeleteFlag")
	private int deleteFlag;
	
	@Column(name="CreatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="UpdatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	@Transient
	private String observationNotesShort;

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getObservationID() {
		return observationID;
	}

	public void setObservationID(int observationID) {
		this.observationID = observationID;
	}

	public String getObservationNotes() {
		return observationNotes;
	}

	public void setObservationNotes(String observationNotes) {
		this.observationNotes = observationNotes;
	}

	public ObservationCategory getObservationCategory() {
		return observationCategory;
	}

	public void setObservationCategory(ObservationCategory observationCategory) {
		this.observationCategory = observationCategory;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getObservationNotesShort() {
		return doSubstring(observationNotes, 100);
	}

	public void setObservationNotesShort(String observationNotesShort) {
		this.observationNotesShort = observationNotesShort;
	}

	@Override
	public String toString() {
		return "Observation [observationID=" + observationID
				+ ", observationNotes=" + observationNotes
				+ ", observationCategory=" + observationCategory + ", media="
				+ media + ", user=" + user + ", deleteFlag=" + deleteFlag
				+ ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", observationNotesShort="
				+ observationNotesShort + "]";
	}
}
