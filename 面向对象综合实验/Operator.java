
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
		System.out.print("1.��ʾ�ļ��б�\n"+"2.�����ļ�\n"+"3.�ϴ��ļ�\n"+"4.�˳�\n");
		System.out.println("******************");
		num=s.nextInt();
		if(num==1) showFile("D:\\java-upload");//��ʾ�ļ�D:\\java-upload�е�Ŀ¼
		else if(num==2)downloadFile();//�����ļ�
		else if(num==3) uploadFile();//�ϴ��ļ�
		else System.exit(0);//�˳�
		}
			
	}
	void  uploadFile()  {  //�ϴ��ļ�������D:\java-upload�ļ���
	      try  {  
	           int  temp =  0;  
	           int  byteread  =  0;  
	           Scanner scan=new Scanner(System.in);
	           System.out.println("�������ϴ����ļ���������׺����");
	           String name=scan.next();
	           String path="D:\\java-download\\"+name;
	           System.out.println("�������ļ���ţ�");
	           String ID=scan.next();
	           System.out.println("�������ļ�������");
	           String description=scan.next();
	           File  oldfile  =  new  File(path);  //��String����ת����File����
	           if  (oldfile.exists())  {  //�ļ�����ʱ     exists()��������ʱboolean���ͣ� ���Դ˳���·������ʾ���ļ���Ŀ¼�Ƿ���ڡ� 
	               FileInputStream  inStream  =  new  FileInputStream(path);  //����ԭ�ļ�  
	               FileOutputStream  fs  =  new  FileOutputStream("D:\\java-upload\\"+name);//д��D:\java-upload
	               byte[]  buffer  =  new  byte[1444];  //һ�ζ�1444���ֽ�
	              
	               while  (  (  byteread =  inStream.read(buffer))  !=  -1)  {  
	            	   temp  +=  temp;  //�ֽ���  �ļ���С  
	                   fs.write(buffer,  0,  byteread);  //д��
	               }
	               
                   System.out.println("�ļ���С��"+temp);  
	               inStream.close();//�ر���
	               fs.close();//�ر���
	               Timestamp timestamp = new Timestamp(System.currentTimeMillis());//��ʱ�䣬java.sql.Timestamp
			       if(DataProcessing.insertDoc(ID, this.getName(),timestamp,description,name));
	               System.out.println("�ļ��ϴ��ɹ���");
	           }
	           else System.out.println("�Ҳ������ļ���");
	       }
	       catch  (Exception  e)  {  
	           System.out.println("�ϴ��ļ�����");  
	           e.printStackTrace();
	       }
		
		
		
		
		
		/*try{
			Scanner sca=new Scanner(System.in);
			System.out.println("�������ϴ����ļ���������׺��");
			String name=sca.nextLine();
			String past="D:\\java-download\\"+name;
			System.out.println("�������ļ��ı��");
			String ID=sca.nextLine();
			System.out.println("�������ļ�������");
			String description=sca.nextLine();
			File file=new File(past);
			if(file.exists()){
				FileInputStream fis=new FileInputStream(past);
				FileOutputStream fos=new FileOutputStream("D:/java-upload/"+name);
				byte[] bytes=new byte[1024];
				int temp=0;
				while((temp=fis.read(bytes))!=-1){
					System.out.println("�ļ��Ĵ�С��"+temp);
					fos.write(bytes, 0, temp);
				}
				fis.close();
				fos.close();
				Timestamp time=new Timestamp(System.currentTimeMillis());
				if(DataProcessing.insertDoc(ID,this.getName(),time,description,name)){
					System.out.println("�ϴ��ɹ�");
				}
				else{ System.out.println("�Ҳ������ļ���");}
			}
			
		}catch(Exception e){
			System.out.println("�ϴ��ļ�����");  
			e.printStackTrace();
		}*/
		
	   }
	void downloadFile()  {  //��D:\java-upload�����ļ���D:\java-download�ļ���
	       try  {  
	           int  temp  =  0;  
	           int  byteread  =  0;
	           System.out.println("�������е��ļ���");
	           showFile("D:\\java-upload");//��ʾ�ļ�D:\\java-upload�е�Ŀ¼
	           String path="D:\\java-upload\\";
	           Scanner scan=new Scanner(System.in);
	           System.out.println("������Ҫ���ص��ļ���������׺����");
	           String name=scan.next();
	           path=path+name;
	           File  oldfile  =  new  File(path);  //��String����ת����File����
	           if  (oldfile.exists())  {  //�ļ�����ʱ
	               InputStream  inStream  =  new  FileInputStream(path);  //����ԭ�ļ�  
	               FileOutputStream  fs  =  new  FileOutputStream("D:\\java-download\\"+name);  
	               byte[]  buffer  =  new  byte[1444];   
	               while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {  
	            	   temp  +=  byteread;  //�ֽ���  �ļ���С  
	                  
	                   fs.write(buffer,  0,  byteread);  
	               }
	               System.out.println("�ļ���С��"+temp); 
	               inStream.close();
	               fs.close();
	               System.out.println("�����ļ��ɹ���");
	           }
	           else System.out.println("�ļ������ڣ������Ȳ鿴�������ļ��б�");
	       }
	       catch  (Exception  e)  {
	           System.out.println("�ϴ��ļ�����");  
	           e.printStackTrace();  
	       }
		/*try{
			System.out.println("�������е��ļ���");
			showFile("D:/java-upload");
			  String path="D:\\java-upload\\";
			Scanner sca=new Scanner(System.in);
			System.out.println("������Ҫ���ص��ļ�����������׺��");
			String name=sca.nextLine();
			path=path+name;
			File file=new File(path);
			if(file.exists()){
			FileInputStream fis=new FileInputStream(path);
			FileOutputStream fos=new FileOutputStream("D:/java-download/"+name);
			byte [] bytes =new byte[1024];
			int temp=0;
			while((temp=fis.read(bytes))!=-1){
				System.out.println("�ļ���С��"+temp);
				fos.write(bytes, 0, temp);
			}
			fis.close();
			fos.close();
			System.out.println("�ļ����سɹ���");
			}else{
				 System.out.println("�ļ������ڣ������Ȳ鿴�������ļ��б�");
			}
		}catch(Exception e){
			System.out.println("�ϴ��ļ�����");  
			e.printStackTrace();
		}*/
	
}
	void showFile(String s){//��ʾָʾ·�����ļ���sΪ�����·��
		try{
		File path=new File(s);
		String[] list=path.list();//��ʾ�ļ���Ŀ¼
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