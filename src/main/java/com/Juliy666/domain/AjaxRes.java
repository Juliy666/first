package com.Juliy666.domain;

import lombok.Getter;
import lombok.Setter;

/*@Setter@Getter*/
public class AjaxRes {
    private boolean success;
    private String msg;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
    
}
