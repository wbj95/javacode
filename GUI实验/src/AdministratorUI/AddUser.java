package AdministratorUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Main.Administrator;

public class AddUser extends JFrame implements ActionListener,WindowListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public AddUser(){
		super("AddUser");
		setVisible(true);
		setSize(400,400);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(52, 25, 45, 18);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(111, 22, 159, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6 \u7801");
		label_1.setBounds(52, 67, 45, 18);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 64, 159, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6743 \u9650");
		label_2.setBounds(52, 108, 72, 18);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(284, 108, 72, 18);
		getContentPane().add(label_3);
		JButton button = new JButton("\u786E \u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String password=textField_1.getText();
				String role=textField_2.getText();
				try {
					if(Administrator.addUser(name, password, role))
						label_3.setText("添加成功！");
					else label_3.setText("添加失败！");
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(135, 167, 113, 27);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(135, 215, 113, 27);
		getContentPane().add(button_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 105, 159, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);	
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
