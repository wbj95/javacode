package �Ƶ����ϵͳ;
import java.util.Scanner;
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("*******��ӭʹ�þƵ����ϵͳ*******");
		Scanner sca=new Scanner(System.in);
		Hotel h=new Hotel();
		h.print();//��ӡ������Ϣ
		int i=1;
		do{
		System.out.println("����������Ԥ���ķ������");
		String no=sca.next();
		h.order(no);//Ԥ������
		
		h.print();
		//System.out.println();
		System.out.println("�Ƿ����Ԥ�����䣬1-�ǣ�2-��");
		i=sca.nextInt();
		}while(i==1);
		
		do{
		System.err.println("�����������˵ķ����");
		String ss=sca.next();
		h.tuifang(ss);
		h.print();
		System.out.println("�Ƿ�����˷��䣬1-�ǣ�2-��");
		i=sca.nextInt();
		}while(i==1);
		
	}

}
