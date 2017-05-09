package jk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException; //以上6条声明语句可以改成：import java.io.*；
import java.sql.*;
import java.util.Enumeration;
public abstract class User {
	private String name;
	private String password;
	private String role;
	
	static String uploadpath="D:\\upload";
	static String downloadpath="D:\\download";   //指定上传文件和下载文件的路径
	
	User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;				
	}
	
	public boolean changeUserInfo(String password) throws SQLException,IllegalStateException{
		//写用户信息到存储
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			System.out.println("修改成功");
			return true;
		}else
			return false;
	}
	
	public static  boolean downloadFile(String ID) throws SQLException,IOException{  //定义下载文件方法
		//boolean result=false;
		byte[] buffer = new byte[1024];
		Doc doc=DataProcessing.searchDoc(ID);//调用DataProcessing类中的searchDoc()方法，返回编号ID的文件doc
		
		if (doc==null)
			return false;
		
		File tempFile =new File(uploadpath,doc.getFilename());//在uploadpath对应的路径下，创建文件对象tempFile，文件名为doc.getFilename()
		String filename = tempFile.getName();
		
		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(tempFile));//创建文件字节输入流对象，打开要读取数据的文件tempFile
                                                                                                     //用打开的文件字节输入流对象作为参数，创建字符缓冲区输入流对象infile，
                                                                                                     //将打开的源文件和字符缓冲区流联系起来，通过缓冲区读取文件数据
		BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(downloadpath+filename)); //创建文件字节输出流对象，打开要写入数据的目标文件filename
                                                                                                     //用打开的文件字节输出流对象作为参数，创建字符缓冲区输入流对象targetfile，
                                                                                                     //将打开的目标文件和字符缓冲区流联系起来，通过缓冲区写入数据到目标文件

		while (true) {
			int byteRead=infile.read(buffer); //通过缓冲区读取文件数据给字节数组
            if (byteRead==-1) //在文件尾，无数据可读
                break;  //退出循环           
            targetfile.write(buffer,0,byteRead);  //将读到的数据通过缓冲区写入目标文件
        }
		infile.close();
		targetfile.close();//关闭字符缓冲区输入输出流
		
		return true;
        //System.out.println("copy success! ");		
	}
	
	static void showFileList() throws SQLException{
		Enumeration<Doc> e =DataProcessing.getAllDocs();
		Doc doc;
		while(e.hasMoreElements()){
			doc = e.nextElement();
			System.out.println("ID:" + doc.getID() + "  " + "Creator:" + doc.getCreator() + "  " + "Time:" + doc.getTimestamp() + "  " + "Filename:" + doc.getFilename());	
			System.out.println("Description:" + doc.getDescription());
		}
	}
	
	public abstract void showMenu() throws SQLException, IOException;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
