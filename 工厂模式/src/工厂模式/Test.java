package ����ģʽ;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaStore ny=new NYPizzaStore();
		PizzaStore cgg=new ChigagoStore();
		
		Pizza p=ny.orderPizza("cheese");
		System.out.println("ͨ��"+p.getName()+"�µ�");
		Pizza p2=ny.orderPizza("clam");
		Pizza p1=cgg.orderPizza("veggie");
		System.out.println("ͨ��"+p1.getName()+"�µ�");
	}
}
