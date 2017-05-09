package equals;
/*
 * ����Object�е�equals����
 * Object�е�equals����   ʵ�֣�
 *    public boolean equals(Object obj){
 *        return (this==obj);
 *        }
 *     o1.equals(o2) ��o1��this��o2��obj
 *     ==��������������������ͣ��Ƚ��ڴ��ַ
 *     java�����е�equals������Ƶ�Ŀ�ģ��ж����������Ƿ����
 */
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Object o1=new Object();
        Object o2=new Object();
        boolean b1=o1.equals(o2);
        System.out.println(o1==o2);//false
        System.out.println(b1);//false
        Start s1=new Start(100,"����");
        Start s2=new Start(100,"����");
        Start s3=new Start(100,"����");
        System.out.println(s1==s2);//false
        System.out.println(s1.equals(s2));//true
        System.out.println(s2.equals(s3));//
	}

}
class Start{
	int id;
	String name;
	public Start(int id,String name){
		this.id=id;
		this.name=name;
	}
	 public boolean equals(Object obj){
		 if(this==obj) return true;
		      if(obj instanceof Start){
		    	  Start s=(Start)obj;
		    if(s.id==id&&s.name.equals(name)){//java�е��ַ����Ƚϣ�������"==",Ӧ�õ���equals����
		    	return true;
		    }
		    	  
		}
		      return false;
    }
}

/*
 * ����ʵ���߼��У���Ӧ�ñȽ��ڴ��ַ��Ӧ�ñȽ�����
 * ����Object�е�equals����   ҲҪ��д
 * ��������涨����д�����涨��������֤��һ�£�����һ�£��������ͬһ����
 */
