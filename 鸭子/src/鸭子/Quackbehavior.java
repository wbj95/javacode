package Ѽ��;

public interface Quackbehavior {//�е���Ϊ
		public void quack();
}
 class Quack implements Quackbehavior{
	public void quack(){
		System.out.println("quack");
	}
}
 class Squack implements Quackbehavior{
	 public void quack(){
		 System.out.println("squack");
	 }
 }
 class MuteQuack implements Quackbehavior{
	 public void quack()
	 {
		 System.out.println("can not quack");
	 }
 }