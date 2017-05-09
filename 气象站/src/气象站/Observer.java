package 气象站;

import java.util.Observable;
import java.util.Observer;
/*public interface Observer {   观察者接口
	public void updata(float temperature,float humidity,float pressure);//当气象观测值改变时，主题会把这些状态值当作方法的参数，传送给观察者。
}
*/
//显示数据
interface DisplayElement{  //公告板接口
	public void dispaly();//当布告板需要显示时，调用此方法。
}
//显示当前气象数据


//观察者实现观察者接口和公告板接口
class CurrentConditionsDisplay implements Observer,DisplayElement{
	private float temperature;
	private float humidity;
	private float pressure;
	Observable observable;
	//构造方法
	public CurrentConditionsDisplay(Observable observable) {  
        this.observable = observable;  
        observable.addObserver(this);       //登记为观察者  
    }
	public void update(Observable obs, Object arg) {  
        if(obs instanceof WeatherData) {  
            WeatherData weatherData = (WeatherData) obs;  
            this.temperature = weatherData.getTemperature();  
            this.humidity = weatherData.getHumidity();  
            dispaly();  
        } 
	}
	public void dispaly(){
		System.out.println("目前的温度为："+temperature+"\t"+"目前的湿度为："+humidity+"\t"+"目前的气压为："+pressure);
	}
	
	
}
