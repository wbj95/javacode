import java.io.*;
import java.util.Scanner;

/*
 * �����û���������
 */
public class BufferedReaderTest01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*	//��ǰ�ķ�ʽ
			  Scanner sc =new Scanner(System.in);
		String str=sc.next();//  �����ո񲻻����������������
		System.out.println(str);
		*/
		//�����û�����
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		try {
		 str=	br.readLine();//ÿ�ζ�һ��
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
			
		//�ر�
		br.close();
	}

}
