package java编程题;
/*
 * 处理二进制问题： 
两个int32整数m和n的二进制表达，有多少个位(bit)不同么？ 
(1)m^n后，将结果赋值给一个String类型的变量，循环遍历变量的每一位，看是否等于1. 
(2)m^n后，将二进制结果的最后一位&1,然后将二进制右移。
 */
public class BinarySystem {
	
	public static void find(int m , int n) {
		String a = Integer.toBinaryString(m);
		String b = Integer.toBinaryString(n);
		//int res = m^n;
		System.out.println(a);
		System.out.println(b);
	}
	
	public int countBitDiff(int m, int n) {
		String a = Integer.toBinaryString(m);
		String b = Integer.toBinaryString(n);
		//int res = m^n;
		System.out.println(a);
		System.out.println(b);
        int x = m^n;
        System.out.println(x);
        int y = 0;
        while(x>0) {
            if((x&1) == 1) {
                y+=1;
            }
           x= x>>1;
        }
        return y;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//find(234, 134);
		int result = new BinarySystem().countBitDiff(1234, 1345);
		System.out.println(result);
	}

}
