import java.io.*;
public class FileInputStreamTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("D:/javachengxu/IO��/src/FileInputStreamTest02.java");
			byte[] bytes=new byte[1024];//һ�ζ�ȡ1024kB
			/*while(true){
			
				int temp=fis.read(bytes);
				if(temp==-1)break;
				System.out.print(new String(bytes,0,temp));
			}*/
			//����ѭ��
			System.out.println(fis.available());//ʣ������ֽ���
			fis.skip(2);//���������ֽ�
			int temp=0;
			while((temp=fis.read(bytes))!=-1){
				System.out.print(new String(bytes,0,temp));
			}
			
		} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null)
				try {
					fis.close();//
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}

}
