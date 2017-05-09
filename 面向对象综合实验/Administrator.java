
import java.util.*;
import java.util.Scanner;
import java.sql.*;


public class Administrator extends User{
	Administrator(String name,String password,String role){
		super(name,password,role);
	}
	Scanner s=new Scanner(System.in);
	int num;
	public void showMenu(){

		while(true){
			System.out.println("********************");
		System.out.print("1.�ı��û���Ϣ\n"+"2.ɾ���û�\n"+"3.�����û�\n"+"4.�г��û�\n"+"5.�˳�\n");
		System.out.println("********************");
		num=s.nextInt();
		if(num==1)changeUserInfo();
		else if(num==2)delUser();
		else if(num==3) addUser();
	    else if(num==4) listUser();
	    else if(num==5) System.exit(0);
	    else ; 
			
		}
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
			boolean b=DataProcessing.deleteUser(delname);
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
		System.out.println("�������û�Ȩ��");
		String newrole=s.next();
		boolean b=DataProcessing.insertUser(newname, newpassword, newrole);
		System.out.println(b);}catch(SQLException s){
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
