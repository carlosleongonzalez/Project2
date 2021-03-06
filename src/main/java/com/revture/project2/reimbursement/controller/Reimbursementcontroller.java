package com.revture.project2.reimbursement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revture.project2.reimbursement.exception.ApplicationException;
import com.revture.project2.reimbursement.pojo.RequestPojo;
import com.revture.project2.reimbursement.pojo.UsersPojo;
import com.revture.project2.reimbursement.service.RequestServicList;
import com.revture.project2.reimbursement.service.UsersServicList;

@RestController// to make the class RESt controller class
@RequestMapping("api")// option
@CrossOrigin(origins = "http://localhost:4200")
public class Reimbursementcontroller {
	
	
	// we want an object from
	// RequestServicEmpliment requestServicEmpliment = new RequestServicEmpliment();
	// so we tell spring framework create an object from RequestServiceEmliments class 
	// implements RequestServicList and has the @Service annotation
	
	@Autowired // go get any bean implement the RequestServicList and has @Service annotation and inject here  
	RequestServicList requestServicList;
	
	@Autowired
	UsersServicList usersServicList;
	
	public Reimbursementcontroller() {

	}

	// -------------------add request------------------------------------------------------------------
	// http://localhost:8080/api/request
	@PostMapping("request")
	//@RequestBody when you pass request body whatever comes in the response body restore in a RequestPojo object
	RequestPojo addRequest(@Valid @RequestBody RequestPojo requestPojo)throws ApplicationException{	
		System.out.print(requestPojo.getReqDate());
		return requestServicList.addRequest(requestPojo);
	}
	
	// ------------------ User Pending Requesters--------------------------------------------------------
	// http://localhost:8080/api/request/pend/{Id}
	@GetMapping("request/pend/{Id}")
	List<RequestPojo> userPendingRequestes(@PathVariable("Id")int Id)throws ApplicationException{		
		return requestServicList.userPendingRequestes(Id);
	}
	
	// ---------------User Resolve Request---------------------------------------------------------------
	// http://localhost:8080/api/request/resolve/{Id}
	@GetMapping("request/resolve/{Id}")
	List<RequestPojo> userResolveRequest(@PathVariable("Id") int Id)throws ApplicationException{
		return requestServicList.userResolveRequest(Id);
	}
	
	// ---------------approve Request--------------------------------------------------------------------
	// http://localhost:8080/api/request/{reqId}
	@PatchMapping("request/{reqId}")
	//@PathVariabl take the pass variable and copy it to method parameter
	boolean approveRequest(@PathVariable("reqId") int reqId)throws ApplicationException{
		return requestServicList.approveRequest(reqId);
	}
	
	// ------------all Pending Request-------------------------------------------------------------------
	// http://localhost:8080/api/request/pending
	@GetMapping("request/pending")
	List<RequestPojo>  allPendingRequsts()throws ApplicationException{
		return requestServicList.allPendingRequsts();
	}
	
	// ------------- all Resolved Request----------------------------------------------------------------
	// http://localhost:8080/api/request/resolve
	@GetMapping("request/resolve")
	List<RequestPojo> allResolvedRequsts()throws ApplicationException{
		return requestServicList.allResolvedRequsts();
	}
	
	// -----------------SpecificRequest------------------------------------------------------------------
	// http://localhost:8080/api/request/spacific/{userId}
	@GetMapping("request/spacific/{userId}")
	List<RequestPojo>  spacificEmployeeRequests(@PathVariable("userId") int userId)throws ApplicationException{
		return requestServicList.spacificEmployeeRequests(userId);
	}
	
	// ---------------reject Request---------------------------------------------------------------------
	// http://localhost:8080/api/request/reject/{reqId}
	@PatchMapping("request/reject/{reqId}")
	boolean rejectRequest(@PathVariable("reqId")int reqId)throws ApplicationException{
		return requestServicList.rejectRequest(reqId);
	}
	
	// -----------update user Profile--------------------------------------------------------------------
	// http://localhost:8080/api/users/update/{userId}
	@PutMapping("users/update/{userId}")
	UsersPojo updateUserProfile(@Valid @RequestBody UsersPojo userPojo)throws ApplicationException{
		return usersServicList.updateUserProfile(userPojo);
	}
	
	// --------------------Login-------------------------------------------------------------------------
	// http://localhost:8080/api/users/login
	@PostMapping("users/login")
	UsersPojo logIn(@RequestBody UsersPojo userPojo)throws ApplicationException{
		return usersServicList.logIn(userPojo);
	}
	
	// ----------- register -----------------------------------------------------------------------------
	// http://localhost:8080/api/users/register
	@PostMapping("users/register")
	UsersPojo register(@Valid @RequestBody UsersPojo userPojo)throws ApplicationException{
		return usersServicList.register(userPojo);
	}
	
	// ---------------all Employees----------------------------------------------------------------------
	// http://localhost:8080/api/users/employee
	@GetMapping("users/employee")
	List<UsersPojo> allEmployees()throws ApplicationException{
		return usersServicList.allEmployees();
	}
	
	// ----------------user profile-------------------------------------------------------------------------
	//http://localhost:8080/api/users/profile/{userId}
	@GetMapping("users/profile/{userId}")
	UsersPojo getUserById(@PathVariable("userId") int userId) throws ApplicationException{
		return usersServicList.getUserById(userId);
	}
	
	// ----------------Send Email-------------------------------------------------------------------------
	//http://localhost:8080/api/users/email/{userId}/{flag}
	@PatchMapping("users/email/{userId}/{flag}")
	boolean sendEmail(@PathVariable("userId") int userId, @PathVariable("flag") int flag) throws ApplicationException{
		return usersServicList.sendEmail(userId,flag);
	}

}
