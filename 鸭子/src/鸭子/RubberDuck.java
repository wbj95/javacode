package я╪вс;

public class RubberDuck extends Duck{
	RubberDuck(){
		flybehavior=new FlyNoWay();
		quackbehavior=new Squack();
	}
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("I'm RubberDuck");
	}
}
