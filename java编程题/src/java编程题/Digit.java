package java�����;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//���N*N��������ת����
//�ݹ��㷨,numble ���Ͻ����֣�begin���Ͻ����꣬size�������
public class Digit {
	int data[][]=new int[100][100];
	public void FullDigit(int numble , int begin , int size) {
		if(size == 0) {
			//System.out.println("�޴˷���");
			return;
		}
		if(size == 1) {
			data[begin][begin] = numble;
			return;
		}
		int i =begin ,j = begin;
		//������
		for (int j2 = 0; j2 < size-1; j2++) {
			data[i][j] = numble;
			i++;
			numble++;
		}
		//������
		for (int j2 = 0; j2 < size-1; j2++) {
			data[i][j] = numble;
			numble++;
			j++;
		}
		//
		for (int j2 = 0; j2 < size-1; j2++) {
			data[i][j] = numble;
			numble++;
			i--;
		}
		for (int j2 = 0; j2 < size-1; j2++) {
			data[i][j] = numble;
			numble++;
			j--;
		}
		FullDigit(numble, begin+1, size-2);
	}
	
	public void result(int size){
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Digit d = new Digit();
		Scanner sc = new Scanner(System.in);
		int numble = 1;
		int begin = 0;
		System.out.println("�����뷽��Ľ�N");
		int size = sc.nextInt();
		
		//int all = size*size;
		/*ArrayList<ArrayList<Integer>> arraylist = new ArrayList<ArrayList<Integer>>();
 		for (int i = 0; i < size; i++) {
 			ArrayList<Integer> ziarray = new ArrayList<Integer>();
			for (int j = 0; j < args.length; j++) {
				ziarray.add(j);
			}
			arraylist.add(ziarray);
		}
 		
 		Iterator<ArrayList<Integer>> iterator = arraylist.iterator();
 		while(iterator.hasNext()) {
 			System.out.println(iterator.next());
 		}*/
		try {
			d.FullDigit(numble , begin , size);
			d.result(size);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
