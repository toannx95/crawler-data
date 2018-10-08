package com.crawler.dto;

public class ActionDto {

	public enum Status {
		SUCCESS, FAIL
	};

	private Status status;
	private Object message;

	public ActionDto() {
		super();
	}

	public ActionDto(Status status, Object message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

}
