package я╪вс;

public interface  Flybehavior {
	public void fly();
}
class FlyWithWings implements Flybehavior{
	public void fly(){
		System.out.println("fly");
	}
}
class FlyNoWay implements Flybehavior{
	public void fly(){
		System.out.println("can not fly");
	}
}
class FlyRocketPowered implements Flybehavior{
	public void fly(){
		System.out.println("I'm flying with a rocket");
	}
}