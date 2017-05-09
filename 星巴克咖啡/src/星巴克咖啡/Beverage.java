package ÐÇ°Í¿Ë¿§·È;

public abstract class Beverage {
	String description="unknow description";
	int Size;
	public String getDescription(){
		return description;
	}
	public void setSize(int s){
		this.Size=s;
	}
	public int getSize(){
		return Size;
	}
	
	public abstract double cost();
}
