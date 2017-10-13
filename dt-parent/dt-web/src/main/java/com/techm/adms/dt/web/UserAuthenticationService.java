package com.techm.adms.dt.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techm.adms.dt.common.exception.DTServiceException;
import com.techm.adms.dt.entity.User;
import com.techm.adms.dt.service.IDTUserAuthenticationBean;

@Path("/userauthenticationservice")
@RequestScoped
public class UserAuthenticationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthenticationService.class);
	
	@Inject
	IDTUserAuthenticationBean dTUserAuthenticationBean;
	
	@POST
	@Path("/authenticate")
	@Consumes({"application/json"})
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public User authenticateUser(User user)throws DTServiceException{
		LOGGER.info("In Service Class");
		User validUser= null;
		try{
			LOGGER.info("In Bean Class dtUserAuthenticationDAO###"+ dTUserAuthenticationBean+"   user.getUserId():::"+user.getUserId());
			User userDetails=dTUserAuthenticationBean.getUserDetails(user.getUserId());
			LOGGER.info("valid user list "+userDetails);
			if(userDetails != null && userDetails.getPassword().toString().equals(user.getPassword())){
				validUser = userDetails;
			}
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		LOGGER.info("result:-:-:"+validUser);
		
		return validUser;
	}
	
	@POST
	@Path("/createUser")
	@Consumes({"application/json"})
    @Produces({"application/json"})
	public void createUser(User users) throws DTServiceException{
		LOGGER.info("In Service Class");
		try{
			LOGGER.info("In Bean Class dtUserAuthenticationDAO###"+ dTUserAuthenticationBean);
			dTUserAuthenticationBean.createUser(users);
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		
	}
	
	@GET
	@Path("/checkusername/{userId}")
    @Produces({"application/json"})
	public String checkAvailability(@PathParam("userId") String userId)throws DTServiceException{
		LOGGER.info("In username Availability checking service");
		String result=null;
		try{
			User userDetails=dTUserAuthenticationBean.getUserDetails(userId);
			if(userDetails != null){
				result= "false";
			}else{
				result="true";
			}
		}catch(Exception e){
			throw new DTServiceException(e);
		}
		return result;
	}
	
	
}
