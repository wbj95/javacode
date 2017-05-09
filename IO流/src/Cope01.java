import java.io.*;//文件的复制粘贴
public class Cope01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			//创建输入流
			fis=new FileInputStream("D:/javachengxu/IO流/src/FileOutputStreamTest01.java");
			//创建输出流
			fos=new FileOutputStream("E:/FileOutputStreamTest01.java");
			int temp=0;
			//一边读一边写
			byte[] bytes=new byte[1024];
			while((temp=fis.read(bytes))!=-1){
				fos.write(bytes);
			}
			
			fos.flush();//刷新
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//关闭
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
