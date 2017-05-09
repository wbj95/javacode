package ≤‚ ‘;
class Circle{
	private double r;
	final static  double PI=3.14;
	Circle(){
		r=1;
	}
	Circle(double _r){
		r=_r;
	}
	public double zhouchang(){
		return 2*PI*r;
	}
	public void area(){
	 System.out.println(PI*r*r);
	}
}
public class Test000 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c=new Circle(10);
		c.area();
		double d1=-0.5;
		System.out.println("Ceil d1="+Math.ceil(d1));
		System.out.println("floor d1="+Math.floor(d1));
	}

}
