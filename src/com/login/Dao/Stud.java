package com.login.Dao;

public class Stud {

	private String sid;
	private String sname;
	private String dept;
	private String email;
	private int year;

	public Stud(String sid, String sname, String dept, int year, String email) {
		this.sid = sid;
		this.sname = sname;
		this.dept = dept;
		this.year = year;
		this.email=email;
	}
	public Stud() {
		// TODO Auto-generated constructor stub
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
