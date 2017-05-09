package 鸭子;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck m=new MallardDuck();//父类型引用指向子类型对象，调用子类覆盖的方法
		m.display();
		m.swim();
		m.peformQuack();
		m.performFly();
		System.out.println();
		//创建模型鸭对象
		Duck model=new ModelDuck();
		model.display();
		model.swim();
		model.performFly();
		model.setFlybehavior(new FlyRocketPowered());
		model.performFly();
		System.out.println();
		
		//创建橡皮鸭对象
		Duck rubber=new RubberDuck();
		rubber.display();
		rubber.swim();
		rubber.performFly();
		rubber.peformQuack();
	}

}
