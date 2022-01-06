package com.revture.project2.reimbursement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.revture.project2.reimbursement.dao.RequestRepositoryDao;
import com.revture.project2.reimbursement.entity.RequestEntity;
import com.revture.project2.reimbursement.exception.ApplicationException;
import com.revture.project2.reimbursement.pojo.RequestPojo;

@Service // we config the service class as a bean so we can inject it

public class RequestServicEmpliment implements RequestServicList {
	

	@Autowired
	RequestRepositoryDao requestRepositoryDao ;
	
	
	public RequestServicEmpliment() {
		
	}
	
	//---------------------add Request------------------------------------------------------------------------------------------------

	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) throws ApplicationException {

		// first we need to send the coming requestPojo to the Entity(table) 
		System.out.println(requestPojo.getReqDate());
		
		RequestEntity requestEntity = new RequestEntity(
				requestPojo.getId(), 
				requestPojo.getReqName(), 
				requestPojo.getReqPrice(), 
				requestPojo.getReqDescription(), 
				requestPojo.isReqFlag(), 
				requestPojo.getReqDate(),
				requestPojo.getAcceptDate(), 
				requestPojo.getImg(), 
				requestPojo.getUsersId(), 
				requestPojo.isReject());
		//save the new Entity nf flush to sync the data in table with the object entity
		RequestEntity returnaddEntityequest = this.requestRepositoryDao.saveAndFlush(requestEntity);
		//(set the PK from the requestEntity to  requestPojo object)
		requestPojo.setId(returnaddEntityequest.getId());

		return requestPojo;
	}
	//----------------------user Pending Requesters-----------------------------------------------------------------------------------------------
	
	@Override
	public List<RequestPojo> userPendingRequestes(int Id) throws ApplicationException {

		List<RequestEntity> returnUserPendingRequest = this.requestRepositoryDao.findUserPendingRequestes(Id);
		List<RequestPojo> allUserPendingRequest = new ArrayList<RequestPojo>();
		returnUserPendingRequest.forEach((resolveRequest)-> {
			RequestPojo requestPojo = new RequestPojo(
					resolveRequest.getId(), 
					resolveRequest.getReqName(),
					resolveRequest.getReqPrice(), 
					resolveRequest.getReqDescription(), 
					resolveRequest.isReqFlag(), 
					resolveRequest.getReqDdate(), 
					resolveRequest.getAcceptDate(), 
					resolveRequest.getImg(), 
					resolveRequest.getUsersId(), 
					resolveRequest.isReject());
			allUserPendingRequest.add(requestPojo);
		});

		return allUserPendingRequest;

	}
	//-----------------------user Resolve Request----------------------------------------------------------------------------------------------

	@Override
	public List<RequestPojo> userResolveRequest(int Id) throws ApplicationException {

		List<RequestEntity> returnUserResolveRequest = this.requestRepositoryDao.findUserResolveRequest(Id);
		List<RequestPojo> allUserResolveRequest = new ArrayList<RequestPojo>();
		returnUserResolveRequest.forEach((resolveRequest)-> {
			RequestPojo requestPojo = new RequestPojo(
					resolveRequest.getId(), 
					resolveRequest.getReqName(),
					resolveRequest.getReqPrice(), 
					resolveRequest.getReqDescription(), 
					resolveRequest.isReqFlag(), 
					resolveRequest.getReqDdate(), 
					resolveRequest.getAcceptDate(),
					resolveRequest.getImg(), 
					resolveRequest.getUsersId(), 
					resolveRequest.isReject());
			allUserResolveRequest.add(requestPojo);
		});
		return allUserResolveRequest;
	}
	//------------------------approve Request---------------------------------------------------------------------------------------------

	@Override
	public boolean approveRequest(int reqId) throws ApplicationException {
		LocalDate today = LocalDate.now();
				
		Optional<RequestEntity> optional = this.requestRepositoryDao.findById(reqId);
		if(optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
		
			requestEntity.setReqFlag(true);
			requestEntity.setAcceptDate(today);
			requestRepositoryDao.save(requestEntity);
			return true;
	}

	return false;

	}
	//------------------------all Pending Requests---------------------------------------------------------------------------------------------

	@Override
	public List<RequestPojo> allPendingRequsts() throws ApplicationException {

		List<RequestEntity> returnUserResolveRequest = this.requestRepositoryDao.findAllPendingRequsts();
		List<RequestPojo> allPendingRequest = new ArrayList<RequestPojo>();
		returnUserResolveRequest.forEach((resolveRequest)-> {
			RequestPojo requestPojo = new RequestPojo(
					resolveRequest.getId(), 
					resolveRequest.getReqName(),
					resolveRequest.getReqPrice(), 
					resolveRequest.getReqDescription(), 
					resolveRequest.isReqFlag(), 
					resolveRequest.getReqDdate(), 
					resolveRequest.getAcceptDate(), 
					resolveRequest.getImg(), 
					resolveRequest.getUsersId(), 
					resolveRequest.isReject());
					allPendingRequest.add(requestPojo);
		});

		return allPendingRequest;
	}

	//-----------------------------all Resolved Requests----------------------------------------------------------------------------------------
	@Override
	public List<RequestPojo> allResolvedRequsts() throws ApplicationException {

		List<RequestEntity> returnUserResolveRequest = this.requestRepositoryDao.findAllResolvedRequsts();
		List<RequestPojo> allResolveRequest = new ArrayList<RequestPojo>();
		returnUserResolveRequest.forEach((resolveRequest)-> {
			RequestPojo requestPojo = new RequestPojo(
					resolveRequest.getId(), 
					resolveRequest.getReqName() ,
					resolveRequest.getReqPrice(), 
					resolveRequest.getReqDescription(), 
					resolveRequest.isReqFlag(), 
					resolveRequest.getReqDdate(), 
					resolveRequest.getAcceptDate(),
					resolveRequest.getImg(), 
					resolveRequest.getUsersId(), 
					resolveRequest.isReject());
			allResolveRequest.add(requestPojo);
		});

		return allResolveRequest;

	}
	//---------------------------Specific Employee Requests------------------------------------------------------------------------------------------
	@Override
	public List<RequestPojo> spacificEmployeeRequests(int userId) throws ApplicationException {

		List<RequestEntity> returnspacificEmpRequests = this.requestRepositoryDao.findSpacificEmployeeRequests(userId);
		List<RequestPojo> spacificEmpRequests = new ArrayList<RequestPojo>();
		returnspacificEmpRequests.forEach((resolveRequest)-> {
			RequestPojo requestPojo = new RequestPojo(
					resolveRequest.getId(), 
					resolveRequest.getReqName(),
					resolveRequest.getReqPrice(), 
					resolveRequest.getReqDescription(), 
					resolveRequest.isReqFlag(), 
					resolveRequest.getReqDdate(), 
					resolveRequest.getAcceptDate(), 
					resolveRequest.getImg(), 
					resolveRequest.getUsersId(), 
					resolveRequest.isReject());
			spacificEmpRequests.add(requestPojo);
		});		

	    return spacificEmpRequests;

	}
	//--------------------------reject Request-------------------------------------------------------------------------------------------
	@Override
	public boolean rejectRequest(int reqId) throws ApplicationException {
		LocalDate today = LocalDate.now();
		Optional<RequestEntity> optional = this.requestRepositoryDao.findById(reqId);
		if(optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
			requestEntity.setReject(true);
			requestEntity.setAcceptDate(today);
			requestRepositoryDao.save(requestEntity);


				return true;
		}
		return false;
	}
}
