package com.lec.java.crawl14;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

//http://openapi.seoul.go.kr:8088/53646a6847746a723131384a52787277/json/CardSubwayStatsNew/1/5/20181001
public class Crawl14Main {
	public static void main(String[] args) throws IOException {
		System.out.println("잭슨데이터바인드 연습");
		System.out.println("url->josn->java");
		
		ObjectMapper mapper= new ObjectMapper();
		URL url=new URL("http://openapi.seoul.go.kr:8088/53646a6847746a723131384a52787277/json/CardSubwayStatsNew/1/5/20181001");
		
		Subway subway=mapper.readValue(url, Subway.class);
		
		System.out.println(subway.getCardSubwayStatsNew().getList_total_count());
		
		for(SubRow e:subway.getCardSubwayStatsNew().getRow()) {
			System.out.printf("%5s : %8s역 [승차:%6s 하차:%6s]\n",
					e.getLineNum(), e.getStationName(), e.getRidePassenger(), e.getAlightPassenger());
			
		}
	}
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Subway{
	public Stats CardSubwayStatsNew;

	public Stats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {
		CardSubwayStatsNew = cardSubwayStatsNew;
	}
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Stats{
	private int list_total_count;
	private List<SubRow>row;
	
	public List<SubRow> getRow() {
		return row;
	}

	public void setRow(List<SubRow> row) {
		this.row = row;
	}

	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
}

//JSON 필드명가 매핑되는 java 객체의 변수명을달맇고싶으면

@JsonIgnoreProperties(ignoreUnknown = true)
class SubRow{
	@JsonProperty("LINE_NUM")
	private String lineNum;
	@JsonProperty("SUB_STA_NM")
	private String stationName;
	@JsonProperty("RIDE_PASGR_NUM")
	private int ridePassenger;
	@JsonProperty("ALIGHT_PASGR_NUM")
	private int alightPassenger;
	
	public String getLineNum() {
		return lineNum;
	}
	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public int getRidePassenger() {
		return ridePassenger;
	}
	public void setRidePassenger(int ridePassenger) {
		this.ridePassenger = ridePassenger;
	}
	public int getAlightPassenger() {
		return alightPassenger;
	}
	public void setAlightPassenger(int alightPassenger) {
		this.alightPassenger = alightPassenger;
	}
	
	
}





