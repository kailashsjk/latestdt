package com.techm.adms.dt.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.techm.adms.dt.entity.MediaType;

@ApplicationScoped
@Named

public interface IDTMediaTypeDAO extends IBaseDAO<MediaType, Serializable>{


	
}
