package java�����;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Java��һά�����ڲ�֪�����ȵ����������������
//��֪�����ȣ����Բ���ֱ��������С
public class Array {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int m;
		while(true) {
			m = sc.nextInt();
			if(m == 0) {
				break;
			}
			list.add(m);
		}
		int size = list.size();
		Integer[] integer = (Integer[])list.toArray(new Integer[size]);
		for (int i = 0; i < integer.length; i++) {
			System.out.print(integer[i]+" ");
		}
	}

}
