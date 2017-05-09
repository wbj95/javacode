package java编程题;
//生成排序对象 试编写一个函数，用来输出n 个元素的所有子集和所有排列。
public class Test02 {
	 void KnapSack(char []str,int mark[],int start ,int end ){
		if(start==end){
			System.out.print("{");
			for (int k = 0; k < end; k++) {
				if(mark[k]==1)
				System.out.print(str[k]);
			}
			System.out.println("}");
			return;
		}else {
			mark[start]=0;
			KnapSack(str, mark, start+1, end);
			mark[start]=1;
			KnapSack(str, mark, start+1, end);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char str[]={'a','b','c','d'};
		int mark[] =new int[4];
		Test02 test02 =new Test02();
		test02.KnapSack(str, mark,0,4);
	}

}
