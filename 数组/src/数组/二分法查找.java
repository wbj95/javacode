package 数组;
/*
 * 二分法查找
 *  1.二分法查找是建立在已经排列的基础上的
 *  2.以下程序分析从小到大排列
 *  3.这个数组中没有重复的元素
 */
public class 二分法查找 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={1,3,4,6,8,9,12,36,88};
		int destElement=100;
		//要求从a数组中查找destElement这个元素的下标
		int index=binarySearch(a,destElement);//如果找到则返回元素的下标，如果找不到统一返回-1
		System.out.println((index==-1)? destElement+"不存在":destElement+"的下标是"+index);
	}
	//折半查找的核心算法
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
