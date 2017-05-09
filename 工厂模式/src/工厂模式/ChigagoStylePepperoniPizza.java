package 工厂模式;
//香肠匹萨
public class ChigagoStylePepperoniPizza extends Pizza{
	ChigagoStylePepperoniPizza(){
		name=" chi ga go pepperni pizza ";
		dough="厚面";
		sauce="番茄酱";
		toppings.add("奶油，辣椒");
	}
	public void cut(){
		System.out.println("切成正方形");
	}
}
