package 工厂模式;

import java.util.ArrayList;

public  abstract  class Pizza {
	String name;//名称
	String dough;//面团
	String sauce;//酱
	ArrayList toppings=new ArrayList();//一套佐料
	
	public void prepare(){
		System.out.println(name+"正在准备中~~~~");
		System.out.println("正在和"+dough);
		System.out.println("加"+sauce);
		for(int i=0;i<toppings.size();i++){
			System.out.println("添加"+toppings.get(i));
		}
	}
	public void bake(){
		System.out.println("烤30分钟");
	}
	public void cut(){
		System.out.println("切长方形");
	}
	public void box(){
		System.out.println("装袋子");
	}
	public String getName(){
		return name;
	}
}
