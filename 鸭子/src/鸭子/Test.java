package Ѽ��;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck m=new MallardDuck();//����������ָ�������Ͷ��󣬵������า�ǵķ���
		m.display();
		m.swim();
		m.peformQuack();
		m.performFly();
		System.out.println();
		//����ģ��Ѽ����
		Duck model=new ModelDuck();
		model.display();
		model.swim();
		model.performFly();
		model.setFlybehavior(new FlyRocketPowered());
		model.performFly();
		System.out.println();
		
		//������ƤѼ����
		Duck rubber=new RubberDuck();
		rubber.display();
		rubber.swim();
		rubber.performFly();
		rubber.peformQuack();
	}

}
