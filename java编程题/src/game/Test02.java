package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java�����.Quick;

public class Test02 {
	public void quickSort(int[] A, int first, int end) {
		int port;
		if (first < end) {
			port = partition(A, first, end);//����������
			quickSort(A, first, port - 1);//���������1�����������������
			quickSort(A, port + 1, end);//�������2�����Ҳ�����������
		}
	}
	//����
	int partition(int A[], int first, int end) {
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
		int A[] = {23,29,20,32,23,21,33,25,34};
		Quick quick = new Quick();
		int first = 0;
		int end = A.length-1;
		//System.out.println(end);
		quick.quickSort(A, first, end);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		System.out.println("��λ��");
		double mid=0;
		if(A.length%2==0){
			mid = (A[end/2]+A[end/2+1])/2;
		}else{
			mid=A[end/2];
		}
		System.out.println(mid);
	}
}
