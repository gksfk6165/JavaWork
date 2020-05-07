package com.lec.java.crawl01;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * 외부 라이브러리 사용한 자바프로젝트 
 * 
 * 프로젝트내 라이어브리 저장
 * 
 * 프로젝트의 build path설정
 * 
 * https://jsoup.org 에서 다운
 * 
 * 프로젝트우클릭 add jars
 * 
 * 
 * 네이버뉴스캐스트 상단의 실시간 뉴스
 * */
public class Crawl01Main {
	public static void main(String[] args) throws IOException {
		System.out.println("네이버 뉴스 캐스트 크롤링");

		String url;// 크롤링할 url
		Response response;
		Document doc;
		Element element;

		url = "https://www.naver.com";
		response = Jsoup.connect(url).execute(); //get방식 request는 다음과 같이 해도된다 ->Jsoup.connect(url).get();
		
		System.out.println(response.statusCode());
//		request 결과코드
//		200 성공
//		404 url 존재하지 않음
//		500 서버 내부 
//		400 Bad Request : request 문법상의 오류
//		401 권한에러 : 권한 관현 적절한 header 정보가 없는 경우 많이 발생
//		402 권한에러 : 자원에 대한 접근 권한 에러
//		403  권한에러 Forbidden : 파일권한, 읽기권한, SSL, IP, 등...  <--- 웹 크롤링 하다가 은근히 자주 마주치게 되는 에러
	
		System.out.println(response.statusMessage());
		doc=response.parse();
		
		System.out.println(doc.title());//<title> element의 속성
		System.out.println(doc.location());//<title> element의 속성
		//System.out.println(doc.outerHtml());//<title> element의 속성
		String outerHtml=doc.outerHtml();
		System.out.println(outerHtml.substring(0,200)+"...");
		
		System.out.println("네이버뉴스캐스트");
		
		element=doc.selectFirst("#news_cast"); //최초 하나만 뽑아낼때
		//System.out.println(element.outerHtml());
		doc.select("#news_cast li.ca_item"); //검색된 엘리먼트들이 담겨잇는 엘리먼츠 리턴
		Elements elements;
		elements=doc.select("#news_cast li.ca_item"); 
		//목록 크롤링 할시 내가 원하는 '개수'만큼 크로링되었느지 우선확인해보자
		System.out.println(elements.size());
		for (Element e: elements) {
			//System.out.println(e.outerHtml());
			element= e.selectFirst("a");
			System.out.println(element.text());
			System.out.println(element.attr("href"));
		}
		
		System.out.println("종료");
	}
}
