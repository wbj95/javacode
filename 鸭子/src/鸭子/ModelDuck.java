package Ѽ��;

public class ModelDuck extends Duck{
	public void display(){
		System.out.println("I'm ModelDuck");
	}
	ModelDuck(){
		flybehavior=new FlyNoWay();
		quackbehavior=new Quack();
	}
}
