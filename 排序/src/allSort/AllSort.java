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
	//ѡ������
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
	
	//ð������
	public static void MaoPao(int r[],int n){
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(r[i]>r[j]){
					swap(r, i, j);
				}
			}
		}
	}
	
	//������
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
	//��������
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
//			temp=r[i];//�ݴ���ż�¼
//			while(j>0&&temp<r[j-1]){
//				r[j]=r[j-1];
//				j--;//��¼������
//			}
//			r[j]=temp;
//		}
//	}
	
	//�鲢����
	//������r[s]~r[t]���й鲢����
		static void  MergeSort(int[] r, int s, int t) {
			int m, r1[]=new int[1000];// r1Ϊ��ʱ���飬mΪ�����м���
			if (s == t)//�ݹ���ֹ������ֻ��һ����¼ʱ
				return;
			else {
				m=(s+t)/2;//����
				MergeSort(r,s,m);//������
				MergeSort(r,m+1,t);//������
				Merge(r,r1,s,m,t);//�ϲ�������
				for (int i = s; i <=t; i++) {
					r[i]=r1[i];
				}
			}
		}

	//�ϲ�������
	static	void  Merge(int r[],int []r1,int s,int m,int t){
			int i=s,j=m+1,k=s;
			while(i<=m&&j<=t){
				if(r[i]<=r[j])r1[k++]=r[i++];//ȡr[i]��r[j]�н�С��������r1[k]��
				else r1[k++]=r[j++];
			}
			while(i<=m){//����һ��������û�д����꣬�������β����
				r1[k++]=r[i++];
			}
			while(j<=t){//���ڶ���������û�д����꣬������β����
				r1[k++]=r[j++];
			}
		}
	
	public static void quickSort(int[] A, int first, int end) {
		int port;
		if (first < end) {
			port = partition(A, first, end);//����������
			quickSort(A, first, port - 1);//���������1�����������������
			quickSort(A, port + 1, end);//�������2�����Ҳ�����������
		}
	}
	//����
	static int partition(int A[], int first, int end) {
		int i = first, j = end;//��ʼ����������
		while (i < j) {
			while (i < j && A[i] <= A[j])j--;//�Ҳ�ɨ��
			if (i < j) {//����С��������ǰ��
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
			}
			while (i < j && A[i] <= A[j])i++;//���ɨ��
			if (i < j) {//���ϴ������������
				int temp = A[i];A[i] = A[j];A[j] = temp;
				j--;
			}
		}
		//System.out.println(i);
		return i;//����������
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r[]={9,7,8,6,2,4,3,5,1};
		int n=r.length;
		print(r);
//		System.out.print("ѡ������:");
//		selectSort(r, n);
//		print(r);
//		System.out.print("ð������");
//		MaoPao(r, n);
//		print(r);
//		System.out.print("������");
//		Heap_Sort(r, n);
//		print(r);
//		System.out.println("��������");
//		insert_sort(r);
//		print(r);
//		System.out.println("�鲢����");
//		MergeSort(r,0,r.length-1);
//		print(r);
		System.out.println("��������");
		MergeSort(r, 0, r.length-1);
		print(r);
	}

}
