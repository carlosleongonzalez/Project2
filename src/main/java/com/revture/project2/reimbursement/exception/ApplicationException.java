package com.revture.project2.reimbursement.exception;

public class ApplicationException extends Exception {
	String msg;
	public ApplicationException(String msg) {
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return this.msg;
	}

}
