package ����;
/*
 *  Arrays��SUN�ṩ��һ��������
 *  java.util.Arrays;
 *    �ù�������Ҫ��Ե�������Ĳ���
 *    ���򣬶��ַ����ҵ�
 */
import java.util.Arrays;
public class ArraysTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={1,15,2,3,6,9,5,12,7};
		
		Arrays.sort(a);//����
		//���
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		//���ַ�����
		int index=Arrays.binarySearch(a, 6);
		System.out.print(index+" ");
	}

}
