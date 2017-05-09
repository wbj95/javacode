package Book;

//����Ӷκͣ�һ������������������������ĳ���Ӷεĺ������ģ������÷��η������Ǳȷ��η���
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
