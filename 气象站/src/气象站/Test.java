package 气象站;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData wd=new WeatherData();
		CurrentConditionsDisplay ccd=new CurrentConditionsDisplay(wd);//增加为观察者
		//增减为观察者
		StationDisplay sd=new StationDisplay(wd);//增加为观察者
		ForecastDisplay fd=new ForecastDisplay(wd);//增加为观察者
		//添加数据
		wd.setMeasurements(33.2f, 50, 80);
		wd.setMeasurements(37.1f, 45.3f, 75.2f);
		wd.setMeasurements(55.2f, 43, 55);
	}

}
