package ����վ;

import java.util.ArrayList;
import java.util.Observable;//java�����У��Ѿ����й۲���ģʽ��

/*public interface  Subject {  ����ӿ�
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}*/
//class WeatherData implements Subject{

//����
class WeatherData extends Observable{//Observable��һ���࣬���ǽӿ�
    //private ArrayList observer;//�ü���װ�۲���
	private float temperature;//�¶�
	private float humidity;//ʪ��
	private float pressure;//��ѹ
	
	//���췽��
	WeatherData(){
		//observer=new ArrayList();
	}
	/*public void registerObserver(Observer o){
	   observer.add(o);//���ӹ۲���
	}*/
	
	/*public void removeObserver(Observer o){//ɾ���۲���
		int i=observer.indexOf(o);
		if(i>0){
			observer.remove(i);
		}
	}*/
	/*public void notifyObservers(){//֪ͨ�۲���
		for(int i=0;i<observer.size();i++){
			Observer observers=(Observer)observer.get(i);
			observers.updata(temperature, humidity, pressure);
		}
	}*/
	//�������
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