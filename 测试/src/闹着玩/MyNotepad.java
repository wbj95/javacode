package 闹着玩;

import java.awt.*;

import javax.swing.* ;

import java.awt.event.* ;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.undo.*;
public class MyNotepad extends JFrame{
	
	//文件的标题
	private String title = "无标题" ;
	//菜单栏
	private JPanel mp = new JPanel() ;
	private JMenuBar mb = new JMenuBar() ;
	private JMenu
		file = new JMenu("文件(F)"),
		edit = new JMenu("编辑(E)"),
		format = new JMenu("格式(V)"),
		view = new JMenu("查看(O)"),
		help = new JMenu("帮助(H)");
	//文件
	private JMenuItem 
		newFile = new JMenuItem("新建(N)") ,
		open = new JMenuItem("打开(O)") ,
		save = new JMenuItem("保存(S)") ,
		exit = new JMenuItem("退出(X)") ;
	//编辑
	private JMenuItem 
		undo = new JMenuItem("撤销(U)") ,
		cut = new JMenuItem("剪切(T)") ,
		copy = new JMenuItem("复制(C)") ,
		paste = new JMenuItem("粘贴(P)") ,
		delete = new JMenuItem("删除(L)") ,
		find = new JMenuItem("查找(F)") ,
		replace = new JMenuItem("替换(R)") ,
		goTo = new JMenuItem("转到(G)") ,
		selectAll = new JMenuItem("全选(A)") ,
		time = new JMenuItem("时间/日期(D)") ;
	//格式
	private JMenuItem font = new JMenuItem("字体(F)") ;
	private JCheckBox autoLineWrap = new JCheckBox("自动换行(W)") ;
	//查看
	private JMenuItem state = new JMenuItem("状态(S)") ;
	//帮助
	private JMenuItem
		checkHelp = new JMenuItem("查看帮助(H)") ,
		about = new JMenuItem("关于记事本(A)") ;
	//文本域
	private JTextArea txt = new JTextArea() ;
	//弹出菜单
	private JPopupMenu jpm = new JPopupMenu() ;
	//定义弹出窗口的打开状态
	private static boolean isOpen = false ;
	//获取屏幕的尺寸
	private int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
	private int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() ;
	public MyNotepad(){
		//新建
		newFile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text = txt.getText() ;
				if(!text.equals("")){
					String str[] = text.split("\n") ;
					int result = JOptionPane.showConfirmDialog(null, "是否将更改保存到 "+
					title+"?", "记事本",  JOptionPane.YES_NO_CANCEL_OPTION) ;
					if(result == JOptionPane.NO_OPTION){		//不保存
						txt.setText("");
					}else if(result == JOptionPane.CANCEL_OPTION){}		//取消保存
					else if(result == 0){			//保存
						JFileChooser jfc = new JFileChooser() ;
						jfc.setDialogTitle("保存");
						int ssd = jfc.showSaveDialog(MyNotepad.this) ;
						if(ssd == jfc.APPROVE_OPTION){
							File file = jfc.getSelectedFile() ;
							PrintStream out = null ;
							try {
								out = new PrintStream(new FileOutputStream(file)) ;
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for(String s:str){
								out.print(s + "\r\n");
							}
							out.close();
							txt.setText(""); ;
						}
					}
				}
			}
		});
		//打开
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser jfc = new JFileChooser() ;
				jfc.setDialogTitle("打开");
				int result = jfc.showOpenDialog(MyNotepad.this) ;
				if(result == JFileChooser.CANCEL_OPTION){}
				else if(result == JFileChooser.APPROVE_OPTION){
					File file = jfc.getSelectedFile() ;
					BufferedReader input = null ;
					try {
						input = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String temp = null ;
					try {
						while((temp = input.readLine())!=null){
							txt.append(temp +"\n");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						input.close() ;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} 
		});
		//保存
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String str[] = txt.getText().split("\n") ;
				JFileChooser jfc = new JFileChooser() ;
				jfc.setDialogTitle("保存");
				int ssd = jfc.showSaveDialog(MyNotepad.this) ;
				if(ssd == jfc.APPROVE_OPTION){
					File file = jfc.getSelectedFile() ;
					PrintStream out = null ;
					try {
						out = new PrintStream(new FileOutputStream(file)) ;
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for(String s:str){
						out.print(s + "\r\n");
					}
					out.close();
				}
			}
		});
		//退出
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = txt.getText() ;
				if(!str.equals("")){
					int result = JOptionPane.showConfirmDialog(null, "退出前是否保存？", "退出", 
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) ;
					if(result == JOptionPane.YES_OPTION){}
					if(result == JOptionPane.NO_OPTION){
						dispose() ;
					}
					if(result == JOptionPane.CANCEL_OPTION){}
				}else{
					dispose() ;
				}
			}
		});
		/*
		 * 撤销功能
		 */
		final UndoManager undom = new UndoManager() ;
		txt.getDocument().addUndoableEditListener(new UndoableEditListener(){
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				undom.addEdit(e.getEdit()) ;
				}
			});
		undo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(undom.canUndo()){
					undom.undo();
				}
			}
		});
		//剪切
		cut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txt.cut() ;
			}
		});
		//粘贴
		paste.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txt.paste();
			}
		});
		//删除
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int start = txt.getSelectionStart() ;
				int end = txt.getSelectionEnd() ;
				txt.replaceRange("", start, end);
			}
		});
		/*
		 * 为了更好地访问本类中的属性，所以查找使用内部类
		 */
		//定义查找内部类
		
		class FindDialog extends JDialog{
		    private JPanel pan = new JPanel() ;
			private JLabel label = new JLabel("查找内容(N):") ;
			private JTextField txtf = new JTextField(20) ;
			private JButton btnf = new JButton("查找下一个(F)") ;
			private JButton btnc = new JButton("取消") ;
			private JCheckBox jcb = new JCheckBox("区分大小写(C)") ;
			private JRadioButton jrb1 = new JRadioButton("向上(U)") ;
			private JRadioButton jrb2 = new JRadioButton("向下(D)",true) ;
			public FindDialog(){
				super(MyNotepad.this, "查找") ;
				//当文本框中有内容时按钮才起作用
				txtf.getDocument().addDocumentListener(new DocumentListener(){

					@Override
					public void insertUpdate(DocumentEvent e) {
							btnf.setEnabled(true);
					}
					@Override
					public void removeUpdate(DocumentEvent e) {
						if(txtf.getText().length() == 0){
							btnf.setEnabled(false);
						}
					}
					@Override
					public void changedUpdate(DocumentEvent e) {
					}
				});
				btnf.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String str = txtf.getText() ;
						String texta = txt.getText() ;
						int start = 0 ;				
						int end = 0 ;
						int caretPosition = txt.getCaretPosition() ;			//记录光标的起始位置
						if(jcb.isSelected()){		//区分大小写
							if(jrb2.isSelected()){		//向下查询,如果有光标就从光标的位置开始查找，否则就从选中的文本之后的位置开始查找
								start = (txt.getSelectedText()==null ? caretPosition : txt.getSelectionEnd()) ;
								start = texta.indexOf(str, start) ;
								if(start == -1){			//如果没有找到
									JOptionPane.showMessageDialog(null, "找不到"+str);
								}else{		//如果找到了
									end = start + str.length() ;
									txt.select(start, end);
								}
							}else if(jrb1.isSelected()){	//向上查询,如果有光标就从光标的位置开始查找，否则就从选中的文本之前的位置开始查找
								end = (txt.getSelectedText()==null ? caretPosition : txt.getSelectionStart()) ;
								String subtext = texta.substring(0, end) ;
								start = subtext.lastIndexOf(str, end-1) ;
								if(start == -1){
									JOptionPane.showMessageDialog(null, "找不到"+str) ;
								}else{
									end = start + str.length()  ;
									txt.select(start, end);
								}
							}
						}
						if(!jcb.isSelected()){		//不区分大小写
							texta = texta.toLowerCase() ;
							if(jrb2.isSelected()){		//向下查询,如果有光标就从光标的位置开始查找，否则就从选中的文本之后的位置开始查找
								start = (txt.getSelectedText()==null ? caretPosition : txt.getSelectionEnd()) ;
								start = texta.indexOf(str.toLowerCase(), start) ;
								if(start == -1){			//如果没有找到
									JOptionPane.showMessageDialog(null, "找不到"+str) ;
								}else{		//如果找到了
									end = start + str.length() ;
									txt.select(start, end);
								}
							}else if(jrb1.isSelected()){	//向上查询,如果有光标就从光标的位置开始查找，否则就从选中的文本之前的位置开始查找
								end = (txt.getSelectedText() == null ? caretPosition : txt.getSelectionStart()) ;
								String subtext = texta.substring(0, end) ;
								start = subtext.lastIndexOf(str.toLowerCase(), end-1) ;
								if(start == -1){
									JOptionPane.showMessageDialog(null, "找不到"+str) ;
								}else{
									end = start + str.length() ;
									txt.select(start, end);
								}
							}
						}
					}
				});
				btnc.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose() ;
						isOpen = false ;
					}
				});
				
				this.setLayout(null) ;
				label.setBounds(12,10,80,20) ;
				txtf.setBounds(100,10,170,20) ;
				btnf.setBounds(280,10,90,20) ;
				btnf.setMargin(new Insets(0, 0,0, 0)) ;
				btnf.setEnabled(false);					//初始化查找下一个按钮不可选
				jcb.setBounds(12,70,110,20) ;
				jrb1.setMargin(new Insets(0,0,0,0)) ;
				jrb2.setMargin(new Insets(0,0,0,0)) ;
				ButtonGroup group = new ButtonGroup() ;
				group.add(jrb1);
				group.add(jrb2);
				pan.add(jrb1) ;
				pan.add(jrb2) ;
				pan.setBorder(BorderFactory.createTitledBorder("方向")) ;
				pan.setBounds(120,40,150,55) ;
				btnc.setBounds(280,40,90,20) ;
				btnc.setMargin(new Insets(0,0,0,0)) ;
				add(btnf) ;
				add(label) ;
				add(txtf) ;
				add(jcb) ;
				add(pan) ;
				add(btnc) ;
				setSize(380,130) ;
				setLocation(x/2-190,y/2-65) ;
				setResizable(false) ;
				setVisible(true) ;
				setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;
				//每次只能显示一个窗口
				addWindowListener(new WindowAdapter(){
					public void windowOpened(WindowEvent e){
						isOpen = true ;
					}
				}) ;
				addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						isOpen = false ;
					}
				}) ;
			}
		}
		//查找的监听事件
		find.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!isOpen){
					new FindDialog() ;
				}
			}
		});
		
		
		//替换内部类
		class ReplaceDialog extends JDialog{
			private JLabel label1 = new JLabel("查找内容(N)") ;
			private JLabel label2 = new JLabel("替换为(P)") ;
			private JTextField field1 = new JTextField(20) ;
			private JTextField field2 = new JTextField(20) ;
			private JButton find = new JButton("查找下一个(F)") ;
			private JButton replace = new JButton("替换(R)") ;
			private JButton replaceAll = new JButton("全部替换(A)") ;
			private JButton canc = new JButton("取消") ;
			private JCheckBox jcb = new JCheckBox("区分大小写(C)") ;
			public ReplaceDialog(){
				super(MyNotepad.this,"查找") ;
				this.setLayout(null) ;
				label1.setBounds(12,5,80,20) ;
				label2.setBounds(12,30,80,20) ;
				field1.setBounds(100,5,170,20) ;
				field2.setBounds(100,30,170,20) ;
				find.setBounds(280,5,90,20) ;
				find.setMargin(new Insets(0, 0,0, 0)) ;
				replace.setBounds(280,30,90,20) ;
				replace.setMargin(new Insets(0,0,0,0)) ;
				replaceAll.setBounds(280,55,90,20) ;
				replaceAll.setMargin(new Insets(0,0,0,0)) ;
				jcb.setBounds(12,70,105,20) ;
				jcb.setMargin(new Insets(0,0,0,0)) ;
				canc.setBounds(280,80,90,20) ;
				field1.getDocument().addDocumentListener(new DocumentListener(){
					//当文本框中有内容时按钮才起作用
						@Override
						public void insertUpdate(DocumentEvent e) {
								find.setEnabled(true);
								replace.setEnabled(true);
								replaceAll.setEnabled(true);
						}
						@Override
						public void removeUpdate(DocumentEvent e) {
							if(field1.getText().length() == 0){
								find.setEnabled(false);
								replace.setEnabled(false);
								replaceAll.setEnabled(false);
							}
						}
						@Override
						public void changedUpdate(DocumentEvent e) {
						}
					});
				//查找下一个按钮
				find.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						new findFunction() ;
					}
				});
				//替换按钮
				replace.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//如果有选中的内容就替换，然后选中下一个要替换的内容，否则先查找要替换的内容
						if(txt.getSelectedText()!=null){				
							txt.replaceSelection(field2.getText());
						}
						new findFunction() ;
					}
				});
				//替换所有按钮
				replaceAll.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String str = txt.getText() ;
						if(jcb.isSelected()){
							str = str.replaceAll(field1.getText(), field2.getText()) ;
						}else{
							str = str.replaceAll("(?i)" + field1.getText(), field2.getText()) ;
						}
						txt.setText(str);
					}
				});
				//取消按钮
				canc.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose() ;
						isOpen = false ;
					}
				});
				add(label1) ;
				add(label2) ;
				add(field1) ;
				add(field2) ;
				find.setEnabled(false);
				replace.setEnabled(false);
				replaceAll.setEnabled(false);
				add(find) ;
				add(replace) ;
				add(replaceAll) ;
				add(jcb) ;
				add(canc) ;
				setSize(380,130) ;
				setLocation(x/2-190,y/2-65) ;
				setResizable(false) ;
				setVisible(true) ;
				setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;
				addWindowListener(new WindowAdapter(){
					public void windowOpened(WindowEvent e){
						isOpen = true ;
					}
				}) ;
				addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						isOpen = false ;
					}
				}) ;
			}
			//替换对话框中查找功能类
			/*
			 * 为了简化代码，将替换对话框里面的查找功能提取出来，成为一个内部类
			 */
			class findFunction {
				
				public findFunction(){				//要替换的字符串的位置
					int start = 0 ;
					int end = 0 ;
					int caretPosition = txt.getCaretPosition() ;
					String str = field1.getText() ;
					String texta = txt.getText() ;
					//区分大小写，向下查询,如果有光标就从光标的位置开始查找，否则就从选中的文本之后的位置开始查找
					if(jcb.isSelected()){		
						start = (txt.getSelectedText()==null ? caretPosition : txt.getSelectionEnd()) ;
						start = texta.indexOf(str.toLowerCase(), start) ;
						if(start == -1){			//如果没有找到
							JOptionPane.showMessageDialog(null, "找不到"+str) ;
						}else{		//如果找到了
							end = start + str.length() ;
							txt.select(start, end);
						}
					}else if(!jcb.isSelected()){		//不区分大小写
						texta = texta.toLowerCase() ;
						//向下查询,如果有光标就从光标的位置开始查找，否则就从选中的文本之后的位置开始查找
						start = (txt.getSelectedText()==null ? caretPosition : txt.getSelectionEnd()) ;
						start = texta.indexOf(str.toLowerCase(), start) ;
						if(start == -1){			//如果没有找到
							JOptionPane.showMessageDialog(null, "找不到"+str) ;
						}else{		//如果找到了
							end = start + str.length() ;
							txt.select(start, end);
						}
					}
				}
			}
		}
		replace.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!isOpen){
					new ReplaceDialog() ;
				}
			}
		});
		//转到内部类
		class GoToDialog extends JDialog{
			private JLabel label = new JLabel("行号(L):") ;
			private JTextField field = new JTextField() ;
			private JButton goToBtn = new JButton("转到") ;
			private JButton canBtn = new JButton("取消") ;
			private int rowNum = 0 ;//行号 
			public GoToDialog(){
				field.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e){
						if(!(e.getKeyChar()>='0' && e.getKeyChar()<='9' )){
							e.consume();
						}
					}
				});
				//转到
				goToBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						rowNum = Integer.parseInt(field.getText()) ;
						if(rowNum>txt.getLineCount()){
							JOptionPane.showMessageDialog(null, "行数超过了总行数", "记事本-跳行",JOptionPane.INFORMATION_MESSAGE);
							field.setText(txt.getLineCount() +"") ;
							field.requestFocus() ;			//获取文本域的焦点
							field.selectAll();
						}else{
							int position = 0 ;
							try {
								position = txt.getLineStartOffset(rowNum-1) ;
							} catch (BadLocationException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							GoToDialog.this.dispose();
							txt.requestFocus();
							txt.setCaretPosition(position);
						}
					}
				});
				//取消
				canBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose() ;
						isOpen = false ;
					}
				});
				setLayout(null) ;
				label.setBounds(12,10,100,20) ;
				field.setBounds(12,30,230,20) ;
				goToBtn.setBounds(85,65,75,20) ;
				canBtn.setBounds(167,65,75,20) ;
				add(label) ;
				add(field) ;
				add(goToBtn) ;
				add(canBtn) ; 
				setTitle("转到指定行") ;
				setModal(true) ;		//当对话框弹出时母窗口不可编辑
				setSize(270,130) ;
				setLocation(x/2-135,y/2-65) ;
				setResizable(false) ;
				setVisible(true) ;
				setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;
				addWindowListener(new WindowAdapter(){
					public void windowOpened(WindowEvent e){
						isOpen = true ;
					}
				}) ;
				addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						isOpen = false ;
					}
				}) ;
			}
		}
		//转到
		goTo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!isOpen){
					new GoToDialog() ;
				}
			}
		});
		//全选
		selectAll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txt.requestFocus();
				txt.selectAll() ;
			}
		});
		time.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String dateTime = null ;
				int pos = txt.getCaretPosition() ;
				dateTime = new SimpleDateFormat("hh:mm yyyy/MM/dd").format(new Date()) ;
				txt.insert(dateTime, pos);
			}
		});
		//自动换行
		autoLineWrap.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(autoLineWrap.isSelected()){
					txt.setLineWrap(true);
				}else{
					txt.setLineWrap(false);
				}
			}
		});
		//字体内部类
		class FontDialog extends JDialog{
			private JLabel label1 = new JLabel("字体(F):") ;
			private JLabel label2 = new JLabel("字形(Y):") ;
			private JLabel label3 = new JLabel("大小(S):") ;
			private JLabel instns = new JLabel("中文示例AaBaCc",JLabel.CENTER) ;
			private JTextField field1 = new JTextField() ;
			private JTextField field2 = new JTextField() ;
			private JTextField field3 = new JTextField() ;
			private String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames() ;
			private JScrollPane scr1 = new JScrollPane() ;
			private JScrollPane scr2 = new JScrollPane() ;
			private JScrollPane scr3 = new JScrollPane() ;
			private JList<String> fontList = null ;
			private JList<String> fStyleList = null ;
			private JList<String> fSizeList = null ;
			private JButton okBtn = new JButton("确定") ;
			private JButton cancBtn = new JButton("取消") ;
			//示例的显示
			private String selectedFont = "Fixedsys";
			private int selectedStyle = Font.PLAIN;
			private float selectedSize = 16;
			public FontDialog() {
				
				fontList = new JList<String>(fonts) ;
				//fontStyle
				String style[] = {"常规","倾斜","粗体","倾斜 粗体"} ;
				fStyleList = new JList<String>(style) ;
				//fontSize
				String size[] = {"8","9","10","11","12","14","16","18","20","22","24",
						"26","28","36","48","72","初号","小号","一号","小一","二号",
						"小二","三号","小三","四号","小四","五号","六号","小六","七号","八号"} ;
				fSizeList = new JList<String>(size) ;
				//Jlist中一次只能选择一个选项
				fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION) ;
				fStyleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION) ;
				fSizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION) ;
				scr1.add(fontList) ;
				scr2.add(fStyleList) ;
				scr3.add(fSizeList) ;
				scr1.setViewportView(fontList);
				scr2.setViewportView(fStyleList);
				scr3.setViewportView(fSizeList);
				okBtn.setBounds(250,450,80,30) ;
				cancBtn.setBounds(340,450,80,30) ;
				label1.setBounds(20,20,50,20) ;
				label2.setBounds(205,20,50,20) ;
				label3.setBounds(350,20,50,20) ;
				instns.setBounds(205,280,215,80) ;
				instns.setBorder(BorderFactory.createTitledBorder("示例")) ;
				field1.setBounds(20,40,170,20) ;
				field2.setBounds(205,40,130,20) ;
				field3.setBounds(350,40,70,20) ;
				scr1.setBounds(20,60,170,170) ;
				scr2.setBounds(205,60,130,170) ;
				scr3.setBounds(350,60,70,150) ;
				scr1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER) ;
				scr2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER) ;
				scr3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER) ;
				//文本框1
				field1.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e){
						int count = 0 ;			//文本框中的字符数
						String str = null ;		//保存输入到文本框中的字符
						int size = fontList.getModel().getSize() ;			//fontList中的文本个数
						str = field1.getText()+e.getKeyChar()+"" ;
						count = str.length() ;
						
						for(int i=0; i<size; i++){
							if(fontList.getModel().getElementAt(i).length()>=count){
								//判断输入的是否与JList中的内容部分匹配(忽略大小写)
								if(fontList.getModel().getElementAt(i).substring(0, count).compareToIgnoreCase(str)==0){
									fontList.ensureIndexIsVisible(size-i>=10 ? i+9 : size-1);
									if(fontList.getModel().getElementAt(i).compareToIgnoreCase(str)==0){
										fontList.setSelectedIndex(i);
									}
									break ;
								}
								else{
									fontList.ensureIndexIsVisible(0);
									fontList.clearSelection();
								}
							}
						}
					}
				});
				//文本框2
				field2.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e){
						int count = 0 ;			//文本框中的字符数
						String str = null ;		//保存输入到文本框中的字符
						int size = fStyleList.getModel().getSize() ;			//fontList中的文本个数
						str = field2.getText()+e.getKeyChar()+"" ;
						count = str.length() ;
						
						for(int i=0; i<size; i++){
							if(fStyleList.getModel().getElementAt(i).length()>=count){
								//判断输入的是否与JList中的内容部分匹配(忽略大小写)
								if(fStyleList.getModel().getElementAt(i).substring(0, count).compareToIgnoreCase(str)==0){
									if(fStyleList.getModel().getElementAt(i).compareToIgnoreCase(str)==0){
										fStyleList.setSelectedIndex(i);
									}
									break ;
								}
								else{
									fStyleList.clearSelection();
								}
							}
						}
					}
				});
				//文本框3
				field3.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e){
						int count = 0 ;			//文本框中的字符数
						String str = null ;		//保存输入到文本框中的字符
						int size = fSizeList.getModel().getSize() ;			//fontList中的文本个数
						str = field3.getText()+e.getKeyChar()+"" ;
						count = str.length() ;
						
						for(int i=0; i<size; i++){
							if(fSizeList.getModel().getElementAt(i).length()>=count){
								//判断输入的是否与JList中的内容部分匹配(忽略大小写)
								if(fSizeList.getModel().getElementAt(i).substring(0, count).compareToIgnoreCase(str)==0){
									fSizeList.ensureIndexIsVisible(size-i>=9 ? i+8 : size-1);
									if(fSizeList.getModel().getElementAt(i).compareToIgnoreCase(str)==0){
										fSizeList.setSelectedIndex(i);
									}
									break ;
								}
								else{
									fSizeList.ensureIndexIsVisible(0);
									fSizeList.clearSelection();
								}
							}
						}
					}
				});
				//设置示例中的文本字体样式
				//设置字形与字号对照表
				final Map<String,Float> map = new HashMap<String,Float>() ;
				map.put("常规", (float) Font.PLAIN) ;
				map.put("倾斜", (float) Font.ITALIC) ;
				map.put("粗体", (float) Font.BOLD) ;
				map.put("倾斜 粗体", (float) (Font.ITALIC+Font.BOLD)) ;
				map.put("初号", 42f) ;
				map.put("小号", 36f) ;
				map.put("一号", 26f) ;
				map.put("小一", 24f) ;
				map.put("二号", 22f) ;
				map.put("小二", 18f) ;
				map.put("三号", 16f) ;
				map.put("小三", 15f) ;
				map.put("四号", 14f) ;
				map.put("小四", 12f) ;
				map.put("五号", 10.5f) ;
				map.put("六号", 7.5f) ;
				map.put("小六", 6.5f) ;
				map.put("七号", 5.5f) ;
				map.put("八号", 5f) ;
				
				//字体列表监听事件
				fontList.addListSelectionListener(new ListSelectionListener(){
					@Override
					public void valueChanged(ListSelectionEvent e) {
						String txtFont = txt.getFont().getName() ;		//获取文本中的字体
						selectedFont = fontList.isSelectionEmpty() ? txtFont :fontList.getSelectedValue() ;
						instns.setFont(new Font(selectedFont,selectedStyle,(int)selectedSize));
					}
				}) ;
				//字体样式监听事件
				fStyleList.addListSelectionListener(new ListSelectionListener(){
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int txtStyle = txt.getFont().getStyle() ;		//获取文本中的字体
						selectedStyle = (int) (fStyleList.isSelectionEmpty() ? txtStyle :map.get(fStyleList.getSelectedValue())) ;
						instns.setFont(new Font(selectedFont,selectedStyle,(int)selectedSize));
					}
				}) ;
				//字体大小监听
				fSizeList.addListSelectionListener(new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent e){
						int txtSize = txt.getFont().getSize() ;
						if(!fSizeList.isSelectionEmpty()){
							String temp = fSizeList.getSelectedValue() ;
							if(temp.matches("\\d+")){
								selectedSize = Integer.parseInt(temp) ;
							}else{
								selectedSize = map.get(fSizeList.getSelectedValue()) ;
							}
						}
						instns.setFont(new Font(selectedFont,selectedStyle,(int)selectedSize));
					}
				});
				//确定按钮
				okBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						txt.setFont(new Font(selectedFont,selectedStyle,(int)selectedSize));
						isOpen = false ;
						dispose() ;
					}
				});
				//取消按钮
				cancBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dispose() ;
						isOpen = false ;
					}
				});
				/*class MyRender extends DefaultListCellRenderer{
					public Component getListCellRendererComponent(JList<?> list, Object value, 
							int index, boolean isSelected,
							boolean cellHasFocus){
						String font = value.toString() ;
						setFont(new Font(font,Font.PLAIN,12)) ;
						return this ;
					}
				}*/
				setLayout(null) ;
				add(label1) ;
				add(label2) ;
				add(label3) ;
				add(instns) ;
				add(field1) ;
				add(field2) ;
				add(field3) ;
				add(scr1) ;
				add(scr2) ;
				add(scr3) ;
				add(okBtn) ;
				add(cancBtn) ;
				setModal(true) ;		//当对话框弹出时母窗口不可编辑
				setSize(440,530) ;
				setLocation(x/2-220,y/2-265) ;
				setResizable(false) ;
				setVisible(true) ;
				setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;
				addWindowListener(new WindowAdapter(){
					public void windowOpened(WindowEvent e){
						isOpen = true ;
					}
				}) ;
				addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						isOpen = false ;
					}
				}) ;
			}
		}
		//字体
		font.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!isOpen){
					new FontDialog() ;
				}
			}
		});
		//查看帮助
		checkHelp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "与Windows系统下的帮助相似", "帮助", JOptionPane.CLOSED_OPTION);
			}
		});
		//关于
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "仿Windows记事本，初学Java的练手作品", "关于", JOptionPane.CLOSED_OPTION);
			}
		});
		//右键弹出菜单内部类
		class popupListener extends MouseAdapter{
			private JPopupMenu popup = null ;
			public popupListener(JPopupMenu popup){
				this.popup = popup ;
				
			}
			public void mouseReleased(MouseEvent e){
				showPopupMenu(e) ;
			}
			public void mouseClicked(MouseEvent e){
				showPopupMenu(e) ;
			}
			private  void showPopupMenu(MouseEvent e) {
			   if (e.isPopupTrigger()) {
			   //右键弹出菜单
				jpm.add(undo) ;
				jpm.add(cut) ;
				jpm.add(copy) ;
				jpm.add(delete) ;
				jpm.add(find) ;
				jpm.add(replace) ;
				jpm.add(goTo) ;
				jpm.add(selectAll) ;
				jpm.add(time) ;
			    popup.show(e.getComponent(), e.getX(), e.getY());
			   }
			  }
			}
		
		//右键弹出菜单
		txt.addMouseListener(new popupListener(jpm)) ;
		//设置快捷键
		newFile.setAccelerator(KeyStroke.getKeyStroke('N',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke('S',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		
		undo.setAccelerator(KeyStroke.getKeyStroke('Z',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		cut.setAccelerator(KeyStroke.getKeyStroke('X',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		copy.setAccelerator(KeyStroke.getKeyStroke('C',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke('V',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		find.setAccelerator(KeyStroke.getKeyStroke('F',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		replace.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		goTo.setAccelerator(KeyStroke.getKeyStroke('G',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		selectAll.setAccelerator(KeyStroke.getKeyStroke('A',java.awt.event.InputEvent.CTRL_DOWN_MASK));
		time.setAccelerator((KeyStroke) KeyStroke.getAWTKeyStroke((char) KeyEvent.VK_F5));
		//设置助记键
		file.setMnemonic('F');
		edit.setMnemonic('E');
		format.setMnemonic('O');
		view.setMnemonic('V');
		help.setMnemonic('H');
		
		newFile.setMnemonic('N');
		open.setMnemonic('O');
		save.setMnemonic('S');
		exit.setMnemonic('X');
		
		undo.setMnemonic('U'); 
		cut.setMnemonic('T'); 
		copy.setMnemonic('C');
		paste.setMnemonic('P'); 
		delete.setMnemonic('L');
		find.setMnemonic('F');
		replace.setMnemonic('R');
		goTo.setMnemonic('G');
		selectAll.setMnemonic('A');
		time.setMnemonic('D');
		
		font.setMnemonic('F');
		autoLineWrap.setMnemonic('W');
		
		state.setMnemonic('S');
		
		checkHelp.setMnemonic('H');
		about.setMnemonic('A');
		
		txt.setFont(new Font("Fixedsys",Font.PLAIN,16));
		txt.setEditable(true);
	
		file.add(newFile) ;
		file.add(open) ;
		file.add(save) ;
		file.addSeparator();
		file.add(exit) ;
		
		edit.add(undo) ;
		edit.addSeparator();
		edit.add(cut) ;
		edit.add(copy) ;
		edit.add(paste) ;
		edit.add(delete) ;
		edit.addSeparator();
		edit.add(find) ;
		edit.add(replace) ;
		edit.add(goTo) ;
		edit.addSeparator();
		edit.add(selectAll) ;
		edit.add(time) ;
		
		format.add(autoLineWrap) ;
		format.add(font) ;
		view.add(state) ;
		help.add(checkHelp) ;
		help.addSeparator();
		help.add(about) ;
		
		mb.add(file) ;
		mb.add(edit) ;
		mb.add(format) ;
		mb.add(view) ;
		mb.add(help) ;
		setJMenuBar(mb) ;
		add(mp) ;
		add(new JScrollPane(txt)) ;
		setVisible(true) ;
		setSize(530,640) ;
		setLocation(x/2-265,y/2-320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
	}
}

