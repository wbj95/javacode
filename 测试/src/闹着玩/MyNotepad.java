package ������;

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
	
	//�ļ��ı���
	private String title = "�ޱ���" ;
	//�˵���
	private JPanel mp = new JPanel() ;
	private JMenuBar mb = new JMenuBar() ;
	private JMenu
		file = new JMenu("�ļ�(F)"),
		edit = new JMenu("�༭(E)"),
		format = new JMenu("��ʽ(V)"),
		view = new JMenu("�鿴(O)"),
		help = new JMenu("����(H)");
	//�ļ�
	private JMenuItem 
		newFile = new JMenuItem("�½�(N)") ,
		open = new JMenuItem("��(O)") ,
		save = new JMenuItem("����(S)") ,
		exit = new JMenuItem("�˳�(X)") ;
	//�༭
	private JMenuItem 
		undo = new JMenuItem("����(U)") ,
		cut = new JMenuItem("����(T)") ,
		copy = new JMenuItem("����(C)") ,
		paste = new JMenuItem("ճ��(P)") ,
		delete = new JMenuItem("ɾ��(L)") ,
		find = new JMenuItem("����(F)") ,
		replace = new JMenuItem("�滻(R)") ,
		goTo = new JMenuItem("ת��(G)") ,
		selectAll = new JMenuItem("ȫѡ(A)") ,
		time = new JMenuItem("ʱ��/����(D)") ;
	//��ʽ
	private JMenuItem font = new JMenuItem("����(F)") ;
	private JCheckBox autoLineWrap = new JCheckBox("�Զ�����(W)") ;
	//�鿴
	private JMenuItem state = new JMenuItem("״̬(S)") ;
	//����
	private JMenuItem
		checkHelp = new JMenuItem("�鿴����(H)") ,
		about = new JMenuItem("���ڼ��±�(A)") ;
	//�ı���
	private JTextArea txt = new JTextArea() ;
	//�����˵�
	private JPopupMenu jpm = new JPopupMenu() ;
	//���嵯�����ڵĴ�״̬
	private static boolean isOpen = false ;
	//��ȡ��Ļ�ĳߴ�
	private int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
	private int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() ;
	public MyNotepad(){
		//�½�
		newFile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text = txt.getText() ;
				if(!text.equals("")){
					String str[] = text.split("\n") ;
					int result = JOptionPane.showConfirmDialog(null, "�Ƿ񽫸��ı��浽 "+
					title+"?", "���±�",  JOptionPane.YES_NO_CANCEL_OPTION) ;
					if(result == JOptionPane.NO_OPTION){		//������
						txt.setText("");
					}else if(result == JOptionPane.CANCEL_OPTION){}		//ȡ������
					else if(result == 0){			//����
						JFileChooser jfc = new JFileChooser() ;
						jfc.setDialogTitle("����");
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
		//��
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser jfc = new JFileChooser() ;
				jfc.setDialogTitle("��");
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
		//����
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String str[] = txt.getText().split("\n") ;
				JFileChooser jfc = new JFileChooser() ;
				jfc.setDialogTitle("����");
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
		//�˳�
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = txt.getText() ;
				if(!str.equals("")){
					int result = JOptionPane.showConfirmDialog(null, "�˳�ǰ�Ƿ񱣴棿", "�˳�", 
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
		 * ��������
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
		//����
		cut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txt.cut() ;
			}
		});
		//ճ��
		paste.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txt.paste();
			}
		});
		//ɾ��
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int start = txt.getSelectionStart() ;
				int end = txt.getSelectionEnd() ;
				txt.replaceRange("", start, end);
			}
		});
		/*
		 * Ϊ�˸��õط��ʱ����е����ԣ����Բ���ʹ���ڲ���
		 */
		//��������ڲ���
		
		class FindDialog extends JDialog{
		    private JPanel pan = new JPanel() ;
			private JLabel label = new JLabel("��������(N):") ;
			private JTextField txtf = new JTextField(20) ;
			private JButton btnf = new JButton("������һ��(F)") ;
			private JButton btnc = new JButton("ȡ��") ;
			private JCheckBox jcb = new JCheckBox("���ִ�Сд(C)") ;
			private JRadioButton jrb1 = new JRadioButton("����(U)") ;
			private JRadioButton jrb2 = new JRadioButton("����(D)",true) ;
			public FindDialog(){
				super(MyNotepad.this, "����") ;
				//���ı�����������ʱ��ť��������
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
						int caretPosition = txt.getCaretPosition() ;			//��¼������ʼλ��
						if(jcb.isSelected()){		//���ִ�Сд
							if(jrb2.isSelected()){		//���²�ѯ,����й��ʹӹ���λ�ÿ�ʼ���ң�����ʹ�ѡ�е��ı�֮���λ�ÿ�ʼ����
								start = (txt.getSelectedText()==null ? caretPosition : txt.getSelectionEnd()) ;
								start = texta.indexOf(str, start) ;
								if(start == -1){			//���û���ҵ�
									JOptionPane.showMessageDialog(null, "�Ҳ���"+str);
								}else{		//����ҵ���
									end = start + str.length() ;
									txt.select(start, end);
								}
							}else if(jrb1.isSelected()){	//���ϲ�ѯ,����й��ʹӹ���λ�ÿ�ʼ���ң�����ʹ�ѡ�е��ı�֮ǰ��λ�ÿ�ʼ����
								end = (txt.getSelectedText()==null ? caretPosition : txt.getSelectionStart()) ;
								String subtext = texta.substring(0, end) ;
								start = subtext.lastIndexOf(str, end-1) ;
								if(start == -1){
									JOptionPane.showMessageDialog(null, "�Ҳ���"+str) ;
								}else{
									end = start + str.length()  ;
									txt.select(start, end);
								}
							}
						}
						if(!jcb.isSelected()){		//�����ִ�Сд
							texta = texta.toLowerCase() ;
							if(jrb2.isSelected()){		//���²�ѯ,����й��ʹӹ���λ�ÿ�ʼ���ң�����ʹ�ѡ�е��ı�֮���λ�ÿ�ʼ����
								start = (txt.getSelectedText()==null ? caretPosition : txt.getSelectionEnd()) ;
								start = texta.indexOf(str.toLowerCase(), start) ;
								if(start == -1){			//���û���ҵ�
									JOptionPane.showMessageDialog(null, "�Ҳ���"+str) ;
								}else{		//����ҵ���
									end = start + str.length() ;
									txt.select(start, end);
								}
							}else if(jrb1.isSelected()){	//���ϲ�ѯ,����й��ʹӹ���λ�ÿ�ʼ���ң�����ʹ�ѡ�е��ı�֮ǰ��λ�ÿ�ʼ����
								end = (txt.getSelectedText() == null ? caretPosition : txt.getSelectionStart()) ;
								String subtext = texta.substring(0, end) ;
								start = subtext.lastIndexOf(str.toLowerCase(), end-1) ;
								if(start == -1){
									JOptionPane.showMessageDialog(null, "�Ҳ���"+str) ;
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
				btnf.setEnabled(false);					//��ʼ��������һ����ť����ѡ
				jcb.setBounds(12,70,110,20) ;
				jrb1.setMargin(new Insets(0,0,0,0)) ;
				jrb2.setMargin(new Insets(0,0,0,0)) ;
				ButtonGroup group = new ButtonGroup() ;
				group.add(jrb1);
				group.add(jrb2);
				pan.add(jrb1) ;
				pan.add(jrb2) ;
				pan.setBorder(BorderFactory.createTitledBorder("����")) ;
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
				//ÿ��ֻ����ʾһ������
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
		//���ҵļ����¼�
		find.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!isOpen){
					new FindDialog() ;
				}
			}
		});
		
		
		//�滻�ڲ���
		class ReplaceDialog extends JDialog{
			private JLabel label1 = new JLabel("��������(N)") ;
			private JLabel label2 = new JLabel("�滻Ϊ(P)") ;
			private JTextField field1 = new JTextField(20) ;
			private JTextField field2 = new JTextField(20) ;
			private JButton find = new JButton("������һ��(F)") ;
			private JButton replace = new JButton("�滻(R)") ;
			private JButton replaceAll = new JButton("ȫ���滻(A)") ;
			private JButton canc = new JButton("ȡ��") ;
			private JCheckBox jcb = new JCheckBox("���ִ�Сд(C)") ;
			public ReplaceDialog(){
				super(MyNotepad.this,"����") ;
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
					//���ı�����������ʱ��ť��������
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
				//������һ����ť
				find.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						new findFunction() ;
					}
				});
				//�滻��ť
				replace.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//�����ѡ�е����ݾ��滻��Ȼ��ѡ����һ��Ҫ�滻�����ݣ������Ȳ���Ҫ�滻������
						if(txt.getSelectedText()!=null){				
							txt.replaceSelection(field2.getText());
						}
						new findFunction() ;
					}
				});
				//�滻���а�ť
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
				//ȡ����ť
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
			//�滻�Ի����в��ҹ�����
			/*
			 * Ϊ�˼򻯴��룬���滻�Ի�������Ĳ��ҹ�����ȡ��������Ϊһ���ڲ���
			 */
			class findFunction {
				
				public findFunction(){				//Ҫ�滻���ַ�����λ��
					int start = 0 ;
					int end = 0 ;
					int caretPosition = txt.getCaretPosition() ;
					String str = field1.getText() ;
					String texta = txt.getText() ;
					//���ִ�Сд�����²�ѯ,����й��ʹӹ���λ�ÿ�ʼ���ң�����ʹ�ѡ�е��ı�֮���λ�ÿ�ʼ����
					if(jcb.isSelected()){		
						start = (txt.getSelectedText()==null ? caretPosition : txt.getSelectionEnd()) ;
						start = texta.indexOf(str.toLowerCase(), start) ;
						if(start == -1){			//���û���ҵ�
							JOptionPane.showMessageDialog(null, "�Ҳ���"+str) ;
						}else{		//����ҵ���
							end = start + str.length() ;
							txt.select(start, end);
						}
					}else if(!jcb.isSelected()){		//�����ִ�Сд
						texta = texta.toLowerCase() ;
						//���²�ѯ,����й��ʹӹ���λ�ÿ�ʼ���ң�����ʹ�ѡ�е��ı�֮���λ�ÿ�ʼ����
						start = (txt.getSelectedText()==null ? caretPosition : txt.getSelectionEnd()) ;
						start = texta.indexOf(str.toLowerCase(), start) ;
						if(start == -1){			//���û���ҵ�
							JOptionPane.showMessageDialog(null, "�Ҳ���"+str) ;
						}else{		//����ҵ���
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
		//ת���ڲ���
		class GoToDialog extends JDialog{
			private JLabel label = new JLabel("�к�(L):") ;
			private JTextField field = new JTextField() ;
			private JButton goToBtn = new JButton("ת��") ;
			private JButton canBtn = new JButton("ȡ��") ;
			private int rowNum = 0 ;//�к� 
			public GoToDialog(){
				field.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e){
						if(!(e.getKeyChar()>='0' && e.getKeyChar()<='9' )){
							e.consume();
						}
					}
				});
				//ת��
				goToBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						rowNum = Integer.parseInt(field.getText()) ;
						if(rowNum>txt.getLineCount()){
							JOptionPane.showMessageDialog(null, "����������������", "���±�-����",JOptionPane.INFORMATION_MESSAGE);
							field.setText(txt.getLineCount() +"") ;
							field.requestFocus() ;			//��ȡ�ı���Ľ���
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
				//ȡ��
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
				setTitle("ת��ָ����") ;
				setModal(true) ;		//���Ի��򵯳�ʱĸ���ڲ��ɱ༭
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
		//ת��
		goTo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!isOpen){
					new GoToDialog() ;
				}
			}
		});
		//ȫѡ
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
		//�Զ�����
		autoLineWrap.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(autoLineWrap.isSelected()){
					txt.setLineWrap(true);
				}else{
					txt.setLineWrap(false);
				}
			}
		});
		//�����ڲ���
		class FontDialog extends JDialog{
			private JLabel label1 = new JLabel("����(F):") ;
			private JLabel label2 = new JLabel("����(Y):") ;
			private JLabel label3 = new JLabel("��С(S):") ;
			private JLabel instns = new JLabel("����ʾ��AaBaCc",JLabel.CENTER) ;
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
			private JButton okBtn = new JButton("ȷ��") ;
			private JButton cancBtn = new JButton("ȡ��") ;
			//ʾ������ʾ
			private String selectedFont = "Fixedsys";
			private int selectedStyle = Font.PLAIN;
			private float selectedSize = 16;
			public FontDialog() {
				
				fontList = new JList<String>(fonts) ;
				//fontStyle
				String style[] = {"����","��б","����","��б ����"} ;
				fStyleList = new JList<String>(style) ;
				//fontSize
				String size[] = {"8","9","10","11","12","14","16","18","20","22","24",
						"26","28","36","48","72","����","С��","һ��","Сһ","����",
						"С��","����","С��","�ĺ�","С��","���","����","С��","�ߺ�","�˺�"} ;
				fSizeList = new JList<String>(size) ;
				//Jlist��һ��ֻ��ѡ��һ��ѡ��
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
				instns.setBorder(BorderFactory.createTitledBorder("ʾ��")) ;
				field1.setBounds(20,40,170,20) ;
				field2.setBounds(205,40,130,20) ;
				field3.setBounds(350,40,70,20) ;
				scr1.setBounds(20,60,170,170) ;
				scr2.setBounds(205,60,130,170) ;
				scr3.setBounds(350,60,70,150) ;
				scr1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER) ;
				scr2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER) ;
				scr3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER) ;
				//�ı���1
				field1.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e){
						int count = 0 ;			//�ı����е��ַ���
						String str = null ;		//�������뵽�ı����е��ַ�
						int size = fontList.getModel().getSize() ;			//fontList�е��ı�����
						str = field1.getText()+e.getKeyChar()+"" ;
						count = str.length() ;
						
						for(int i=0; i<size; i++){
							if(fontList.getModel().getElementAt(i).length()>=count){
								//�ж�������Ƿ���JList�е����ݲ���ƥ��(���Դ�Сд)
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
				//�ı���2
				field2.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e){
						int count = 0 ;			//�ı����е��ַ���
						String str = null ;		//�������뵽�ı����е��ַ�
						int size = fStyleList.getModel().getSize() ;			//fontList�е��ı�����
						str = field2.getText()+e.getKeyChar()+"" ;
						count = str.length() ;
						
						for(int i=0; i<size; i++){
							if(fStyleList.getModel().getElementAt(i).length()>=count){
								//�ж�������Ƿ���JList�е����ݲ���ƥ��(���Դ�Сд)
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
				//�ı���3
				field3.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e){
						int count = 0 ;			//�ı����е��ַ���
						String str = null ;		//�������뵽�ı����е��ַ�
						int size = fSizeList.getModel().getSize() ;			//fontList�е��ı�����
						str = field3.getText()+e.getKeyChar()+"" ;
						count = str.length() ;
						
						for(int i=0; i<size; i++){
							if(fSizeList.getModel().getElementAt(i).length()>=count){
								//�ж�������Ƿ���JList�е����ݲ���ƥ��(���Դ�Сд)
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
				//����ʾ���е��ı�������ʽ
				//�����������ֺŶ��ձ�
				final Map<String,Float> map = new HashMap<String,Float>() ;
				map.put("����", (float) Font.PLAIN) ;
				map.put("��б", (float) Font.ITALIC) ;
				map.put("����", (float) Font.BOLD) ;
				map.put("��б ����", (float) (Font.ITALIC+Font.BOLD)) ;
				map.put("����", 42f) ;
				map.put("С��", 36f) ;
				map.put("һ��", 26f) ;
				map.put("Сһ", 24f) ;
				map.put("����", 22f) ;
				map.put("С��", 18f) ;
				map.put("����", 16f) ;
				map.put("С��", 15f) ;
				map.put("�ĺ�", 14f) ;
				map.put("С��", 12f) ;
				map.put("���", 10.5f) ;
				map.put("����", 7.5f) ;
				map.put("С��", 6.5f) ;
				map.put("�ߺ�", 5.5f) ;
				map.put("�˺�", 5f) ;
				
				//�����б�����¼�
				fontList.addListSelectionListener(new ListSelectionListener(){
					@Override
					public void valueChanged(ListSelectionEvent e) {
						String txtFont = txt.getFont().getName() ;		//��ȡ�ı��е�����
						selectedFont = fontList.isSelectionEmpty() ? txtFont :fontList.getSelectedValue() ;
						instns.setFont(new Font(selectedFont,selectedStyle,(int)selectedSize));
					}
				}) ;
				//������ʽ�����¼�
				fStyleList.addListSelectionListener(new ListSelectionListener(){
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int txtStyle = txt.getFont().getStyle() ;		//��ȡ�ı��е�����
						selectedStyle = (int) (fStyleList.isSelectionEmpty() ? txtStyle :map.get(fStyleList.getSelectedValue())) ;
						instns.setFont(new Font(selectedFont,selectedStyle,(int)selectedSize));
					}
				}) ;
				//�����С����
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
				//ȷ����ť
				okBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						txt.setFont(new Font(selectedFont,selectedStyle,(int)selectedSize));
						isOpen = false ;
						dispose() ;
					}
				});
				//ȡ����ť
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
				setModal(true) ;		//���Ի��򵯳�ʱĸ���ڲ��ɱ༭
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
		//����
		font.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!isOpen){
					new FontDialog() ;
				}
			}
		});
		//�鿴����
		checkHelp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "��Windowsϵͳ�µİ�������", "����", JOptionPane.CLOSED_OPTION);
			}
		});
		//����
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "��Windows���±�����ѧJava��������Ʒ", "����", JOptionPane.CLOSED_OPTION);
			}
		});
		//�Ҽ������˵��ڲ���
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
			   //�Ҽ������˵�
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
		
		//�Ҽ������˵�
		txt.addMouseListener(new popupListener(jpm)) ;
		//���ÿ�ݼ�
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
		//�������Ǽ�
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

