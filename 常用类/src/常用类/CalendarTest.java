package 常用类;
//日历
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class CalendarTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	//获取系统当前日历
		Calendar c=Calendar.getInstance();
	//查看当前日历的星期几
		int i=c.get(Calendar.DAY_OF_WEEK);
		//int i1=c.get(7);不推荐写7，因为不容易理解，别人看不懂
		System.out.println(i);//中国人的星期日是外国人的第一天
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		
		//获取2008 08 08是星期几
		
		//获取2008 08 08的日历
		String str="2008,08,08";
		Date d=new SimpleDateFormat("yyy,MM,dd").parse(str);
		
		//该日历就是2008 08 08 的日历
		c.setTime(d);
		//获取星期几
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
	}

}
