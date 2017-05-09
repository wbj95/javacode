package 闹着玩;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
public class test1 extends JFrame implements ActionListener
{
    private Calendar cal= Calendar.getInstance();
    private String [] str = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    private DefaultTableModel dtm = new DefaultTableModel(null,str);
    private JTable table = new JTable(dtm);                  //装日期的表格
    private JScrollPane sp = new JScrollPane(table);
    private JButton bLastYear = new JButton("上一年");
    private JButton bNextYear = new JButton("下一年");
    private JButton bLastMonth = new JButton("上月");
    private JButton bNextMonth = new JButton("下月");
    private JTextField Year = new JTextField(4);//jtfYear年份显示和输入文本
    private JLabel jla=new JLabel("年");
    private JTextField month = new JTextField(4);
    private JLabel jla1=new JLabel("月");
    private JTextField jtfMonth = new JTextField(2);//jtfMonth月份显示文本框
    private JPanel p1 = new JPanel();               //装入控制日期按钮的模块
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel(new BorderLayout());
    private JPanel p4 = new JPanel(new GridLayout(2,1));
    private JPanel p5 = new JPanel(new BorderLayout());
    private JLabel l = new JLabel("文本框中可直接键入要查找的年份,以提高查询效率");
    private JLabel lt = new JLabel();
    private int lastTime;
    
    public test1()
    {
        super("万年历"); //框架命名
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭函数
        this.getContentPane().setLayout(new BorderLayout(10, 0));
        
        table.setGridColor(Color.GRAY);    //星期之间的网格线是灰色的
        table.setColumnSelectionAllowed(true);
        table.setSelectionBackground(Color.BLACK);//当选定某一天时这一天背景黑色
        table.setSelectionForeground(Color.GREEN);//选定的日期字体是绿色的
        table.setBackground(new Color(184,207,229));//日期显示表格颜色浅蓝色
        table.setFont(new Font("黑体",Font.BOLD,24));//日期数字字体格式
        table.setRowHeight(30);//表格的高度
        
        Year.addActionListener(this);//可输入年份的文本框
        month.addActionListener(this);//可输入年份的文本框
         //为各个按钮添加监听函数
        bLastYear.addActionListener(this);
        bNextYear.addActionListener(this);
        bLastMonth.addActionListener(this);
        bNextMonth.addActionListener(this);
        //将按钮添加到Jpanel上
        
        p1.add(bLastYear); 
        p1.add(Year);//年份输入文本框      
        p1.add(jla);
        p1.add(month);//年份输入文本框      
        p1.add(jla1);
        p1.add(bNextYear);
        p1.add(bLastMonth);
        p1.add(jtfMonth);
        p1.add(bNextMonth);
        p3.add(p2, BorderLayout.SOUTH);
        p4.add(l);
        p4.add(lt);
        p5.add(p4, BorderLayout.SOUTH);
        p5.add(sp, BorderLayout.CENTER);
        p5.add(p1, BorderLayout.NORTH);
        
        this.getContentPane().add(p5, BorderLayout.CENTER);
        this.getContentPane().add(p3, BorderLayout.EAST);
     
        String [] strDate = DateFormat.getDateInstance().format(new Date()).split("-");//获得日期
        cal.set(Integer.parseInt(strDate[0]), Integer.parseInt(strDate[1])-1, 0);
        showCalendar(Integer.parseInt(strDate[0]), Integer.parseInt(strDate[1]), cal);
        jtfMonth.setEditable(false);//设置月份的文本框为不可编辑
        Year.setText(strDate[0]);
       month.setText(strDate[1]);
        jtfMonth.setText(strDate[1]);
        new Timer(lt).start();
        this.setBounds(200,200,600,320);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public void showCalendar(int localYear, int localMonth, Calendar cld)
    {
        int Days = getDaysOfMonth(localYear, localMonth) + cld.get(Calendar.DAY_OF_WEEK) - 2;
        Object [] ai = new Object[7];
        lastTime = 0;
        for (int i = cld.get(Calendar.DAY_OF_WEEK)-1; i <= Days; i++)
        {
            ai[i%7] = String.valueOf(i-(cld.get(Calendar.DAY_OF_WEEK)-2));
            if (i%7 == 6)
            {
                dtm.addRow(ai);
                ai = new Object[7];
                lastTime++;
            }
        }
        dtm.addRow(ai);
    }
    
    public int getDaysOfMonth(int year, int Month)   //显示所选月份的天数
    {
        if(Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12)
        {
            return 31;
        }
        if(Month == 4 || Month == 6 || Month == 9 || Month == 11)
        {
            return 30;
        }
        if(year%4 == 0 && year%100 != 0 || year%400 == 0)//闰年
        {
            return 29;
        }
        else
        {
            return 28;
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == Year || e.getSource() == bLastYear || e.getSource() == bNextYear ||
                e.getSource() == bLastMonth || e.getSource() == bNextMonth)
        {
            int m, y;
            try//控制输入的年份正确，异常控制
            {
             if (Year.getText().length() != 4)
                {
                    throw new NumberFormatException();
                }
                y = Integer.parseInt(Year.getText());
                m = Integer.parseInt(jtfMonth.getText());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "请输入4位0-9的数字！", "年份有误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < lastTime+1; i++){ dtm.removeRow(0);}
            if(e.getSource() == bLastYear){ Year.setText(String.valueOf(--y)); }
            if(e.getSource() == bNextYear){Year.setText(String.valueOf(++y)); }
            if(e.getSource() == bLastMonth)
            {
                if(m == 1)
                	
                {
                    Year.setText(String.valueOf(--y));
                    m = 12;
                    jtfMonth.setText(String.valueOf(m));
                    
                }
                else
                {
                    jtfMonth.setText(String.valueOf(--m));
                }
            }
            if(e.getSource() == bNextMonth)
            {
                if(m == 12)
                {
                    Year.setText(String.valueOf(++y));
                    m = 1;
                    jtfMonth.setText(String.valueOf(m));
                }
                else
                {
                    jtfMonth.setText(String.valueOf(++m));
                }
            }
            cal.set(y, m-1, 0);
            showCalendar(y, m, cal);
            month.setText(String.valueOf(m));
        }
        }
  
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new test1();
    }
}

class Timer extends Thread//显示系统时间
{
    private JLabel lt;
    private SimpleDateFormat fy = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
    private SimpleDateFormat fn = new SimpleDateFormat("yyyy.MM.dd G 'at' HH mm ss z");
    private boolean b = true;
    
    public Timer(JLabel lt)
    {
        this.lt = lt;
    }
    
    public void run()
    {
        while (true)
        {
            try
            {
                if (b)
                {
                    lt.setText(fy.format(new Date()));
                }
                else
                {
                    lt.setText(fn.format(new Date()));
                }
                b = !b;
                Timer.sleep(500);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}