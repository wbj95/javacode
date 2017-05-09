package ����վ;

import java.util.Observable;
import java.util.Observer;
/*public interface Observer {   �۲��߽ӿ�
	public void updata(float temperature,float humidity,float pressure);//������۲�ֵ�ı�ʱ����������Щ״ֵ̬���������Ĳ��������͸��۲��ߡ�
}
*/
//��ʾ����
interface DisplayElement{  //�����ӿ�
	public void dispaly();//���������Ҫ��ʾʱ�����ô˷�����
}
//��ʾ��ǰ��������


//�۲���ʵ�ֹ۲��߽ӿں͹����ӿ�
class CurrentConditionsDisplay implements Observer,DisplayElement{
	private float temperature;
	private float humidity;
	private float pressure;
	Observable observable;
	//���췽��
	public CurrentConditionsDisplay(Observable observable) {  
        this.observable = observable;  
        observable.addObserver(this);       //�Ǽ�Ϊ�۲���  
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
		System.out.println("Ŀǰ���¶�Ϊ��"+temperature+"\t"+"Ŀǰ��ʪ��Ϊ��"+humidity+"\t"+"Ŀǰ����ѹΪ��"+pressure);
	}
	
	
}
