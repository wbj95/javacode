package 测试;

import java.util.Arrays;

/**
 * @author Administrator
 * 对于两个长度均为n的已排序的序列,确定这两个序列的2n个元素的中位数
 */
public class Test02 {
	    //返回数组中位数
		public static double getOneMedium(int a[]){
			 double mid;
			 int length=a.length;
			 if((length%2)==0){//判断子数组的长度是奇数还是偶数
			      mid=(a[length/2]+a[length/2-1]+0.0)/2;
			   }else{
			          mid=a[length/2];
			      }
			  return mid;
		}  
		 public static double getMedium(int a[],int b[], int n){
	           double mid_x=getOneMedium(a);
			   double mid_y=getOneMedium(b);
			   if(n==1){//n=1
				   return (mid_x+mid_y)/2;
			   	}
			   if(mid_x==mid_y){
			       return mid_x;
			   }else if(mid_x>mid_y){//x的中位数大于y的中位数，则保留x的中位数及其左边的数和y的中位数及其右边的数，继续递归
			        if (n%2==0) {//数组长度为偶数（偶数和奇数数组在复制数组时与及下次递归时的数组长度取值不同）
			        int[] x2=Arrays.copyOfRange(a,0,n/2);//赋值
			        int[] y2=Arrays.copyOfRange(b,n/2,n);
			        n=n/2;//偶数数组的长度
				    return getMedium(x2,y2,n);
				  }else {//数组长度为奇数
					 int[] x2=Arrays.copyOfRange(a,0,n/2+1);
			         int[] y2=Arrays.copyOfRange(b,n/2,n);
			         n=n/2+1;
				     return getMedium(x2,y2,n);
				  }
			    }else{//x的中位数小于y的中位数，则保留x的中位数及其右边的数和y的中位数及其坐边的数，继续递归
			    	if (n%2==0) {//数组长度为偶数
			    		int[] x2=Arrays.copyOfRange(a,n/2,n);
				        int[] y2=Arrays.copyOfRange(b,0,n/2);
				        n=n/2;
					    return getMedium(x2,y2,n);
					}else {//数组长度为奇数
						int[] x2=Arrays.copyOfRange(a,n/2,n);
				        int[] y2=Arrays.copyOfRange(b,0,n/2+1);
				        n=n/2+1;
					    return getMedium(x2,y2,n);
					}
			        
			    }	
		 }
		 public static void main(String[] args) {
			 int[] a={23,29,20,32};
			 int[] b={23,21,33,24};
			 Arrays.sort(a);
			 Arrays.sort(b);
			 System.out.println(getMedium(a, b, 4));
		}

}
