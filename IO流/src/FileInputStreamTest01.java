import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 *     int read(byte[] bytes);
 *     ��ȡ֮ǰ���ڴ���׼��һ��byte���飬ÿ�ζ�ȡ����ֽڴ洢��byte�����У�
 *     һ�ζ�ȡ����ֽڣ����ǵ��ֽڶ�ȡ
 */
public class FileInputStreamTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream  fis=null;
		try{
			//������
		fis=new FileInputStream("D:/javachengxu/IO��/test");
		//��ʼ��
		//׼��һ��byte����
		byte[] bytes=new byte[3];//ÿ������3���ֽ�
		int i1=fis.read(bytes);
		//��byte����ת�����ַ���
		System.out.println(new String(bytes));//abc
		//int read(byte[] bytes);  �÷������ص�����������ζ�ȡ�˼����ֽ�
		System.out.println(i1);//3
		
		int i2=fis.read(bytes);
		System.out.println(new String(bytes));//def
		System.out.println(i2);//3
	
		int i3=fis.read(bytes);
		//System.out.println(new String(bytes));//gef
		System.out.println(new String(bytes,0,i3));//g
		System.out.println(i3);//1
		
		int i4=fis.read(bytes);
		//System.out.println(new String(bytes));//gef

		System.out.println(i4);//-1
		//�ر���
		fis.close();
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
