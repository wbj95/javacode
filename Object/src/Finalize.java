
public class Finalize {
/*
 * finalize����ʲôʱ�����
 * 1.finalizeÿ��java������
 * 2.finalize����Ҫ����Ա���ã���ϵͳ�Զ�����
 * 3.java�������û�и�������ָ��������java����Ϊ�������ݣ��ȴ�GC����
 *    GC�ڻ���java����֮ǰ���Զ����øö��󷽷�
 *  finalize�Ǹö������Ͼ�Ҫ��������  
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         person p=new person();
         p=null;
         //����Աֻ�ܽ���������������������
         System.gc();
         //hashCold�������ض���Ĺ�ϣ��ֵ��java�����ڴ��ַ������ϣ�㷨�ó�int������ֵ
         Finalize f=new Finalize();
         
        System.out.println( f.hashCode());
	}

}
class person{
public void finalize() throws Throwable{
	System.out.println("��������");
	//�������ٴ�����ָ��Ķ��󣬸ö������������ݣ����ᱻ��������������
	person p2=this;
    }
}