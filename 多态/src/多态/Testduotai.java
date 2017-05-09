package 多态;
/*
 * 关于java中的向上转型和向下转型
 * 向上转型：（upcasting):子——————》父
 * 向下转型：（downcasting):父————》子
 * 无论向上转型还是向下转型，两个类都必须有继承关系
 */

public class Testduotai {
	/*
	 * 向上转型又被称为自动类型转换
	 * 父类型的引用指向子类型的对象
	 * 程序分为两个阶段：编译阶段，运行阶段
	 * 程序编译阶段只知道a是Animal类型
	 * 程序在运行时堆中的实际对象是cat类型
	 * 所以程序在编译阶段a的引用绑定是Animal类中的eat方法（静态绑定）
	 * 程序在运行的阶段对象绑定是cat中的eat方法（动态绑定）
	 */
	public static void main(String[] args) {
		String ee[];
	Animal a=new Animal();
	a.eat();//动物在吃东西
	Animal c=new Cat();
    c.eat();//猫在吃东西
    //向下转型 强制类型转换
    Animal a1=new Cat();
    Cat a2=(Cat)a1;
    a2.move();
    /*
	 Animal a2=new Dog();
	  cat c2=(cat)a2;Dog类和cat类之间没有继承，无法进行强制类型转换
	  c2.eat();存在风险，为了避免，java引进instanceof
	  用法：
	  1：instanceof运算符的运算结果是boolean
	  2:(引用  instanceof 类型)---->>ture/fase
	  例如：(a instanceof cat)如果结果是ture 表明a引用指向堆得对象是cat类型
	 */

    Animal a3=new Dog();
    System.out.println(a3 instanceof Cat);
    if(a3 instanceof Cat){
    Cat c3=(Cat)a3;
    }
	}
}
class Cat extends Animal{
	Cat(){
		System.out.println("猫的构造函数");
	}
	public void eat(){
		System.out.println("猫在吃东西");
		}
	public void move(){
		System.out .println("猫在走猫步");
	}
}
class Dog extends Animal{
	Dog(){
		System.out.println("狗的构造函数");
	}
	public void eat(){
		System.out.println("狗在吃东西");
	}
}
class Animal{
	Animal(){
		System.out.println("父类的构造函数");
	}
	public void eat(){
	System.out.println("动物在吃东西");
	}
}