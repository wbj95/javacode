import java.io.*;

/*
 * java.lang.Object
   java.io.Reader
       java.io.InputStreamReader ת�������ֽ�������-���ַ���������
           java.io.FileReader  �ļ��ַ�������

 */

public class FileReaderTest01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader f=null;	
		try {
			//�����ļ��ַ�������
				f=new FileReader("D:/javachengxu/IO��/src/FileReaderTest01.java");
			//��ʼ��
				char[] ch=new char[512];//1kb
			int temp=0;
			while((temp=f.read(ch))!=-1)
			{
				//��char������Ч����ת�����ַ���
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





