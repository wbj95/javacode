
public class Static01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Animal m=new Animal("С��",20);
      Animal m1=new Animal("С��",50);
      
      System.out.println(m.age);
      System.out.println(m.name);
      System.out.println(m.type);
      System.out.println(m1.age);
      System.out.println(Animal.type);
      System.out.println(m.type);
      m.fangwen();
      System.out.println(m.type);
      Animal.jingtai();
      System.out.println(Animal.type);
      m.jingtai();
      
	}

}
class Animal{
	String name;
	int age;
	static String type="½��";
	Animal(String _name,int _age){
		name=_name;
		age=_age;
	}
	public void fangwen(){
		type ="����";
	}
	public static void jingtai(){
		type = "����";
	}
}