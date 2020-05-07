package com.lec.java.crawl08;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//크롤링 검색페이지
//첫페이지url체크
//두번쨰 페이지부터 url 변화 확인 어떤방식 어떤파라미터사용인지
//검색결과 마지막 페이지는 어떻게 처리하는지

public class Crawl08Main {
	public static void main(String[] args) throws IOException {
		System.out.println("페이징네이션");
		
		for (int i = 0; i <=10; i++) {
			crwalDaumBlog("파이썬",i);
		}
		
		System.out.println("프로그램종료");
	}

	public static void crwalDaumBlog(String search, int page) throws IOException {
		
		//post title
		//post link url
		//blog title
		
		if (search == null || search.trim().length() == 0 || page < 1) {
			return;
		}
		System.out.println(page+"페이지=============");
		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;
		url=String.format("https://search.daum.net/search?w=blog&DA=PGD&enc=utf8&q=%s&page=%d",
				URLEncoder.encode(search,"utf-8"),page);
		
		doc=Jsoup.connect(url).execute().parse();
		elements=doc.select("#blogColl .list_info .wrap_cont");
		
		for (Element e: elements) {
			String postTitle=e.selectFirst("a").text().trim();
			String blogTitle=e.select(".info .f_nb").text().trim();
			String linkUrl=e.selectFirst("a").attr("href").trim();
			//String postTitle=e.selectFirst("a").text().trim();
			System.out.println(postTitle);
			System.out.println(blogTitle);
			System.out.println(linkUrl);
		}
		
	}
}
