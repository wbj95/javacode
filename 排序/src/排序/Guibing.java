package 排序;

public class Guibing {
	//合并子序列
	void Merge(int r[],int []r1,int s,int m,int t){
		int i=s,j=m+1,k=s;
		while(i<=m&&j<=t){
			if(r[i]<=r[j])r1[k++]=r[i++];//取r[i]和r[j]中较小的数放入r1[k]中
			else r1[k++]=r[j++];
		}
		while(i<=m){//若第一个子序列没有处理完，则进行收尾处理
			r1[k++]=r[i++];
		}
		while(j<=t){//若第二个子序列没有处理完，进行收尾处理
			r1[k++]=r[j++];
		}
	}
	//对序列r[s]~r[t]进行归并排序
	void MergeSort(int[] r, int s, int t) {
		int m, r1[]=new int[1000];// r1为临时数组，m为划分中间数
		if (s == t)//递归终止条件，只有一条记录时
			return;
		else {
			m=(s+t)/2;//划分
			MergeSort(r,s,m);//左序列
			MergeSort(r,m+1,t);//右序列
			Merge(r,r1,s,m,t);//合并子序列
			for (int i = s; i <=t; i++) {
				r[i]=r1[i];
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] r = { 4,5,7,6,9,10,33,66};
		int t = r.length - 1;
		int s = 0;
		Guibing guibing=new Guibing();
		guibing.MergeSort(r, s, t);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i]+" ");
		}
	}

}
