public class Testduotai {

	public static void main(String[] args) {
	/*
	 * 向上转型又被称为自动类型转换
	 * 父类型的引用指向子类型的对象
	 * 程序分为两个阶段：编译阶段，运行阶段
	 * 程序编译阶段只知道a是Animal类型
	 * 程序在运行时堆中的实际对象是cat类型
	 * 所以程序在编译阶段a的引用绑定是Animal类中的eat方法（静态绑定）
	 * 程序在运行的阶段对象绑定是cat中的eat方法（动态绑定）
	 */
	Animal a=new Animal();
	a.eat();
	Animal c=new cat();
    c.eat();
    //向下转型 强制类型转换
    Animal a1=new cat();
    cat a2=(cat)a1;
    a2.move();
	}
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
	if(a3 instanceof cat){
		cat c3=(cat)a3;
		c3.eat();
	}

}
class cat extends Animal{
	public void eat(){
		System.out.println("猫在吃东西");
		}
	public void move(){
		System.out .println("猫在走猫步");
	}
}
class Dog extends Animal{
	public void eat(){
		System.out.println("狗在吃东西");
	}
}
class Animal{
	public void eat(){
	System.out.println("动物在吃东西");
	}
}