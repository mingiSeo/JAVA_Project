package test20190814;

public class control {
	public static void main(String[] args) {
		// ���� ��� JSON�����͸� ������� �ʿ��� ��û������ �Է����ݴϴ�.
		//baseDate : ���س�¥, baseTime : ���ؽð�, x : �浵, y : ���� �������� Ȯ���ϼ���
	    String baseDate = "20190814";
	    String baseTime = "1400"; //0200, 0500, 0800, 1100, 1400, 2000, 2300
		int x = 89;
		int y = 90;
	    
	    // ������͸� ������ ��ü�� ����
		VillageWeatherJSON vwJson = new VillageWeatherJSON();
		// ������͸� JSON���·� �޾� VillageWeather�� ����
		VillageWeather vw = vwJson.getVillageWeather(baseDate, baseTime, x, y);
		System.out.println("��ǥ��� : " + vw.getBaseDate());
		System.out.println("��ǥ�ð� : " + vw.getBaseTime());
		System.out.println("����Ȯ�� : " + vw.getPop());
		System.out.println("�������� : " + vw.getPty());
		System.out.println("6�ð� ������ : " + vw.getR06());
		System.out.println("���� : " + vw.getReh());
		System.out.println("6�ð� ������ : " + vw.getS06());
		System.out.println("�ϴû��� : " + vw.getSky());
		System.out.println("3�ð� ��� : " + vw.getT3h());
		System.out.println("��ħ ������� : " + vw.getTmn());
		System.out.println("�� �ְ��� : " + vw.getTmx());
		System.out.println("����ǳ�� : " + vw.getUuu());
		System.out.println("����ǳ�� : " + vw.getVvv());
		System.out.println("�İ� : " + vw.getWav());
		System.out.println("ǳ�� : " + vw.getVec());
		System.out.println("ǳ�� : " + vw.getWsd());
	}
}
