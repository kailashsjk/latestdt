package com.techm.adms.dt.web;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.entity.Media;
import com.techm.adms.dt.entity.ObservationCategory;
import com.techm.adms.dt.service.DTObservationCategoryBean;
import com.techm.adms.dt.service.IDTObservationCategoryBean;

@Path("/obscategoryservice")
@RequestScoped
public class ObservationCategoryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MediaService.class);
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject 
	IDTObservationCategoryBean dtObservationCategoryBean;
	
	
	@GET
	@Path("/getObsCategory")
	@Produces({"application/json"})
	public List<ObservationCategory> getObservationCategories(){
		List<ObservationCategory> observationList = new ArrayList<ObservationCategory>();
		observationList = dtObservationCategoryBean.getObservationCategory();
		return observationList;
	}

}
