package ���ﳵ;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�������ﳵ
				ShoppingCart cart=new ShoppingCart();
				
				//����
				Product p1=new Product(1000,"iphone5s",5000);
				Product p2=new Product(2000,"С��4",2000.2);
				Product p3=new Product(3000,"����note3",799);
				Product p4=new Product(3001,"����mx3",500.5);
				
				//��ʼ����
				cart.add(p1);
				cart.add(p4);
				cart.add(p3, 5);
				
				//��ӡ�굥
				cart.print();
				
				//ɾ��ĳ��Ʒ
				cart.remove(p4, 2);
				
				//��ӡ
				cart.print();
				
				//���
				cart.Clear();
				
				//��ӡ
				cart.print();

	}

}
