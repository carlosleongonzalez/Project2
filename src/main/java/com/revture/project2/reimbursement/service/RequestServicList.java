package com.revture.project2.reimbursement.service;

import java.util.List;

import com.revture.project2.reimbursement.exception.ApplicationException;
import com.revture.project2.reimbursement.pojo.RequestPojo;

public interface RequestServicList {
	
	RequestPojo addRequest(RequestPojo requestPojo)throws ApplicationException;
	List<RequestPojo> userPendingRequestes(int Id)throws ApplicationException;
	List<RequestPojo>   userResolveRequest(int Id)throws ApplicationException;
	boolean approveRequest(int reqId)throws ApplicationException;
	List<RequestPojo>  allPendingRequsts()throws ApplicationException;
	List<RequestPojo> allResolvedRequsts()throws ApplicationException;
	List<RequestPojo>  spacificEmployeeRequests(int userId)throws ApplicationException;
	boolean rejectRequest(int reqId)throws ApplicationException;

}
