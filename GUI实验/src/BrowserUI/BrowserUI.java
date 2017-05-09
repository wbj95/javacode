package BrowserUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import Main.Browser;
public class BrowserUI extends JFrame implements ActionListener,WindowListener{
	public BrowserUI(){
		super("BrowserUI");
		setVisible(true);
		setSize(400,400);
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(104, 155, 174, 151);
		getContentPane().add(list);
		
		JLabel label = new JLabel("");
		label.setBounds(104, 319, 174, 18);
		getContentPane().add(label);
		
		JButton button = new JButton("\u6240\u6709\u6587\u4EF6");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector vt=new Vector();
				try {
					vt=Browser.serverFile();
					list.setListData(vt);
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(128, 36, 113, 27);
		getContentPane().add(button);
		
		JButton button_2 = new JButton("\u6587\u4EF6\u4E0B\u8F7D");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=(String) list.getSelectedValue();
				if((Browser.downloadFile(str)))
					label.setText("下载成功！");
				else label.setText("下载失败！");
			}
		});
		button_2.setBounds(128, 80, 113, 27);
		getContentPane().add(button_2);
	}
	
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
