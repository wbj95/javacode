package ÐÇ°Í¿Ë¿§·È;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Beverage beverage;
		System.out.println("1.´ó±­"+"2.ÖÐ±­"+"3.Ð¡±­");
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		
		
		Beverage b1=new DarkRoast();
		b1.setSize(size);
		//Beverage b2=new Milk(b1);
		//Beverage b3=new Soy(b2);
		b1=new Milk(b1);
		b1=new Soy(b1);
		System.out.println(b1.getDescription()+"  "+b1.cost());
		
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() 
		+ " $" + beverage2.cost());
	}

}
