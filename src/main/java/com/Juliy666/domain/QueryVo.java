package com.Juliy666.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*@Setter@Getter@ToString*/
public class QueryVo {
    private int page;
    private int rows;
    private String keyword;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "QueryVo [page=" + page + ", rows=" + rows + ", keyword=" + keyword + "]";
	}
    
}
