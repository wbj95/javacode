package ����;
/*
 * List���ϴ洢Ԫ���ص�
 * 1.����List�����д洢���±꣩�����ȥ��������˳��ȡ��������������˳��
 * 2.���ظ�
 * ����List����
 * ArrayList���ϵײ������飬���������±�ġ�
 * ����ArrayList�����кܶ��Լ�������
 * 
 * ArrayList���ϵײ�Ĭ�ϳ�ʼֵ������10��������������ԭ������1.5��
 * Vector���ϵײ�Ĭ�ϳ�ʼ��������10��������������ԭ������2��
 * 
 * ����Ż�ArrayList��Vector��
 *  �����������ݲ�������Ϊ������Ҫ���鿽�������鿽���ܺ��ڴ�
 *  һ���Ƽ��ڴ������ϵ�ʱ��ָ����ʼ������
 */

import java.util.*;
public class ListTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//List l=new ArrayList();
		List l=new LinkedList();	
		
			l.add(123);
			l.add(456);
			l.add(789);
			l.add(123);
			l.add(1,555);//���±�Ϊ1��λ�����555
			
			//System.out.println(l.get(0));//123
			
			Iterator i=l.iterator();
			while(i.hasNext()){
				System.out.println(i.next());//ʡ��Object o=i.next(); ��ΪObject�е�toString����д��
			}
			/*
			for(int ii=0;ii<l.size();ii++){
				System.out.println(l.get(ii));
			}*/
	}

}
