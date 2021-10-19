package com.tienda.tienda.services.exeptions;

import java.util.Date;

public class ExceptionResponse {
	private Date timeestamp;
	private String message;
	private String details;
	public Date getTimeestamp() {
		return timeestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public ExceptionResponse(Date timeestamp, String message, String details) {
		super();
		this.timeestamp = timeestamp;
		this.message = message;
		this.details = details;
	}

}
