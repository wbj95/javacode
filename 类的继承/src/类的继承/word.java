package ��ļ̳�;

public class word {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Dictionary xinhua=new Dictionary();
       System.out.println("ҳ����"+xinhua.GetPage());
       System.out.println("��������"+xinhua.GetDictionary());
       System.out.println("ÿҳ��������"+xinhua.computerRatio());
       System.out.println(xinhua);//toString
	}

}
class Book{
	protected  int Page=300;//��д��int,���д��private,���ཫ�޷��̳д�����
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
		return definitions/Page;//�������Page��private����ʱ��PageҪд��GetPage
	}
	public void SetDictionary(int definitions){
		this.definitions=definitions;
	}
	public int GetDictionary(){
		return definitions;
	}
}