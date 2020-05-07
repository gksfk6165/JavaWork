package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요 12번
// JSON 은  jackson 을 활용하여 파싱하세요14번


public class DailySumMain {
	
	public static final String APIKEY="53646a6847746a723131384a52787277";
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		//http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
		//http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
		System.out.println("요청시작index : ex)1");
		int startIndex=sc.nextInt();
		System.out.println("요청종료index : ex)5");
		int endIndex=sc.nextInt();
		System.out.println("기준일ID : ex)20190101");
		int stdrDeId=sc.nextInt();
		
		XML(startIndex,endIndex,stdrDeId);
		System.out.println("========================================");
		JSON(startIndex,endIndex,stdrDeId);

	} // end main
	public static void XML(int sIndex,int eIndex,int date) throws IOException {
		System.out.println("XML 파싱");
		Document doc = Jsoup.connect("http://openapi.seoul.go.kr:8088/"
				+ ""+APIKEY+"/"
				+ "xml/"
				+ "SPOP_DAILYSUM_JACHI/"
				+ ""+sIndex+"/"
				+ ""+eIndex+"/"
				+ ""+date+"/")
				.parser(Parser.xmlParser()).get();;
        Elements elements = doc.select("row");
        for (Element e : elements) {
            System.out.println(
            		e.selectFirst("STDR_DE_ID").text().trim()+"\t"
    				+e.selectFirst("SIGNGU_CODE_SE").text().trim()+"\t"
    				+e.selectFirst("TOT_LVPOP_CO").text().trim()+"\t"
    				+e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim()
            		);
        }
	}
	public static void JSON(int sIndex,int eIndex,int date) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("JSON 파싱");
		ObjectMapper om=new ObjectMapper();
		URL url=new URL("http://openapi.seoul.go.kr:8088/"+APIKEY+"/json/SPOP_DAILYSUM_JACHI/"+sIndex+"/"+eIndex+"/"+date+"/");
		SpopDailysumJachi sd=om.readValue(url, SpopDailysumJachi.class);
		
		for(SubRow e :sd.getSPOP_DAILYSUM_JACHI().getRow()) {
			System.out.println(e.getSTDR_DE_ID()+"\t"+e.getSIGNGU_CODE_SE()+"\t"+ e.getTOT_LVPOP_CO()+"\t"+e.getDAIL_MXMM_LVPOP_CO());
		}
	}
} // end class
@JsonIgnoreProperties(ignoreUnknown = true)
class SpopDailysumJachi{
	public Stat SPOP_DAILYSUM_JACHI;

	public Stat getSPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}

	public void setSPOP_DAILYSUM_JACHI(Stat sPOP_DAILYSUM_JACHI) {
		SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}
	
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Stat{
	private int list_total_count;
	private List<SubRow>row;
	
	public int getList_total_count() {
		return list_total_count;
	}
	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	public List<SubRow> getRow() {
		return row;
	}
	public void setRow(List<SubRow> row) {
		this.row = row;
	}
}
@JsonIgnoreProperties(ignoreUnknown = true)
class SubRow{
	@JsonProperty("SIGNGU_CODE_SE")
	private String SIGNGU_CODE_SE;
	@JsonProperty("STDR_DE_ID")
	private String STDR_DE_ID;
	@JsonProperty("TOT_LVPOP_CO")
	private String TOT_LVPOP_CO;
	@JsonProperty("DAIL_MXMM_LVPOP_CO")
	private String DAIL_MXMM_LVPOP_CO;
	public String getSIGNGU_CODE_SE() {
		return SIGNGU_CODE_SE;
	}
	public void setSIGNGU_CODE_SE(String sIGNGU_CODE_SE) {
		SIGNGU_CODE_SE = sIGNGU_CODE_SE;
	}
	public String getSTDR_DE_ID() {
		return STDR_DE_ID;
	}
	public void setSTDR_DE_ID(String sTDR_DE_ID) {
		STDR_DE_ID = sTDR_DE_ID;
	}
	public String getTOT_LVPOP_CO() {
		return TOT_LVPOP_CO;
	}
	public void setTOT_LVPOP_CO(String tOT_LVPOP_CO) {
		TOT_LVPOP_CO = tOT_LVPOP_CO;
	}
	public String getDAIL_MXMM_LVPOP_CO() {
		return DAIL_MXMM_LVPOP_CO;
	}
	public void setDAIL_MXMM_LVPOP_CO(String dAIL_MXMM_LVPOP_CO) {
		DAIL_MXMM_LVPOP_CO = dAIL_MXMM_LVPOP_CO;
	}
	
	
}