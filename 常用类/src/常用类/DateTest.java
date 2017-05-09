package 常用类;
//获取特定的日期
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class DateTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
			String Strtime="2008年08月08日  08:08:08 888";
			//将String日期转换成日期类型DAte
			//String-->Date
			
			//1.创建日期格式化对象
			SimpleDateFormat sdf=new SimpleDateFormat("yyy年MM月dd日  HH:mm:ss SSS");
			
				Date t=sdf.parse(Strtime);
			
			System.out.println(t);////Fri Aug 08 08:08:08 CST 2008
	}
}
