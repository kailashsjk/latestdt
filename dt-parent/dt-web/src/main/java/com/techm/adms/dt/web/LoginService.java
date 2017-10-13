package com.techm.adms.dt.web;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.techm.adms.dt.service.IDTEmpathyHmwQuestionsBean;
import com.techm.adms.dt.service.IDTLoginBean;

@RequestScoped
@Path("/loginservice")
public class LoginService {

private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject 
	IDTLoginBean dTLoginBean;	
	
	@GET
	@Path("/getAll/{userId}/{password}")
	@Produces({ "application/json" })
	public List<User> getUserDetails(@PathParam("userId") String userId,@PathParam("password") String password) {
		List<User> userList = new ArrayList<User>();
		userList = dTLoginBean.getUserDetails(userId,password);
		return userList;
	}
}
