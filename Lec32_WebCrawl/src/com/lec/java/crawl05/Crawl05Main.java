package com.lec.java.crawl05;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


//국내도서 첫페이지 20개 아이템 크로링
//책이름 / 책가격 / 상세페이지url / 썸네일url
//yes24.com 사이트는 euc-kr url 인코딩되어잇다 한글1글장당2byte
public class Crawl05Main {
	
	public static final String PATH="books";
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("검색어를 입력하세요");
		String search=sc.nextLine();
		sc.close();
		
		Crawl05Main app=new Crawl05Main();
		ArrayList<InfoBook> list=app.crawlYes24(search);
		
		//썸네일 이미지 다운로드 받아서
		//thumb001.jpg~thumb002.jag....
		int fileIndex=1;
		for (InfoBook e:list) {
			System.out.println(e);//정보출력
			String filename=String.format(PATH, File.separator+"thumb%03d.jpg",fileIndex);
			URL imgUrl=new URL(e.getImgUrl());
			
			BufferedImage imgData=ImageIO.read(imgUrl);
			File file=new File(filename);
			ImageIO.write(imgData, "jpg", file);
			
			fileIndex++;
		}
		
	}
	
	private ArrayList<InfoBook> crawlYes24(String search) throws IOException{
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		String url;
		String enSearch=URLEncoder.encode(search,"euc-kr");
		Response response;
		url = "http://www.yes24.com/searchcorner/Search?keywordAd=&keyword=&domain=ALL&qdomain=%C0%FC%C3%BC&Wcode=001_005&query="+enSearch+"";
		response = Jsoup.connect(url).execute(); 
		Document doc;
		Elements elements;
		doc=response.parse();
	
		elements=doc.select("#schMid_wrap > div.goods_list_wrap.mgt30").get(0).select("tr:nth-child(odd)"); 
		System.out.println(elements.size());
		String bookName;
		double bookPrice;
		String bookUrl;
		String bookImgUrl;
		for (Element e: elements) {
			InfoBook ib=new InfoBook();
//			System.out.println(e.select("a strong").text().trim());
//			System.out.println(e.select(".goods_price .yes_b").text().trim());
//			System.out.println(e.select(".goods_img a img").attr("src").trim());
//			System.out.println(e.select(".goods_infogrp a").attr("href").trim());
			bookName=e.select("a strong").text().trim();
			bookPrice=Double.parseDouble(e.select(".goods_price .yes_b").text().trim().replace(",", ""));
			bookImgUrl=e.select(".goods_img a img").attr("src").trim();
			bookUrl="http://www.yes24.com"+e.select(".goods_infogrp a").attr("href").trim();
			ib.setBookTitle(bookName);
			ib.setPrice(bookPrice);
			ib.setImgUrl(bookImgUrl);
			ib.setUrl(bookUrl);
			list.add(ib);
		}
		return list;
	}
}
