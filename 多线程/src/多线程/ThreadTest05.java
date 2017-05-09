package ∂‡œﬂ≥Ã;

public class ThreadTest05 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		p5 p=new p5();
		Thread t=new Thread(p);
		
		t.setName("t");
		
		t.start();
		
		t.sleep(5000);//5s÷’÷π
		
		p.run=false;
	}

}
class p5 implements Runnable{
	boolean run=true;
	public void run(){
		
		for(int i=0;i<10;i++){
			if(run){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"---->"+i);
			}else{
				return;
			}
		}
	}
}