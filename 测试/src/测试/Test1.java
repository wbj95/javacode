package ����;

/**
 * 
 */
/**
 * @author Administrator
 *����n=2k��ѡ��Ҫ��������ѭ������Ҫ�����һ����������Ҫ��ı����ճ̱�
��1��ÿ��ѡ�ֱ���������n-1��ѡ�ָ���һ�Σ�
��2��ÿ��ѡ��һ��ֻ����һ�Ρ�
 */
public class Test1 {
	
	public static int GameTable(int k,int a[][]){
		int n,temp;
		n=2;//2��ѡ�ֱ����ճ̿�ֱ�����
		a[1][1]=1;a[1][2]=2;
		a[2][1]=2;a[2][2]=1;
		//�����������δ���22, ��, 2k��ѡ�ֱ����ճ�
		for(int t=1;t<k;t++){
		    temp=n;
		    n=n*2;
		    //�����½�Ԫ��
		    for (int i = temp+1; i<=n; i++) {
				 for(int j=1;j<=temp;j++){
					 a[i][j]=a[i-temp][j]+temp;//���Ͻ�Ԫ�غ����½�Ԫ�ض�Ӧ��ϵ
				 }
			}
		    //�����Ͻ�Ԫ��
		    for (int i =1; i <=temp; i++) {
				for(int j=temp+1;j<=n;j++){
					a[i][j]=a[i+temp][(j+temp)%n];
				}
			}
		    //�����Ͻ�Ԫ�س������½�
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
