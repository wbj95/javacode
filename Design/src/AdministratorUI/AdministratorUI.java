package AdministratorUI;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
public class AdministratorUI extends JFrame implements ActionListener,WindowListener{
	public AdministratorUI() {
		super("AdministratorUI");
		setVisible(true);
		setSize(400,400);
		getContentPane().setLayout(null);
		
		JButton button = new JButton("\u589E\u52A0\u7528\u6237");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddUser();
			}
		});
		button.setBounds(131, 13, 93, 27);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u5220\u9664\u7528\u6237");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteUser();
			}
		});
		button_1.setBounds(131, 53, 93, 27);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u66F4\u6539\u7528\u6237");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangeUser();
			}
		});
		button_2.setBounds(131, 93, 93, 27);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u5217\u51FA\u7528\u6237");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ListUser();
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(131, 133, 93, 27);
		getContentPane().add(button_3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
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
}
