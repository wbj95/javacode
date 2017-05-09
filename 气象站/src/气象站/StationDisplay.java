package 气象站;

import java.util.Observable;
import java.util.Observer;
//显示最大，最小，平均温度
//观察者
public class StationDisplay implements Observer,DisplayElement{
	private Observable observable;
	private float max=0.0f;
	private float min=200.0f;
	private float sumTemp;//温度和
	private int times;//统计次数
	//private WeatherData weatherData; 
	
	 /*public StatisticsDisplay(WeatherData weatherData) {  
	        this.weatherData = weatherData;  
	        weatherData.registerObserver(this);  
	    }*/  
	
	StationDisplay(Observable observable){
		this.observable=observable;
		observable.addObserver(this);//增加观察者
	}
	@Override
	public void dispaly() {
		// TODO Auto-generated method stub
		System.out.println("最大温度："+max+"\t"+"最小温度："+min+"\t"+"平均温度："+(sumTemp/times));
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof WeatherData){
			WeatherData wd=(WeatherData)o;
			float temp=wd.getTemperature();
			sumTemp+=temp;
			times++;
			if(temp>max){
				max=temp;
			}
			if(temp<min){
				min=temp;
			}
			dispaly();
		}
	}

	/*public void update(float temp, float humidity, float pressure) {  
        tempSum += temp;  
        numReadings++;  
          
        if(temp > maxTemp) {  
            maxTemp = temp;  
        }  
        if(temp < minTemp) {  
            minTemp = temp;  
        }  
          
        display();  
    } */ 
}
