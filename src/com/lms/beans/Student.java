package com.lms.beans;

public class Student {

	private int id;
	private String name;
	private String email;
	private String course;
	private String password;

	public Student() {

	}

	public Student(String name, String email, String course, String password) {
		super();
		this.name = name;
		this.email = email;
		this.course = course;
		this.password = password;
	}

	public Student(int id, String name, String email, String course, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.course = course;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", course=" + course + ", password="
				+ password + "]";
	}

}
