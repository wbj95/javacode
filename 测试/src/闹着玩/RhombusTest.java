package ������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RhombusTest {
/*
	public static List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

		private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrack(list, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 
	*/
	public static void Fun(int []nums,int start){
		if(start==nums.length-1){
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i]);
			}
			System.out.println();
		}else{
			for (int i = start; i < nums.length; i++) {
				Fun(nums, start+1);
				int temp=nums[i];
				nums[i]=nums[i+1];
				nums[i+1]=temp;
				Fun(nums, start+1);
				int temp2=nums[i];
				nums[i]=nums[i+1];
				nums[i+1]=temp2;
			}
		}
		
	}
	public static void main(String[] args) {
		int[] nums={1,2,3,4};
		//List l=permute(nums);
		/*Iterator<List> i=l.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}*/
		Fun(nums, 0);
	}
}
