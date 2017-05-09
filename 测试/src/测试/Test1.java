package 测试;

/**
 * 
 */
/**
 * @author Administrator
 *设有n=2k个选手要进行网球循环赛，要求设计一个满足以下要求的比赛日程表：
（1）每个选手必须与其他n-1个选手各赛一次；
（2）每个选手一天只能赛一次。
 */
public class Test1 {
	
	public static int GameTable(int k,int a[][]){
		int n,temp;
		n=2;//2个选手比赛日程可直接求得
		a[1][1]=1;a[1][2]=2;
		a[2][1]=2;a[2][2]=1;
		//迭代处理，依次处理22, …, 2k个选手比赛日程
		for(int t=1;t<k;t++){
		    temp=n;
		    n=n*2;
		    //填左下角元素
		    for (int i = temp+1; i<=n; i++) {
				 for(int j=1;j<=temp;j++){
					 a[i][j]=a[i-temp][j]+temp;//左上角元素和左下角元素对应关系
				 }
			}
		    //填右上角元素
		    for (int i =1; i <=temp; i++) {
				for(int j=temp+1;j<=n;j++){
					a[i][j]=a[i+temp][(j+temp)%n];
				}
			}
		    //将左上角元素抄到右下角
		    for(int i=temp+1;i<=n;i++){
		    	for(int j=temp+1;j<=n;j++){
		    		a[i][j]=a[i-temp][j-temp];
		    	}
		    }
			
		}
		return n;
	}
	public static void main(String[] args) {
		int k=3;
		int[][] a=new int[1000][1000];
		int n=GameTable(k,a);
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++){
				System.out.print(a[i][j]+" ");
				if (j==n) {
					System.out.println();
				}
			}
	}
	

}
