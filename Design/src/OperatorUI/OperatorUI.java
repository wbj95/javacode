package OperatorUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import Main.Browser;
import Main.Operator;
public class OperatorUI extends JFrame implements ActionListener,WindowListener{
	public OperatorUI(){
		super("OperatorUI");
		setVisible(true);
		setSize(400,400);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(54, 299, 240, 18);
		getContentPane().add(label);
		
		JList list = new JList();
		list.setBounds(54, 159, 265, 158);
		getContentPane().add(list);
		
		JButton button = new JButton("\u670D\u52A1\u5668\u6587\u4EF6");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector vt=Operator.serverFile();
				list.setListData(vt);
			}
		});
		button.setBounds(126, 10, 113, 27);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u672C\u5730\u6587\u4EF6");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector vt=new Vector();
				try {
					vt=Operator.localFile();
					list.setListData(vt);
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(126, 48, 113, 27);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u4E0B\u8F7D\u6587\u4EF6");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Operator.downloadFile((String)list.getSelectedValue()))
					label.setText("文件下载成功！");
				else label.setText("文件下载失败！");
			}
		});
		button_2.setBounds(126, 122, 113, 27);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u4E0A\u4F20\u6587\u4EF6");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Operator.uploadFile((String)list.getSelectedValue()))
						label.setText("文件上传成功！");
				else label.setText("文件上传失败！");
			}
		});
		button_3.setBounds(126, 85, 113, 27);
		getContentPane().add(button_3);	
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
