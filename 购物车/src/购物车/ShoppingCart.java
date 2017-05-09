package 购物车;

import java.util.*;

public class ShoppingCart {
	//使用Map存商品条目
		Map<Product,Integer> products;
		
		//总价
		double totalprice;
		
		//Constructor
		ShoppingCart(){
			products=new HashMap<Product,Integer>();//HashMap一开始写错成MapHash
		}
		
		//添加一个商品
		public void add(Product p){//一开始忘了传参数
			add(p,1);
		}
		//添加n个商品
		public void add(Product p,int n){
			//判断购物车中是否含有这个商品
			if(!products.containsKey(p)){//没有该商品
				products.put(p, n);
			}else{
				int before=products.get(p);//自动拆箱products.get(p).intValue()
				int after=before+n;
				products.put(p, after);
			}
			
			totalprice+=p.getPrice()*n;
		}
		//删除一个商品
		public void remove(Product p){
			remove(p,1);
		}
		//删除n个商品
		public void remove(Product p,int n){
			int before=products.get(p);
			if(products.containsKey(p))
			{
			//如果购物城车某商品的数目和n相等，则删除整个条目
			if(before==n){
				products.remove(p);
				}
			else if(before<n){
				System.out.println("删除数目多过购物车中数量");
				return;
			}
			int after=before-n;
			products.put(p, after);
			
			totalprice-=p.getPrice()*n;
			}else{
				System.out.println("购物车中没有该商品");
			}
		}
		//清空
		public void Clear(){
			products.clear();
			totalprice=0.0;
		}
		//输出详单
		public void print(){
			StringBuffer sb=new StringBuffer();
			sb.append("购物车详单：\n");
			
			//遍历Map
			Set<Product> keys=products.keySet();
			Iterator<Product> it=keys.iterator();
			while(it.hasNext()){
				Product k=it.next();
				Integer v=products.get(k);
				sb.append("\t"+v+"\t"+k+"\t"+k.getPrice()+"\n");
				
			}
			sb.append("\t\t\t\t\t\t\t\t总价:"+totalprice+"元");
			System.out.println(sb);
		}
		
		
}
/*
 * 迭代器（Iterator）

　　迭代器是一种设计模式，它是一个对象，它可以遍历并选择序列中的对象，而开发人员不需要了解该序列的底层结构。迭代器通常被称为“轻量级”对象，因为创建它的代价小。

　　Java中的Iterator功能比较简单，并且只能单向移动：

　　(1) 使用方法iterator()要求容器返回一个Iterator。第一次调用Iterator的next()方法时，它返回序列的第一个元素。注意：iterator()方法是java.lang.Iterable接口,被Collection继承。

　　(2) 使用next()获得序列中的下一个元素。

　　(3) 使用hasNext()检查序列中是否还有元素。

　　(4) 使用remove()将迭代器新返回的元素删除。

　　Iterator是Java迭代器最简单的实现，为List设计的ListIterator具有更多的功能，它可以从两个方向遍历List，也可以从List中插入和删除元素。
 */
