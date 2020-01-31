package br.com.danielcrdev.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private Date timestamp;
	private String massage;
	private String details;
	
	public ExceptionResponse(Date timestamp, String massage, String details) {
		super();
		this.timestamp = timestamp;
		this.massage = massage;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMassage() {
		return massage;
	}

	public String getDetails() {
		return details;
	}

}
