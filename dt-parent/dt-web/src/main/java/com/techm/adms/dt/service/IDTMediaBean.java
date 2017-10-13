package com.techm.adms.dt.service;

import java.util.List;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.dto.MediaDTO;
import com.techm.adms.dt.entity.Media;

public interface IDTMediaBean {
	/**
	 * To insert Media details into database
	 * 
	 * @param media
	 * @throws DTServiceException
	 */
	public Media createMedia(Media media) throws DTServiceException;
	
	/**
	 * Get Media Details
	 * @return
	 * @throws DTServiceException
	 */
	public List<MediaDTO> getDTMediaDetails(int projectId) throws DTServiceException;
	
	/**
	 * Get Media details by projectId
	 * 
	 * @param projectId
	 * @return
	 * @throws DTServiceException
	 */
	public List<Media> getMediaDetailByProjectId(int projectId) throws DTServiceException;
	
	
	/**
	 * Get media details based on the media id
	 * 
	 * @param mediaId
	 * @return
	 * @throws DTServiceException
	 */
	public Media getMediaDetailByMediaId(int mediaId) throws DTServiceException;
	/**
	 * Update the media details 
	 * 
	 * @param media
	 * @throws DTServiceException
	 */
	public void upadateMedia(Media media) throws DTServiceException;
	
	/**
	 * Delete Media
	 * 
	 * @param deleteMedia
	 */
	public void deleteMedia(int mediaId);

	public List<MediaDTO> getActiveDTMediaDetails(int projectId)throws DTServiceException;

	public void activateMedia(int mediaId);
	
	public Media getMediaDetailsByUniqueId(String uniqueId);
}
