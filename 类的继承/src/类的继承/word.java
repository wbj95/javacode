package 类的继承;

public class word {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Dictionary xinhua=new Dictionary();
       System.out.println("页数："+xinhua.GetPage());
       System.out.println("词条数："+xinhua.GetDictionary());
       System.out.println("每页词条数："+xinhua.computerRatio());
       System.out.println(xinhua);//toString
	}

}
class Book{
	protected  int Page=300;//少写了int,如果写成private,子类将无法继承此数据
	public void SetPage(int Page){
		this.Page=Page;
	}
	public int GetPage(){
		return Page;
	}
}
class Dictionary extends Book{
	private int definitions =1000;
	public double computerRatio(){
		return definitions/Page;//当父类的Page是private类型时，Page要写成GetPage
	}
	public void SetDictionary(int definitions){
		this.definitions=definitions;
	}
	public int GetDictionary(){
		return definitions;
	}
}