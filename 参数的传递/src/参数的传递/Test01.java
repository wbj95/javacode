package �����Ĵ���;

import java.util.Date;


//����java�Ŀɱ䳤����
public class Test01 {
//
	public static void m1(int... i){
	System.out.println(i.length);
	for(int j=0;j<i.length;j++)	
	{
		System.out.print(i[j]+" ");
	}
	System.out.println();
	}
//������Ծ�ȷƥ��ķ���������ø÷�����������ȥִ�пɱ䳤�����ķ���
	public static void m1(int i){
	System.out.println(i);
	}
	//�ɱ䳤�������Ե�ͬ��������
	public static void m2(String... aeg){
		for(int i=0;i<aeg.length;i++){
			System.out.print(aeg[i]+" ");
		}
		System.out.println();
	}
	
	public static void m3(int... j){
		for(int i=0;i<j.length;i++){
			System.out.print(j[i]+" ");
		}
		System.out.println();
	}
	
	public static void m4(Class... args) throws Exception{
		for(int i=0;i<args.length;i++)
		{
			Class c=args[i];
				System.out.println(c.newInstance());
		}
	}
	//�ɱ䳤����ֻ�ܳ���һ�Σ�����ֻ�������в��������һλ
//	public static void m4(String...a,int i){}
	public static void m4(int i,String...a){}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		m1(1);//1
		m1(2,5);//2
		m1(2,6,9,8,4);//5
		m2("����","����","��ѧ","����");
		m3(4,5,6,5,41,54,54);
		m4(Date.class,Employee.class);
	}
	
	
}
