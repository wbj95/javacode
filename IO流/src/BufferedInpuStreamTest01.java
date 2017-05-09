import java.io.*;
/*    字节
 * 	BufferedInputStream
 *  BufferedOutputStream
 * 
 *    字符
 *    BufferedReader 带有缓冲区的字符输入流
 *    BufferedWriter 带有缓冲区的字符输出流
 */

public class BufferedInpuStreamTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr;
		try {
			//创建一个带有缓冲区的字节输入流
			fr = new FileReader("D:/javachengxu/IO流/src/BufferedInpuStreamTest01.java");
			//创建一个文件字符输入流
			
			BufferedReader bis=new BufferedReader(fr);//将文件字符输入流包装成带缓冲区的字符输入流
			//FileReader fr 是节点流
			//BufferedReader bis是一个包装流，或者处理流
			
			//开始读
			String temp=null;
			while((temp=bis.readLine())!=null){//br.readLine()方法读取一行，但是行尾不带换行符
				
				System.out.println(temp);
			}
			bis.close();//关闭
			//注意：关闭的时候只需要关闭最外层的包装流。
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
