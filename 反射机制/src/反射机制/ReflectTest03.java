package �������;
import java.text.SimpleDateFormat;
//��ȡClass���Ͷ���֮�󣬾Ϳ��Դ����������
import java.util.Date;
public class ReflectTest03 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
	Class c=	Class.forName("�������.Employee");
	
	Object o=c.newInstance();//������ Class ��������ʾ�����һ����ʵ����������Employee���޲������췽��
	
	System.out.println(o);//�Զ�����O��toString�������������.Employee@2a139a55
	
	Class c1=Class.forName("java.util.Date");
	Object o1=c1.newInstance();
	
	if(o1 instanceof Date)
	{
		Date t=(Date)o1;
		//2016-05-14 15:24;00 301
		//��ȡϵͳ��ǰʱ��
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm;ss SSS").format(t));
	}
	}
}
