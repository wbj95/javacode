package ≤‚ ‘;

import java.awt.*;
import java.awt.event.*;
class dlg extends Frame{
	Frame fe;
	Button bt1 = new Button("Quit Main Frame");
	Button bt2 = new Button("Open File");
	public dlg(String str){
		super(str);
		setLayout(new FlowLayout());
		setSize(200,180);
		add(bt1);
		add(bt2);
		setVisible(true);
		bt1.addActionListener(new koActionListener());
		bt2.addActionListener(new koActionListener());
	}
	class koActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			fe = new Frame();
			if(e.getSource() == bt1){
				System.exit(0);
			}
			if(e.getSource() == bt2){
				FileDialog fd1 = new FileDialog(fe,"Open File",FileDialog.LOAD);
				fd1.show();
				fd1.setVisible(true);
				System.out.println(fd1);
				System.out.println(fd1.getFile());
			}
		}
	}
}
class MyFileDialog{
	public static void main(String[] args){
		Frame fe = new dlg("MyFileDialogDemo");
	}
}
