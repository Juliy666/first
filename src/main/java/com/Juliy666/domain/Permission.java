package com.Juliy666.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*@Setter@Getter@ToString*/
public class Permission {
    private Long pid;

    private String pname;

    private String presource;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPresource() {
		return presource;
	}

	public void setPresource(String presource) {
		this.presource = presource;
	}

	@Override
	public String toString() {
		return "Permission [pid=" + pid + ", pname=" + pname + ", presource=" + presource + "]";
	}
	


}