package ÐÇ°Í¿Ë¿§·È;
//¶¹½¬
public class Soy extends CondimentDecorator{
	Beverage beverage;
	Soy(Beverage b){
		this.beverage=b;
		//description="Soy";
	}
	
	public int getSize() {
		return beverage.getSize();
		}
	public String getDescription(){
		return beverage.getDescription()+",Soy";
	}
	public double cost() {
		// TODO Auto-generated method stub
		double cost=beverage.cost();
		if(getSize()==1){
			cost+=0.20;
		}else if(getSize()==2){
			cost+=0.15;
		}else if(getSize()==3){
			cost+=0.10;
		}
		return cost;
	}
}
