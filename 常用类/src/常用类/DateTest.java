package ������;
//��ȡ�ض�������
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class DateTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
			String Strtime="2008��08��08��  08:08:08 888";
			//��String����ת������������DAte
			//String-->Date
			
			//1.�������ڸ�ʽ������
			SimpleDateFormat sdf=new SimpleDateFormat("yyy��MM��dd��  HH:mm:ss SSS");
			
				Date t=sdf.parse(Strtime);
			
			System.out.println(t);////Fri Aug 08 08:08:08 CST 2008
	}
}
