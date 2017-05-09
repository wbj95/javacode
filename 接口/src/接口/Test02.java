package 接口;
/*
 * 汽车和发动机之间的接口
 * 生产汽车的厂家面向接口生产
 * 生产发动机的厂家面向接口生产
 */
public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //生产引擎
		Engine e1=new YAMAHA();//Engine可以写成YAMAHA
       Car c=new Car(e1);//生产汽车
    c.TextEngine();//测试汽车
    c.e=new HONDA();//换一个发动机
    c.TextEngine();
	}
}
 interface Engine{//接口
	void start();
}
 class YAMAHA implements Engine{//生产YAMAHA发动机
	public  void start(){
		System.out.println("YAMAHA启动");
	}
}
 class HONDA implements Engine{
	 public void start(){
		 System.out.println("HONDA启动");
	 }
 }
 class Car{//生产汽车
	 Engine e;//引擎面向接口编程  Field属性
	 Car(Engine e){//Constructor构造方法
		 this.e=e;
	 }
	 public void TextEngine(){//汽车能测试引擎
		e.start();//面向接口调用
	 }
 }
 