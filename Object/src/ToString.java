
public class ToString{
/*
 * ����Object�е�toString����
 *   SUN��Object�������toString��Ŀ�ģ�����java������ַ�����ʾ
 *   ����ʵ�У�Object��toString�����Ѿ��������ˣ�����Object��toString�ķ���ʵ�ֲ�����
 *   Object��toString����Ҫ����д
 *   SUN������ʵ��toString
 *   public String toString(){
 *   return getClass().getName()+"@"+Integer.toHexString(hashCode());
 *   Object toString�������� ������ @ java������ڴ��ַ������ϣ�㷨�ó���int����
 *                            ֵת����ʮ�����ƣ�������Ե�ͬ����java�����ڶ����ڴ��ַ
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ��Object���Ͷ���
       Object o1=new Object();
       //����toString
       String s1=o1.toString();
       //���
       System.out.println(s1);//java.lang.Object@2a139a55
       //����һ��Person���͵Ķ���
       Person1 o2=new Person1("����",50);//Person[name=����,age=50]
       //����toString
       String s2=o2.toString();
       System.out.println(s2);//Person@15db9742
       Person1 o3=new Person1("����",110);
       String s3=o3.toString();
       System.out.println(s3.toString());//Person[name=����,age=110]
       //���print�������������Ǹ��������ͣ���Ĭ�ϵ����������͵�toString����
       System.out.println(s3);//Person[name=����,age=110]
       
	}

}
class Person1{
	String name;
	int age;
	Person1(String name,int age){
		this.name=name;
		this.age=age;
	}
  //��дtoString������������Ŀ���������������涨����ʾ��ʽ��Person[name=ĳĳ��age=xx]
    public String toString(){
	return "Person[name="+name+",age="+age+"]";
    }
}