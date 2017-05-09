package jk;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
public class Administrator  extends User{
	
		private AdminMenu frmAdminMenu;

		Administrator(String name, String password, String role)
		{
			super(name, password, role);
		}

		public boolean changeUserInfo(String name, String password, String role) throws SQLException
		{
			return (DataProcessing.updateUser(name, password, role));
		}

		public boolean delUser(String name) throws SQLException
		{
			return (DataProcessing.deleteUser(name));
		}

		public boolean addUser(String name, String password, String role) throws SQLException
		{
			return (DataProcessing.insertUser(name, password, role));
		}

		public void listUser() throws SQLException
		{
			Enumeration<User> e = DataProcessing.getAllUser();
			User user;
			while (e.hasMoreElements())
			{
				user = e.nextElement();
				System.out.println(
						"Name:" + user.getName() + "\t Password:" + user.getPassword() + "\t Role:" + user.getRole());
			}
		}

		public void showMenu()
		{
			frmAdminMenu = new AdminMenu("系统管理员菜单");
		}

		class AdminMenu extends JFrame
		{
			private static final long serialVersionUID = 1L;

			JButton btnAdd;
			JButton btnDel;
			JButton btnModi;
			JButton btnPass;
			JButton btnExit;

			JPanel panel;

			public AdminMenu(String strTitle)
			{
				super(strTitle);
				btnAdd = new JButton("增  加  用  户");
				btnDel = new JButton("删  除  用  户");
				btnModi = new JButton("修  改  用  户");
				btnPass = new JButton("列  出  用  户");
				// btnPass = new JButton("修 改 口 令");
				btnExit = new JButton("退  出  系  统");

				panel = new JPanel();
				panel.add(btnAdd);
				panel.add(btnDel);
				panel.add(btnModi);
				panel.add(btnPass);
				panel.add(btnExit);

				btnAdd.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						AdminMenu.this.setVisible(false);
						new AddUser("增加用户");
					}
				});
				
				btnDel.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						AdminMenu.this.setVisible(false);
						new DelUser("删除用户");
					}
					
				});
				
				btnModi.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						AdminMenu.this.setVisible(false);
						new ChangeUser("修改用户");
					}
				});
				
				btnPass.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						AdminMenu.this.setVisible(false);
						new ListUser("列出用户");
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
				this.setSize(400, 200);
				this.setResizable(false);
				this.setLocationRelativeTo(null);
				this.setVisible(true);
			}
		}

		class AddUser extends JFrame
		{
			private static final long serialVersionUID = 1L;

			private JLabel lblUserName;
			private JTextField txtUserName;
			private JLabel lblPassword;
			private JPasswordField txtPassword;
			private JLabel lblRole;
			private JComboBox<String> cbbRole;

			private JButton btnOK;
			private JButton btnCancel;

			private JPanel pnlLogin;

			private JPanel pnlInput;
			private JPanel pnlButton;

			public AddUser(String strTitle)
			{
				super(strTitle);

				String[] strRoles = { "administrator   ", "operator", "browser" };

				lblUserName = new JLabel("用       户:  ");
				lblPassword = new JLabel("口       令:  ");
				lblRole = new JLabel("角       色:  ");

				txtUserName = new JTextField(15);
				txtPassword = new JPasswordField(15);
				cbbRole = new JComboBox<>(strRoles);

				btnOK = new JButton("确定");
				btnCancel = new JButton("取消");

				pnlLogin = new JPanel();
				pnlLogin.setLayout(new BorderLayout());

				pnlInput = new JPanel();

				pnlInput.add(lblUserName);
				pnlInput.add(txtUserName);
				pnlInput.add(lblPassword);
				pnlInput.add(txtPassword);
				pnlInput.add(lblRole);
				pnlInput.add(cbbRole);

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
						String userName = txtUserName.getText().trim();
						String password = new String(txtPassword.getPassword());
						String role = (String) cbbRole.getSelectedItem();

						try
						{
							if (addUser(userName.trim(), password, role.trim()))
								JOptionPane.showMessageDialog(AddUser.this, "新增用户成功", "信息", JOptionPane.PLAIN_MESSAGE);
							else
							{
								JOptionPane.showMessageDialog(AddUser.this, "新增用户失败", "信息", JOptionPane.PLAIN_MESSAGE);
								return;
							}
						} catch (SQLException ex)
						{
							JOptionPane.showMessageDialog(AddUser.this, "数据库错误" + ex.getMessage(), "错误",
									JOptionPane.ERROR_MESSAGE);
						}
						frmAdminMenu.setVisible(true);
						AddUser.this.dispose();

					}
				});

				btnCancel.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						frmAdminMenu.setVisible(true);
						AddUser.this.dispose();
					}
				});

				this.addWindowListener(new WindowAdapter()
				{
					@Override
					public void windowClosing(WindowEvent e)
					{
						frmAdminMenu.setVisible(true);
						AddUser.this.dispose();
					}
				});

				this.getContentPane().add(pnlLogin, BorderLayout.CENTER);
				this.setSize(300, 200);
				this.setResizable(false);
				this.setLocationRelativeTo(null);
				this.setVisible(true);
			}
		}

		class DelUser extends JFrame
		{
			private static final long serialVersionUID = 1L;
			private JLabel User_name;
			private JTextField text_User_name;
			private JButton ok;
			private JButton cancel;
			private JPanel pnlLogin;
			private JPanel pan_input;
			private JPanel pan_btn;
			
			public DelUser (String strTitle){
				
			super(strTitle);
			User_name = new JLabel("用   户:");
			text_User_name = new JTextField(15);
			ok = new JButton("确定");
			cancel = new JButton("取消");
			pan_input = new JPanel();
			pan_btn = new JPanel();
			pnlLogin = new JPanel();
			pnlLogin.setLayout(new BorderLayout());
			
			pan_input.add(User_name);
			pan_input.add(text_User_name);
			
			pan_btn.add(ok);
			pan_btn.add(cancel);
			
			pnlLogin.add(pan_input, BorderLayout.CENTER);
			pnlLogin.add(pan_btn, BorderLayout.SOUTH);
			
			ok.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					String userName = text_User_name.getText().trim();

					try
					{
						if (delUser(userName.trim()))
							JOptionPane.showMessageDialog(DelUser.this, "删除用户成功", "信息", JOptionPane.PLAIN_MESSAGE);
						else
						{
							JOptionPane.showMessageDialog(DelUser.this, "删除用户失败", "信息", JOptionPane.PLAIN_MESSAGE);
							return;
						}
					} catch (SQLException ex)
					{
						JOptionPane.showMessageDialog(DelUser.this, "数据库错误" + ex.getMessage(), "错误",
								JOptionPane.ERROR_MESSAGE);
					}
					frmAdminMenu.setVisible(true);
					DelUser.this.dispose();

				}
			});
			
			cancel.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					frmAdminMenu.setVisible(true);
					DelUser.this.dispose();
				}
			});

			this.addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e)
				{
					frmAdminMenu.setVisible(true);
					DelUser.this.dispose();
				}
			});
			this.getContentPane().add(pnlLogin, BorderLayout.CENTER);
			this.setSize(300, 200);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			}
		}
		
		class ChangeUser extends JFrame
		{
			private JLabel lblUserName;
			private JTextField txtUserName;
			private JLabel lblPassword;
			private JPasswordField txtPassword;
			private JLabel lblRole;
			private JComboBox<String> cbbRole;
			
			private JButton btnOK;
			private JButton btnCancel;

			private JPanel pnlLogin;

			private JPanel pnlInput;
			private JPanel pnlButton;

			public ChangeUser(String strTitle){
				super(strTitle);
				String[] strRoles = { "administrator   ", "operator", "browser" };

				lblUserName = new JLabel("用       户:  ");
				lblPassword = new JLabel("口       令:  ");
				lblRole = new JLabel("角       色:  ");

				txtUserName = new JTextField(15);
				txtPassword = new JPasswordField(15);
				cbbRole = new JComboBox<>(strRoles);

				btnOK = new JButton("确定");
				btnCancel = new JButton("取消");

				pnlLogin = new JPanel();
				pnlLogin.setLayout(new BorderLayout());

				pnlInput = new JPanel();

				pnlInput.add(lblUserName);
				pnlInput.add(txtUserName);
				pnlInput.add(lblPassword);
				pnlInput.add(txtPassword);
				pnlInput.add(lblRole);
				pnlInput.add(cbbRole);

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
						String userName = txtUserName.getText().trim();
						String password = new String(txtPassword.getPassword());
						String role = (String) cbbRole.getSelectedItem();

						try
						{
							if (changeUserInfo(userName.trim(), password, role.trim()))
								JOptionPane.showMessageDialog(ChangeUser.this, "修改用户成功", "信息", JOptionPane.PLAIN_MESSAGE);
							else
							{
								JOptionPane.showMessageDialog(ChangeUser.this, "修改用户失败", "信息", JOptionPane.PLAIN_MESSAGE);
								return;
							}
						} catch (SQLException ex)
						{
							JOptionPane.showMessageDialog(ChangeUser.this, "数据库错误" + ex.getMessage(), "错误",
									JOptionPane.ERROR_MESSAGE);
						}
						frmAdminMenu.setVisible(true);
						ChangeUser.this.dispose();

					}
				});

				btnCancel.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						frmAdminMenu.setVisible(true);
						ChangeUser.this.dispose();
					}
				});

				this.addWindowListener(new WindowAdapter()
				{
					@Override
					public void windowClosing(WindowEvent e)
					{
						frmAdminMenu.setVisible(true);
						ChangeUser.this.dispose();
					}
				});

				this.getContentPane().add(pnlLogin, BorderLayout.CENTER);
				this.setSize(300, 200);
				this.setResizable(false);
				this.setLocationRelativeTo(null);
				this.setVisible(true);
			}
		}
		
		class ListUser extends JFrame
		{
			private static final long serialVersionUID = 1L;
			private JTextArea txtAreaUserList;
			private JScrollPane sPanelUserList;
			private JButton btnExit;

			private JPanel panelUserList;

			public ListUser(String strTitle)
			{
				super(strTitle);

				txtAreaUserList = new JTextArea(12, 25);
				txtAreaUserList.setEditable(false);
				sPanelUserList = new JScrollPane();
				sPanelUserList.setViewportView(txtAreaUserList);

				btnExit = new JButton("返回");

				String alluser = "";

				Enumeration<User> users;
				try
				{
					users = DataProcessing.getAllUser();
					User user;


					while (users.hasMoreElements())
					{
						user = users.nextElement();
						alluser = alluser + "Name:" + user.getName() + "\t Password:" + user.getPassword() + "\t Role:"
								+ user.getRole() + "\n";
					}
				} catch (IllegalStateException e)
				{
					e.printStackTrace();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}

				txtAreaUserList.setText(alluser);

				panelUserList = new JPanel();
				panelUserList.setBorder(BorderFactory.createTitledBorder("用户列表信息"));
				panelUserList.add(sPanelUserList);

				btnExit.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						frmAdminMenu.setVisible(true);
						ListUser.this.dispose();
					}
				});

				this.addWindowListener(new WindowAdapter()
				{
					@Override
					public void windowClosing(WindowEvent e)
					{
						frmAdminMenu.setVisible(true);
						ListUser.this.dispose();
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
