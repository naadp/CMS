package com.yao.entity;

public class Manager {

	// ���
	private Integer id;
	// �û���
	private String userName;
	// ����
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(Integer id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", userName=" + userName + ", password="
				+ password + "]";
	}

}
