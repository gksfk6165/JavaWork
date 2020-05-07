package com.lec.java.crawl04;

import org.jsoup.Jsoup;
import java.io.IOException;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {
	public static void main(String[] args) throws IOException {
		String url;
		Response response;

		url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EB%8F%99%EB%AC%BC%EC%9D%98%EC%88%B2";
		response = Jsoup.connect(url).execute(); //
		Document doc;
		Element element;
		Elements elements;
		doc=response.parse();
		elements=doc.select("._related_keyword_ul li");
		System.out.println(elements.size());
		for (Element e: elements) {
			element= e.selectFirst("a");
			System.out.println(element.text().trim());
		}
	}
}
