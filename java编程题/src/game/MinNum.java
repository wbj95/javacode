package game;

import java.util.Arrays;
import java.util.Scanner;

//中位数问题
public class MinNum {
	// 找一个数组中的中位数

	public int findMedian(int x[], int y[], int n) {
		if (n == 0) {
			System.out.println("无效");
			return 0;
		}
		int mid_x, mid_y;
		int offset = 0;
		if (n % 2 == 0) {// 偶数
			mid_x = n / 2 - 1;
			mid_y = n / 2 - 1;
			offset = 1;//偏移值
		} else {// 奇数
			mid_x = n / 2;
			mid_y = n / 2;
		}
		if (n == 1) {
			return x[mid_x] < y[mid_y] ? x[mid_x] : y[mid_y];
		}
		if (x[mid_x] == y[mid_y]) {
			return x[mid_x];
		} else if (x[mid_x] > y[mid_y]) {
			int[] x2 = Arrays.copyOfRange(x, 0, mid_x + 1);
			int[] y2 = Arrays.copyOfRange(y, mid_y + offset, n);
			n = x2.length;
			return findMedian(x2, y2, n);
		} else {
			int[] x2 = Arrays.copyOfRange(x, mid_x + offset, n);
			int[] y2 = Arrays.copyOfRange(y, 0, mid_y + 1);
			n = x2.length;
			return findMedian(x2, y2, n);
		}
	}

	public static void main(String[] args) {

		int n = 4;
		int[] x = { 8, 10, 16, 19 };
		int[] y = { 11, 15, 18, 20 };
		MinNum minNum = new MinNum();
		int result = minNum.findMedian(x, y, n);
		System.out.println(result);
	}

}
