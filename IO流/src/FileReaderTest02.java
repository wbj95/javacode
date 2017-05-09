import java.io.*;

/*
 * java.lang.Object
   java.io.Writer
       java.io.OutputStreamWriter
           java.io.FileWriter

 */
public class FileReaderTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			FileWriter fw=new FileWriter("D:/javachengxu/IO流/newTest",true);//追加
		
			
		fw.write("我是中国人！！！1");
		char [] ch={'韦','小','宝','!','？'};
		fw.write(ch,0,3);//部分写入
		
		fw.flush();//刷新
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
