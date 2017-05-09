package Main;
import java.io.*;
import java.sql.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import OperatorUI.OperatorUI;
public class Operator extends User{
	Operator(String name,String password,String role){
		setName(name);
		setPassword(password);
		setRole(role);
	}
	public static boolean uploadFile(String str)  {  //上传文件到本地D:\java-upload文件夹
	       try  {  
	           int  bytesum  =  0;  
	           int  byteread  =  0;  
	           String path="D:\\java-download\\"+str;
	           File  oldfile  =  new  File(path);  
	           if  (oldfile.exists())  {  //文件存在时  
	               InputStream  inStream  =  new  FileInputStream(path);  //读入原文件  
	               FileOutputStream  fs  =  new  FileOutputStream("D:\\java-upload\\"+str);  
	               byte[]  buffer  =  new  byte[1444];  
	               int  length;
	               while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {  
	                   bytesum  +=  byteread;  //字节数  文件大小  
	                   System.out.println(bytesum);  
	                   fs.write(buffer,  0,  byteread);  
	               }
	               inStream.close();
	               Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			       //if(DataProcessing.insertDoc(ID, str,timestamp,description,name));
	               return true;
	           }
	           else return false;
	       }
	       catch  (Exception  e)  {   
	           e.printStackTrace();
	           return false;
	       }
	       }
	public static boolean downloadFile(String str)  {  //从D:\java-upload下载文件到D:\java-download文件夹
	       try  {  
	           int  bytesum  =  0;  
	           int  byteread  =  0;
	           String path="D:\\java-upload\\";
	           String name=str;
	           path=path+name;
	           File  oldfile  =  new  File(path);  
	           if  (oldfile.exists())  {  //文件存在时
	               InputStream  inStream  =  new  FileInputStream(path);  //读入原文件  
	               FileOutputStream  fs  =  new  FileOutputStream("D:\\java-download\\"+name);  
	               byte[]  buffer  =  new  byte[1444];  
	               int  length;  
	               while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {  
	                   bytesum  +=  byteread;  //字节数  文件大小  
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
	public static Vector serverFile(){
		try{
			Vector vt=new Vector();
			File path=new File("D:\\java-upload\\");
			String[] list=path.list();
			for(int i=0;i<list.length;i++)
				vt.add(list[i]);
			return vt;
			}catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}
	public static Vector localFile(){//显示指示路径的文件，s为传入的路径
		try{
			Vector vt=new Vector();
			File path=new File("D:\\java-download\\");
			String[] list=path.list();
			for(int i=0;i<list.length;i++)
				vt.add(list[i]);
			return vt;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void showMenu(){
		new OperatorUI();
	}
}