package 星巴克咖啡;
//综合咖啡
public class HouseBlend extends Beverage{
	HouseBlend(){//不管怎么样一定要记得写构造方法
		description="HouseBlend";//description已经继承过来
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 0.89;
	}
	
}
