package 购物车;

public class Product {
  
  private int no;
  private String name;
  private double price;
  
  //Constructor
  Product(int no,String name,double price){
	  this.no=no;
	  this.name=name;
	  this.price=price;
  }
  //setter and getter

public int getNo() {
	return no;
}

public void setNo(int no) {
	this.no = no;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}
  
//toString 
public String toString(){
	return "[编号："+no+",名称："+name+",单价："+price+"元/个]";
}

//hashCode
public int hashCode(){//括号内部传参数
	return no/1000;
	
	
}
//equlas
	public boolean equals(Object o){
		if(this==o)return true;
		if(o instanceof Product){
			Product p=(Product)o;
			if(this.no==p.no&&this.name.equals(p.name))
			return true;
		}
		return false;
	}
}
