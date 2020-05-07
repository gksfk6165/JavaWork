package com.lec.java.crawl09;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawl09Main2 {
	public static void main(String[] args) throws IOException {
		System.out.println("네이버 페이징네이션");		
			crwalNaverMoive();
		System.out.println("프로그램종료");
	}

	public static void crwalNaverMoive() throws IOException {
		
		String url;
		Document doc;
		Elements elements;
	
		url="https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		doc=Jsoup.connect(url).execute().parse();
		
		elements=doc.select("#old_content > table > tbody > tr");
		for (Element e: elements) {
			String rank=e.select(".ac img").attr("alt").trim();
			String movieTitle = e.select(".tit3 a").text().trim();
			System.out.println(rank+"위 "+movieTitle);
		}
		
	}
}
