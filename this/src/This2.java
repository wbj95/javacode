
public class This2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Data c=new Data();
         System.out.println("year:"+c.year+"\n"+"month:"+c.month+"\n"+"day:"+c.day);
	}

}
class Data{
	int year;
	int month;
	int day;
	Data(){
		this(1995,2,5);
	}
	Data(int _year,int _month,int _day){
		year=_year;
		month=_month;
		day=_day;
	}
}//this(ʵ��
//ͨ��һ�����췽��ȥ������һ�����췽��)
//Ŀ�ģ���������
//this(ʵ��)��������ڹ��췽���ĵ�һ��