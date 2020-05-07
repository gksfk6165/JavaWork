package com.lec.java.crawl03;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {
	public static void main(String[] args) throws IOException {
		System.out.println("다음");
		
		String url;
		Response response;

		url = "https://www.daum.net";
		response = Jsoup.connect(url).execute(); //
		Document doc;
		Element element;
		Elements elements;
		doc=response.parse();
		System.out.println(response.statusCode());
		elements=doc.select(".list_favorsch li a");
		System.out.println(elements.size());
		for (Element e: elements) {
			element= e.selectFirst("a");
			System.out.println(element.text().trim());
			System.out.println(element.attr("href").trim());
		
		}
		
		System.out.println("종료");
	}
}
