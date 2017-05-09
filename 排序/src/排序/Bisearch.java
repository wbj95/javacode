package 排序;
/*
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。 
给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。 
分析：重点在返回第一次出现的位置。
 */
public class Bisearch {
	
	public static void find(int [] A ,int k){
		int low =0 ,high =A.length-1 ;
		int min ;
		while(true) {
			min = (low + high)/2;
			System.out.println(min);
			if(k ==A[min]) {
				System.out.println(k+"在数组的下标为："+min);
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
