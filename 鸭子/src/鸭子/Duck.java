package 鸭子;

public abstract class Duck {
	Flybehavior flybehavior;
	Quackbehavior quackbehavior;
	
	Duck(){}
	
	public void performFly(){
		flybehavior.fly();
	}
	public void peformQuack(){
		quackbehavior.quack();
	}
	public void swim(){
		System.out.println("All duck can swim");
	}
	public abstract void display();//鸭子的外观
	
	public void setFlybehavior(Flybehavior fb){
		flybehavior=fb;
	}
	public void setQuackehavior(Quackbehavior qb){
		quackbehavior=qb;
	}
	
}
