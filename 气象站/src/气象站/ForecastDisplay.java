package 气象站;

import java.util.Observable;
import java.util.Observer;
//天气预报

//观察者
public class ForecastDisplay implements Observer,DisplayElement{
	private float currentPressure=50.0f;
	private float lastPressure;
	//private Subject weatherData;
	private Observable observable;
	/*ForecastDisplay(WeatherData wd){
		this.weatherData=wd;
		weatherData.registerObserver(this);
		
	}*/
	//构造方法
	ForecastDisplay(Observable observable){
		this.observable=observable;
		observable.addObserver(this);//添加观察者
		
	}
	
	@Override
	public void dispaly() {//布告板
		// TODO Auto-generated method stub
		if(lastPressure<currentPressure){
			System.out.println("气温正在升高");
		}else if(lastPressure==currentPressure){
			System.out.println("气温没有变化");
		}else if(lastPressure>currentPressure){
			System.out.println("气温正在下降");
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
