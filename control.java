package test20190814;

public class control {
	public static void main(String[] args) {
		// 동내 기상 JSON데이터를 얻기위해 필요한 요청변수를 입력해줍니다.
		//baseDate : 기준날짜, baseTime : 기준시간, x : 경도, y : 위도 참고문서를 확인하세요
	    String baseDate = "20190814";
	    String baseTime = "1400"; //0200, 0500, 0800, 1100, 1400, 2000, 2300
		int x = 89;
		int y = 90;
	    
	    // 기상데이터를 얻어오는 객체를 생성
		VillageWeatherJSON vwJson = new VillageWeatherJSON();
		// 기상데이터를 JSON형태로 받아 VillageWeather에 저장
		VillageWeather vw = vwJson.getVillageWeather(baseDate, baseTime, x, y);
		System.out.println("발표년월 : " + vw.getBaseDate());
		System.out.println("발표시간 : " + vw.getBaseTime());
		System.out.println("강수확률 : " + vw.getPop());
		System.out.println("강수형태 : " + vw.getPty());
		System.out.println("6시간 강수량 : " + vw.getR06());
		System.out.println("습도 : " + vw.getReh());
		System.out.println("6시간 신적설 : " + vw.getS06());
		System.out.println("하늘상태 : " + vw.getSky());
		System.out.println("3시간 기온 : " + vw.getT3h());
		System.out.println("아침 최저기온 : " + vw.getTmn());
		System.out.println("낮 최고기온 : " + vw.getTmx());
		System.out.println("동서풍속 : " + vw.getUuu());
		System.out.println("남북풍속 : " + vw.getVvv());
		System.out.println("파고 : " + vw.getWav());
		System.out.println("풍향 : " + vw.getVec());
		System.out.println("풍속 : " + vw.getWsd());
	}
}
