package 常用类;
import java.util.Date;
import java.text.SimpleDateFormat;
public class 日期类 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获取系统当前时间
		Date nowTime=new Date();
		
		System.out.println(nowTime);//Thu Nov 19 17:13:11 CST 2015
		//以上程序说明java.util.Date已经重写了Object中的toString方法
		//只不过重写的方法对中国人不容易理解
		
		//所以引用了“格式化”日期
		//java.util.Date-->String
		
		//创建日期格式化对象
		//SimpleDateFormat(String pattern) 
		SimpleDateFormat s=new SimpleDateFormat("yyy年MM月dd日 HH:mm:ss SSS");
		/*
		 * y  年  Year  1996; 96  
	M  年中的月份  Month  July; Jul; 07  
	w  年中的周数  Number  27  
	W  月份中的周数  Number  2  
	D  年中的天数  Number  189  
	d  月份中的天数  Number  10  
	F  月份中的星期  Number  2  
	E  星期中的天数  Text  Tuesday; Tue  
	a  Am/pm 标记  Text  PM  
	H  一天中的小时数（0-23）  Number  0  
	k  一天中的小时数（1-24）  Number  24  
	K  am/pm 中的小时数（0-11）  Number  0  
	h  am/pm 中的小时数（1-12）  Number  12  
	m  小时中的分钟数  Number  30  
	s  分钟中的秒数  Number  55  
	S  毫秒数  Number  978  
	z  时区  General time zone  Pacific Standard Time; PST; GMT-08:00  
	Z  时区  RFC 822 time zone  -0800  

		 */
		//开始格式化（Date-->String）
		String StrTime=s.format(nowTime);
		System.out.println(StrTime);//2015年11月19日 17:13:11 412
	}

}
