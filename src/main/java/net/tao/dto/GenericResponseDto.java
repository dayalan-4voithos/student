package net.tao.dto;

import java.io.Serializable;

public class GenericResponseDto implements Serializable {

	String message;
	boolean status;
	Object result;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "GenericResponseDto [message=" + message + ", status=" + status + ", result=" + result + "]";
	}
	
	

}
