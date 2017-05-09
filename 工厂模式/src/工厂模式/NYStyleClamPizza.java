package 工厂模式;
//
public class NYStyleClamPizza extends Pizza{
	NYStyleClamPizza(){
		name="ny clam pizza";
		dough="大米面";
		sauce="酱油";
		toppings.add("番茄，芝麻");
	}
	public void cut(){
		System.out.println("切成三角形");
	}
	public void box(){
		System.out.println("装盒子");
	}
}
