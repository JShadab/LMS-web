package com.lms.beans;

public class Book {

	private int id;
	private String title;
	private String author;
	private String subject;
	private int units;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, String subject, int units) {
		super();

		this.title = title;
		this.author = author;
		this.subject = subject;
		this.units = units;
	}

	public Book(int id, String title, String author, String subject, int units) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.units = units;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", subject=" + subject + ", units="
				+ units + "]";
	}

}
