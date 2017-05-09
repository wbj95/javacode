import java.io.*;
import java.util.Scanner;

/*
 * 接收用户键盘输入
 */
public class BufferedReaderTest01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*	//以前的方式
			  Scanner sc =new Scanner(System.in);
		String str=sc.next();//  遇到空格不会继续输出后面的内容
		System.out.println(str);
		*/
		//接收用户输入
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		try {
		 str=	br.readLine();//每次读一行
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
			
		//关闭
		br.close();
	}

}
