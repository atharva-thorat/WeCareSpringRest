package com.wecarelife.dto;

public class LoginDTO {

	private Integer id;
	private String password;
	
	public LoginDTO() {}
	
	public LoginDTO(Integer id,String password) {
		this.id = id;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}