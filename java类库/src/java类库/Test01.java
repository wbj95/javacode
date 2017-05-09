package java类库;
import java.util.Hashtable;
import java.util.*;
public class Test01{
	static Hashtable<String, User> users;

	static {
		users = new Hashtable<String, User>();
		users.put("jack", new Operator("jack","123","operator"));
		users.put("rose", new Browser("rose","123","browser"));
		users.put("kate", new Administrator("kate","123","administrator"));		
	}
	
	public static User search(String name, String password){
		if (users.containsKey(name)) {
			User temp =users.get(name);
			if ((temp.getPassword()).equals(password))
				return temp;
		}
		return null;
	}
	
	public static boolean update(String name, String password, String role){
		User user;
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
	
	public static boolean insert(String name, String password, String role){
		User user;
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
	
	public static boolean delete(String name){
				
		if (users.containsKey(name)){
			users.remove(name);
			return true;
		}else
			return false;
		
	}	
	
	public static void main(String[] args) {
		
		User u=new User();
		u.showMenu();
		Scanner s=new Scanner(System.in);
		String name1,password1;
		int num1=s.nextInt();
		if(num1==1){
			System.out.println("请输入用户名：");
			name1=s.next();
			System.out.println("请输密码：");
			password1=s.next();
			if(name1!=null&&password1!=null){
			User u1=null;
			u1=search(name1,password1);
			
			}
		}else if(num1==2){System.out.println("退出系统");}
		else{System.out.println("输入密码错误");}
	}
	
}
 class User{
	private String name, password, role;
	public void showMenu(){
		System.out.println("*************欢迎登陆界面***********");
		System.out.println("            1.登陆");
		System.out.println("            2.退出");
		System.out.println("********************************");
	}
	User(){}
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
class Administrator extends User{
	private String name, password,role;
	Administrator(){}
	Administrator(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;
	}

	public void changeUserInfo(String name,int password,String role){
		
	}
	public void delUser(String name){
		
	}
	public void addUser(String name,String password,String role){
		
	}
	public void listUser(){
		
	}
	public void showMenu(){
		System.out.println("*************欢迎登陆界面***********");
		System.out.println("          1.登陆");
		System.out.println("          2.退出");
		System.out.println("********************************");
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
}
class Operator extends User{
	private String name, password, role;
	Operator(){}
	Operator(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;
	}
	public void uploadFile(){
		System.out.println("上传文件");
	}
	public void downloadFile(){
		System.out.println("下载文件");
	}
	public void showFileList(){
		
	}
	public void showMune(){
		System.out.println("*************欢迎登陆界面***********");
		System.out.println("          1.登陆");
		System.out.println("          2.退出");
		System.out.println("********************************");
	}
}
class Browser extends User{
	private String name, password, role;
	Browser(){}
	Browser(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;
	}
	public void downloadFile(){
		
	}
     public void showloadFile(){
		
	}
     public void showMune(){
    	 System.out.println("*************欢迎登陆界面***********");
 		System.out.println("          1.登陆");
 		System.out.println("          2.退出");
 		System.out.println("********************************");
     }
}
