package ����վ;

import java.util.Observable;
import java.util.Observer;
//��ʾ�����С��ƽ���¶�
//�۲���
public class StationDisplay implements Observer,DisplayElement{
	private Observable observable;
	private float max=0.0f;
	private float min=200.0f;
	private float sumTemp;//�¶Ⱥ�
	private int times;//ͳ�ƴ���
	//private WeatherData weatherData; 
	
	 /*public StatisticsDisplay(WeatherData weatherData) {  
	        this.weatherData = weatherData;  
	        weatherData.registerObserver(this);  
	    }*/  
	
	StationDisplay(Observable observable){
		this.observable=observable;
		observable.addObserver(this);//���ӹ۲���
	}
	@Override
	public void dispaly() {
		// TODO Auto-generated method stub
		System.out.println("����¶ȣ�"+max+"\t"+"��С�¶ȣ�"+min+"\t"+"ƽ���¶ȣ�"+(sumTemp/times));
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
