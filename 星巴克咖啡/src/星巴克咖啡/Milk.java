package ÐÇ°Í¿Ë¿§·È;

public class Milk extends CondimentDecorator{
	Beverage beverage;
	Milk(Beverage beverage){
		this.beverage=beverage;
		//description="Milk";
	}
	public String getDescription(){
		return beverage.getDescription()+",Milk";
	}
	public double cost() {
		// TODO Auto-generated method stub
		return 0.10+beverage.cost();
	}
	
}
