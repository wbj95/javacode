import java.io.*;
public class FileInputSreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream  fis=null;
		try{
			//�ļ�·��      ����·�������·��
		//String str="D:\\javachengxu\\IO��\\test";
		String str="D:/javachengxu/IO��/test";
		 fis=new FileInputStream(str);
		//���ļ�
		/* int i1=fis.read();//���ֽڵķ�ʽ��
		int i2=fis.read();
		int i3=fis.read();
		int i4=fis.read();
		int i5=fis.read();
		int i6=fis.read();
		int i7=fis.read();
		int i8=fis.read();
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
		System.out.println(i6);
		System.out.println(i7);//-1//����Ѿ������ļ���ĩβ���ͻ᷵��-1
		System.out.println(i8);//-1
		*/
		 while(true){
			 int temp=fis.read();
			 if(temp==-1) break;
			 System.out.println(temp);
		 }
		 fis.close();//�����ȱ�㣺Ƶ�����ʴ��̣��˺����̣�����Ч�ʵ�
		 
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try{
				fis.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}

}
