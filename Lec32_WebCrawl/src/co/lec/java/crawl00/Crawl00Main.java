package co.lec.java.crawl00;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl00Main {
	public static void main(String[] args) throws IOException {
		System.out.println("jsoup");
		
		Element element;
		Elements elements;
		
		File f=new File("data/hello.html");
		Document doc=Jsoup.parse(f,"UTF-8");
		
		element=doc.selectFirst("div");
		//System.out.println(element.outerHtml());
		
		elements=doc.select("div");
		//System.out.println(elements.outerHtml());
		
//		for (Element e:elements) {
//			System.out.println(e.outerHtml());
//		}
		element=doc.selectFirst("#addr");
		//System.out.println(element.outerHtml());
		elements=element.select(".favorite a");
		
		
		for (Element e:doc.select("img")) {
			System.out.println(e.attr("src").trim());
		}
		
		System.out.println("종료");
	}
}
