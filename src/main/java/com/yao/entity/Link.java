package com.yao.entity;

/**
 * 友情链接实现
 * @author user
 *
 */
public class Link {

	private Integer id; // 编号
	private String name; // 链接名称
	private String url; // 链接地址
	private Integer sortNo; // 排列序号
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	
	
}
