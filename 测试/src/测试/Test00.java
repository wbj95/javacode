package ����;

public class Test00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,count=0;
		 System.out.println("�� For ���ʵ�֣���� 10~50 ֮��� 3 �ı���");
		 for(i=12;i<=50;i=i+3){
		 System.out.print(i+" ");
		 count++;
		 if(count%5==0)
		 System.out.println();
		 }

		 System.out.println();
		 count=0;
		 System.out.println("�� While ���ʵ�֣���� 10~50 ֮��� 3 �ı���");
		 i=12;
		 while(i<=50){
		 System.out.print(i+" ");
		 count++;
		 if(count%5==0)
		 System.out.println();
		 i+=3;
		 }

		 System.out.println();
		 count=0;
		 System.out.println("�� do-While ���ʵ�֣���� 10~50 ֮��� 3 �ı���");
		 i=12;
		 do{
		 System.out.print(i+" ");
		 count++;
		 if(count%5==0)
		 System.out.println();
		 i+=3;
		 }while(i<=50);

		 System.out.println();
	}

}
