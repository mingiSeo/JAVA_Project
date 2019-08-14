package test20190814;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * 
 * VillageWeatherJSON 클래스는 기상청에서 제공하는 동내 기상데이터를 JSON형태로 가져오는 클래스입니다.
 * 동내 기상정보를 JSON데이터로 가져와서 VillageWeather객체를 만들어 저장하여 반환합니다. */
public class VillageWeatherJSON {
	// 서비스키로 기상청에서 제공해줍니다. 고정적으로 사용되기 때문에 final static변수로 설정하겠습니다.
	final static String serviceKey = "zqt2pXvEByYws0tghELj%2BeqA1UWdf%2BzFTDgy%2B6gw3X3P2gyfvG%2FZEodh0fs%2FeHTDuXrh4NsmHzQiZ2fwhJ2nRA%3D%3D";

	//기준 날짜, 시간, 위도, 경도를 입력하면 해당하는 지역의 동내기상정보를 JSON데이터로 가져와 VillageWeater객체를 만들어 반환합니다.
	//baseDate : 기준날짜, baseTime : 기준시간, x : 경도, y : 위도 참고문서를 확인하세요
	public VillageWeather getVillageWeather(String baseDate, String baseTime, int x, int y) {
		// JSON데이터를 요청하는 URLstr을 만듭니다.
       String urlStr = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?"
        		+ "serviceKey=" + serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime
        		+ "&nx="+ x + "&ny=" + y + "&_type=json";
		
       VillageWeather vl = new VillageWeather(); // 결과 데이터를 저장할 동내기상객체를 만듭니다.
        try {
        	URL url = new URL(urlStr); // 완성된 urlStr을 사용해서 URL 만들어 해당 데이터를 가져옵니다.
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            String result="";
            //버퍼에 있는 정보를 문자열로 변환.
            while((line=bf.readLine())!=null){ //bf 에 있는값을 읽어와서 하나의 문자열로 만듭니다.
                result=result.concat(line);
            }
           //System.out.println(result);
            
            //문자열을 JSON으로 파싱합니다. 마지막 배열형태로 저장된 데이터까지 파싱해냅니다.
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
            JSONObject parse_response = (JSONObject) jsonObj.get("response");
            JSONObject parse_body = (JSONObject) parse_response.get("body");// response 로 부터 body 찾아오기
            JSONObject parse_items = (JSONObject) parse_body.get("items");// body 로 부터 items 받아오기
            JSONArray parse_item = (JSONArray) parse_items.get("item");// items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다.
            
            
    		JSONObject obj;
    		String category;
    		// 기준 날짜와 기준시간을 VillageWeather 객체에 저장합니다.
    		vl.baseDate = baseDate;
    		vl.baseTime = baseTime;
    		
            for(int i = 0; i < parse_item.size(); i++) {
            	obj = (JSONObject) parse_item.get(i); // 해당 item을 가져옵니다.
            	category = (String)obj.get("category"); //item에서 카테고리를 검색해옵니다.
            
            	// 검색한 카테고리와 일치하는 변수에 문자형으로 데이터를 저장합니다.
            	//데이터들이 형태가 달라 문자열로 통일해야 편합니다. 꺼내서 사용할때 다시변환하는게 좋습니다.
            	switch(category) {
            		case "POP":
            			vl.pop = (obj.get("fcstValue")).toString();
            			break;
            		case "PTY":
            			vl.pty = (obj.get("fcstValue")).toString();
            			break;
            		case "R06":
            			vl.r06 = (obj.get("fcstValue")).toString();
            			break;
            		case "REH":
            			vl.reh = (obj.get("fcstValue")).toString();
            			break;
            		case "S06":
            			vl.s06 = (obj.get("fcstValue")).toString();
            			break;
            		case "SKY":
            			vl.sky = (obj.get("fcstValue")).toString();
            			break;
            		case "T3H":
            			vl.t3h = (obj.get("fcstValue")).toString();
            			break;
            		case "TMN":
            			vl.tmn = (obj.get("fcstValue")).toString();
            			break;
            		case "TMX":
            			vl.tmx = (obj.get("fcstValue")).toString();
            			break;
            		case "UUU":
            			vl.uuu = (obj.get("fcstValue")).toString();
            			break;
            		case "VEC":
            			vl.vec = (obj.get("fcstValue")).toString();
            			break;
            		case "VVV":
            			vl.vvv = (obj.get("fcstValue")).toString();
            			break;
            		case "WAV":
            			vl.wav= (obj.get("fcstValue")).toString();
            			break;
            		case "WSD":
            			vl.wsd= (obj.get("fcstValue")).toString();
            			break;	
            	}
            }

            
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("ParseException : " + e.getMessage());		
		}
        
        
		return vl;// 모든값이 저장된 VillageWeather객체를 반환합니다.
    }
}