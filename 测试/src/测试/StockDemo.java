package 测试;
import java.util.Scanner;
class Products {
	private String ID,name;
	private int kucun;
	public Products(){
		ID="null";
		name="null";
		kucun=0;
	}
	public Products(String ID,String name,int kucun){
		this.ID=ID;
		this.name=name;
		this.kucun=kucun;
	}
	public String getID(){return ID;}
	public String getName(){return name;}
	public int getKucun(){return kucun;}
	public void increaseQuantity(){}
	public void SellOne(){kucun--;}
	public void setID(String ID){this.ID=ID;}
	public void setName(String name){this.name=name;}
	public void setKucun(int kucun){this.kucun=kucun;}
	public void addKucun(int increase){kucun+=increase;}
	public boolean searchID(String id1){
		if(ID==id1) return true;
		else return false;
	}
	
	public boolean searchName(String name1){
		if(name==name1) return true;
		else return false;
	}
}
class StockManager {
	private Products[] p=new Products[50];//
	private int length;
	public StockManager(){
		p[0]=new Products("0001","Mini",3);
		length++;
	}
	public void printProductDetails(){
		if(length==0) System.out.println("没有此产品！");
		else{
		for(int i=0;i<length;i++)
			if(p[i]!=null){
				//输出产品信息
			System.out.println("Name:"+(p[i]).getName()+
				"  ID:"+p[i].getID()+"    Kucun:"+p[i].getKucun());
			}
			else break;
		}
	}
	void addProducts(Products pd){
		int flag=0;//标记
		if(length==0){
			p[0]=new Products(pd.getID(),pd.getName(),pd.getKucun());
		}
		else{
			for(int i=0;i<length;i++){
				if(p[i].getID()==pd.getID()) flag=1;//如果已有的产品ID和添加进去的产品ID相同，就不添加
			}
			//说明已有的产品清单中没有此产品，可以添加
			if(flag==0)p[length]=new Products(pd.getID(),pd.getName(),pd.getKucun());
		}
	}
	//查找产品ID
	public Products findProduct(String ID){
		Products pd=new Products();
		if(length==0) {System.out.println("没有此产品"); return null;}
		for(int j=0;j<length;j++)
			if(p[j].searchID(ID)) {
				pd=p[j];return pd;
			}
		return null;
	}
	public int numberInStock(String ID){
		for(int i=0;i<length;i++){
			if(p[i].searchID(ID)) return p[i].getKucun();
		}
		return 0;
	}
	public void delivery(String ID,int increase){
		for(int i=0;i<length;i++){
			if(p[i].searchID(ID)) p[i].addKucun(increase);
		}
	}
	public void printLowStockProducts(int low){
		Products[] temp=null;
		for(int i=0;i<length;i++){
			if(p[i].getKucun()<=low){
				System.out.println("库存水平低于"+low+"的产品信息如下：");
				System.out.println("Name:"+p[i].getName()+"  ID:"+p[i].getID()+"  Kucun:"+p[i].getKucun());
			}
		}
	}
	public Products findProductByName(String name){
		for(int i=0;i<length;i++){
			if(p[i].getName()==name) return p[i];
		}
		return null;
	}
}
public class StockDemo{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flag=1;//标记
		StockManager manager = new StockManager();
		while(flag==1){
		System.out.println("1-增加产品"+"\n"+"2列出产品"+"\n"+"3-找产品（通过ID）");
		System.out.println("4-获得某产品的数量"+"\n"+ "5-打印低于某库存水平的产品");
		System.out.println("6-找产品（通过名字）"+"\n"+"其他-退出");
		Scanner scan=new Scanner(System.in);
		String ID,name;//ID 名称
		int kucun,low;//库存
		int choice=scan.nextInt();//输入选择
		switch(choice){
		case 1:{
			//增加产品
			System.out.println("产品信息");
			System.out.println("请分别输入ID，名字，库存");
			ID=scan.next();
			name=scan.next();
			kucun=scan.nextInt();
			Products p=new Products(ID,name,kucun);
			manager.addProducts(p);
			System.out.println("产品已添加成功！！");
		}break;
		case 2:{
			//列出产品
			manager.printProductDetails();
		}break;
		case 3:{
			System.out.println("产品的ID号：");
			ID=scan.next();//输入ID
			Products p=new Products();//构造函数
			if((p=manager.findProduct(ID))!=null){
				System.out.println("Name:"+p.getName()+"  ID:"+p.getID()+"  Kucun:"+p.getKucun());
			}
		}break;
		case 4:{
			System.out.println("产品的ID号：");
			ID=scan.next();
			Products p=new Products();
			p=manager.findProduct(ID);
			if(p!=null) System.out.println("Kucun:"+p.getKucun());
			else System.out.println("找不到此产品");
		}break;
		case 5:{
			System.out.println("产品数量值:");
			low=scan.nextInt();
			manager.printLowStockProducts(low);
		}
		case 6:{
			System.out.println("产品名字：");
			name=scan.next();
			Products p=new Products();
			p=manager.findProductByName(name);
			System.out.println("Name:"+p.getName()+"  ID:"+p.getID()+"  Kucun:"+p.getKucun());
		}break;
		default: System.exit(0); 
		}
		System.out.println("是否继续？"+"\n"+"1-继续"+"\n"+"其它-退出");
		flag=scan.nextInt();
		}
		System.out.println("谢谢使用");
		
	}

}
