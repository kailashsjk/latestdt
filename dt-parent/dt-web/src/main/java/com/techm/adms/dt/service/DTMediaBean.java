package com.techm.adms.dt.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.conversation.MediaConversation;
import com.techm.adms.dt.dao.IDTMediaDAO;
import com.techm.adms.dt.dto.MediaDTO;
import com.techm.adms.dt.entity.Media;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DTMediaBean implements IDTMediaBean {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DTMediaBean.class);

	@Inject
	IDTMediaDAO dtMediaDAO;
	@Inject
	MediaConversation mediaConversation;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Media createMedia(Media media) throws DTServiceException {
		LOGGER.info("In Bean Class");
		Media updatedMedia = null;
		try {
			LOGGER.info("In Bean Class dtProjectDAO###" + dtMediaDAO);
			updatedMedia = dtMediaDAO.create(media);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
		return updatedMedia;
	}

	@Override
	public List<MediaDTO> getDTMediaDetails(int projectId) throws DTServiceException {
		List<Media> media = dtMediaDAO.getMediaDetailsByProjectId(projectId);
		LOGGER.debug("observations>>>>>>" + media);
		return mediaConversation.fromEntityToDTO(media);
	}
	
	@Override
	public List<Media> getMediaDetailByProjectId(int projectId) throws DTServiceException {
		LOGGER.info("Inside getMediaByProjectID method");
		List<Media> mediaList = new ArrayList<Media>();
		try {
			mediaList = dtMediaDAO.getMediaDetailsByProjectId(projectId);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
		return mediaList;

	}

	@Override
	public Media getMediaDetailByMediaId(int mediaId) throws DTServiceException {
		LOGGER.info("Inside getMediaByProjectID method");
		Media media = new Media();
		try {
			media = dtMediaDAO.read(mediaId);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
		return media;

	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void upadateMedia(Media media) throws DTServiceException {
		LOGGER.info("In Project Bean Class upadateProject method");
		try {
			dtMediaDAO.update(media);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteMedia(int mediaId) throws DTServiceException {
		LOGGER.info("In Project Bean Class deleteObservation method");
		try {
			dtMediaDAO.deleteMedia(mediaId);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void activateMedia(int mediaId) throws DTServiceException {
		LOGGER.info("In Project Bean Class deleteObservation method");
		try {
			dtMediaDAO.activateMedia(mediaId);
		} catch (Exception e) {
			throw new DTServiceException(e);
		}
	}
	

	@Override
	public List<MediaDTO> getActiveDTMediaDetails(int projectId) throws DTServiceException{
		List<Media> media = dtMediaDAO.readByDeleteFlag(projectId);
		LOGGER.debug("observations>>>>>>" + media);
		return mediaConversation.fromEntityToDTO(media);
	}
	
	@Override
	public Media getMediaDetailsByUniqueId(String uniqueId) {
		return dtMediaDAO.getMediaDetailsByUniqueId(uniqueId);
	}
}
