package com.techm.adms.dt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="assignroles")
public class AssignRoles implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "CreatedBy", referencedColumnName = "Id"),
		@JoinColumn(name = "UpdatedBy", referencedColumnName = "Id")
		})
	private User user;
	
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(name="UserId", referencedColumnName="Id")
	private User logInUser;
	
	@ManyToOne(targetEntity=Roles.class, fetch=FetchType.EAGER)
	@JoinColumn(name="RoleId", referencedColumnName= "Id")
	private Roles roles;
	
	@ManyToOne(targetEntity=Project.class, fetch=FetchType.EAGER)
	@JoinColumn(name="ProjectID", referencedColumnName="ProjectID")
	private Project project;
	
	@Column(name="CreatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="UpdatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	

	public User getLogInUser() {
		return logInUser;
	}

	public void setLogInUser(User logInUser) {
		this.logInUser = logInUser;
	}

	@Override
	public String toString() {
		return "AssignRoles [id=" + id + ", user=" + user + ", logInUser="
				+ logInUser + ", roles=" + roles + ", project=" + project
				+ ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}


}
