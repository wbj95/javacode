
public class hanshu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     hanshu.m1(10,20);//hanshu����ɾ��
     hanshu.m2("hello world");//hanshu����ɾ��
     int f=hanshu.m3(20, 20);
     System.out.println(f);
     hanshu.m4();//hanshu����ɾ��
     A.m5();//A����ɾ��
	}

	public static void m1(int a,int b){
		int c=a+b;
		System.out.println(c);
	}
	public static void m2(String mf){
		System.out.println(mf);
	}
	public static int m3(int a,int b){
		int c=a+b;
		return c;
	}
	public static void m4(){
		System.out.println("hehe");
	}
}
class A{
	public static void m5(){
		System.out.println("����");
	}
}
