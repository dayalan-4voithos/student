package net.tao.dto;

import java.io.Serializable;

public class PaginatedResponse implements Serializable {

	private static final long serialVersionUID = 1009L;

	Object data;
	PaginationDto pagination;

	public Object getData() {
		return data;
	}

	public void setData(Object results) {
		this.data = results;
	}

	public PaginationDto getPagination() {
		return pagination;
	}

	public void setPagination(PaginationDto pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "{\"results\":\"" + data + "\", pagination\":\"" + pagination + "}";
	}

}
