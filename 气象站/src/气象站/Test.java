package ����վ;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData wd=new WeatherData();
		CurrentConditionsDisplay ccd=new CurrentConditionsDisplay(wd);//����Ϊ�۲���
		//����Ϊ�۲���
		StationDisplay sd=new StationDisplay(wd);//����Ϊ�۲���
		ForecastDisplay fd=new ForecastDisplay(wd);//����Ϊ�۲���
		//�������
		wd.setMeasurements(33.2f, 50, 80);
		wd.setMeasurements(37.1f, 45.3f, 75.2f);
		wd.setMeasurements(55.2f, 43, 55);
	}

}
