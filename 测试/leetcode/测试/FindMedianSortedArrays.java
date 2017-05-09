package 测试;
//There are two sorted arrays nums1 and nums2 of size m and n respectively.

//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
public class FindMedianSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int num[]=new int[len1+len2];
        int i=0,j=0,k=0;
        while(i<len1&&j<len2){
        	if(nums1[i]<=nums2[j]){
        		num[k++]=nums1[i++];
        	}else{
        		num[k++]=nums2[j++];
        	}
        }
        while(i<len1){
        	num[k++]=nums1[i++];
        }
        while(j<len2){
        	num[k++]=nums2[j++];
        }
        
        //找中位数
        double midnum=0;
        if(num.length%2==0){
        	//偶数
        	int m=num.length/2;
        	midnum=(double)(num[m]+num[m-1])/2;
        }else{
        	//奇数
        	midnum=(double)num[num.length/2];
        }
        return  midnum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums1={2,4,6,8,9};
		int []nums2={2,4,99,9999};
		long startTime = System.currentTimeMillis();
		LongestPalindrome l=new LongestPalindrome();
		FindMedianSortedArrays f=new FindMedianSortedArrays();
		System.out.println(f.findMedianSortedArrays(nums1, nums2));
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间："+(endTime-startTime)+"ms");
	}

}
