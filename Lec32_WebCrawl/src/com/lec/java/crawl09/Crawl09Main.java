package com.lec.java.crawl09;

import java.io.IOException;
import java.net.URLEncoder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//네이버
//블로그
//post title
//post url
//blog title
//페이징구현

public class Crawl09Main {
	public static void main(String[] args) throws IOException {
		System.out.println("네이버 페이징네이션");
		for(int i = 1; i <= 10; i++) {			
			crwalNaverBlog("파이썬", i);
		}
		
		System.out.println("프로그램종료");
	}

	public static void crwalNaverBlog(String search, int page) throws IOException {
		
		if (search == null || search.trim().length() == 0 || page < 1) {
			return;
		}
		System.out.println(page+"페이지=============");
		String url;
		Document doc;
		Elements elements;
	
		url=String.format("https://search.naver.com/search.naver?"
				+ "date_from=&date_option=0&"
				+ "date_to=&dup_remove=1&"
				+ "nso=&post_blogurl=&"
				+ "post_blogurl_without=&"
				+ "query=%s&"
				+ "sm=tab_pge&srchby=all&"
				+ "st=sim&where=post&"
				+ "start=%d",
				URLEncoder.encode(search,"utf-8"),page);
//		url = String.format("https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d", 
//				URLEncoder.encode(search, "utf-8"), (page - 1) * 10 + 1);
		doc=Jsoup.connect(url).execute().parse();
		
		elements=doc.select("#elThumbnailResultArea .sh_blog_top");
		System.out.println(elements.size());
		for (Element e: elements) {
			String postTitle=e.select("dl > dt > a").text().trim();
			String blogTitle = e.selectFirst("dd.txt_block a.txt84").text().trim();
			String postUrl = e.selectFirst("a.sh_blog_title").attr("href").trim();
			System.out.println(blogTitle);
		}
		
	}
}
