package ĞÇ°Í¿Ë¿§·È;
//ÄÌÅİ
public class Whip extends CondimentDecorator{
	Beverage beverage;
	Whip(Beverage b){
		this.beverage=b;
		
	}
	public String getDescription(){
		//return   beverage.description+",Whip";//
		  return   beverage.getDescription()+",Whip";
	}
	public double cost() {
		// TODO Auto-generated method stub
		return 0.15+beverage.cost();
	}
}
