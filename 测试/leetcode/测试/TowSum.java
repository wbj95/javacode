package ≤‚ ‘;

import java.util.Scanner;

public class TowSum {

	public int[] twoSum(int[] nums, int target) {
        int r[]=new int[2];
        loop:
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]+nums[j]==target) {
					r[0]=i;r[1]=j;break loop;
				}
			}
		}
		return r;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r[]={2,7,11,15};
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		TowSum sum=new TowSum();
		int []rr=sum.twoSum(r, n);
		System.out.println(rr[0]);
		System.out.println(rr[1]);
	}

}
