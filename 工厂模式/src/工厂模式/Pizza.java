package ����ģʽ;

import java.util.ArrayList;

public  abstract  class Pizza {
	String name;//����
	String dough;//����
	String sauce;//��
	ArrayList toppings=new ArrayList();//һ������
	
	public void prepare(){
		System.out.println(name+"����׼����~~~~");
		System.out.println("���ں�"+dough);
		System.out.println("��"+sauce);
		for(int i=0;i<toppings.size();i++){
			System.out.println("���"+toppings.get(i));
		}
	}
	public void bake(){
		System.out.println("��30����");
	}
	public void cut(){
		System.out.println("�г�����");
	}
	public void box(){
		System.out.println("װ����");
	}
	public String getName(){
		return name;
	}
}
