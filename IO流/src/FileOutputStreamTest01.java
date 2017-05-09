import java.io.*;
public class FileOutputStreamTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos=null;
		try {
			//谨慎使用，会将源文件内容覆盖
			//fos=new FileOutputStream("D:/javachengxu/IO流/newTest");//该文件不存在则自动创建
			
			//以追加的方式写入
			fos=new FileOutputStream("D:/javachengxu/IO流/newTest",true);
			
			String sre="hello world";
			//将String转换成byte数组
			byte[] bytes=sre.getBytes();
			
		//	fos.write(bytes);//将byte数组中的数据全部写入
			fos.write(bytes,0,3);//部分写入
			
			fos.flush();//强制写入
			
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
