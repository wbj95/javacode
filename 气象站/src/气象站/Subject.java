package 气象站;

import java.util.ArrayList;
import java.util.Observable;//java　ＡＰＩ已经有有观察者模式了

/*public interface  Subject {  主题接口
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}*/
//class WeatherData implements Subject{

//主题
class WeatherData extends Observable{//Observable是一个类，不是接口
    //private ArrayList observer;//用集合装观察者
	private float temperature;//温度
	private float humidity;//湿度
	private float pressure;//气压
	
	//构造方法
	WeatherData(){
		//observer=new ArrayList();
	}
	/*public void registerObserver(Observer o){
	   observer.add(o);//增加观察者
	}*/
	
	/*public void removeObserver(Observer o){//删除观察者
		int i=observer.indexOf(o);
		if(i>0){
			observer.remove(i);
		}
	}*/
	/*public void notifyObservers(){//通知观察者
		for(int i=0;i<observer.size();i++){
			Observer observers=(Observer)observer.get(i);
			observers.updata(temperature, humidity, pressure);
		}
	}*/
	//添加数据
	public void setMeasurements(float temperature,float humidity,float pressure){
		this.temperature=temperature;
		this.humidity=humidity;
		this.pressure=pressure;
		this.measurementsChanged();
	}
	public void measurementsChanged(){
		setChanged();
		notifyObservers();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
	
}