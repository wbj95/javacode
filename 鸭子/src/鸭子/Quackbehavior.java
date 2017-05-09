package 鸭子;

public interface Quackbehavior {//叫的行为
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