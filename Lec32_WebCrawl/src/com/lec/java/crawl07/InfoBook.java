package com.lec.java.crawl07;

public class InfoBook {
	private String bookName;   // 책제목
	private double price; // 책가격
	private String url;   // 상세페이지 url
	private String imgUrl;   // 썸네일 url
	
	// 기본생성자
	public InfoBook() {}
	// 매개변수 생성자
	public InfoBook(String bookTitle, double price, String url, String imgUrl) {
		super();
		this.bookName = bookTitle;
		this.price = price;
		this.url = url;
		this.imgUrl = imgUrl;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return bookName + " : " + price + "원, URL: " + url + ", img: " + imgUrl;
	}
	
}














