import java.io.*;
public class FileOutputStreamTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos=null;
		try {
			//����ʹ�ã��ὫԴ�ļ����ݸ���
			//fos=new FileOutputStream("D:/javachengxu/IO��/newTest");//���ļ����������Զ�����
			
			//��׷�ӵķ�ʽд��
			fos=new FileOutputStream("D:/javachengxu/IO��/newTest",true);
			
			String sre="hello world";
			//��Stringת����byte����
			byte[] bytes=sre.getBytes();
			
		//	fos.write(bytes);//��byte�����е�����ȫ��д��
			fos.write(bytes,0,3);//����д��
			
			fos.flush();//ǿ��д��
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
