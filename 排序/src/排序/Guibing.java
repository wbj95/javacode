package ����;

public class Guibing {
	//�ϲ�������
	void Merge(int r[],int []r1,int s,int m,int t){
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
	//������r[s]~r[t]���й鲢����
	void MergeSort(int[] r, int s, int t) {
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
