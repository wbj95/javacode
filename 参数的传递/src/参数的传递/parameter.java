package 参数的传递;

public class parameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Animal a=new Animal(10);
      m1(a);
      System.out.println(a.age);
	}
	public static void m1(Animal a){
		a.age++;
		System.out.println(a.age);
	}
}
 class Animal{
	 int age;
	 Animal(int _age){
		 age=_age;
	 }
 }