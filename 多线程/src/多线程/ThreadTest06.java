package ���߳�;
/*
 *     �첽���ģ�ͣ�t1�߳�ִ��t1�ģ�t2�߳�ִ��t2�ģ������߳�˭������˭
 *     ͬ�����ģ�ͣ�t1�̺߳�t2�߳�ִ�У���t1�̱߳����t2�߳�ִ�н���֮��t1�̲߳���ִ��
 *     ʲôʱ��Ҫͬ����ΪʲôҪ�����߳�ͬ���أ�
 *     1.Ϊ�����ݵİ�ȫ������Ӧ�ó����ʹ���ʽ��ͣ�����Ϊ�˱�֤�����ǰ�ȫ�ģ���������߳�ͬ����
 *       �߳�ͬ������ʹ�������ˣ���ͬ�����߳�
 *       2. ʲô������ʹ���߳�ͬ����
 *         ��һ�������Ƕ��̻߳���
 *         �ڶ������̻߳�������ͬһ������
 *         ����������������漰���޸Ĳ���
 */			
public class ThreadTest06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������˻�
		Account act=new Account("101",5000);
		processor p=new processor(act);
		//�����̶߳�ͬһ�˻�ȡ��
		Thread t1=new Thread(p);
		Thread t2=new Thread(p);
		t1.start();
		t2.start();
	}
}
//ȡ���߳�
class processor implements Runnable{
	//�˻�
	Account acc;
	//Constructor
	processor(Account acc){
		this.acc=acc;
	}
	
	public void run(){
		for(int i=0;i<100;i++){
		acc.withDraw(10);
		System.out.println(Thread.currentThread().getName()+"ȡ��10����"+acc.getBalance());
		}
	}
}
//�˻�
class Account{
	private String no;//�˻�����
	private double balance;//�˻����
	
	//���췽��
	Account(){}
	Account(String no,double balance){
		this.no=no;
		this.balance=balance;
	}

	//setter and getter
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//�ṩһ��ȡ���
	//public synchronized void withDraw(double money){
	//synchronized�ؼ�����ӵ���Ա�����ϣ��߳����ߵ���this�����������ᳫ�����ã�
	public void withDraw(double money){
		/*
		 * ����Ҫͬ���Ĵ��룬�ŵ�ͬ�������С�
		 * 
		 * ԭ��t1��t2
		 * t1�߳�ִ�е��˴�������synchronized�ؼ��֣��ͻ�ȥ��this�Ķ�����
		 * ����ҵ�this�������������ͬ��������ִ�г��򣬵�ͬ������Ĵ���ִ�н�����
		 * t1�̹߳黹this�Ķ�����
		 * 
		 * ��t1�߳�ִ��ͬ������Ĺ����У����t2�߳�Ҳ����ִ�����´��룬Ҳ����
		 * synchronized�ؼ��֣�����Ҳȥ��this�Ķ����������Ǹö�������t1���򱣳��У�ֻ�ܵȴ�this����黹
		 */
		
		synchronized(this){
		double after =balance-money;
		try {
			Thread.sleep(1000);//�л��̣߳���ͣһ��
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setBalance(after);//����
	
		}
	}
}