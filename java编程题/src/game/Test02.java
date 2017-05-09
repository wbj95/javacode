package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java编程题.Quick;

public class Test02 {
	public void quickSort(int[] A, int first, int end) {
		int port;
		if (first < end) {
			port = partition(A, first, end);//返回中轴数
			quickSort(A, first, port - 1);//求解子问题1，对左侧子序列排列
			quickSort(A, port + 1, end);//求解问题2，对右侧子序列排序
		}
	}
	//划分
	int partition(int A[], int first, int end) {
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
		System.out.println("中位数");
		double mid=0;
		if(A.length%2==0){
			mid = (A[end/2]+A[end/2+1])/2;
		}else{
			mid=A[end/2];
		}
		System.out.println(mid);
	}
}
