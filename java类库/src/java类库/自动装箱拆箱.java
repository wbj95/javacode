package java���;
//1.�Զ�װ����Զ������ǳ������׶ε�һ������ͳ��������޹�
//2.�Զ�װ����Զ�������ҪĿ���Ƿ������Ա����
public class �Զ�װ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i3=12;//�Զ�װ��
		int i4=i3;//�Զ�����
		System.out.println(i3);//"12"
		System.out.println(i4);//12
		m1(123);//�Զ�װ��
		
		Integer p1=new Integer(100);
		Integer p2=new Integer(100);
		//���ﲻ�����Զ�����
		System.out.println(p1==p2);//false
		//�Ƚ�����Integer���͵������Ƿ���ȣ�������==
		//Integer�Ѿ���д��Object�е�equals����
		System.out.println(p1.equals(p2));//true
		
		//�ص�
		Integer p3=128;
		Integer p4=128;
		
		//����ĵ�ͬ��
		//Integer p3=new Integer(128);
		//Integer p4=new Integer(128);
		
		System.out.println(p3==p4);//false
		
		//ע���������
		//�����������[-128~127]֮�䣬java������һ�������ͳ����ء����ڷ�������
		//�����ͳ�����ֻ�洢-128~127֮�������
		Integer p5=127;//������򲻻��ڶ��д������󣬻�ֱ�Ӵ����ͳ���������
		Integer p6=127;
		System.out.println(p5==p6);//true
		Integer p7=-128;
		Integer p8=-128;
		System.out.println(p7==p8);//true
		Integer p9=-129;
		Integer p10=-129;
		System.out.println(p9==p10);//false
		
	}
	public static void m1(Object o){
		System.out.println(o);
	}
}
