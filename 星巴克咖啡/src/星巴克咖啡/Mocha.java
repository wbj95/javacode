package ÐÇ°Í¿Ë¿§·È;

public class Mocha extends CondimentDecorator{
	Beverage beverage;
	Mocha(Beverage beverage){
		this.beverage=beverage;
		
	}
	public String getDescription(){
		return beverage.getDescription()+",Mocha";
	}
	public double cost() {
		// TODO Auto-generated method stub
		return 0.20+beverage.cost();
	}
}
