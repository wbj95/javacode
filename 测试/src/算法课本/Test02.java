package �㷨�α�;
//.���һ�������㷨��������Ԫ�ص����ֵ
public class Test02 {
	//���ֵ
	public int Fun(int []A,int start,int end){
		if(start==end){
			return A[start];
		}
		if(end==start+1){
			return A[start]<A[end]?A[end]:A[start];
		}else{
			int m=(start+end)/2;
			int r=Fun(A, start, m);
			int r2=Fun(A, m+1, end);
			return r<r2?r2:r;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A={2,23,33,12,33,66,23,45,3};
		Test02 test02=new Test02();
		int result=test02.Fun(A, 0, A.length-1);
		System.out.println(result);
	}

}
