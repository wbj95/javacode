package java���;

public class String1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str1="123456789123456125";
			int len=str1.length();//��ȡ�ַ����ĳ���   int length()
			System.out.println(len);
			char ind=str1.charAt(5);//��ȡindex�±���ַ�  char charAt(int index)
			System.out.println(ind);
			int ind2=str1.indexOf('5');//int indexOf(int ch)��ȡ�ַ�������ch�ַ���ͬ�ĵ�һ���±꣬�����򷵻�-1
			System.out.println(ind2);
			int ind3=str1.indexOf('6', 6);
			//int indexOf(int ch,int fromIndex)
			//��ȡ��fromIndex��ʼ��ch�ַ���ͬ�ĵ�һ���±꣬���ޣ�����-1
			System.out.println(ind3);
			int ind4=str1.indexOf("67");
			//int indexOf(String str)
			//��ȡ�ַ��������ַ���str��ͬ�ĵ�һ���±꣬���ޣ�����-1
			System.out.println(ind4);
			int ind5=str1.indexOf("123",6);
			//int indexOf(String str,int fromIndex)
			//��ȡ�ַ����д�fromIndex���ַ���str��ͬ�ĵ�һ���±꣬���ޣ�����-1
			System.out.println(ind5);
			
			String str2="123456789";
			String str3=str2.concat("���������");
			//String concat(String str)
			//���ַ���β����str�õ��µ��ַ���
			System.out.println(str3);
			String str4=str3.replace('��', 'ʺ');
			//String replace(char oldChar, char newChar)
			//���ַ���������oldChar����newChar�õ�һ�����ַ���
			System.out.println(str4);
			String str5=str4.replaceAll("123", "Zhu");
			//String raplaceAll(String regex,String raplacement)
			//������regex�ַ�������raplacement�õ�һ���µ��ַ�������
			System.out.println(str5);
			String str6=str5.substring(2, 10);
			//String substring(int beginIndex,int endIndex)
			//��ȡ��beginIndexλ�ÿ�ʼ������λ��ΪendIndex���ַ����õ�һ���µĶ��󣬲�����endIndexλ�õ��ַ�
			System.out.println(str6);
			String str7=str5.toLowerCase();
			//���ַ����������ַ�ת����Сд
			System.out.println(str7);
			String str8=str5.toUpperCase();
			//���ַ����������ַ�ת���ɴ�д
			System.out.println(str8);
	}

}
