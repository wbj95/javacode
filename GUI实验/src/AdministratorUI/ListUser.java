package AdministratorUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;

import Main.DataProcessing;
import Main.User;

public class ListUser extends JFrame implements ActionListener,WindowListener{
	public ListUser() throws IllegalStateException, SQLException {
		super("ListUser");
		setVisible(true);
		setSize(400,400);
		getContentPane().setLayout(null);
		JList list = new JList();
		list.setBounds(24, 25, 333, 191);
		Enumeration<User> e = DataProcessing.getAllUser();
		User user=null;
		Vector vt=new Vector();
		while(e.hasMoreElements()){
			user=e.nextElement();
			vt.add("用户名："+user.getName()+"  密码："+user.getPassword()+"   用户权限："+user.getRole());
		}
		list.setListData(vt);
		getContentPane().add(list);
	}
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
