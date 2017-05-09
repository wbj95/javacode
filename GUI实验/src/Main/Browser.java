package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Vector;

import BrowserUI.BrowserUI;

public class Browser extends User{
	Browser(String name,String password,String role){
		setName(name);
		setPassword(password);
		setRole(role);
	}
	public static boolean downloadFile(String filename)  {  
	       try  {  
	           int  bytesum  =  0;  
	           int  byteread  =  0;
	           String path="D:\\java-upload\\";
	           String name=filename;
	           path=path+name;
	           File  oldfile  =  new  File(path);  
	           if  (oldfile.exists())  {  //�ļ�����ʱ
	               InputStream  inStream  =  new  FileInputStream(path);  //����ԭ�ļ�  
	               FileOutputStream  fs  =  new  FileOutputStream("D:\\java-download\\"+name);  
	               byte[]  buffer  =  new  byte[1444];  
	               int  length;  
	               while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {  
	                   bytesum  +=  byteread;  //�ֽ���  �ļ���С   
	                   fs.write(buffer,  0,  byteread);  
	               }
	               inStream.close();
	               return true;
	           }
	           else return false;
	       }
	       catch  (Exception  e)  {
	    	   e.printStackTrace();
	           return false;
	       }
}
	public static Vector serverFile() throws IllegalStateException, SQLException{
		String[] str=findFile("D:\\java-upload\\");
		Vector vt=new Vector();
		for(int i=0;i<str.length;i++)
			vt.add(str[i]);
		return vt;
	}
	public static Vector localFile(){
		String[] str=findFile("D:\\java-download\\");
		Vector vt=new Vector();
		for(int i=0;i<str.length;i++)
			vt.add(str[i]);
		return vt;
	}
	static String[] findFile(String s){//��ʾָʾ·�����ļ���sΪ�����·��
		try{
		File path=new File(s);
		String[] list=path.list();
		return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void showMenu() throws IllegalStateException, SQLException{
		new BrowserUI();
	}
}
