package java�����;
//ˮ�ɻ����⣺ˮ�ɻ���������һ�����ڵ�����λ����ÿһλ�����������������������������
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
			r = temp/10;//��һλ��
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
