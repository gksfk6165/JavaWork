package com.lec.java.crawl07;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl07Main {

	private static final String PATH = "books";
	
	public static void main(String[] args) throws IOException {
		System.out.println("인터파크도서");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		String search = sc.nextLine(); 
		sc.close();
		
		Crawl07Main app = new Crawl07Main();
		ArrayList<InfoBook> list = app.crawlInterPark(search);
		
		for (InfoBook e: list) {
			System.out.println(e.toString());
		}
		System.out.println("\n프로그램 종료");
	} // end main()

	
	private ArrayList<InfoBook> crawlInterPark(String search) throws IOException {
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		
		url="http://bsearch.interpark.com/dsearch/book.jsp?"
				+ "sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&"
				+ "bid1=search_auto&"
				+ "bid2=product&bid3=000&"
				+ "bid4=001&"
				+ "query="+URLEncoder.encode(search,"euc-kr")+"";
		response = Jsoup.connect(url).execute(); 
		doc=response.parse();
		elements=doc.select("#bookresult > form div.list_wrap");
		System.out.println("======="+elements.size()+"개의 검색결과"+"=======");
		for (Element e: elements) {
			
			InfoBook ib=new InfoBook();
			String bookTitle=e.select(".tit a").text().trim();
			int idx=e.select(".nowMoney").text().trim().indexOf("원");
			double bookPrice=Double.parseDouble(e.select(".nowMoney").text().trim().substring(0,idx).replace(",", ""));
			String bookImgUrl=e.select(".bimgWrap .bd").attr("src").trim();
			String bookDetailUrl=e.select(".tit a").attr("href").trim();
			
			ib.setBookName(bookTitle);
			ib.setPrice(bookPrice);
			ib.setImgUrl(bookImgUrl);
			ib.setUrl(bookDetailUrl);
			list.add(ib);
		}
		return list;
	}
} // end class

//int fileIndex = 1;
//for(InfoBook e : list) {
//	System.out.println(e);  // 크롤링 정보 출력
//	
//	// 썸네일 이미지 다운로드
//	String fileName = String.format(PATH + File.separator + "thumb%03d.jpg", fileIndex);
//	URL imgUrl = new URL(e.getImgUrl());
//	
//	BufferedImage imgData = ImageIO.read(imgUrl);
//	File file = new File(fileName);
//	ImageIO.write(imgData, "jpg", file);			
//	
//	System.out.println(fileName + " 이 저장되었습니다");
//	fileIndex++;
//}


