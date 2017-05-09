
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
		System.out.print("1.改变用户信息\n"+"2.删除用户\n"+"3.增加用户\n"+"4.列出用户\n"+"5.退出\n");
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
		System.out.println("请输入新的用户名");
		String newname=s.next();
		setName(newname);
		System.out.println("请输入新密码");
		String newpassword=s.next();
		setPassword(newpassword);
		System.out.println("请输入新身份"); 
		String newrole=s.next();
		setRole(newrole);
		
	}
	public void delUser(){
		System.out.println("请输入要删除的用户名");
		String delname=s.next();
		try{
			boolean b=DataProcessing.deleteUser(delname);
		System.out.println(b);
		if(b==true){System.out.println("删除成功");}
		else System.out.println("删除失败");
		}catch(SQLException s){
			System.out.println(s);
			s.printStackTrace();
			}
	}
	public void addUser(){
		try{
		System.out.println("请输入用户名");
		String newname=s.next();
		System.out.println("请输入密码");
		String newpassword=s.next();
		System.out.println("请输入用户权限");
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
			System.out.println("名字:"+user.getName()+" 密码:"+user.getPassword()+" 身份:"+user.getRole());
		}}catch(SQLException s){
			System.out.println(s);
		s.printStackTrace();}
	
	}
}
