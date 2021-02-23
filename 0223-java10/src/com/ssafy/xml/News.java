package com.ssafy.xml;

public class News {
	private String title;
	private String author;
	private String date;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		date.substring(0, 1);
		this.date = date;
	}

	public News() {
		super();
	}
	
	public News(String title, String author, String date) {
		super();
		this.title = title;
		this.author = author;
		this.date = date;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("제목: ");
		builder.append(String.format("%.25s", title));
		builder.append("    || ");
		builder.append("기자: ");
		builder.append(author);
		builder.append("  ||   ");
		builder.append("날짜: ");
		builder.append(date.substring(0, 16));
		builder.append("     ");
		return builder.toString();
	}
}
