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
			
			FileWriter fw=new FileWriter("D:/javachengxu/IO��/newTest",true);//׷��
		
			
		fw.write("�����й��ˣ�����1");
		char [] ch={'Τ','С','��','!','��'};
		fw.write(ch,0,3);//����д��
		
		fw.flush();//ˢ��
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
