package Main;

import java.sql.SQLException;
import java.util.Enumeration;

import AdministratorUI.AdministratorUI;

public class Administrator extends User{
	Administrator(String name,String password,String role){
		setName(name);
		setPassword(password);
		setRole(role);
	}
	public static boolean changeUser(String name,String newpassword,String newrole) throws IllegalStateException, SQLException{//更改别人的名字
		if(DataProcessing.updateUser(name, newpassword, newrole)==true) {
			return true;
		}
		return false;
	}
	public static boolean deleteUser(String name) throws IllegalStateException, SQLException{
		if(DataProcessing.deleteUser(name)==true) return true;
		return false;
	}
	public static boolean addUser(String name,String password,String role) throws IllegalStateException, SQLException{
		if(DataProcessing.insertUser(name,password,role)) return true;
		return false;
	}
	static User getUser(String name) throws IllegalStateException, SQLException{
		if (DataProcessing.users.containsKey(name)) {
			User temp =DataProcessing.users.get(name);
			return temp;
		}
		return null;
	}
	void listUser() throws IllegalStateException, SQLException{
		Enumeration<User> e = DataProcessing.getAllUser();
		User user;
		while(e.hasMoreElements()){
			user=e.nextElement();
			System.out.println("Name:"+user.getName()+" password:"+user.getPassword()+" role:"+user.getRole());
		}
	}
	public void showMenu() throws IllegalStateException, SQLException{
		new AdministratorUI();
	}
}
