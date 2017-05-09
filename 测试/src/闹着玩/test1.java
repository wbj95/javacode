package ������;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
public class test1 extends JFrame implements ActionListener
{
    private Calendar cal= Calendar.getInstance();
    private String [] str = {"����һ", "���ڶ�", "������", "������", "������", "������", "������"};
    private DefaultTableModel dtm = new DefaultTableModel(null,str);
    private JTable table = new JTable(dtm);                  //װ���ڵı��
    private JScrollPane sp = new JScrollPane(table);
    private JButton bLastYear = new JButton("��һ��");
    private JButton bNextYear = new JButton("��һ��");
    private JButton bLastMonth = new JButton("����");
    private JButton bNextMonth = new JButton("����");
    private JTextField Year = new JTextField(4);//jtfYear�����ʾ�������ı�
    private JLabel jla=new JLabel("��");
    private JTextField month = new JTextField(4);
    private JLabel jla1=new JLabel("��");
    private JTextField jtfMonth = new JTextField(2);//jtfMonth�·���ʾ�ı���
    private JPanel p1 = new JPanel();               //װ��������ڰ�ť��ģ��
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel(new BorderLayout());
    private JPanel p4 = new JPanel(new GridLayout(2,1));
    private JPanel p5 = new JPanel(new BorderLayout());
    private JLabel l = new JLabel("�ı����п�ֱ�Ӽ���Ҫ���ҵ����,����߲�ѯЧ��");
    private JLabel lt = new JLabel();
    private int lastTime;
    
    public test1()
    {
        super("������"); //�������
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ڹرպ���
        this.getContentPane().setLayout(new BorderLayout(10, 0));
        
        table.setGridColor(Color.GRAY);    //����֮����������ǻ�ɫ��
        table.setColumnSelectionAllowed(true);
        table.setSelectionBackground(Color.BLACK);//��ѡ��ĳһ��ʱ��һ�챳����ɫ
        table.setSelectionForeground(Color.GREEN);//ѡ����������������ɫ��
        table.setBackground(new Color(184,207,229));//������ʾ�����ɫǳ��ɫ
        table.setFont(new Font("����",Font.BOLD,24));//�������������ʽ
        table.setRowHeight(30);//���ĸ߶�
        
        Year.addActionListener(this);//��������ݵ��ı���
        month.addActionListener(this);//��������ݵ��ı���
         //Ϊ������ť��Ӽ�������
        bLastYear.addActionListener(this);
        bNextYear.addActionListener(this);
        bLastMonth.addActionListener(this);
        bNextMonth.addActionListener(this);
        //����ť��ӵ�Jpanel��
        
        p1.add(bLastYear); 
        p1.add(Year);//��������ı���      
        p1.add(jla);
        p1.add(month);//��������ı���      
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
     
        String [] strDate = DateFormat.getDateInstance().format(new Date()).split("-");//�������
        cal.set(Integer.parseInt(strDate[0]), Integer.parseInt(strDate[1])-1, 0);
        showCalendar(Integer.parseInt(strDate[0]), Integer.parseInt(strDate[1]), cal);
        jtfMonth.setEditable(false);//�����·ݵ��ı���Ϊ���ɱ༭
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
    
    public int getDaysOfMonth(int year, int Month)   //��ʾ��ѡ�·ݵ�����
    {
        if(Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12)
        {
            return 31;
        }
        if(Month == 4 || Month == 6 || Month == 9 || Month == 11)
        {
            return 30;
        }
        if(year%4 == 0 && year%100 != 0 || year%400 == 0)//����
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
            try//��������������ȷ���쳣����
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
                JOptionPane.showMessageDialog(this, "������4λ0-9�����֣�", "�������", JOptionPane.ERROR_MESSAGE);
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

class Timer extends Thread//��ʾϵͳʱ��
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