package ����վ;

import java.util.Observable;
import java.util.Observer;
//����Ԥ��

//�۲���
public class ForecastDisplay implements Observer,DisplayElement{
	private float currentPressure=50.0f;
	private float lastPressure;
	//private Subject weatherData;
	private Observable observable;
	/*ForecastDisplay(WeatherData wd){
		this.weatherData=wd;
		weatherData.registerObserver(this);
		
	}*/
	//���췽��
	ForecastDisplay(Observable observable){
		this.observable=observable;
		observable.addObserver(this);//��ӹ۲���
		
	}
	
	@Override
	public void dispaly() {//�����
		// TODO Auto-generated method stub
		if(lastPressure<currentPressure){
			System.out.println("������������");
		}else if(lastPressure==currentPressure){
			System.out.println("����û�б仯");
		}else if(lastPressure>currentPressure){
			System.out.println("���������½�");
		}
	}

	/*public void updata(float temperature, float humidity, float pressure) {
		// TODO Auto-generated method stub
		lastPressure=currentPressure;
		currentPressure=pressure;
		dispaly();
	}*/


	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(o instanceof WeatherData){
			lastPressure=currentPressure;
			currentPressure=((WeatherData) o).getPressure();
			dispaly();
		}
	}
	
}
