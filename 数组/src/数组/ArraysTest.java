package 数组;
/*
 *  Arrays是SUN提供的一个工具类
 *  java.util.Arrays;
 *    该工具类主要针对的是数组的操作
 *    排序，二分法查找等
 */
import java.util.Arrays;
public class ArraysTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={1,15,2,3,6,9,5,12,7};
		
		Arrays.sort(a);//排序
		//输出
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		//二分法查找
		int index=Arrays.binarySearch(a, 6);
		System.out.print(index+" ");
	}

}
