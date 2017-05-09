package 测试;

public class Test003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int engishCount = 0;
		int digitCount = 0;
		int chineseCount = 0;
		String str = "assd56562阿克苏的购房款asd号345";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= '0' && ch <= '9')
				digitCount++;
			else if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
				engishCount++;
			else
				chineseCount++;
		}
		System.out.println("数字："+digitCount);
		System.out.println("字母："+engishCount);
		System.out.println("汉子"+chineseCount);*/
		short a=128;
		byte b=(byte)a;
		System.out.println(a);
		System.out.println(b);
	}

}
