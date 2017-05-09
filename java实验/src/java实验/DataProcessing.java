package javaʵ��;

import java.sql.*;
import java.util.*;

abstract class User{
	private String name,password,role;
	User(){}
	User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;
	}
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
	public void showFile(){
		getName();
		getRole();
	}
	 public  void showMenu(){	
	}
}
//****************************************
class Administrator extends User{
	Administrator(String name,String password,String role){
		super(name,password,role);
	}
	Scanner s=new Scanner(System.in);
	int num;
	public void showMenu(){
		int j;
		do{
		System.out.print("1.�ı��û���Ϣ\n"+"2.ɾ���û�\n"+"3.�����û�\n"+"4.�г��û�\n"+"5.�˳�\n");
		num=s.nextInt();
		if(num==1)changeUserInfo();
		else if(num==2)delUser();
		else if(num==3) addUser();
	    else if(num==4) listUser();
	    else if(num==5) System.exit(0);
	    else ; 
			System.out.println("�Ƿ�����û�������1-��ʾ�˵� ����-�˳��˵���");
		j=s.nextInt();
		}while(j==1);
	}
	public void changeUserInfo(){
		System.out.println("�������µ��û���");
		String newname=s.next();
		setName(newname);
		System.out.println("������������");
		String newpassword=s.next();
		setPassword(newpassword);
		System.out.println("�����������"); 
		String newrole=s.next();
		setRole(newrole);
		
	}
	public void delUser(){
		System.out.println("������Ҫɾ�����û���");
		String delname=s.next();
		try{
			boolean b=DataProcessing.delete(delname);
		System.out.println(b);
		if(b==true){System.out.println("ɾ���ɹ�");}
		else System.out.println("ɾ��ʧ��");
		}catch(SQLException s){
			System.out.println(s);
			s.printStackTrace();
			}
	}
	public void addUser(){
		try{
		System.out.println("�������û���");
		String newname=s.next();
		System.out.println("����������");
		String newpassword=s.next();
		System.out.println("���������");
		String newrole=s.next();
		boolean b=DataProcessing.insert(newname, newpassword, newrole);
		if(b==true){
		System.out.println("���ӳɹ�");}else{System.out.println("����ʧ��");}
		}catch(SQLException s){
			System.out.println(s);
		s.printStackTrace();}
	}
	public void listUser(){
		try{
		Enumeration<User> e = DataProcessing.getAllUser();
		User user;
		while(e.hasMoreElements()){
			user=e.nextElement();
			System.out.println("����:"+user.getName()+" ����:"+user.getPassword()+" ���:"+user.getRole());
		}}catch(SQLException s){
			System.out.println(s);
		s.printStackTrace();}
	}
}
//*********************************************
class Browser extends User{
	Browser(String name,String password,String role){
		super(name,password,role);
	}
	Scanner s=new Scanner(System.in);
	int num;
	public void showMenu(){
		int j;
		do{
		System.out.print("1.�����ļ�\n"+"2.�г������ļ�\n"+"3.�˳�\n");	
		num=s.nextInt();
		if(num==1)upDown();
		else if(num==2) listFile();
		else ;
		System.out.println("�Ƿ�����û�������1-��ʾ�˵� ����-�˳���");	
			j=s.nextInt();
		}while(j==1);
	}
	public void upDown(){
		System.out.println("�����ļ�");
	}
	public void listFile(){}
}
//************************************************************
class Operator extends User{
	Operator(String name,String password,String role){
		super(name,password,role);
	}
	Scanner s=new Scanner(System.in);
	int num;
	public void showMenu(){
		int j;
		do{
		System.out.print("1.�ϴ��ļ�\n"+"2.�����ļ�\n"+"3.�����ļ�\n"+"4.�˳�\n");
		num=s.nextInt();
		if(num==1) uploadFile();
		else if(num==2) downloadFile();
		else if(num==3) listFile();
		else ;
		System.out.println("�Ƿ�����û�������1-��ʾ�˵� ����-�˳�");
		j=s.nextInt();
		}while(j==1);
	}
	public void uploadFile(){
		System.out.println("�ϴ��ļ�");
	}
	public void downloadFile(){
		System.out.println("�����ļ�");
	}
	public void listFile(){}
}
public class DataProcessing {
		private static Connection con;
		private Statement st;
		private ResultSet rs;
//		private int numberofRows;
		private static boolean connectToDB=false;
		static Hashtable<String, User> users;
		static {
			users = new Hashtable<String, User>();
			users.put("jack", new Operator("jack","123","operator"));
			users.put("rose", new Browser("rose","123","browser"));
			users.put("kate", new Administrator("kate","123","administrator"));
			Init();
		}
		public static  void Init(){
			// connect to database
			//con = DriverManager.getConnection( "url", "username", "password" );

			// create Statement to query database
			//st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );

			// update database connection status
			if (Math.random()>0.3)
				connectToDB = true;
			else
				connectToDB = false;	
		}
		public static User search(String name, String password) throws SQLException,IllegalStateException {
			if ( !connectToDB ) 
		        throw new IllegalStateException( "Not Connected to Database" );
			if (Math.random()>0.7)
				throw new SQLException( "Error in excecuting Query" );
			if (users.containsKey(name)) {
				User temp =users.get(name);
				if ((temp.getPassword()).equals(password))
					return temp;
			}
			return null;
		}
		public static Enumeration<User> getAllUser() throws SQLException,IllegalStateException{
			if ( !connectToDB ) 
		        throw new IllegalStateException( "Not Connected to Database" );
			if (Math.random()>0.7)
				throw new SQLException( "Error in excecuting Query" );
			Enumeration<User> e  = users.elements();
			return e;
		}
		public static boolean update(String name, String password, String role) throws SQLException,IllegalStateException{
			User user;
			if ( !connectToDB ) 
		        throw new IllegalStateException( "Not Connected to Database" );
			if (Math.random()>0.7)
				throw new SQLException( "Error in excecuting Update" );
			if (users.containsKey(name)) {
				if (role.equalsIgnoreCase("administrator"))
					user = new Administrator(name,password, role);
				else if (role.equalsIgnoreCase("operator"))
					user = new Operator(name,password, role);
				else
					user = new Browser(name,password, role);
				users.put(name, user);
				return true;
			}else
				return false;
		}
		public static boolean insert(String name, String password, String role) throws SQLException,IllegalStateException{
			User user;
			if ( !connectToDB ) 
		       throw new IllegalStateException( "Not Connected to Database" );
			if (Math.random()>0.7)
				throw new SQLException( "Error in excecuting Insert" );
			if (users.containsKey(name))
				return false;
			else{
				if (role.equalsIgnoreCase("administrator"))
					user = new Administrator(name,password, role);
				else if (role.equalsIgnoreCase("operator"))
					user = new Operator(name,password, role);
				else
					user = new Browser(name,password, role);
				users.put(name, user);
				return true;
			}
		}
		public static boolean delete(String name) throws SQLException,IllegalStateException{
			if ( !connectToDB ) 
		        throw new IllegalStateException( "Not Connected to Database" );
			
			if (Math.random()>0.7)
				throw new SQLException( "Error in excecuting Delete" );
			
			if (users.containsKey(name)){
				users.remove(name);
				return true;
			}else
				return false;
		}	      
		public void disconnectFromDB() {
			if ( connectToDB ){
				// close Statement and Connection            
				try{
					rs.close();                        
				    st.close();                        
				    con.close();                       
				}catch ( SQLException sqlException ){                                            
				    sqlException.printStackTrace();           
				}finally{                                            
					connectToDB = false;              
				}                             
			} 
	   }           
	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println("*************��ӭ��½����***********");
		System.out.println("            1.��½");
		System.out.println("            2.�˳�");
		System.out.println("********************************");
	String name1,password1;
	Scanner s=new Scanner(System.in);
	int num1=s.nextInt();
	if(num1==1){
		System.out.println("�������û�����");
		name1=s.next();
		System.out.println("�������룺");
		password1=s.next();
		if(name1!=null&&password1!=null){
		User u1=null;
		try{
			u1=DataProcessing.search(name1,password1);
		}catch(SQLException e){
			e.getStackTrace();
			e.printStackTrace();
		}catch(IllegalStateException ill){ill.printStackTrace();}
			if(u1==null){
			System.out.println("�����û������������");
			}
		u1.showMenu();	
		}
	}else if(num1==2){System.out.println("�˳�ϵͳ");
		System.exit(0);
	}
	else{System.out.println("�������");
	}
    }
}