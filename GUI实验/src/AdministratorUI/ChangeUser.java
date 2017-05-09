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

public class ChangeUser extends JFrame implements ActionListener,WindowListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public ChangeUser() {
		getContentPane().setLayout(null);
		setVisible(true);
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(77, 32, 72, 18);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801");
		label_1.setBounds(77, 63, 72, 18);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u65B0\u6743\u9650");
		label_2.setBounds(77, 94, 72, 18);
		getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(163, 29, 166, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 60, 166, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(163, 91, 166, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_1.setBounds(259, 134, 66, 27);
		getContentPane().add(button_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(163, 194, 166, 18);
		getContentPane().add(label_3);
		
		JButton button = new JButton("\u786E\u5B9A");
		
		button.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent arg0) {
				try {
					if(Administrator.changeUser(textField.getText(), textField_1.getText(), textField_2.getText())){
						label_3.setText("更改成功！");
					}
					else label_3.setText("更改失败！");
				} catch (IllegalStateException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(168, 134, 66, 27);
		getContentPane().add(button);
		
		
		setSize(400,400);
	}
	
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			    boolean user;
//				try {
//					if(Administrator.changeUser(textField.getText(),textField_1.getText(),textField_2.getText(),textField_4.getText())){
//						label_3.setText("更改成功！");
//					}
//					else label_3.setText("更改失败！");
//				} catch (IllegalStateException | SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});

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
