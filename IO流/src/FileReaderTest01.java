import java.io.*;

/*
 * java.lang.Object
   java.io.Reader
       java.io.InputStreamReader 转换流（字节输入流-》字符输入流）
           java.io.FileReader  文件字符输入流

 */

public class FileReaderTest01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader f=null;	
		try {
			//创建文件字符输入流
				f=new FileReader("D:/javachengxu/IO流/src/FileReaderTest01.java");
			//开始读
				char[] ch=new char[512];//1kb
			int temp=0;
			while((temp=f.read(ch))!=-1)
			{
				//将char数组有效部分转换成字符串
				System.out.println(new String(ch,0,temp));
			}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(f!=null){
					f.close();
				}
			}
	}

}





