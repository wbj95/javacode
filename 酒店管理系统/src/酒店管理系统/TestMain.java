package 酒店管理系统;
import java.util.Scanner;
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("*******欢迎使用酒店管理系统*******");
		Scanner sca=new Scanner(System.in);
		Hotel h=new Hotel();
		h.print();//打印房间信息
		int i=1;
		do{
		System.out.println("请输入你想预定的房间号码");
		String no=sca.next();
		h.order(no);//预定房间
		
		h.print();
		//System.out.println();
		System.out.println("是否继续预定房间，1-是，2-否");
		i=sca.nextInt();
		}while(i==1);
		
		do{
		System.err.println("请输入你想退的房间号");
		String ss=sca.next();
		h.tuifang(ss);
		h.print();
		System.out.println("是否继续退房间，1-是，2-否");
		i=sca.nextInt();
		}while(i==1);
		
	}

}
