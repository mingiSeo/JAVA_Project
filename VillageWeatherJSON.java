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
 * VillageWeatherJSON Ŭ������ ���û���� �����ϴ� ���� ������͸� JSON���·� �������� Ŭ�����Դϴ�.
 * ���� ��������� JSON�����ͷ� �����ͼ� VillageWeather��ü�� ����� �����Ͽ� ��ȯ�մϴ�. */
public class VillageWeatherJSON {
	// ����Ű�� ���û���� �������ݴϴ�. ���������� ���Ǳ� ������ final static������ �����ϰڽ��ϴ�.
	final static String serviceKey = "zqt2pXvEByYws0tghELj%2BeqA1UWdf%2BzFTDgy%2B6gw3X3P2gyfvG%2FZEodh0fs%2FeHTDuXrh4NsmHzQiZ2fwhJ2nRA%3D%3D";

	//���� ��¥, �ð�, ����, �浵�� �Է��ϸ� �ش��ϴ� ������ ������������� JSON�����ͷ� ������ VillageWeater��ü�� ����� ��ȯ�մϴ�.
	//baseDate : ���س�¥, baseTime : ���ؽð�, x : �浵, y : ���� �������� Ȯ���ϼ���
	public VillageWeather getVillageWeather(String baseDate, String baseTime, int x, int y) {
		// JSON�����͸� ��û�ϴ� URLstr�� ����ϴ�.
       String urlStr = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?"
        		+ "serviceKey=" + serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime
        		+ "&nx="+ x + "&ny=" + y + "&_type=json";
		
       VillageWeather vl = new VillageWeather(); // ��� �����͸� ������ �������ü�� ����ϴ�.
        try {
        	URL url = new URL(urlStr); // �ϼ��� urlStr�� ����ؼ� URL ����� �ش� �����͸� �����ɴϴ�.
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            String result="";
            //���ۿ� �ִ� ������ ���ڿ��� ��ȯ.
            while((line=bf.readLine())!=null){ //bf �� �ִ°��� �о�ͼ� �ϳ��� ���ڿ��� ����ϴ�.
                result=result.concat(line);
            }
           //System.out.println(result);
            
            //���ڿ��� JSON���� �Ľ��մϴ�. ������ �迭���·� ����� �����ͱ��� �Ľ��س��ϴ�.
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
            JSONObject parse_response = (JSONObject) jsonObj.get("response");
            JSONObject parse_body = (JSONObject) parse_response.get("body");// response �� ���� body ã�ƿ���
            JSONObject parse_items = (JSONObject) parse_body.get("items");// body �� ���� items �޾ƿ���
            JSONArray parse_item = (JSONArray) parse_items.get("item");// items�� ���� itemlist �� �޾ƿ��� itemlist : �ڿ� [ �� �����ϹǷ� jsonarray�̴�.
            
            
    		JSONObject obj;
    		String category;
    		// ���� ��¥�� ���ؽð��� VillageWeather ��ü�� �����մϴ�.
    		vl.baseDate = baseDate;
    		vl.baseTime = baseTime;
    		
            for(int i = 0; i < parse_item.size(); i++) {
            	obj = (JSONObject) parse_item.get(i); // �ش� item�� �����ɴϴ�.
            	category = (String)obj.get("category"); //item���� ī�װ��� �˻��ؿɴϴ�.
            
            	// �˻��� ī�װ��� ��ġ�ϴ� ������ ���������� �����͸� �����մϴ�.
            	//�����͵��� ���°� �޶� ���ڿ��� �����ؾ� ���մϴ�. ������ ����Ҷ� �ٽú�ȯ�ϴ°� �����ϴ�.
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
        
        
		return vl;// ��簪�� ����� VillageWeather��ü�� ��ȯ�մϴ�.
    }
}