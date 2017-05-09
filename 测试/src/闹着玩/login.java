package ������;
import static java.awt.BorderLayout.SOUTH;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;//��������������������p225
import java.security.cert.PolicyQualifierInfo;
import java.util.ArrayList;
//����ѧ���ࣺ����
class Student implements Serializable {//�ӿڣ�Serialization:ָ����ͨ��д�������Լ�״̬����ֵ��¼�Լ����г�
	
	private long num;          //����ѧ��
	private long bianhao;       //������
	private String mingcheng;       //����γ�����
	private int xuefen;   //����ѧ��
	private int pingshi;   //����ƽʱ�ɼ�
	private int shiyan;   //����ʵ��ɼ�
	private int juanmian;   //�������ɼ�
	private int sum=0;    //�����ܷ�
	private int shidexuefen;   //����ʵ��ѧ��
	public Student() {//�����޲ι��췽��
		
	}
	public Student( long num, long bianhao,String mingcheng,int xuefen,int pingshi,int shiyan,int juanmian,int sum,int shidexuefen) {//���ݳ�ʼ��
		super();//���ø����ͬ�������������������
		this.num = num;//��ʽ��ʹ��this���ʶ����num������
		this.bianhao = bianhao;
		this.mingcheng= mingcheng;
		this.xuefen = xuefen;
		this.pingshi= pingshi;
		this.shiyan=shiyan;
		this.juanmian = juanmian;
		this.sum=sum;
		this.shidexuefen=shidexuefen;
	}//�������ɹ��췽��:set,get,toString,����
	public Student(String num2, int parseInt, int parseInt2, int parseInt3,
			int parseInt4, int parseInt5, int parseInt6) {
		// TODO �Զ����ɵĹ��캯�����
	}
	public long getnum() {
		return num;
		}
	public void setnum(long num) {
		this.num = num;
		}
	public long getbianhao() {
		return bianhao;
		}
	public void setbianhao(long bianhao) {
		this.bianhao = bianhao;
		}
	public String getmingcheng() {
		return mingcheng;
		}
	public void setmingcheng(String mingcheng) {	
		this.mingcheng = mingcheng;
		}
	public int getxuefen() {
		return xuefen;
		}
	public void setxuefen(int xuefen) {
		this.xuefen = xuefen;
		}
	public int getpingshi() {
		return pingshi;
		}
	public void setpingshi(int pingshi) {
		this.pingshi =pingshi;	
		}
	public int getshiyan() {
		return shiyan;	
		}
	public void setshiyan(int shiyan) {	
		this.shiyan = shiyan;	
		}
	public int getjuanmian() {
		return juanmian;	
		}
	public void setjuanmian(int juanmian) {	
		this.juanmian = juanmian;	
		}
	public int getsum() {
		return sum;	
		}
	public void setsum(int sum) {
		this.sum = sum;
	}
	public int getshidexuefen(){
		return shidexuefen;
	}
	public void setshidexuefen(int shidexuefen){
		
	}
	public String toString() {//���ַ���˵��һ��
		return "Student [num=" + num + ",bianhao=" + bianhao + ",mingcheng=" + mingcheng
				+ ", xuefen=" + xuefen +  " ,pingshi=" + pingshi
				+  ",shiyan=" + shiyan + "juanmian=" + juanmian + ", sum=" + sum
				+ ",shidexuefen=" + shidexuefen + ",]";
	}
}	
//����ѧ�������࣬ʵ�ֳɼ�������ɾ�飺
class StuC {
	ArrayList <Student> al=new ArrayList<Student>();//ArrayList��һ���䳤�������飬��Ϊһ�������б�����
	File file = new File("mydata.txt");//�����ļ�������·��
	public void adds(Student s) {//
		al.add(s);	
		}//���ѧ����Ϣ(String ����)	
	public void del(int n) {//ɾ��ѧ��Ϊn������
		for(int i=0;i<al.size();i++) {
			if(al.get(i).getnum()==n)
				al.remove(i);	
		}
	}
	public void sum() {//���ܷ�
		for(int i=0;i<al.size();i++) {
	al.get(i).setsum(al.get(i).getpingshi()+al.get(i).getshiyan()+al.get(i).getjuanmian());
		}	
	}
	public void sort() {//����
		  for (int i = 0; i < al.size(); i++) {
			  for (int j = 0; j < al.size()-1-i; j++) {
				  if (al.get(j).getsum() < al.get(j+1).getsum()) {
					  Object o=al.get(j);
					 al.set(j, al.get(j+1));
					 al.set(j+1, (Student) o);
				  }
			  }
		  }
	}
	
	public void paint() {//������п�Ŀ�ķ���
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
	}
	
	
	public String toString() {//���ַ�������
		return "StuC [al=" + al + "]";
	}
	public void stor() {//�����
		ObjectOutputStream out = null;
		try {//���ܳ����쳣�����
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(al);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();//����쳣ջ��
		} catch (IOException e) {
			e.printStackTrace();//����쳣ջ��
		}
	}
	public void read() {//�������������ж�ȡ���ݣ�p223
		ObjectInputStream in = null;
		try {//���ܳ����쳣�����
			in = new ObjectInputStream(new FileInputStream(file));
			try {//���ܳ����쳣�����
				al = (ArrayList<Student>)in.readObject();
			} catch (ClassNotFoundException e) {//�쳣������
				al=null;
			}
			in.close();//�ر���
		} catch (FileNotFoundException e) {//�쳣������
			File file = new File("mydata.txt");//�����ļ���ָ����洢·��
		} catch (IOException e) {//�쳣������
			e.printStackTrace();//����쳣ջ��
		}
	}
	public Student find(int n) {//����ѧ��Ϊn��ѧ����Ϣ
		for(int i=0;i<al.size();i++) {
			if(al.get(i).getnum()==n) {
				return al.get(i);
			}
		}
		return null;					//����Ϣ������null
	}
}

//����������ͼƬ��
class MyPanel extends JPanel {//�̳�JPanel
	Image img=Toolkit.getDefaultToolkit().getImage("d:\\nanyou.jpg");//��ͼƬ�ľ���·����ȡͼƬ
	public void paint(Graphics g) {
		g.drawImage(img,0,0,this);//��ͼƬ
	}
}
class MyPanel1 extends JPanel {//�����½����ͼƬ
	Image img=Toolkit.getDefaultToolkit().getImage("d:\\nanyou.jpg");
	public void paint(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
//��½���棺
public class login extends JFrame {//�̳�
	private TextField f1;
	private TextField f2;//�����ı���
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;//�����ı���ť
	StuC scs=new StuC();//����ѧ����
	public login() {//setBackground(new Color(20,56,225));
		Container cp=getContentPane();//��ȡ����,java�У��������ֱ����ӵ�����������������ӵ���������ϡ�
		cp.setLayout(new GridLayout(4,1));//���ò��ֹ���Ϊ��������һ��
		Label l1=new Label("�û���");//������ǩ��l1��l2
		Label l2=new Label("��   ��"); 
		Panel p1=new Panel();//����ƽ����壬p1,p2,p3
		Panel p2=new Panel();
		Panel p3=new Panel();
		MyPanel1 p4=new MyPanel1();//��������ͼƬƽ��p4
		f1=new TextField(10);//ָ���ı�����п�
		f2=new TextField(10);
		b1=new JButton("��ʦ��½");//�����������ı��İ�ťb1��b2��b3
		b2=new JButton("ѧ����½");
		b3=new JButton("�˳���½");
		p1.add(l1);//��һ�����label 1�����ı��򣬰�ť����ǩ��ӵ�����ϡ�
		p1.add(f1);
		p2.add(l2);
		p2.add(f2);
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		cp.add(p4);//���p4��p1��p2��p3�ֱ��������cp
		cp.add(p1);
		cp.add(p2);
		cp.add(p3);
		b1.addActionListener(new TeacherEnter());//��Ӱ�ť�¼���Ӧ��Ϊb1,b2,b3��ťע���¼�������
		b2.addActionListener(new StudentEnter());
		b3.addActionListener(new Close());
	}
	class TeacherEnter implements ActionListener {//b1��ť����ʦ�����½��Ӧ��ʵ���¼������ӿڵ���
		public void actionPerformed(ActionEvent e) {      //ʵ���¼�������
         		if((f1.getText()).equals("1��")&&(f2.getText()).equals("123456")) {//�����ʦ��½������1�࣬ ���룺123456	
         				scs.read();//��ʼ�������ļ�������Ϣ
         				TeacherMainForm  frame1 = new TeacherMainForm();//�����½���ʦ����
         		}
             	else JOptionPane.showMessageDialog(null, "�û�����������������µ�¼��");//�����������������󣺵������ڣ��Ի���
		}
	}
	class StudentEnter implements ActionListener {//ѧ�������½��Ӧb2��ť
		public void actionPerformed(ActionEvent e) {      
         		if((f1.getText()).equals("1��")&&(f2.getText()).equals("666666")) {//������룺������1�࣬����666666��
         				scs.read();//��ʼ�������ļ�������Ϣ
         				StudentMainForm  frame1 = new StudentMainForm();
         		}
             	else JOptionPane.showMessageDialog(null, "�û�����������������µ�¼��");//�������������������򵯳��Ի����û�����������������뾯ʾ
		}
	}
	
	class Close implements ActionListener {//�رյ�½��ť��Ӧ��b3���˳�����ť��
		public void actionPerformed(ActionEvent e) {
			JButton bt=(JButton)e.getSource();
			if(bt==b3) {
				System.exit(0);//�˳�
			}
		}
	}

	//��ʦ��½���棺
	class TeacherMainForm extends JFrame implements ActionListener{
	//
		JMenu mSystem=new JMenu("ϵͳ");//ϵͳ�˵�
	    JMenuItem mExit=new JMenuItem("�˳�");
	    JMenuItem mSave=new JMenuItem("����");
	    JMenu mHelp=new JMenu("����");//�����˵�
	    JMenuItem mAbout=new JMenuItem("�����Ϣ");
	    JMenuBar mBar=new JMenuBar();//�˵���
	    JPanel panel;
		JButton button1,button2,button3,button4,button5,button6;//��ť���
		JLabel label,labelTitle,label1,label2,label3,label4,label5,label6;//��ǩ���
		  //��ӱ���
		ImageIcon ����;//����Ϊ��������ı�����ͨ�����ͼƬ����Ϊ����
	    Icon icon1,icon2,icon3,icon4,icon5,icon6;//��ťͼ��
	    Box basebox,boxV1,boxV2,boxV3,boxV4,boxV5,boxV6;//box���
	    TeacherMainForm() {
	        super("��ʦ���� ");
//	        setSize(500,700);
//	        setLocation(2000,2000);
	        setSize(561,561);
	        setLocation(350,110);
	        mBar.add(mSystem);//���˵���ӵ��˵���
	        mBar.add(mHelp);
	        mSystem.add(mSave);//Ϊ�˵���Ӳ˵���Ŀ
	        mSystem.add(mExit);
	        mHelp.add(mAbout);
	        setJMenuBar(mBar);//���ò˵���
	        mExit.addActionListener(this);//Ϊ�˵���ť��Ӽ����¼�
	        mAbout.addActionListener(this);
	        mSave.addActionListener(this);
	        setVisible(true);
	        setResizable(true);
	        //��ӱ�������ӱ��⣬���ð�ťͼ��
	      		labelTitle=new JLabel("�ɼ�����ϵͳ");//��ӱ���
	      		Font font=new Font("�����п�",
	      				Font.BOLD+Font.TRUETYPE_FONT+Font.LAYOUT_LEFT_TO_RIGHT,100);
	      		labelTitle.setFont(font);//Ϊ�����������
	      		labelTitle.setForeground(new Color(0,0,139));
	      		���� = new ImageIcon("C:/nanyou/you.jpg");//���ñ���ͼƬ
	      		label = new JLabel(����);
	      		label.setBounds(0, 0, ����.getIconWidth()-1,����.getIconHeight()-1);//���ó�ͼƬ�Ĵ�С
	      		this.getLayeredPane().setLayout(null);
	      		icon1=new ImageIcon("C:/nanyou/you2.jpg");//Ϊ��ť���ͼƬ
	      		button1 = new JButton(icon1);
	      		button1.setContentAreaFilled (false);
	      		icon2=new ImageIcon("C:/nanyou/you2.jpg");
	      		button2 = new JButton(icon2);
	      		button2.setContentAreaFilled (false);
	      		icon3=new ImageIcon("C:/nanyou/you2.jpg");
	      		button3 = new JButton(icon3);
	      		button3.setContentAreaFilled (false);
	      		icon4=new ImageIcon("C:/nanyou/you2.jpg");
	      		button4 = new JButton(icon4);
	      		button4.setContentAreaFilled (false);
	      		icon5=new ImageIcon("C:/nanyou/you2.jpg");
	      		button5 = new JButton(icon5);
	      		button5.setContentAreaFilled (false);
	      		icon6=new ImageIcon("C:/nanyou/you2.jpg");
	      		button6 = new JButton(icon6);
	      		button6.setContentAreaFilled (false);
	      		//���ð�ť�Ľ������ֵ��������ɫ�����Ѱ�ť�����Ӧ������˵����BoxLayout����
	      		//����Ϊ���¶�����ʽ
	      		Font font1=new Font("�����п�",
	      			Font.BOLD+Font.TRUETYPE_FONT+Font.LAYOUT_LEFT_TO_RIGHT,30);//��������
	      		label1=new JLabel("  ��ѯ");//��ǩע�Ͱ�ť
	      		label2=new JLabel("  ����");
	      		label3=new JLabel("  ɾ��");
	      		label4=new JLabel("  �޸�");
	      		label5=new JLabel("  ͳ��");
	      		label6=new JLabel("  �˳�");
	      		label1.setFont(font1);//Ϊ��ǩ��������
	      		label2.setFont(font1);
	      		label3.setFont(font1);
	      		label4.setFont(font1);
	      		label5.setFont(font1);
	      		label6.setFont(font1);
	      		
//	      		label1.setForeground(Color.yellow);
//	      		label2.setForeground(Color.yellow);
//	      		label3.setForeground(Color.blue);
//	      		label4.setForeground(Color.blue);
//	      		label5.setForeground(Color.blue);
//	      		label6.setForeground(Color.blue);
	      		
	      		label1.setForeground(new Color(255,250,250));//Ϊ��ǩ������ɫ
	      		label2.setForeground(new Color(255,235,205));//Ϊ��ǩ������ɫ
	      		label3.setForeground(new Color(255,228,225));//Ϊ��ǩ������ɫ
	      		label4.setForeground(new Color(250,235,215));//Ϊ��ǩ������ɫ
	      		label5.setForeground(new Color(255,245,238));//Ϊ��ǩ������ɫ
	      		label6.setForeground(new Color(255,127,80));//Ϊ��ǩ������ɫ
	      		
	      		boxV1=Box.createVerticalBox();    //���һЩ��ʽ����
	      		boxV2=Box.createVerticalBox();    
	      		boxV3=Box.createVerticalBox();
	      		boxV4=Box.createVerticalBox();	 
	      		boxV5=Box.createVerticalBox();
	      		boxV6=Box.createVerticalBox();
	      		boxV1.add(button1);
	      		boxV1.add(Box.createVerticalStrut(9));//���ô�ֱ����  
	      		boxV1.add(label1);
	      		boxV2.add(button2);
	      		boxV2.add(Box.createVerticalStrut(9));//���ô�ֱ����  
	      		boxV2.add(label2);
	      		boxV3.add(button3);
	      		boxV3.add(Box.createVerticalStrut(9));//���ô�ֱ����  
	      		boxV3.add(label3);
	      		boxV4.add(button4);
	      		boxV4.add(Box.createVerticalStrut(9));//���ô�ֱ����  
	      		boxV4.add(label4);
	      		boxV5.add(button5);
	      		boxV5.add(Box.createVerticalStrut(9));//���ô�ֱ����  
	      		boxV5.add(label5);
	      		boxV6.add(button6);
	      		boxV6.add(Box.createVerticalStrut(9));//���ô�ֱ����  
	      		boxV6.add(label6);
	      		basebox=Box.createHorizontalBox();
	      		basebox.add(boxV1);
	      		basebox.add(Box.createHorizontalStrut(1));//���ô�ֱ����  
	      		basebox.add(boxV2);
	      		basebox.add(Box.createHorizontalStrut(1));//���ô�ֱ����  
	      		basebox.add(boxV3);
	      		basebox.add(Box.createHorizontalStrut(1));//���ô�ֱ����  
	      		basebox.add(boxV4);
	      		basebox.add(Box.createHorizontalStrut(1));//���ô�ֱ����  
	      		basebox.add(boxV5);
	      		basebox.add(Box.createHorizontalStrut(1));//���ô�ֱ����  
	      		basebox.add(boxV6);
	      		
	      		add(basebox,SOUTH);
	      		JPanel p1 = new JPanel();
	      		
	      	    //��ӱ��������Ѵ��ڴ�С����Ϊ����ͼƬ�Ĵ�С
	    		panel = (JPanel) this.getContentPane();
	    		panel.setOpaque(false);
	    		FlowLayout f = new FlowLayout();
	    		panel.add(labelTitle);
	    		panel.setLayout(f);
	    		getLayeredPane().setLayout(null);
	    		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	    		setSize(����.getIconWidth(), ����.getIconHeight());
	    		setBounds(350, 150,����.getIconWidth(),����.getIconHeight());
	    		setVisible(true);
	    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    		
	    		button1.addActionListener(this);//Ϊÿ����ť���ü�����
	    		button2.addActionListener(this);
	    		button3.addActionListener(this);
	    		button4.addActionListener(this);
	    		button5.addActionListener(this);
	    		button6.addActionListener(this);
	      	}
	    
	      	public void actionPerformed(ActionEvent e) {//�¼���Ӧ
	      		if(e.getSource()==mExit)//�˳�
	                System.exit(0);
	      		else if(e.getSource()==mSave)//����
	                shutDown();
	            else if(e.getSource()==mAbout)//�й���Ϣ
	                JOptionPane.showMessageDialog(this,"ѧ���ɼ�����ϵͳ\n�Ͼ��ʵ��ѧ\n����ѧԺ\n���̹���" +			//��Ϣ����
	                		"\n1��\n2017��4��","�����Ϣ",JOptionPane.INFORMATION_MESSAGE);
	            else if(e.getSource()==button1)//������button1ʱ����SIDFind()���ҵĴ���
	            	new SIDFind().setVisible(true);
	      		else if(e.getSource()==button2)//������button2ʱ����AddFI()��ӵĴ���
	      			new AddFI().setVisible(true);
	      		else if(e.getSource()==button3)//������button1ʱ����InterfaceDesign3ɾ���Ĵ���
	      			new Delet().setVisible(true);
	      		else if(e.getSource()==button4)//���޸Ĵ���
	      			new XiuGai().setVisible(true);
	      		else if(e.getSource()==button5)//��ͳ�ƴ���
	      	          new Tongji().setVisible(true);
	      		else if(e.getSource()==button6)//�˳�
	      			 System.exit(0);
	      		}
	    }
	private void shutDown() {
		//����
		scs.stor();			//���÷���
		JOptionPane.showMessageDialog(null, "��Ϣ�ѱ���");
	}
	 public void main1(String[] args) {
		 //������
		 new  TeacherMainForm();
	    }
	 
    //ѧ����½�����棺
    class StudentMainForm extends JFrame implements ActionListener {
	    JMenu mSystem=new JMenu("ϵͳ");//ϵͳ�˵�
	    JMenuItem mExit=new JMenuItem("�˳�");
	    JMenu mQuery=new JMenu("�ɼ���ѯ");   //�ɼ���ѯ�˵�
	    JMenuItem mSID=new JMenuItem("���Ƴɼ�");
	    JMenu mHelp=new JMenu("����");//�����˵�
	    JMenuItem mAbout=new JMenuItem("�����Ϣ");
	    JMenuBar mBar=new JMenuBar();
	    StudentMainForm() {
	        super("����1��2016��2017ѧ��ѧ����ĩ�ɼ�����ϵͳ--ѧ������");
	        setSize(561,561);
	        setLocation(350,110);
	        
	        // mSystem.add(mExit);
	        // mHelp.add(mAbout);
	        // mQuery.add(mSID);
	        // mBar.add(mSystem);
	        // mBar.add(mQuery);
	        // mBar.add(mHelp);
	        
	        mBar.add(mSystem);
	        mBar.add(mQuery);
	        mBar.add(mHelp);
	        mSystem.add(mExit);
	        mHelp.add(mAbout);
	        mQuery.add(mSID);
	        
	        setJMenuBar(mBar);
	        mExit.addActionListener(this);//��Ӱ�ť�¼�����
	        mAbout.addActionListener(this);
	        mSID.addActionListener(this);
	        setContentPane(new MyPanel());//����ƽ��
	        setVisible(true);
	        setResizable(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==mExit)//��ť�¼���Ӧ
            System.exit(0);
        else if(ae.getSource()==mSID)
            new SIDFind().setVisible(true);
        else if(ae.getSource()==mAbout)
            JOptionPane.showMessageDialog(this,"ѧ���ɼ�����ϵͳ\n\n�Ͼ��ʵ��ѧ\n����ѧԺ\n�������\n10��\n" +
            		"2017��4��","�����Ϣ",JOptionPane.INFORMATION_MESSAGE);        	
    }
    
    public void main(String[] args) {
        new StudentMainForm();
    }
}
    
//������Ϣ�����ڲ��࣬�����ı�������Ϣ����Student������ӵ�Arraylist�У�����Ѵ��ڸ�ѧ�Ÿ�����ʾ��Ϣ����������ӣ�����
	class AddFI extends JFrame implements ActionListener {
		private JTextField numT, bianhaoT, mingchengT, xuefenT,pingshiT,shiyanT,juanmianT,sumT,shidexuefenT;//�ı������
		private JButton b1, b2, b3;//��ť���
		private String num,bianhao, mingcheng,xuefen,pingshi,shiyan,juanmian,sum,shidexuefen;
		public AddFI() {
			super("���ѧ����Ϣ");
			Container con = this.getContentPane();//��ȡ����,java�У��������ֱ����ӵ�����������������ӵ���������ϡ�
			con.setLayout(new BorderLayout());
			JPanel P1 = new JPanel();//�������
			JPanel P2 = new JPanel();
			JPanel P3 = new JPanel(); 
			JLabel label2 = new JLabel("                       ");
			JLabel label3 = new JLabel("                       ");
			JPanel center = new JPanel(new GridLayout(9, 3));
			JPanel low = new JPanel(new FlowLayout());//���ְ���
			JLabel label1 = new JLabel("���ѧ����Ϣ", JLabel.CENTER);
			label1.setForeground(new Color(25,25,112));
			Font font=new Font("�����п�",
      				Font.BOLD+Font.TRUETYPE_FONT+Font.LAYOUT_LEFT_TO_RIGHT,50);
      		label1.setFont(font);//Ϊ�����������
			
			//label1.setFont(new Font("TRUE", Font.TRUETYPE_FONT, 30));//��������
			
			P1.add(label1);
			P2.add(label2);
			P3.add(label3);
			numT = new JTextField(4);//����Ϊ4���ı���
			bianhaoT = new JTextField(4);
			mingchengT = new JTextField(4);
			xuefenT = new JTextField(4);
			pingshiT = new JTextField(4);
			shiyanT= new JTextField(4);
			juanmianT= new JTextField(4);
			sumT= new JTextField(4);
			shidexuefenT=new JTextField(4);
			center.add(new JLabel("ѧ    ��", JLabel.CENTER));//��ӱ�ǩѧ��д�ڱ�ǩ�м�
			center.add(numT);//����ı���
			center.add(new JLabel("�γ̱��", JLabel.CENTER));
			center.add(bianhaoT);
			center.add(new JLabel("�γ�����", JLabel.CENTER));
			center.add(mingchengT);
			center.add(new JLabel("ѧ    ��", JLabel.CENTER));
			center.add(xuefenT);
			center.add(new JLabel("ƽʱ�ɼ�", JLabel.CENTER));
			center.add(pingshiT);
			center.add(new JLabel("ʵ��ɼ�", JLabel.CENTER));
			center.add(shiyanT);
			center.add(new JLabel("����ɼ�", JLabel.CENTER));
			center.add(juanmianT);
			center.add(new JLabel("�ۺϳɼ�", JLabel.CENTER));
			center.add(sumT);
			center.add(new JLabel("ʵ��ѧ��",JLabel.CENTER));
			center.add(shidexuefenT);
   		    //center.setBackground( Color.LIGHT_GRAY);
			
			setBackground(new Color(175,238,238));
   		    
   		    
			b1 = new JButton("���");
			b2 = new JButton("���");
			b3 = new JButton("�˳�");
			low.add(b1);
			low.add(b2);
			low.add(b3);
			con.add(low,"South");//��ʽ����
			con.add(center,"Center");
			con.add(P1,"North");
			con.add(P2,"East");
			con.add(P3,"West");
			b1.addActionListener(this);// ��Ӽ���
			b2.addActionListener(this);
			b3.addActionListener(this);
			this.setBounds( 350, 110,561, 495);//���������ͳ����
			this.setVisible(true);
			this.setTitle("���ѧ����Ϣ");
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				try {
					addFI();
				} catch (FileNotFoundException e1) {//�����쳣
					e1.printStackTrace();//�������д�ӡ�쳣��Ϣ�ڳ����г����λ�ú�ԭ��
				} catch (IOException e1) {	
					e1.printStackTrace();
				}
			}
			if (e.getSource() == b2) {
				clearForm();
			}
			if (e.getSource() == b3) {
				this.dispose();
			}
		}
       
		private void addFI() throws FileNotFoundException, IOException {//��ӷ����׳����ܳ��ֵ��ļ���IO�쳣
		    num =numT.getText();
			bianhao = bianhaoT.getText();
			mingcheng = mingchengT.getText();
			xuefen= xuefenT.getText();
			pingshi= pingshiT.getText();
			shiyan= shiyanT.getText();
			juanmian= juanmianT.getText();
			sum= sumT.getText();
			shidexuefen= shidexuefenT.getText();
			if (num.length() == 0 || bianhao.length() == 0 ||mingcheng.length() == 0
					|| xuefen.length() == 0 ||pingshi.length() == 0|| shiyan.length() == 0|| juanmian.length() == 0||shidexuefen.length()==0)
				JOptionPane.showMessageDialog(this, "�������ȫ��Ϣ");//���������Ϣ����ȫ����������������
			else {
					Student a=new Student(Integer.toUnsignedLong(Integer.parseInt(num)),Integer.toUnsignedLong(Integer.parseInt(bianhao)),mingcheng,
							Integer.parseInt(xuefen),Integer.parseInt(pingshi),Integer.parseInt(shiyan),
							Integer.parseInt(juanmian),Integer.parseInt(sum),Integer.parseInt(shidexuefen));
					int b=0;
		
					for(int i=0;i<scs.al.size();i++){
						if(scs.al.get(i).getnum()==Integer.parseInt(num)){
							b=1;
						}
					}
					if(b==0){
						scs.adds(a);
						JOptionPane.showMessageDialog(this, "��ӳɹ�");
					}
					else{
						JOptionPane.showMessageDialog(this, "�Ѵ���");	
					}
			}
		}
          //ɾ����Ϣ
		private void clearForm() {
			numT.setText("");
			bianhaoT.setText("");
			mingchengT.setText("");
			xuefenT.setText("");
			pingshiT.setText("");	
			shiyanT.setText("");
			juanmianT.setText("");
			sumT.setText("");	
		}
	}
//ɾ����Ϣ���棬ͨ�������ѧ�Ž��в��Ҳ���arraylist���Ƴ�
	class Delet extends JFrame implements ActionListener{
		private JButton yes;
		private JButton cancle;
		private JTextField text1;
		private String XueHao;
		public Delet(){
			Container c3 = this.getContentPane();
			c3.setLayout(new GridLayout(3, 1));
			c3.setFont(new Font("true",Font.TRUETYPE_FONT,13));
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JLabel label1 = new JLabel("ɾ��ѧ����Ϣ",SwingConstants.CENTER);
			label1.setFont(new Font("true",Font.TRUETYPE_FONT,13));
			label1.setForeground(Color.red);
			c3.add(label1);
			JLabel label2 = new JLabel("������ѧ��");
			text1 = new JTextField(10);
			p1.add(label2);
			p1.add(text1);
			c3.add(p1);
			
			yes = new JButton("ȷ��");
			cancle = new JButton("�˳�");
			p2.add(yes);
			p2.add(cancle);
			c3.add(p2);
			yes.addActionListener(this);
			cancle.addActionListener(this);
			this.setTitle("ɾ��ѧ����Ϣ");
			this.setBounds(350, 110,561, 495);
			this.setVisible(true);
		}
	   public void actionPerformed(ActionEvent e){
				if(e.getSource()==yes){	
					delt();
				}
				if(e.getSource()==cancle){
					this.dispose();
				}
		}
		private void delt(){
				XueHao  = text1.getText();
				scs.del(Integer.parseInt(XueHao));
				JOptionPane.showMessageDialog(this, "ɾ���ɹ�");
			}
	}
//�޸���Ϣ���棬���������ѧ�ţ����Ҹ�����Ϣ��ֱ�����ı������޸ģ�������ӹ��ܳ�����Ӹ�����Ϣ
	class XiuGai extends JFrame implements ActionListener{
		private JTextField numT, bianhaoT, mingchengT, xuefenT,pingshiT,shiyanT,juanmianT,sumT,numt,shidexuefenT ;
		private JButton b1,b2,b3;
		private String num,bianhao, mingcheng,xuefen,pingshi,shiyan,juanmian,sum,shidexuefen;
		public XiuGai(){
			Container c4 = this.getContentPane();
			c4.setLayout(new GridLayout(4, 1));//������岼��
			c4.setFont(new Font("true",Font.TRUETYPE_FONT,13));
			JPanel up = new JPanel();
			JPanel center1 = new JPanel();
			JPanel center2 = new JPanel(new GridLayout(5, 2));
			JPanel low = new JPanel();
			JLabel label11 = new JLabel("��Ҫ�޸ĵ�ѧ��");
			numT=new JTextField(15);
			up.add(label11);
			up.add(numT);
			c4.add(up);
			b1=new JButton("����");
			center1.add(b1);
			c4.add(center1);
			JLabel label21 = new JLabel("ѧ    ��", SwingConstants.CENTER);
			JLabel label22 = new JLabel("��    ��", SwingConstants.CENTER);
			JLabel label23 = new JLabel("��    ��  ", SwingConstants.CENTER);
			JLabel label24 = new JLabel("ѧ    ��", SwingConstants.CENTER);
			JLabel label25 = new JLabel("ƽ    ʱ", SwingConstants.CENTER);
			JLabel label26 = new JLabel("ʵ    ��", SwingConstants.CENTER);
			JLabel label27 = new JLabel("��    ��", SwingConstants.CENTER);
			JLabel label29 = new JLabel("ʵ    ��", SwingConstants.CENTER);
			JLabel label28 = new JLabel("��    ��",SwingConstants.CENTER);
			numt=new JTextField(22);
			bianhaoT=new JTextField(22);
			mingchengT=new JTextField(22);
			xuefenT=new JTextField(22);
			pingshiT=new JTextField(22);
			shiyanT=new JTextField(22);
			juanmianT=new JTextField(22);
			sumT=new JTextField(22);
			shidexuefenT=new JTextField(22);
			center2.add(label21);
			center2.add(numt);
			center2.add(label22);
			center2.add(bianhaoT);
			center2.add(label23);
			center2.add(mingchengT);
			center2.add(label24);
			center2.add(xuefenT);
			center2.add(label25);
			center2.add(pingshiT);
			center2.add(label26);
			center2.add(shiyanT);
			center2.add(label27);
			center2.add(juanmianT);
			center2.add(label28);
			center2.add(sumT);
			center2.add(label29);
			center2.add(shidexuefenT);
			c4.add(center2);
			b2=new JButton("�޸�");
			b3=new JButton("�˳�");
			low.add(b2);
			low.add(b3);
			c4.add(low);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			this.setTitle("�޸���Ϣ");
			this.setBounds(350, 110,561, 495);
			this.setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				for(int i=0;i<scs.al.size();i++){
					if(Integer.parseInt(numT.getText())==scs.al.get(i).getnum()){
						numt.setText(String.valueOf(scs.al.get(i).getnum()));
						bianhaoT.setText(String.valueOf(scs.al.get(i).getbianhao()));
						mingchengT.setText(String.valueOf(scs.al.get(i).getmingcheng()));
						xuefenT.setText(String.valueOf(scs.al.get(i).getxuefen()));
						pingshiT.setText(String.valueOf(scs.al.get(i).getpingshi()));
						shiyanT.setText(String.valueOf(scs.al.get(i).getshiyan()));
						juanmianT.setText(String.valueOf(scs.al.get(i).getjuanmian()));
						sumT.setText(String.valueOf(scs.al.get(i).getsum()));
						shidexuefenT.setText(String.valueOf(scs.al.get(i).getshidexuefen()));
					}
				}
			}
			if (e.getSource() == b2) {
				if (numt.getColumns() == 0 ||bianhaoT.getColumns() == 0
						|| mingchengT.getColumns() == 0 || xuefenT.getColumns() == 0|| pingshiT.getColumns() == 0
						|| shiyanT.getColumns() == 0 || juanmianT.getColumns() == 0||sumT.getColumns()==0||shidexuefenT.getColumns()==0)
					JOptionPane.showMessageDialog(this, "�������ȫ��Ϣ");
				else {		
					scs.del(Integer.parseInt(numT.getText()));
					Student a=new Student(Integer.toUnsignedLong(Integer.parseInt(numT.getText())),Integer.toUnsignedLong(Integer.parseInt(bianhaoT.getText())),mingchengT.getText(),
							Integer.parseInt(xuefenT.getText()),Integer.parseInt(pingshiT.getText()),Integer.parseInt(shiyanT.getText()),
							Integer.parseInt(juanmianT.getText()),Integer.parseInt(sumT.getText()),Integer.parseInt(shidexuefenT.getText()));
					scs.adds(a);
					JOptionPane.showMessageDialog(this, "�޸ĳɹ�");	
				}
			}
			if (e.getSource() == b3) {
				this.dispose();
			}
		}
	}
//��ѯ��Ϣ�����ڲ���,���������ѧ�ţ���arraylist�в��Ҷ�Ӧѧ�ŵ�ѧ����Ϣ���ֱ����
	class SIDFind extends JFrame implements ActionListener {
		private JTextField numT,numt,bianhaoT, mingchengT, xuefenT, pingshiT,shiyanT,juanmianT,sumT;
		private String num;
		private JButton b1, b2;
		public SIDFind() {
			Container con = this.getContentPane();
			con.setLayout(new BorderLayout());
			JLabel label1 = new JLabel("��ѯѧ����Ϣ", SwingConstants.CENTER);
			JLabel label0 = new JLabel("�������ѯ��ѧ��",SwingConstants.CENTER);
			b1 = new JButton("��ѯ");
			b1.addActionListener(this);
			JPanel p1 = new JPanel(new GridLayout(4,1));  //�������ֹ�����  p1  4��1��
			numT=new JTextField(5);
			p1.add(label1);
			p1.add(label0);
			p1.add(numT);
			p1.add(b1);
			con.add(p1,"North");
			JPanel p2 = new JPanel(new GridLayout(7,2));
			numt = new JTextField(10);
			bianhaoT = new JTextField(10);
			mingchengT= new JTextField(10);
			xuefenT = new JTextField(10);
			pingshiT = new JTextField(10);
			shiyanT= new JTextField(10);
			juanmianT = new JTextField(10);
			sumT = new JTextField(10);
			p2.add(new JLabel("ѧ    ��", SwingConstants.CENTER));
			p2.add(numt);
			p2.add(new JLabel("�γ̱��", SwingConstants.CENTER));
			p2.add(bianhaoT);
			p2.add(new JLabel("�γ�����", SwingConstants.CENTER));
			p2.add(mingchengT);
			p2.add(new JLabel("ѧ    ��", SwingConstants.CENTER));
			p2.add(xuefenT);
			p2.add(new JLabel("ƽʱ�ɼ�", SwingConstants.CENTER));
			p2.add(pingshiT);
			p2.add(new JLabel("ʵ��ɼ�", SwingConstants.CENTER));
			p2.add(shiyanT);
			p2.add(new JLabel("����ɼ�", SwingConstants.CENTER));
			p2.add(juanmianT);
			con.add(p2,"Center");
			JLabel label3 = new JLabel("          ");
			JLabel label4 = new JLabel();
			b2 = new JButton("�˳�");
			b2.addActionListener(this);
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			p3.add(label3);
			p4.add(label4);
			con.add(b2,"South");
			con.add(p3,"East");
			con.add(p4,"West");
			this.setVisible(true);
			this.setBounds(350, 110,561, 495);
		}
		public void actionPerformed(ActionEvent e){
				if (e.getSource() == b1) { 
						num= numT.getText();
						int k=0;
						for(int i=0;i<scs.al.size();i++)
						{
							if(Integer.parseInt(num)==scs.al.get(i).getnum())
							{	numt.setText(String.valueOf(scs.al.get(i).getnum()));
								bianhaoT.setText(String.valueOf(scs.al.get(i).getbianhao()));
								mingchengT.setText(String.valueOf(scs.al.get(i).getmingcheng()));
								xuefenT.setText(String.valueOf(scs.al.get(i).getxuefen()));
								pingshiT.setText(String.valueOf(scs.al.get(i).getpingshi()));
								shiyanT.setText(String.valueOf(scs.al.get(i).getshiyan()));
								juanmianT.setText(String.valueOf(scs.al.get(i).getjuanmian()));
								sumT.setText(String.valueOf(scs.al.get(i).getsum()));
								k=1;
							}
						}
						if(k==0){
							JOptionPane.showMessageDialog(this, "���޴���");//���û��¼������Ϣ�Ի�����ʾ
						}	
				}
				if (e.getSource() == b2) {
					this.dispose();
				}
		}
	}
	
	//ͳ�ƽ��棬��arraylist�����ж���������ܷ֣������ִܷӴﵽС����
	class Tongji extends JFrame implements ActionListener {
		private JButton b1,b2;
		JTextArea t;    //�����ı�����
		public Tongji() {
			Container c1 = this.getContentPane();
			c1.setLayout(new GridLayout(3, 1));
			JPanel p1 =new JPanel();
			JLabel label1 = new JLabel("ͳ����Ϣ", SwingConstants.CENTER);
			label1.setFont(new Font("true",Font.TRUETYPE_FONT,40));//���������С
			label1.setForeground(Color.blue);
			
			p1.add(label1);
			c1.add(p1);
			t=new JTextArea();
			JScrollPane scroll=new JScrollPane(t);//Ϊ�ı�������ӹ�����
			c1.add(scroll);
			JPanel p3=new JPanel();
			b1 = new JButton("ͳ��");
			b2 = new JButton("�˳�");
			p3.add(b1);
			p3.add(b2);
			c1.add(p3);
			this.setBounds(350, 110,561, 495);
			this.setVisible(true);
			b1.addActionListener(this);
			b2.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				scs.sum();
			    scs.sort();
			    String[] s=new String[100];
		        String s1="  ѧ��       �γ̱��       �γ�����       ѧ��       ƽʱ�ɼ�       ʵ��ɼ�      ����ɼ�       �ۺϳɼ�     ʵ��ѧ��";		       
			    for(int i=0;i<scs.al.size();i++) {
			    	 s[i]=scs.al.get(i).getnum()+"      "+scs.al.get(i).getbianhao()+"                    "+scs.al.get(i).getmingcheng()
		    			+"             "+scs.al.get(i).getxuefen()+"                  "+scs.al.get(i).getpingshi()+"             "
			    			 +scs.al.get(i).getshiyan()+"                "+scs.al.get(i).getjuanmian()+"                    "
		    			+scs.al.get(i).getsum()/6+"          "+scs.al.get(i).getshidexuefen();
			    }

			    for(int i=0;i<scs.al.size();i++) {
			    	s1=s1+"\n"+s[i];
			    }
			    t.append(s1);
			}
			if (e.getSource() == b2) {
				this.dispose();//�˳�
			}
		}
	}
}
