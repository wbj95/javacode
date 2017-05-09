package 测试;

public class Test00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,count=0;
		 System.out.println("用 For 语句实现：输出 10~50 之间的 3 的倍数");
		 for(i=12;i<=50;i=i+3){
		 System.out.print(i+" ");
		 count++;
		 if(count%5==0)
		 System.out.println();
		 }

		 System.out.println();
		 count=0;
		 System.out.println("用 While 语句实现：输出 10~50 之间的 3 的倍数");
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
		 System.out.println("用 do-While 语句实现：输出 10~50 之间的 3 的倍数");
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
