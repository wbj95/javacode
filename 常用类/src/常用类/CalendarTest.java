package ������;
//����
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class CalendarTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	//��ȡϵͳ��ǰ����
		Calendar c=Calendar.getInstance();
	//�鿴��ǰ���������ڼ�
		int i=c.get(Calendar.DAY_OF_WEEK);
		//int i1=c.get(7);���Ƽ�д7����Ϊ��������⣬���˿�����
		System.out.println(i);//�й��˵�������������˵ĵ�һ��
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		
		//��ȡ2008 08 08�����ڼ�
		
		//��ȡ2008 08 08������
		String str="2008,08,08";
		Date d=new SimpleDateFormat("yyy,MM,dd").parse(str);
		
		//����������2008 08 08 ������
		c.setTime(d);
		//��ȡ���ڼ�
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
	}

}
