package allSort;

import javax.lang.model.element.QualifiedNameable;

public class AllSort {
	
	public static void swap(int r[],int i,int j){
		int temp=r[i];
		r[i]=r[j];
		r[j]=temp;
	}
	
	public static void print(int []r){
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i]+" ");
		}
		System.out.println();
	}
	//选择排序
	public static void selectSort(int r[],int n){
		int mixIndex;
		for (int i = 0; i < n; i++) {
			mixIndex=i;
			for (int j = i+1; j < n; j++) {
				if(r[mixIndex]>r[j]){
					mixIndex=j;
				}
			}
			if(mixIndex!=i){
				swap(r,i,mixIndex);
			}
		}
	}
	
	//冒泡排序
	public static void MaoPao(int r[],int n){
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(r[i]>r[j]){
					swap(r, i, j);
				}
			}
		}
	}
	
	//堆排序
	public static void Heap_Sort(int []r,int n){
		for (int i = (n-1)/2; i>=0; i--) {
			build_heap(r, n, i);
		}
		for (int i = n-1; i >0; i--) {
			swap(r, i, 0);
			build_heap(r, i, 0);
		}
	}
	public static void build_heap(int r[],int n,int index){
		int left=index*2+1;
		int right=index*2+2;
		int maxIndex=index;
		if(left<n&&r[left]>r[maxIndex])maxIndex=left;
		if(right<n&&r[right]>r[maxIndex])maxIndex=right;
		if(maxIndex!=index){
			swap(r, index, maxIndex);
			build_heap(r, n, maxIndex);
		}
	}
	//插入排序
	public static void insert_sort(int r[]){
		int i,j;
		for ( i = 1; i < r.length; i++) {
			int temp=r[i];
			for ( j = i; j>0; j--) {
				if(r[j-1]>temp){
					r[j]=r[j-1];
					continue;
				}
				break;
			}
			r[j]=temp;
		}
	}
	
//	public void Fun(int[] r,int n){
//		int i,j;
//		int temp;
//		for ( i = 1; i <n; i++) {
//			j=i;
//			temp=r[i];//暂存待排记录
//			while(j>0&&temp<r[j-1]){
//				r[j]=r[j-1];
//				j--;//记录往后移
//			}
//			r[j]=temp;
//		}
//	}
	
	//归并排序
	//对序列r[s]~r[t]进行归并排序
		static void  MergeSort(int[] r, int s, int t) {
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

	//合并子序列
	static	void  Merge(int r[],int []r1,int s,int m,int t){
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
	
	public static void quickSort(int[] A, int first, int end) {
		int port;
		if (first < end) {
			port = partition(A, first, end);//返回中轴数
			quickSort(A, first, port - 1);//求解子问题1，对左侧子序列排列
			quickSort(A, port + 1, end);//求解问题2，对右侧子序列排序
		}
	}
	//划分
	static int partition(int A[], int first, int end) {
		int i = first, j = end;//初始化划分区域
		while (i < j) {
			while (i < j && A[i] <= A[j])j--;//右侧扫描
			if (i < j) {//将较小的数换到前面
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
			}
			while (i < j && A[i] <= A[j])i++;//左侧扫描
			if (i < j) {//讲较大的数换到后面
				int temp = A[i];A[i] = A[j];A[j] = temp;
				j--;
			}
		}
		//System.out.println(i);
		return i;//返回中轴数
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r[]={9,7,8,6,2,4,3,5,1};
		int n=r.length;
		print(r);
//		System.out.print("选择排序:");
//		selectSort(r, n);
//		print(r);
//		System.out.print("冒泡排序：");
//		MaoPao(r, n);
//		print(r);
//		System.out.print("堆排序：");
//		Heap_Sort(r, n);
//		print(r);
//		System.out.println("插入排序：");
//		insert_sort(r);
//		print(r);
//		System.out.println("归并排序：");
//		MergeSort(r,0,r.length-1);
//		print(r);
		System.out.println("快速排序：");
		MergeSort(r, 0, r.length-1);
		print(r);
	}

}
