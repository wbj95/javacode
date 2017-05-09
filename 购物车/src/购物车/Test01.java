package 购物车;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建购物车
				ShoppingCart cart=new ShoppingCart();
				
				//货物
				Product p1=new Product(1000,"iphone5s",5000);
				Product p2=new Product(2000,"小米4",2000.2);
				Product p3=new Product(3000,"魅蓝note3",799);
				Product p4=new Product(3001,"魅族mx3",500.5);
				
				//开始购物
				cart.add(p1);
				cart.add(p4);
				cart.add(p3, 5);
				
				//打印详单
				cart.print();
				
				//删除某商品
				cart.remove(p4, 2);
				
				//打印
				cart.print();
				
				//清空
				cart.Clear();
				
				//打印
				cart.print();

	}

}
