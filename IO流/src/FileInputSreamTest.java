import java.io.*;
public class FileInputSreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream  fis=null;
		try{
			//文件路径      绝对路径或相对路径
		//String str="D:\\javachengxu\\IO流\\test";
		String str="D:/javachengxu/IO流/test";
		 fis=new FileInputStream(str);
		//读文件
		/* int i1=fis.read();//以字节的方式读
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
		System.out.println(i7);//-1//如果已经读到文件的末尾，就会返回-1
		System.out.println(i8);//-1
		*/
		 while(true){
			 int temp=fis.read();
			 if(temp==-1) break;
			 System.out.println(temp);
		 }
		 fis.close();//程序的缺点：频繁访问磁盘，伤害磁盘，而且效率低
		 
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
