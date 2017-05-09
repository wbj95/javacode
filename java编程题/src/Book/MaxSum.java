package Book;

//最大子段和，一个数组中有正数，负数，求某个子段的和是最大的，不是用分治法，但是比分治法优
public class MaxSum {

	public int fun(int[] r, int n) {
		int maxsum = 0, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += r[i];
			if (sum > maxsum) {
				maxsum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] r = { -20, 11, -4, 13, -5, -2 };
		int n = r.length;
		MaxSum maxSum = new MaxSum();
		int result = maxSum.fun(r, n);
		System.out.println(result);
	}

}
