package java编程题;
//水仙花问题：水仙花，即给定一个大于等于三位数，每一位的数字立方加起来等于这个数本身。
public class Daffodil {

	public static void find() {
		int j;
		int k;
		int r;
		int temp;
		for (int i = 100; i <= 999; i++) {
			j = i%10;
			temp = i/10;
			k = temp%10;
			r = temp/10;//第一位数
			if(i == j*j*j+r*r*r+k*k*k) {
				System.out.println(i+"="+r+"^3"+"+"+k+"^3"+"+"+j+"^3");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		find();
	}

}
