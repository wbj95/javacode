package ≤‚ ‘;

class A{
	private double x,y;
	A(){
		this.x=0;
		this.y=0;
	}
	A(double x,double y){
		this.x=x;
		this.y=y;
	}
	public double D(A a){
		//Marh.absæ¯∂‘÷µ
		double distance = (Double) Math.sqrt(Math.abs((this.x - a.x)*(this.x - a.x))+Math.abs((this.y- a.y)*(this.y - a.y)));
		return distance;
		
	}
}
public class Point {
	int []a=new int[6];
	int c=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//System.out.println(a[0]);//Cannot make a static reference to the non-static field a
		//System.out.println(c);
		A a=new A(1,2);
        A b=new A(5,4);
        System.out.println(a.D(b));
	}
}
