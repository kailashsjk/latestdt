package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.techm.adms.dt.entity.Media;

@ApplicationScoped
@Named
public interface IDTMediaDAO extends IBaseDAO<Media, Serializable>{

	/**
	 * Retrieve media details based on the projectId
	 * 
	 * @param projectId
	 * @return
	 */
	public List<Media> getMediaDetailsByProjectId(int projectId) ;

	public Media getMediaDetailsByUniqueId(String uniqueId);
	/**
	 * Delete Media based on the mediaID
	 * 
	 * @param mediaId
	 */
	public void deleteMedia(int mediaId);
	
	public List<Media> readByDeleteFlag(int projectId);

	public void activateMedia(int mediaId);

	

}
