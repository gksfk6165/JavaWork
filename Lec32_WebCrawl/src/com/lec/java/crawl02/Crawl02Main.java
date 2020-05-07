package com.lec.java.crawl02;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main {
	public static void main(String[] args) throws IOException {
		System.out.println("네이트인기검색어");
		
		String url;
		Response response;

		url = "https://www.nate.com";
		response = Jsoup.connect(url).execute(); //
		Document doc;
		Element element;
		Elements elements;
		doc=response.parse();
		
		elements=doc.select(".search_keyword dd a");
		
		for (Element e: elements) {
			element= e.selectFirst("a");
			System.out.println(element.text());
		
		}
		
		System.out.println("종료");
	}
}
