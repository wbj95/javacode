package 多态;
//多态使项目的扩展能力增强，偶合度降低
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      person p1=new person();
      gou d1=new gou();
      mao c1=new mao();
      Pig p2=new Pig();
      p1.feed(d1);
      p1.feed(c1);
      p1.feed(p2);
	}

}
class person{
	/*public void feed(Dog1 d){
		d.eat();
	}
	public void feed(Cat1 c){
		c.eat();
	}
	//person类型扩展能力差
	 * 
	 */
	public void feed(Animal1 a){//Aniaml1 a=d1;Aniaml1=c1;Animal1=p2
		a.eat();
	}
}

class gou extends Animal1{
	gou(){
		System.out.println("我是狗的构造方法");
	}
	public void eat(){
		System.out.println("狗在吃东西000");
	}
}
class mao extends Animal1{
	public void eat(){
		System.out.println("猫在吃东西");
	}
}
class Animal1{
	Animal1(){
		System.out.println("我是父类的构造方法");
	}
	public void eat(){
		
	}
}
class Pig extends Animal1{
	public void eat(){
		System.out.println("猪仔吃东西");
	}
}