package jk;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
public class Login extends JFrame{
	private static final ActionListener ActionListenler = null;
	private Box box0 = Box.createHorizontalBox();
	private Box box1 = Box.createHorizontalBox();
	private Box box2 = Box.createHorizontalBox();
	private Box box3 = Box.createHorizontalBox();
	private Box box4 = Box.createVerticalBox();
	
	private JLabel top = new JLabel("**欢迎进入主菜单**");
	private JLabel luser = new JLabel("用户名 :");
	private JLabel lpwd = new JLabel("密   码 : ");
	private JTextField juser = new JTextField(20);
	private JPasswordField jpwd = new JPasswordField(25);
	private JButton ok = new JButton("登录");
	private JButton cancel = new JButton("取消");
	
	public void init(){
		this.setResizable(false);
		
		box0.add(top);
		box1.add(Box.createHorizontalStrut(40));
		box1.add(luser);
		box1.add(juser);
		box1.add(Box.createHorizontalStrut(60));
		
		box2.add(Box.createHorizontalStrut(40));
		box2.add(lpwd);
		box2.add(jpwd);
		box2.add(Box.createHorizontalStrut(60));
		
		box3.add(Box.createHorizontalStrut(40));
		box3.add(ok);
		box3.add(Box.createHorizontalStrut(60));
		box3.add(cancel);
		box3.add(Box.createHorizontalStrut(60));
		
		box4.add(box0);
		box4.add(Box.createVerticalStrut(30));
		box4.add(box1);
		box4.add(Box.createVerticalStrut(30));
		box4.add(box2);
		box4.add(Box.createVerticalStrut(30));
		box4.add(box3);
		box4.add(Box.createVerticalStrut(40));
		getContentPane().add(box4);
	}	
	public  Login(){
		super("Login");
		this.setSize(400,300);
		this.setLocation(200,200);
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim  = tool.getScreenSize();
		int width = (int) dim.getWidth();
		int height = (int) dim.getHeight();
		this.setLocation((width - 400)/2 , (height - 300)/2);
		init();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = juser.getText();
				String pwd =new String(jpwd.getPassword());
				
				if(null != name && null != pwd ){
					User temp = null;
					try {
						temp = DataProcessing.searchUser(name,pwd);
					} catch (IllegalStateException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Administrator ad = new Administrator(null,null,null);
					Browser bw = new Browser(null,null,null);
					Operator op = new Operator(null,null,null);
					if(temp != null){
						if(temp.getRole() == "administrator"){
							ad.showMenu();
							Login.this.dispose();
						}
						if(temp.getRole() == "browser"){
							bw.showMenu();
							Login.this.dispose();
						}
						if(temp.getRole()== "operator"){
							try {
								op.showMenu();
							} catch (SQLException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Login.this.dispose();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "用户名或密码不正确");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "请正确输入用户名和密码");
				}
			}
			
		});
	}
	public static void main(String[] args) throws IllegalStateException, SQLException, IOException {
		new Login();
	}
}
