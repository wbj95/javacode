package jk;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Operator extends User{
	Operator(String name, String password, String role) {
		super(name, password, role);
	}
	private OperatorMenu frmAdminMenu;
	static String uploadpath="D:\\upload";
	
	public boolean downloadDoc (String name) throws SQLException, IOException
	{
		return (User.downloadFile(name));
	}
	
	public boolean uploadDoc (String ID, String creator, Timestamp timestamp, String description, String filename) throws IllegalStateException, SQLException
	{
		return (DataProcessing.insertDoc(ID, creator, timestamp, description, filename));
	}
	
	public void ListDoc() throws SQLException
	{
		Enumeration<Doc> e = DataProcessing.getAllDocs();
		Doc doc;
		while (e.hasMoreElements())
		{
			doc = e.nextElement();
			System.out.println(
					"ID:" + doc.getID() + "\t creator:" + doc.getCreator() + "\t timestamp:" + doc.getTimestamp()
					+"\t description" + doc.getDescription()+"\t filename" + doc.getFilename());
		}
	}
	@Override
	public void showMenu() throws SQLException, IOException {
		frmAdminMenu = new OperatorMenu("欢迎进入Operator的主菜单");
	}
	
	class OperatorMenu extends JFrame{
		private static final long serialVersionUID = 1L;

		JButton btnupl;
		JButton btndownl;
		JButton btnlist;
		JButton btnExit;

		JPanel panel;

		public OperatorMenu(String temp){
			super (temp);
			btnupl = new JButton("上传文件");
			btndownl = new JButton("下载文件");
			btnlist = new JButton("列出文件");
			btnExit = new JButton("退出系统");
			panel = new JPanel();
			
			panel.add(btnupl);
			panel.add(btndownl);
			panel.add(btnlist);
			panel.add(btnExit);
			
			btndownl.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					OperatorMenu.this.setVisible(false);
					new downloadDoc ("下载文件");
				}
			});
			btnupl.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent arg0) {
							OperatorMenu.this.setVisible(false);
							new uploadDoc ("上传文件");
						}
				
					});
			
			btnlist.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent arg0) {
				OperatorMenu.this.setVisible(false);
				new ListDoc("查看所有的文件");	
				}
			});
			
			btnExit.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
			
			this.getContentPane().add(panel, BorderLayout.CENTER);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(400, 150);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
	}
	
	class uploadDoc extends JFrame{

		private static final long serialVersionUID = 1L;

		private JLabel lblDocId;
		private JTextField txtDocId;
		private JLabel lblCreator;
		private JTextField txtCreator;
		private JLabel lblFilenameAge;
		private JTextField textFilenameAge;
		private JLabel lblDescription;
		private JTextField textDescription;


		private JButton btnOK;
		private JButton btnCancel;

		private JPanel pnlLogin;

		private JPanel pnlInput;
		private JPanel pnlButton;

		public uploadDoc(String strTitle)
		{
			super(strTitle);

			lblDocId = new JLabel("ID:  ");
			lblCreator = new JLabel("creator:  ");
			lblFilenameAge = new JLabel("FilenameAge:  ");
			lblDescription = new JLabel ("Description:  ");

			txtDocId = new JTextField(15);
			txtCreator = new JTextField(15);
			textFilenameAge = new JTextField(15);
			textDescription = new JTextField(15);

			btnOK = new JButton("确定");
			btnCancel = new JButton("取消");

			pnlLogin = new JPanel();
			pnlLogin.setLayout(new BorderLayout());

			pnlInput = new JPanel();

			pnlInput.add(lblDocId);
			pnlInput.add(txtDocId);
			pnlInput.add(lblCreator);
			pnlInput.add(txtCreator);
			pnlInput.add(lblFilenameAge);
			pnlInput.add(textFilenameAge);
			pnlInput.add(lblDescription);
			pnlInput.add(textDescription);

			pnlLogin.add(pnlInput, BorderLayout.CENTER);

			pnlButton = new JPanel();
			pnlButton.add(btnOK);
			pnlButton.add(btnCancel);
			pnlLogin.add(pnlButton, BorderLayout.SOUTH);

			btnOK.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					String DocId = txtDocId.getText().trim();
					String DocCret = txtCreator.getText().trim();
					String DocName =  textFilenameAge.getText().trim();
					String DocDes = textDescription.getText().trim();
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());

					try
					{
						if (uploadDoc(DocId.trim(),DocCret.trim(),timestamp,DocDes.trim(),DocName.trim()))
							JOptionPane.showMessageDialog(uploadDoc.this, "上传文件成功", "信息", JOptionPane.PLAIN_MESSAGE);
						else
						{
							JOptionPane.showMessageDialog(uploadDoc.this, "上传文件失败", "信息", JOptionPane.PLAIN_MESSAGE);
							return;
						}
					} catch (SQLException ex)
					{
						JOptionPane.showMessageDialog(uploadDoc.this, "数据库错误" + ex.getMessage(), "错误",
								JOptionPane.ERROR_MESSAGE);
					}
					frmAdminMenu.setVisible(true);
					uploadDoc.this.dispose();

				}
			});

			btnCancel.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					frmAdminMenu.setVisible(true);
					uploadDoc.this.dispose();
				}
			});

			this.addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e)
				{
					frmAdminMenu.setVisible(true);
					uploadDoc.this.dispose();
				}
			});

			this.getContentPane().add(pnlLogin, BorderLayout.CENTER);
			this.setSize(200, 300);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
	
	}
	
	class downloadDoc extends JFrame{
		JLabel Doc_name;
		JTextField Text_Doc_name;
		
		JPanel pnl_input;
		JPanel pnlLogin;
		JPanel pnl_btn;
		
		JButton ok;
		JButton cancel;
		
		public downloadDoc (String temp){
			super(temp);
			
			Doc_name = new JLabel();
			Text_Doc_name = new JTextField(15);
			
			pnl_input = new JPanel();
			pnl_btn = new JPanel();
			pnlLogin = new JPanel();
			
			ok = new JButton("确定");
			cancel = new JButton("取消");
			
			pnl_input.add(Doc_name);
			pnl_input.add(Text_Doc_name);
			
			pnl_btn.add(ok);
			pnl_btn.add(cancel);
			
			pnlLogin.add(pnl_input, BorderLayout.CENTER);
			pnlLogin.add(pnl_btn, BorderLayout.SOUTH);
			
			ok.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent arg0) {
							String userName = Text_Doc_name.getText().trim();

							try
							{
								if (downloadDoc(userName.trim()))
									JOptionPane.showMessageDialog(downloadDoc.this, "上传文件成功", "信息", JOptionPane.PLAIN_MESSAGE);
								else
								{
									JOptionPane.showMessageDialog(downloadDoc.this, "上传文件失败", "信息", JOptionPane.PLAIN_MESSAGE);
									return;
								}
							} catch (SQLException ex)
							{
								JOptionPane.showMessageDialog(downloadDoc.this, "数据库错误" + ex.getMessage(), "错误",
										JOptionPane.ERROR_MESSAGE);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							frmAdminMenu.setVisible(true);
							downloadDoc.this.dispose();

						}
					});
			
				cancel.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						frmAdminMenu.setVisible(true);
						downloadDoc .this.dispose();
					}
				});
	
				this.addWindowListener(new WindowAdapter()
				{
					@Override
					public void windowClosing(WindowEvent e)
					{
						frmAdminMenu.setVisible(true);
						downloadDoc .this.dispose();
					}
				});
	
				this.getContentPane().add(pnlLogin, BorderLayout.CENTER);
				this.setSize(300, 200);
				this.setResizable(false);
				this.setLocationRelativeTo(null);
				this.setVisible(true);
			}
		}
		
		class ListDoc extends JFrame
		{
			 JTextArea txtAreaUserList;
			 JScrollPane sPanelUserList;
			 JButton btnExit;

			 JPanel panelUserList;
			
			public ListDoc (String temp){
				super(temp);

				txtAreaUserList = new JTextArea(12, 25);
				txtAreaUserList.setEditable(false);
				sPanelUserList = new JScrollPane();
				sPanelUserList.setViewportView(txtAreaUserList);

				btnExit = new JButton("返回");

				String allDoc = "";

				Enumeration<Doc> docs;
				try
				{
					docs = DataProcessing.getAllDocs();
					Doc doc;


					while (docs .hasMoreElements())
					{
						doc = docs .nextElement();
						allDoc = allDoc + "ID:" + doc.getID() + "\t creator:" + doc.getCreator() + "\t timestamp:" + doc.getTimestamp()
						+"\t description" + doc.getDescription()+"\t filename" + doc.getFilename()+ "\n";
					}
				} catch (IllegalStateException e)
				{
					e.printStackTrace();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}

				txtAreaUserList.setText(allDoc);

				panelUserList = new JPanel();
				panelUserList.setBorder(BorderFactory.createTitledBorder("文件列表信息"));
				panelUserList.add(sPanelUserList);

				btnExit.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						frmAdminMenu.setVisible(true);
						ListDoc.this.dispose();
					}
				});

				this.addWindowListener(new WindowAdapter()
				{
					@Override
					public void windowClosing(WindowEvent e)
					{
						frmAdminMenu.setVisible(true);
						ListDoc.this.dispose();
					}
				});
				this.getContentPane().add(panelUserList, BorderLayout.CENTER);
				this.getContentPane().add(btnExit, BorderLayout.SOUTH);
				this.setSize(320, 320);
				this.setResizable(false);
				this.setLocationRelativeTo(null);
				this.setVisible(true);

			
			}
			
		}
}
