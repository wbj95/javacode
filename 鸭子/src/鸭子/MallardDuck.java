package я╪вс;

public class MallardDuck extends Duck{
	MallardDuck(){
		flybehavior=new FlyWithWings();
		quackbehavior=new Quack();
	}
	public void display(){
		System.out.println("I'm MallardDuck");
	}
	/*public void swim(){
		System.out.println("MallarDuck can swim");
	}*/
	public void performFly(){
		System.out.print("MallardDuck  ");
		flybehavior.fly();
	}
	public void peformQuack(){
		System.out.print("MallardDuck  ");
		quackbehavior.quack();
	}
}
