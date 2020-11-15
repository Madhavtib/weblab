package com.login.Dao;

public class Fac {
	private String fid;
	private String fname;
	private String email;
	private String dept;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Fac(String fid, String fname, String email, String dept) {
		this.fid = fid;
		this.fname = fname;
		this.email = email;
		this.dept = dept;
	}
	public Fac() {
	}
	
}
