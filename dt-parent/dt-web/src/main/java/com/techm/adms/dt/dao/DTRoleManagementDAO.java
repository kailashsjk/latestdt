package com.techm.adms.dt.dao;

import java.io.Serializable;

import javax.inject.Named;

import com.techm.adms.dt.entity.User;

@Named
public class DTRoleManagementDAO extends BaseDAO<User, Serializable> implements IDTRoleManagementDAO{
}
