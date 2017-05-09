
import java.util.*;
import java.io.*;
import java.sql.*;


public class Browser extends User{
	Browser(String name,String password,String role){
		super(name,password,role);
	}
	Scanner s=new Scanner(System.in);
	int num;
	public void showMenu(){
		while(true){
			showFileList();
			System.out.println("*******************");
		System.out.print("1.显示所有文件\n"+"2.下载文件\n"+"3.退出\n");	
		System.out.println("*******************");
		num=s.nextInt();
		if(num==1) showFile("D:\\java-upload");
		else if(num==2) downloadFile();
		else System.exit(0);
		
		}
	}
	void downloadFile()  {  
	       try  {  
	           int  bytesum  =  0;  
	           int  byteread  =  0;
	           String path="D:\\java-upload\\";
	           Scanner scan=new Scanner(System.in);
	           System.out.println("请输入要下载的文件（包括后缀）：");
	           String name=scan.next();
	           path=path+name;
	           File  oldfile  =  new  File(path);  
	           if  (oldfile.exists())  {  //文件存在时
	               InputStream  inStream  =  new  FileInputStream(path);  //读入原文件  
	               FileOutputStream  fs  =  new  FileOutputStream("D:\\java-download\\"+name);  
	               byte[]  buffer  =  new  byte[1444];  
	              
	               while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {  
	                   bytesum  +=  byteread;  //字节数  文件大小  
	   
	                   fs.write(buffer,  0,  byteread);  
	               }
	               System.out.println("文件大小："+bytesum); 
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
	void showFile(String s){//显示指示路径的文件，s为传入的路径
		try{
		File path=new File(s);
		String[] list=path.list();
		for(int i=0;i<list.length;i++) System.out.println(list[i]);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
