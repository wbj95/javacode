package ����;
/*
 * ����һ���������飬����ͨ�����ö��ֲ��ҵķ�ʽ����λĳһԪ�أ����д���ֲ��ҵ��㷨���������в���ָ��Ԫ�ء� 
����һ����������A�����Ĵ�Сn��ͬʱ����Ҫ���ҵ�Ԫ��val���뷵�����������е�λ��(��0��ʼ)���������ڸ�Ԫ�أ�����-1������Ԫ�س��ֶ�Σ��뷵�ص�һ�γ��ֵ�λ�á� 
�������ص��ڷ��ص�һ�γ��ֵ�λ�á�
 */
public class Bisearch {
	
	public static void find(int [] A ,int k){
		int low =0 ,high =A.length-1 ;
		int min ;
		while(true) {
			min = (low + high)/2;
			System.out.println(min);
			if(k ==A[min]) {
				System.out.println(k+"��������±�Ϊ��"+min);
				break;
			}
			if(k < A[min]){
				high = min -1;
			}else if(k>A[min]){
				low =min+1;
			}else{
				System.out.println(-1);
			}
		}
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {4,4,10,21};
		find(A , 4);
	}

}
