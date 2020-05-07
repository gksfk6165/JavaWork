package com.lec.java.crawl15;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * xml ,json 파싱 연습
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/2/서울
*/
public class Crawl15Main {
	public static void main(String[] args) throws IOException {
		System.out.println("잭슨데이터바인드 연습");
		
		ObjectMapper mapper= new ObjectMapper();
		URL url=new URL("http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/2/"+URLEncoder.encode("서울","utf-8")+"");
		
		Subway sw=mapper.readValue(url, Subway.class);
		
		for(StationStat e :sw.getStationList()) {
			System.out.println(e.getStatnNm()+" / "+e.getSubwayId()+" / "+ e.getSubwayNm());
		}
		System.out.println("\n종료");
	}
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Subway{	
	public List<StationStat> stationList;

	public List<StationStat> getStationList() {
		return stationList;
	}

	public void setStationList(List<StationStat> stationList) {
		this.stationList = stationList;
	}
}
@JsonIgnoreProperties(ignoreUnknown = true)
class StationStat{
	
	private String statnNm;
	private int subwayId;
	private String subwayNm;
	
	public String getStatnNm() {
		return statnNm;
	}
	public void setStatnNm(String statnNm) {
		this.statnNm = statnNm;
	}
	public int getSubwayId() {
		return subwayId;
	}
	public void setSubwayId(int subwayId) {
		this.subwayId = subwayId;
	}
	public String getSubwayNm() {
		return subwayNm;
	}
	public void setSubwayNm(String subwayNm) {
		this.subwayNm = subwayNm;
	}
	
	
}