package java�����;
/*
 * ������������⣺ 
����int32����m��n�Ķ����Ʊ��ж��ٸ�λ(bit)��ͬô�� 
(1)m^n�󣬽������ֵ��һ��String���͵ı�����ѭ������������ÿһλ�����Ƿ����1. 
(2)m^n�󣬽������ƽ�������һλ&1,Ȼ�󽫶��������ơ�
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
