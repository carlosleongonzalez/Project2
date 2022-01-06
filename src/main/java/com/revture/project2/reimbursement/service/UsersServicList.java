package com.revture.project2.reimbursement.service;

import java.util.List;

import com.revture.project2.reimbursement.exception.ApplicationException;
import com.revture.project2.reimbursement.pojo.UsersPojo;

public interface UsersServicList {
	
	UsersPojo updateUserProfile(UsersPojo userPojo)throws ApplicationException;
	UsersPojo logIn(UsersPojo userPojo)throws ApplicationException;
	UsersPojo register(UsersPojo userPojo)throws ApplicationException;
	List<UsersPojo> allEmployees()throws ApplicationException;
	UsersPojo getUserById(int userId) throws ApplicationException;
	boolean sendEmail(int userId, int flag)throws ApplicationException;


}
