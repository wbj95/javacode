
import java.util.Scanner;
import java.io.*;
import java.sql.*;
import java.util.Enumeration;

public class Operator extends User{
	Operator(String name,String password,String role){
		super(name,password,role);
	}
	Scanner s=new Scanner(System.in);
	int num;
	public void showMenu(){
		
		while(true){
			showFileList();
			System.out.println("******************");
		System.out.print("1.显示文件列表\n"+"2.下载文件\n"+"3.上传文件\n"+"4.退出\n");
		System.out.println("******************");
		num=s.nextInt();
		if(num==1) showFile("D:\\java-upload");//显示文件D:\\java-upload中的目录
		else if(num==2)downloadFile();//下载文件
		else if(num==3) uploadFile();//上传文件
		else System.exit(0);//退出
		}
			
	}
	void  uploadFile()  {  //上传文件到本地D:\java-upload文件夹
	      try  {  
	           int  temp =  0;  
	           int  byteread  =  0;  
	           Scanner scan=new Scanner(System.in);
	           System.out.println("请输入上传的文件（包括后缀）：");
	           String name=scan.next();
	           String path="D:\\java-download\\"+name;
	           System.out.println("请输入文件编号：");
	           String ID=scan.next();
	           System.out.println("请输入文件描述：");
	           String description=scan.next();
	           File  oldfile  =  new  File(path);  //把String类型转换成File类型
	           if  (oldfile.exists())  {  //文件存在时     exists()返回类型时boolean类型， 测试此抽象路径名表示的文件或目录是否存在。 
	               FileInputStream  inStream  =  new  FileInputStream(path);  //读入原文件  
	               FileOutputStream  fs  =  new  FileOutputStream("D:\\java-upload\\"+name);//写到D:\java-upload
	               byte[]  buffer  =  new  byte[1444];  //一次读1444个字节
	              
	               while  (  (  byteread =  inStream.read(buffer))  !=  -1)  {  
	            	   temp  +=  temp;  //字节数  文件大小  
	                   fs.write(buffer,  0,  byteread);  //写入
	               }
	               
                   System.out.println("文件大小："+temp);  
	               inStream.close();//关闭流
	               fs.close();//关闭流
	               Timestamp timestamp = new Timestamp(System.currentTimeMillis());//读时间，java.sql.Timestamp
			       if(DataProcessing.insertDoc(ID, this.getName(),timestamp,description,name));
	               System.out.println("文件上传成功！");
	           }
	           else System.out.println("找不到该文件！");
	       }
	       catch  (Exception  e)  {  
	           System.out.println("上传文件出错！");  
	           e.printStackTrace();
	       }
		
		
		
		
		
		/*try{
			Scanner sca=new Scanner(System.in);
			System.out.println("请输入上传的文件（包括后缀）");
			String name=sca.nextLine();
			String past="D:\\java-download\\"+name;
			System.out.println("请输入文件的编号");
			String ID=sca.nextLine();
			System.out.println("请输入文件的描述");
			String description=sca.nextLine();
			File file=new File(past);
			if(file.exists()){
				FileInputStream fis=new FileInputStream(past);
				FileOutputStream fos=new FileOutputStream("D:/java-upload/"+name);
				byte[] bytes=new byte[1024];
				int temp=0;
				while((temp=fis.read(bytes))!=-1){
					System.out.println("文件的大小："+temp);
					fos.write(bytes, 0, temp);
				}
				fis.close();
				fos.close();
				Timestamp time=new Timestamp(System.currentTimeMillis());
				if(DataProcessing.insertDoc(ID,this.getName(),time,description,name)){
					System.out.println("上传成功");
				}
				else{ System.out.println("找不到该文件！");}
			}
			
		}catch(Exception e){
			System.out.println("上传文件出错！");  
			e.printStackTrace();
		}*/
		
	   }
	void downloadFile()  {  //从D:\java-upload下载文件到D:\java-download文件夹
	       try  {  
	           int  temp  =  0;  
	           int  byteread  =  0;
	           System.out.println("服务器中的文件：");
	           showFile("D:\\java-upload");//显示文件D:\\java-upload中的目录
	           String path="D:\\java-upload\\";
	           Scanner scan=new Scanner(System.in);
	           System.out.println("请输入要下载的文件（包括后缀）：");
	           String name=scan.next();
	           path=path+name;
	           File  oldfile  =  new  File(path);  //把String类型转换成File类型
	           if  (oldfile.exists())  {  //文件存在时
	               InputStream  inStream  =  new  FileInputStream(path);  //读入原文件  
	               FileOutputStream  fs  =  new  FileOutputStream("D:\\java-download\\"+name);  
	               byte[]  buffer  =  new  byte[1444];   
	               while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {  
	            	   temp  +=  byteread;  //字节数  文件大小  
	                  
	                   fs.write(buffer,  0,  byteread);  
	               }
	               System.out.println("文件大小："+temp); 
	               inStream.close();
	               fs.close();
	               System.out.println("下载文件成功！");
	           }
	           else System.out.println("文件不存在，建议先查看服务器文件列表！");
	       }
	       catch  (Exception  e)  {
	           System.out.println("上传文件出错！");  
	           e.printStackTrace();  
	       }
		/*try{
			System.out.println("服务器中的文件：");
			showFile("D:/java-upload");
			  String path="D:\\java-upload\\";
			Scanner sca=new Scanner(System.in);
			System.out.println("请输入要下载的文件名（包括后缀）");
			String name=sca.nextLine();
			path=path+name;
			File file=new File(path);
			if(file.exists()){
			FileInputStream fis=new FileInputStream(path);
			FileOutputStream fos=new FileOutputStream("D:/java-download/"+name);
			byte [] bytes =new byte[1024];
			int temp=0;
			while((temp=fis.read(bytes))!=-1){
				System.out.println("文件大小："+temp);
				fos.write(bytes, 0, temp);
			}
			fis.close();
			fos.close();
			System.out.println("文件下载成功！");
			}else{
				 System.out.println("文件不存在，建议先查看服务器文件列表！");
			}
		}catch(Exception e){
			System.out.println("上传文件出错！");  
			e.printStackTrace();
		}*/
	
}
	void showFile(String s){//显示指示路径的文件，s为传入的路径
		try{
		File path=new File(s);
		String[] list=path.list();//显示文件的目录
		for(int i=0;i<list.length;i++) System.out.println(list[i]);
		}catch(Exception e){
			e.printStackTrace();
		}
		/*try{
			File file=new File(s);
			String [] list=file.list();
			for(int i=0;i<list.length;i++)System.out.print(list[i]);
		}catch(Exception e){e.printStackTrace();}*/

	}
	void showFileList() {
		try{
		Enumeration<Doc> e = DataProcessing.getAllDocs();
		Doc docs;
		while(e.hasMoreElements()){
			docs=e.nextElement();
			System.out.println("*--Creator:"+docs.getCreator()+" --ID:"+docs.getID()+" --Name:"+docs.getFilename()+"\n --Description:"+docs.getDescription()+" --TimeStamp:"+docs.getTimestamp());	
		}
		}catch(SQLException s){
			s.printStackTrace();
		}
	}
}