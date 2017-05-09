package 工厂模式;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaStore ny=new NYPizzaStore();
		PizzaStore cgg=new ChigagoStore();
		
		Pizza p=ny.orderPizza("cheese");
		System.out.println("通过"+p.getName()+"下单");
		Pizza p2=ny.orderPizza("clam");
		Pizza p1=cgg.orderPizza("veggie");
		System.out.println("通过"+p1.getName()+"下单");
	}
}
