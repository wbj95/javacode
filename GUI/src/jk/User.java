package jk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException; //����6�����������Ըĳɣ�import java.io.*��
import java.sql.*;
import java.util.Enumeration;
public abstract class User {
	private String name;
	private String password;
	private String role;
	
	static String uploadpath="D:\\upload";
	static String downloadpath="D:\\download";   //ָ���ϴ��ļ��������ļ���·��
	
	User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;				
	}
	
	public boolean changeUserInfo(String password) throws SQLException,IllegalStateException{
		//д�û���Ϣ���洢
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			System.out.println("�޸ĳɹ�");
			return true;
		}else
			return false;
	}
	
	public static  boolean downloadFile(String ID) throws SQLException,IOException{  //���������ļ�����
		//boolean result=false;
		byte[] buffer = new byte[1024];
		Doc doc=DataProcessing.searchDoc(ID);//����DataProcessing���е�searchDoc()���������ر��ID���ļ�doc
		
		if (doc==null)
			return false;
		
		File tempFile =new File(uploadpath,doc.getFilename());//��uploadpath��Ӧ��·���£������ļ�����tempFile���ļ���Ϊdoc.getFilename()
		String filename = tempFile.getName();
		
		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(tempFile));//�����ļ��ֽ����������󣬴�Ҫ��ȡ���ݵ��ļ�tempFile
                                                                                                     //�ô򿪵��ļ��ֽ�������������Ϊ�����������ַ�����������������infile��
                                                                                                     //���򿪵�Դ�ļ����ַ�����������ϵ������ͨ����������ȡ�ļ�����
		BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(downloadpath+filename)); //�����ļ��ֽ���������󣬴�Ҫд�����ݵ�Ŀ���ļ�filename
                                                                                                     //�ô򿪵��ļ��ֽ������������Ϊ�����������ַ�����������������targetfile��
                                                                                                     //���򿪵�Ŀ���ļ����ַ�����������ϵ������ͨ��������д�����ݵ�Ŀ���ļ�

		while (true) {
			int byteRead=infile.read(buffer); //ͨ����������ȡ�ļ����ݸ��ֽ�����
            if (byteRead==-1) //���ļ�β�������ݿɶ�
                break;  //�˳�ѭ��           
            targetfile.write(buffer,0,byteRead);  //������������ͨ��������д��Ŀ���ļ�
        }
		infile.close();
		targetfile.close();//�ر��ַ����������������
		
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
