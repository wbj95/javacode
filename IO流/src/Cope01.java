import java.io.*;//�ļ��ĸ���ճ��
public class Cope01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			//����������
			fis=new FileInputStream("D:/javachengxu/IO��/src/FileOutputStreamTest01.java");
			//���������
			fos=new FileOutputStream("E:/FileOutputStreamTest01.java");
			int temp=0;
			//һ�߶�һ��д
			byte[] bytes=new byte[1024];
			while((temp=fis.read(bytes))!=-1){
				fos.write(bytes);
			}
			
			fos.flush();//ˢ��
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//�ر�
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
