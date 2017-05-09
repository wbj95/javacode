package ���ﳵ;

import java.util.*;

public class ShoppingCart {
	//ʹ��Map����Ʒ��Ŀ
		Map<Product,Integer> products;
		
		//�ܼ�
		double totalprice;
		
		//Constructor
		ShoppingCart(){
			products=new HashMap<Product,Integer>();//HashMapһ��ʼд���MapHash
		}
		
		//���һ����Ʒ
		public void add(Product p){//һ��ʼ���˴�����
			add(p,1);
		}
		//���n����Ʒ
		public void add(Product p,int n){
			//�жϹ��ﳵ���Ƿ��������Ʒ
			if(!products.containsKey(p)){//û�и���Ʒ
				products.put(p, n);
			}else{
				int before=products.get(p);//�Զ�����products.get(p).intValue()
				int after=before+n;
				products.put(p, after);
			}
			
			totalprice+=p.getPrice()*n;
		}
		//ɾ��һ����Ʒ
		public void remove(Product p){
			remove(p,1);
		}
		//ɾ��n����Ʒ
		public void remove(Product p,int n){
			int before=products.get(p);
			if(products.containsKey(p))
			{
			//�������ǳ�ĳ��Ʒ����Ŀ��n��ȣ���ɾ��������Ŀ
			if(before==n){
				products.remove(p);
				}
			else if(before<n){
				System.out.println("ɾ����Ŀ������ﳵ������");
				return;
			}
			int after=before-n;
			products.put(p, after);
			
			totalprice-=p.getPrice()*n;
			}else{
				System.out.println("���ﳵ��û�и���Ʒ");
			}
		}
		//���
		public void Clear(){
			products.clear();
			totalprice=0.0;
		}
		//����굥
		public void print(){
			StringBuffer sb=new StringBuffer();
			sb.append("���ﳵ�굥��\n");
			
			//����Map
			Set<Product> keys=products.keySet();
			Iterator<Product> it=keys.iterator();
			while(it.hasNext()){
				Product k=it.next();
				Integer v=products.get(k);
				sb.append("\t"+v+"\t"+k+"\t"+k.getPrice()+"\n");
				
			}
			sb.append("\t\t\t\t\t\t\t\t�ܼ�:"+totalprice+"Ԫ");
			System.out.println(sb);
		}
		
		
}
/*
 * ��������Iterator��

������������һ�����ģʽ������һ�����������Ա�����ѡ�������еĶ��󣬶�������Ա����Ҫ�˽�����еĵײ�ṹ��������ͨ������Ϊ����������������Ϊ�������Ĵ���С��

����Java�е�Iterator���ܱȽϼ򵥣�����ֻ�ܵ����ƶ���

����(1) ʹ�÷���iterator()Ҫ����������һ��Iterator����һ�ε���Iterator��next()����ʱ�����������еĵ�һ��Ԫ�ء�ע�⣺iterator()������java.lang.Iterable�ӿ�,��Collection�̳С�

����(2) ʹ��next()��������е���һ��Ԫ�ء�

����(3) ʹ��hasNext()����������Ƿ���Ԫ�ء�

����(4) ʹ��remove()���������·��ص�Ԫ��ɾ����

����Iterator��Java��������򵥵�ʵ�֣�ΪList��Ƶ�ListIterator���и���Ĺ��ܣ������Դ������������List��Ҳ���Դ�List�в����ɾ��Ԫ�ء�
 */
