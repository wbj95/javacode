package 闹着玩;
import static java.awt.BorderLayout.SOUTH;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;//导入所需的输入输出流：p225
import java.security.cert.PolicyQualifierInfo;
import java.util.ArrayList;
//定义学生类：李琳
class Student implements Serializable {//接口，Serialization:指对象通过写出描述自己状态的数值记录自己的行程
	
	private long num;          //定义学号
	private long bianhao;       //定义编号
	private String mingcheng;       //定义课程名称
	private int xuefen;   //定义学分
	private int pingshi;   //定义平时成绩
	private int shiyan;   //定义实验成绩
	private int juanmian;   //定义卷面成绩
	private int sum=0;    //定义总分
	private int shidexuefen;   //定义实得学分
	public Student() {//设置无参构造方法
		
	}
	public Student( long num, long bianhao,String mingcheng,int xuefen,int pingshi,int shiyan,int juanmian,int sum,int shidexuefen) {//数据初始化
		super();//调用父类的同名方法。必须放在首行
		this.num = num;//显式的使用this访问对象的num变量。
		this.bianhao = bianhao;
		this.mingcheng= mingcheng;
		this.xuefen = xuefen;
		this.pingshi= pingshi;
		this.shiyan=shiyan;
		this.juanmian = juanmian;
		this.sum=sum;
		this.shidexuefen=shidexuefen;
	}//定义若干构造方法:set,get,toString,其他
	public Student(String num2, int parseInt, int parseInt2, int parseInt3,
			int parseInt4, int parseInt5, int parseInt6) {
		// TODO 自动生成的构造函数存根
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
	public String toString() {//用字符串说明一下
		return "Student [num=" + num + ",bianhao=" + bianhao + ",mingcheng=" + mingcheng
				+ ", xuefen=" + xuefen +  " ,pingshi=" + pingshi
				+  ",shiyan=" + shiyan + "juanmian=" + juanmian + ", sum=" + sum
				+ ",shidexuefen=" + shidexuefen + ",]";
	}
}	
//创建学生管理类，实现成绩的增改删查：
class StuC {
	ArrayList <Student> al=new ArrayList<Student>();//ArrayList是一个变长对象数组，称为一个数组列表，泛型
	File file = new File("mydata.txt");//创建文件：绝对路径
	public void adds(Student s) {//
		al.add(s);	
		}//添加学生信息(String 类型)	
	public void del(int n) {//删除学号为n的数据
		for(int i=0;i<al.size();i++) {
			if(al.get(i).getnum()==n)
				al.remove(i);	
		}
	}
	public void sum() {//求总分
		for(int i=0;i<al.size();i++) {
	al.get(i).setsum(al.get(i).getpingshi()+al.get(i).getshiyan()+al.get(i).getjuanmian());
		}	
	}
	public void sort() {//排序
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
	
	public void paint() {//输出所有科目的分数
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
	}
	
	
	public String toString() {//用字符串描述
		return "StuC [al=" + al + "]";
	}
	public void stor() {//输出流
		ObjectOutputStream out = null;
		try {//可能出现异常的语句
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(al);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();//输出异常栈堆
		} catch (IOException e) {
			e.printStackTrace();//输出异常栈堆
		}
	}
	public void read() {//输入流：从流中读取数据：p223
		ObjectInputStream in = null;
		try {//可能出现异常的语句
			in = new ObjectInputStream(new FileInputStream(file));
			try {//可能出现异常的语句
				al = (ArrayList<Student>)in.readObject();
			} catch (ClassNotFoundException e) {//异常捕获处理
				al=null;
			}
			in.close();//关闭流
		} catch (FileNotFoundException e) {//异常捕获处理
			File file = new File("mydata.txt");//创建文件并指定其存储路径
		} catch (IOException e) {//异常捕获处理
			e.printStackTrace();//输出异常栈堆
		}
	}
	public Student find(int n) {//查找学号为n的学生信息
		for(int i=0;i<al.size();i++) {
			if(al.get(i).getnum()==n) {
				return al.get(i);
			}
		}
		return null;					//无信息，返回null
	}
}

//插入主界面图片：
class MyPanel extends JPanel {//继承JPanel
	Image img=Toolkit.getDefaultToolkit().getImage("d:\\nanyou.jpg");//用图片的绝对路径获取图片
	public void paint(Graphics g) {
		g.drawImage(img,0,0,this);//画图片
	}
}
class MyPanel1 extends JPanel {//插入登陆界面图片
	Image img=Toolkit.getDefaultToolkit().getImage("d:\\nanyou.jpg");
	public void paint(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
//登陆界面：
public class login extends JFrame {//继承
	private TextField f1;
	private TextField f2;//定义文本框
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;//定义文本按钮
	StuC scs=new StuC();//定义学生类
	public login() {//setBackground(new Color(20,56,225));
		Container cp=getContentPane();//获取容器,java中，组件不能直接添加到顶层容器，必须添加到内容面板上。
		cp.setLayout(new GridLayout(4,1));//设置布局管理为网格四行一列
		Label l1=new Label("用户名");//创建标签了l1，l2
		Label l2=new Label("密   码"); 
		Panel p1=new Panel();//创建平面面板，p1,p2,p3
		Panel p2=new Panel();
		Panel p3=new Panel();
		MyPanel1 p4=new MyPanel1();//创建插入图片平面p4
		f1=new TextField(10);//指定文本框的列宽
		f2=new TextField(10);
		b1=new JButton("教师登陆");//创建三个带文本的按钮b1，b2，b3
		b2=new JButton("学生登陆");
		b3=new JButton("退出登陆");
		p1.add(l1);//第一行添加label 1：将文本框，按钮，标签添加到面板上。
		p1.add(f1);
		p2.add(l2);
		p2.add(f2);
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		cp.add(p4);//面板p4，p1，p2，p3分别加入容器cp
		cp.add(p1);
		cp.add(p2);
		cp.add(p3);
		b1.addActionListener(new TeacherEnter());//添加按钮事件响应：为b1,b2,b3按钮注册事件监听器
		b2.addActionListener(new StudentEnter());
		b3.addActionListener(new Close());
	}
	class TeacherEnter implements ActionListener {//b1按钮：教师进入登陆响应：实现事件监听接口的类
		public void actionPerformed(ActionEvent e) {      //实现事件处理方法
         		if((f1.getText()).equals("1班")&&(f2.getText()).equals("123456")) {//如果教师登陆姓名：1班， 密码：123456	
         				scs.read();//初始化，从文件读入信息
         				TeacherMainForm  frame1 = new TeacherMainForm();//进入新建教师界面
         		}
             	else JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新登录！");//如果密码或者姓名错误：弹出窗口；对话框
		}
	}
	class StudentEnter implements ActionListener {//学生进入登陆响应b2按钮
		public void actionPerformed(ActionEvent e) {      
         		if((f1.getText()).equals("1班")&&(f2.getText()).equals("666666")) {//如果输入：姓名：1班，密码666666，
         				scs.read();//初始化，从文件读入信息
         				StudentMainForm  frame1 = new StudentMainForm();
         		}
             	else JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新登录！");//如果密码或者姓名错误，则弹出对话框：用户名或密码错误！提醒与警示
		}
	}
	
	class Close implements ActionListener {//关闭登陆按钮响应：b3“退出”按钮：
		public void actionPerformed(ActionEvent e) {
			JButton bt=(JButton)e.getSource();
			if(bt==b3) {
				System.exit(0);//退出
			}
		}
	}

	//教师登陆界面：
	class TeacherMainForm extends JFrame implements ActionListener{
	//
		JMenu mSystem=new JMenu("系统");//系统菜单
	    JMenuItem mExit=new JMenuItem("退出");
	    JMenuItem mSave=new JMenuItem("保存");
	    JMenu mHelp=new JMenu("帮助");//帮助菜单
	    JMenuItem mAbout=new JMenuItem("软件信息");
	    JMenuBar mBar=new JMenuBar();//菜单条
	    JPanel panel;
		JButton button1,button2,button3,button4,button5,button6;//按钮组件
		JLabel label,labelTitle,label1,label2,label3,label4,label5,label6;//标签组件
		  //添加背景
		ImageIcon 背景;//背景为整个界面的背景，通过添加图片设置为背景
	    Icon icon1,icon2,icon3,icon4,icon5,icon6;//按钮图标
	    Box basebox,boxV1,boxV2,boxV3,boxV4,boxV5,boxV6;//box组件
	    TeacherMainForm() {
	        super("教师界面 ");
//	        setSize(500,700);
//	        setLocation(2000,2000);
	        setSize(561,561);
	        setLocation(350,110);
	        mBar.add(mSystem);//将菜单添加到菜单条
	        mBar.add(mHelp);
	        mSystem.add(mSave);//为菜单添加菜单项目
	        mSystem.add(mExit);
	        mHelp.add(mAbout);
	        setJMenuBar(mBar);//设置菜单条
	        mExit.addActionListener(this);//为菜单按钮添加监听事件
	        mAbout.addActionListener(this);
	        mSave.addActionListener(this);
	        setVisible(true);
	        setResizable(true);
	        //添加背景，添加标题，设置按钮图标
	      		labelTitle=new JLabel("成绩管理系统");//添加标题
	      		Font font=new Font("华文行楷",
	      				Font.BOLD+Font.TRUETYPE_FONT+Font.LAYOUT_LEFT_TO_RIGHT,100);
	      		labelTitle.setFont(font);//为标题添加字体
	      		labelTitle.setForeground(new Color(0,0,139));
	      		背景 = new ImageIcon("C:/nanyou/you.jpg");//设置背景图片
	      		label = new JLabel(背景);
	      		label.setBounds(0, 0, 背景.getIconWidth()-1,背景.getIconHeight()-1);//设置成图片的大小
	      		this.getLayeredPane().setLayout(null);
	      		icon1=new ImageIcon("C:/nanyou/you2.jpg");//为按钮添加图片
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
	      		//设置按钮的解释文字的字体和颜色，并把按钮和其对应的文字说明用BoxLayout布局
	      		//设置为上下对其形式
	      		Font font1=new Font("华文行楷",
	      			Font.BOLD+Font.TRUETYPE_FONT+Font.LAYOUT_LEFT_TO_RIGHT,30);//设置字体
	      		label1=new JLabel("  查询");//标签注释按钮
	      		label2=new JLabel("  增加");
	      		label3=new JLabel("  删除");
	      		label4=new JLabel("  修改");
	      		label5=new JLabel("  统计");
	      		label6=new JLabel("  退出");
	      		label1.setFont(font1);//为标签设置字体
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
	      		
	      		label1.setForeground(new Color(255,250,250));//为标签设置颜色
	      		label2.setForeground(new Color(255,235,205));//为标签设置颜色
	      		label3.setForeground(new Color(255,228,225));//为标签设置颜色
	      		label4.setForeground(new Color(250,235,215));//为标签设置颜色
	      		label5.setForeground(new Color(255,245,238));//为标签设置颜色
	      		label6.setForeground(new Color(255,127,80));//为标签设置颜色
	      		
	      		boxV1=Box.createVerticalBox();    //完成一些盒式布局
	      		boxV2=Box.createVerticalBox();    
	      		boxV3=Box.createVerticalBox();
	      		boxV4=Box.createVerticalBox();	 
	      		boxV5=Box.createVerticalBox();
	      		boxV6=Box.createVerticalBox();
	      		boxV1.add(button1);
	      		boxV1.add(Box.createVerticalStrut(9));//设置垂直距离  
	      		boxV1.add(label1);
	      		boxV2.add(button2);
	      		boxV2.add(Box.createVerticalStrut(9));//设置垂直距离  
	      		boxV2.add(label2);
	      		boxV3.add(button3);
	      		boxV3.add(Box.createVerticalStrut(9));//设置垂直距离  
	      		boxV3.add(label3);
	      		boxV4.add(button4);
	      		boxV4.add(Box.createVerticalStrut(9));//设置垂直距离  
	      		boxV4.add(label4);
	      		boxV5.add(button5);
	      		boxV5.add(Box.createVerticalStrut(9));//设置垂直距离  
	      		boxV5.add(label5);
	      		boxV6.add(button6);
	      		boxV6.add(Box.createVerticalStrut(9));//设置垂直距离  
	      		boxV6.add(label6);
	      		basebox=Box.createHorizontalBox();
	      		basebox.add(boxV1);
	      		basebox.add(Box.createHorizontalStrut(1));//设置垂直距离  
	      		basebox.add(boxV2);
	      		basebox.add(Box.createHorizontalStrut(1));//设置垂直距离  
	      		basebox.add(boxV3);
	      		basebox.add(Box.createHorizontalStrut(1));//设置垂直距离  
	      		basebox.add(boxV4);
	      		basebox.add(Box.createHorizontalStrut(1));//设置垂直距离  
	      		basebox.add(boxV5);
	      		basebox.add(Box.createHorizontalStrut(1));//设置垂直距离  
	      		basebox.add(boxV6);
	      		
	      		add(basebox,SOUTH);
	      		JPanel p1 = new JPanel();
	      		
	      	    //添加背景，并把窗口大小设置为背景图片的大小
	    		panel = (JPanel) this.getContentPane();
	    		panel.setOpaque(false);
	    		FlowLayout f = new FlowLayout();
	    		panel.add(labelTitle);
	    		panel.setLayout(f);
	    		getLayeredPane().setLayout(null);
	    		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	    		setSize(背景.getIconWidth(), 背景.getIconHeight());
	    		setBounds(350, 150,背景.getIconWidth(),背景.getIconHeight());
	    		setVisible(true);
	    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    		
	    		button1.addActionListener(this);//为每个按钮设置监视器
	    		button2.addActionListener(this);
	    		button3.addActionListener(this);
	    		button4.addActionListener(this);
	    		button5.addActionListener(this);
	    		button6.addActionListener(this);
	      	}
	    
	      	public void actionPerformed(ActionEvent e) {//事件响应
	      		if(e.getSource()==mExit)//退出
	                System.exit(0);
	      		else if(e.getSource()==mSave)//保存
	                shutDown();
	            else if(e.getSource()==mAbout)//有关信息
	                JOptionPane.showMessageDialog(this,"学生成绩管理系统\n南京邮电大学\n管理学院\n工商管理" +			//信息内容
	                		"\n1班\n2017年4月","软件信息",JOptionPane.INFORMATION_MESSAGE);
	            else if(e.getSource()==button1)//当按下button1时，打开SIDFind()查找的窗口
	            	new SIDFind().setVisible(true);
	      		else if(e.getSource()==button2)//当按下button2时，打开AddFI()添加的窗口
	      			new AddFI().setVisible(true);
	      		else if(e.getSource()==button3)//当按下button1时，打开InterfaceDesign3删除的窗口
	      			new Delet().setVisible(true);
	      		else if(e.getSource()==button4)//打开修改窗口
	      			new XiuGai().setVisible(true);
	      		else if(e.getSource()==button5)//打开统计窗口
	      	          new Tongji().setVisible(true);
	      		else if(e.getSource()==button6)//退出
	      			 System.exit(0);
	      		}
	    }
	private void shutDown() {
		//保存
		scs.stor();			//调用方法
		JOptionPane.showMessageDialog(null, "信息已保存");
	}
	 public void main1(String[] args) {
		 //主方法
		 new  TeacherMainForm();
	    }
	 
    //学生登陆主界面：
    class StudentMainForm extends JFrame implements ActionListener {
	    JMenu mSystem=new JMenu("系统");//系统菜单
	    JMenuItem mExit=new JMenuItem("退出");
	    JMenu mQuery=new JMenu("成绩查询");   //成绩查询菜单
	    JMenuItem mSID=new JMenuItem("各科成绩");
	    JMenu mHelp=new JMenu("帮助");//帮助菜单
	    JMenuItem mAbout=new JMenuItem("软件信息");
	    JMenuBar mBar=new JMenuBar();
	    StudentMainForm() {
	        super("工管1班2016至2017学年学生期末成绩管理系统--学生界面");
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
	        mExit.addActionListener(this);//添加按钮事件监听
	        mAbout.addActionListener(this);
	        mSID.addActionListener(this);
	        setContentPane(new MyPanel());//创建平面
	        setVisible(true);
	        setResizable(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==mExit)//按钮事件响应
            System.exit(0);
        else if(ae.getSource()==mSID)
            new SIDFind().setVisible(true);
        else if(ae.getSource()==mAbout)
            JOptionPane.showMessageDialog(this,"学生成绩管理系统\n\n南京邮电大学\n管理学院\n财务管理\n10班\n" +
            		"2017年4月","软件信息",JOptionPane.INFORMATION_MESSAGE);        	
    }
    
    public void main(String[] args) {
        new StudentMainForm();
    }
}
    
//增加信息界面内部类，捕获文本框中信息创建Student对象，添加到Arraylist中，如果已存在该学号给出提示信息，并重新添加：陈玉
	class AddFI extends JFrame implements ActionListener {
		private JTextField numT, bianhaoT, mingchengT, xuefenT,pingshiT,shiyanT,juanmianT,sumT,shidexuefenT;//文本框组件
		private JButton b1, b2, b3;//按钮组件
		private String num,bianhao, mingcheng,xuefen,pingshi,shiyan,juanmian,sum,shidexuefen;
		public AddFI() {
			super("添加学生信息");
			Container con = this.getContentPane();//获取容器,java中，组件不能直接添加到顶层容器，必须添加到内容面板上。
			con.setLayout(new BorderLayout());
			JPanel P1 = new JPanel();//内容面板
			JPanel P2 = new JPanel();
			JPanel P3 = new JPanel(); 
			JLabel label2 = new JLabel("                       ");
			JLabel label3 = new JLabel("                       ");
			JPanel center = new JPanel(new GridLayout(9, 3));
			JPanel low = new JPanel(new FlowLayout());//布局安排
			JLabel label1 = new JLabel("添加学生信息", JLabel.CENTER);
			label1.setForeground(new Color(25,25,112));
			Font font=new Font("华文行楷",
      				Font.BOLD+Font.TRUETYPE_FONT+Font.LAYOUT_LEFT_TO_RIGHT,50);
      		label1.setFont(font);//为标题添加字体
			
			//label1.setFont(new Font("TRUE", Font.TRUETYPE_FONT, 30));//设置字体
			
			P1.add(label1);
			P2.add(label2);
			P3.add(label3);
			numT = new JTextField(4);//长度为4的文本框
			bianhaoT = new JTextField(4);
			mingchengT = new JTextField(4);
			xuefenT = new JTextField(4);
			pingshiT = new JTextField(4);
			shiyanT= new JTextField(4);
			juanmianT= new JTextField(4);
			sumT= new JTextField(4);
			shidexuefenT=new JTextField(4);
			center.add(new JLabel("学    号", JLabel.CENTER));//添加标签学号写在标签中间
			center.add(numT);//添加文本框
			center.add(new JLabel("课程编号", JLabel.CENTER));
			center.add(bianhaoT);
			center.add(new JLabel("课程名称", JLabel.CENTER));
			center.add(mingchengT);
			center.add(new JLabel("学    分", JLabel.CENTER));
			center.add(xuefenT);
			center.add(new JLabel("平时成绩", JLabel.CENTER));
			center.add(pingshiT);
			center.add(new JLabel("实验成绩", JLabel.CENTER));
			center.add(shiyanT);
			center.add(new JLabel("卷面成绩", JLabel.CENTER));
			center.add(juanmianT);
			center.add(new JLabel("综合成绩", JLabel.CENTER));
			center.add(sumT);
			center.add(new JLabel("实得学分",JLabel.CENTER));
			center.add(shidexuefenT);
   		    //center.setBackground( Color.LIGHT_GRAY);
			
			setBackground(new Color(175,238,238));
   		    
   		    
			b1 = new JButton("添加");
			b2 = new JButton("清除");
			b3 = new JButton("退出");
			low.add(b1);
			low.add(b2);
			low.add(b3);
			con.add(low,"South");//盒式布局
			con.add(center,"Center");
			con.add(P1,"North");
			con.add(P2,"East");
			con.add(P3,"West");
			b1.addActionListener(this);// 添加监听
			b2.addActionListener(this);
			b3.addActionListener(this);
			this.setBounds( 350, 110,561, 495);//组件的坐标和长宽度
			this.setVisible(true);
			this.setTitle("添加学生信息");
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				try {
					addFI();
				} catch (FileNotFoundException e1) {//捕获异常
					e1.printStackTrace();//在命令行打印异常信息在程序中出错的位置和原因
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
       
		private void addFI() throws FileNotFoundException, IOException {//添加方法抛出可能出现的文件和IO异常
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
				JOptionPane.showMessageDialog(this, "请添加完全信息");//如果输入信息不完全，跳出：重新输入
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
						JOptionPane.showMessageDialog(this, "添加成功");
					}
					else{
						JOptionPane.showMessageDialog(this, "已存在");	
					}
			}
		}
          //删除信息
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
//删除信息界面，通过输入的学号进行查找并在arraylist中移除
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
			JLabel label1 = new JLabel("删除学生信息",SwingConstants.CENTER);
			label1.setFont(new Font("true",Font.TRUETYPE_FONT,13));
			label1.setForeground(Color.red);
			c3.add(label1);
			JLabel label2 = new JLabel("请输入学号");
			text1 = new JTextField(10);
			p1.add(label2);
			p1.add(text1);
			c3.add(p1);
			
			yes = new JButton("确定");
			cancle = new JButton("退出");
			p2.add(yes);
			p2.add(cancle);
			c3.add(p2);
			yes.addActionListener(this);
			cancle.addActionListener(this);
			this.setTitle("删除学生信息");
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
				JOptionPane.showMessageDialog(this, "删除成功");
			}
	}
//修改信息界面，捕获输入的学号，查找该生信息，直接在文本框中修改，类似添加功能冲新添加该生信息
	class XiuGai extends JFrame implements ActionListener{
		private JTextField numT, bianhaoT, mingchengT, xuefenT,pingshiT,shiyanT,juanmianT,sumT,numt,shidexuefenT ;
		private JButton b1,b2,b3;
		private String num,bianhao, mingcheng,xuefen,pingshi,shiyan,juanmian,sum,shidexuefen;
		public XiuGai(){
			Container c4 = this.getContentPane();
			c4.setLayout(new GridLayout(4, 1));//设置面板布局
			c4.setFont(new Font("true",Font.TRUETYPE_FONT,13));
			JPanel up = new JPanel();
			JPanel center1 = new JPanel();
			JPanel center2 = new JPanel(new GridLayout(5, 2));
			JPanel low = new JPanel();
			JLabel label11 = new JLabel("需要修改的学号");
			numT=new JTextField(15);
			up.add(label11);
			up.add(numT);
			c4.add(up);
			b1=new JButton("查找");
			center1.add(b1);
			c4.add(center1);
			JLabel label21 = new JLabel("学    号", SwingConstants.CENTER);
			JLabel label22 = new JLabel("编    号", SwingConstants.CENTER);
			JLabel label23 = new JLabel("名    称  ", SwingConstants.CENTER);
			JLabel label24 = new JLabel("学    分", SwingConstants.CENTER);
			JLabel label25 = new JLabel("平    时", SwingConstants.CENTER);
			JLabel label26 = new JLabel("实    验", SwingConstants.CENTER);
			JLabel label27 = new JLabel("卷    面", SwingConstants.CENTER);
			JLabel label29 = new JLabel("实    得", SwingConstants.CENTER);
			JLabel label28 = new JLabel("总    和",SwingConstants.CENTER);
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
			b2=new JButton("修改");
			b3=new JButton("退出");
			low.add(b2);
			low.add(b3);
			c4.add(low);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			this.setTitle("修改信息");
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
					JOptionPane.showMessageDialog(this, "请添加完全信息");
				else {		
					scs.del(Integer.parseInt(numT.getText()));
					Student a=new Student(Integer.toUnsignedLong(Integer.parseInt(numT.getText())),Integer.toUnsignedLong(Integer.parseInt(bianhaoT.getText())),mingchengT.getText(),
							Integer.parseInt(xuefenT.getText()),Integer.parseInt(pingshiT.getText()),Integer.parseInt(shiyanT.getText()),
							Integer.parseInt(juanmianT.getText()),Integer.parseInt(sumT.getText()),Integer.parseInt(shidexuefenT.getText()));
					scs.adds(a);
					JOptionPane.showMessageDialog(this, "修改成功");	
				}
			}
			if (e.getSource() == b3) {
				this.dispose();
			}
		}
	}
//查询信息界面内部类,根据输入的学号，在arraylist中查找对应学号的学生信息，分别输出
	class SIDFind extends JFrame implements ActionListener {
		private JTextField numT,numt,bianhaoT, mingchengT, xuefenT, pingshiT,shiyanT,juanmianT,sumT;
		private String num;
		private JButton b1, b2;
		public SIDFind() {
			Container con = this.getContentPane();
			con.setLayout(new BorderLayout());
			JLabel label1 = new JLabel("查询学生信息", SwingConstants.CENTER);
			JLabel label0 = new JLabel("请输入查询的学号",SwingConstants.CENTER);
			b1 = new JButton("查询");
			b1.addActionListener(this);
			JPanel p1 = new JPanel(new GridLayout(4,1));  //创建布局管理器  p1  4行1列
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
			p2.add(new JLabel("学    号", SwingConstants.CENTER));
			p2.add(numt);
			p2.add(new JLabel("课程编号", SwingConstants.CENTER));
			p2.add(bianhaoT);
			p2.add(new JLabel("课程名称", SwingConstants.CENTER));
			p2.add(mingchengT);
			p2.add(new JLabel("学    分", SwingConstants.CENTER));
			p2.add(xuefenT);
			p2.add(new JLabel("平时成绩", SwingConstants.CENTER));
			p2.add(pingshiT);
			p2.add(new JLabel("实验成绩", SwingConstants.CENTER));
			p2.add(shiyanT);
			p2.add(new JLabel("卷面成绩", SwingConstants.CENTER));
			p2.add(juanmianT);
			con.add(p2,"Center");
			JLabel label3 = new JLabel("          ");
			JLabel label4 = new JLabel();
			b2 = new JButton("退出");
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
							JOptionPane.showMessageDialog(this, "查无此人");//如果没有录入者信息对话框提示
						}	
				}
				if (e.getSource() == b2) {
					this.dispose();
				}
		}
	}
	
	//统计界面，对arraylist中所有对象进行求总分，并按总分从达到小排序
	class Tongji extends JFrame implements ActionListener {
		private JButton b1,b2;
		JTextArea t;    //定义文本区域
		public Tongji() {
			Container c1 = this.getContentPane();
			c1.setLayout(new GridLayout(3, 1));
			JPanel p1 =new JPanel();
			JLabel label1 = new JLabel("统计信息", SwingConstants.CENTER);
			label1.setFont(new Font("true",Font.TRUETYPE_FONT,40));//设置字体大小
			label1.setForeground(Color.blue);
			
			p1.add(label1);
			c1.add(p1);
			t=new JTextArea();
			JScrollPane scroll=new JScrollPane(t);//为文本区域添加滚动条
			c1.add(scroll);
			JPanel p3=new JPanel();
			b1 = new JButton("统计");
			b2 = new JButton("退出");
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
		        String s1="  学号       课程编号       课程名称       学分       平时成绩       实验成绩      卷面成绩       综合成绩     实得学分";		       
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
				this.dispose();//退出
			}
		}
	}
}
