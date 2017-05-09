package Main;
import java.sql.SQLException;

public class User{
    private String name=new String();
	private String password=new String();
	private String role;
	public void showMenu()throws IllegalStateException, SQLException{;}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setRole(String role){
		this.role=role;
	}
	public String getRole(){
		return (String)role;
	}
}