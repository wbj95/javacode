package ����;
/*
 * ���ַ�����
 *  1.���ַ������ǽ������Ѿ����еĻ����ϵ�
 *  2.���³��������С��������
 *  3.���������û���ظ���Ԫ��
 */
public class ���ַ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={1,3,4,6,8,9,12,36,88};
		int destElement=100;
		//Ҫ���a�����в���destElement���Ԫ�ص��±�
		int index=binarySearch(a,destElement);//����ҵ��򷵻�Ԫ�ص��±꣬����Ҳ���ͳһ����-1
		System.out.println((index==-1)? destElement+"������":destElement+"���±���"+index);
	}
	//�۰���ҵĺ����㷨
	public static int binarySearch(int[] a,int destElement){
		int begin=0;
		int end=a.length-1;
		
		while(begin<=end){
			int min=(begin+end)/2;
			if(a[min]==destElement)
			{
				return min;
			}else if(a[min]>destElement)
			{
				end=min-1;
			}else if(a[min]<destElement)
			{
				begin=min+1;
			}
		}
		return -1;
	}
}
