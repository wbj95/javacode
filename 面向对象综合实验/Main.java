import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import java.sql.*;
public class Main {
	public static void main(String[] args){
		TextField input;
		
		while(true){
		System.out.println("*************��½����***********");
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
			u1=DataProcessing.searchUser(name1,password1);
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
}