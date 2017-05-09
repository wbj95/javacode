package 多线程;
/*
 *     异步编程模型：t1线程执行t1的，t2线程执行t2的，两个线程谁都不等谁
 *     同步编程模型：t1线程和t2线程执行，当t1线程必须等t2线程执行结束之后，t1线程才能执行
 *     什么时候要同步？为什么要引入线程同步呢？
 *     1.为了数据的安全，尽管应用程序的使用率降低，但是为了保证数据是安全的，必须加入线程同步，
 *       线程同步机制使程序变成了（等同）单线程
 *       2. 什么条件下使用线程同步？
 *         第一：必须是多线程环境
 *         第二：多线程环境共享同一个数据
 *         第三：共享的数据涉及到修改操作
 */			
public class ThreadTest06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建公共账户
		Account act=new Account("101",5000);
		processor p=new processor(act);
		//创建线程对同一账户取款
		Thread t1=new Thread(p);
		Thread t2=new Thread(p);
		t1.start();
		t2.start();
	}
}
//取款线程
class processor implements Runnable{
	//账户
	Account acc;
	//Constructor
	processor(Account acc){
		this.acc=acc;
	}
	
	public void run(){
		for(int i=0;i<100;i++){
		acc.withDraw(10);
		System.out.println(Thread.currentThread().getName()+"取款10，余额："+acc.getBalance());
		}
	}
}
//账户
class Account{
	private String no;//账户号码
	private double balance;//账户余额
	
	//构造方法
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
	
	//提供一个取款方法
	//public synchronized void withDraw(double money){
	//synchronized关键字添加到成员方法上，线程拿走的是this对象锁（不提倡这样用）
	public void withDraw(double money){
		/*
		 * 把需要同步的代码，放到同步语句块中。
		 * 
		 * 原理：t1和t2
		 * t1线程执行到此处，遇到synchronized关键字，就会去找this的对象锁
		 * 如果找到this对象锁，则进入同步语句块中执行程序，当同步语句块的代码执行结束，
		 * t1线程归还this的对象锁
		 * 
		 * 在t1线程执行同步语句块的过程中，如果t2线程也过来执行以下代码，也遇到
		 * synchronized关键字，所以也去找this的对象锁，但是该对象锁被t1程序保持有，只能等待this对象归还
		 */
		
		synchronized(this){
		double after =balance-money;
		try {
			Thread.sleep(1000);//切换线程，暂停一秒
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setBalance(after);//更新
	
		}
	}
}