package ����ģʽ;

public class Singleton {
		//����һ����̬��������¼Ψһʵ��
	private static Singleton uniqueInstace;
	
	//˽�й�����,ֻ��Singleton���ڲ��ܵ���
   private	Singleton(){}
   
   //ʵ��������
   //����
  /* public static Singleton getInstace(){
	   if(uniqueInstace==null){
		   uniqueInstace= new Singleton();
	   }
	   return uniqueInstace;
   }
   */
   
   /*
    * ʹ��ͬ���ķ�����������߳�����
    * ��ʹ�����ַ�����Ӱ��ִ��Ч��
    */
  /* public synchronized static Singleton getInstace(){
	   if(uniqueInstace==null){
		   uniqueInstace= new Singleton();
	   }
	   return uniqueInstace;
   }
   */
   
   /*
    * ʹ�á�����"����ʵ�����������ӳ�ʵ����������
    * ����
    */
   /*private static Singleton uniqueInstance = new Singleton(); 
   public static Singleton getInstance() { 
       return uniqueInstance; 
   }
   */
   
   
   /*
    * �� ˫�ؼ���������getInstace()�м���ʹ��ͬ��
    * �����������Դ�����ʹ�÷�����ʱ��ķ�
    */
   public  static Singleton getInstace(){
	   
	   if(uniqueInstace==null){
		   synchronized(Singleton.class){
			   if(uniqueInstace==null){
				   uniqueInstace= new Singleton();
			   }
			   }
		   }
		   
	   return uniqueInstace;
   }
}
