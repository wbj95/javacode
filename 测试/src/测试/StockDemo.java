package ����;
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
		if(length==0) System.out.println("û�д˲�Ʒ��");
		else{
		for(int i=0;i<length;i++)
			if(p[i]!=null){
				//�����Ʒ��Ϣ
			System.out.println("Name:"+(p[i]).getName()+
				"  ID:"+p[i].getID()+"    Kucun:"+p[i].getKucun());
			}
			else break;
		}
	}
	void addProducts(Products pd){
		int flag=0;//���
		if(length==0){
			p[0]=new Products(pd.getID(),pd.getName(),pd.getKucun());
		}
		else{
			for(int i=0;i<length;i++){
				if(p[i].getID()==pd.getID()) flag=1;//������еĲ�ƷID����ӽ�ȥ�Ĳ�ƷID��ͬ���Ͳ����
			}
			//˵�����еĲ�Ʒ�嵥��û�д˲�Ʒ���������
			if(flag==0)p[length]=new Products(pd.getID(),pd.getName(),pd.getKucun());
		}
	}
	//���Ҳ�ƷID
	public Products findProduct(String ID){
		Products pd=new Products();
		if(length==0) {System.out.println("û�д˲�Ʒ"); return null;}
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
				System.out.println("���ˮƽ����"+low+"�Ĳ�Ʒ��Ϣ���£�");
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
		int flag=1;//���
		StockManager manager = new StockManager();
		while(flag==1){
		System.out.println("1-���Ӳ�Ʒ"+"\n"+"2�г���Ʒ"+"\n"+"3-�Ҳ�Ʒ��ͨ��ID��");
		System.out.println("4-���ĳ��Ʒ������"+"\n"+ "5-��ӡ����ĳ���ˮƽ�Ĳ�Ʒ");
		System.out.println("6-�Ҳ�Ʒ��ͨ�����֣�"+"\n"+"����-�˳�");
		Scanner scan=new Scanner(System.in);
		String ID,name;//ID ����
		int kucun,low;//���
		int choice=scan.nextInt();//����ѡ��
		switch(choice){
		case 1:{
			//���Ӳ�Ʒ
			System.out.println("��Ʒ��Ϣ");
			System.out.println("��ֱ�����ID�����֣����");
			ID=scan.next();
			name=scan.next();
			kucun=scan.nextInt();
			Products p=new Products(ID,name,kucun);
			manager.addProducts(p);
			System.out.println("��Ʒ����ӳɹ�����");
		}break;
		case 2:{
			//�г���Ʒ
			manager.printProductDetails();
		}break;
		case 3:{
			System.out.println("��Ʒ��ID�ţ�");
			ID=scan.next();//����ID
			Products p=new Products();//���캯��
			if((p=manager.findProduct(ID))!=null){
				System.out.println("Name:"+p.getName()+"  ID:"+p.getID()+"  Kucun:"+p.getKucun());
			}
		}break;
		case 4:{
			System.out.println("��Ʒ��ID�ţ�");
			ID=scan.next();
			Products p=new Products();
			p=manager.findProduct(ID);
			if(p!=null) System.out.println("Kucun:"+p.getKucun());
			else System.out.println("�Ҳ����˲�Ʒ");
		}break;
		case 5:{
			System.out.println("��Ʒ����ֵ:");
			low=scan.nextInt();
			manager.printLowStockProducts(low);
		}
		case 6:{
			System.out.println("��Ʒ���֣�");
			name=scan.next();
			Products p=new Products();
			p=manager.findProductByName(name);
			System.out.println("Name:"+p.getName()+"  ID:"+p.getID()+"  Kucun:"+p.getKucun());
		}break;
		default: System.exit(0); 
		}
		System.out.println("�Ƿ������"+"\n"+"1-����"+"\n"+"����-�˳�");
		flag=scan.nextInt();
		}
		System.out.println("ллʹ��");
		
	}

}
