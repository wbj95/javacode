import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 *     int read(byte[] bytes);
 *     读取之前在内存中准备一个byte数组，每次读取多个字节存储到byte数组中，
 *     一次读取多个字节，不是单字节读取
 */
public class FileInputStreamTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream  fis=null;
		try{
			//创建流
		fis=new FileInputStream("D:/javachengxu/IO流/test");
		//开始读
		//准备一个byte数组
		byte[] bytes=new byte[3];//每次最多读3个字节
		int i1=fis.read(bytes);
		//将byte数组转换成字符串
		System.out.println(new String(bytes));//abc
		//int read(byte[] bytes);  该方法返回的整数代表，这次读取了几个字节
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
		//关闭流
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
