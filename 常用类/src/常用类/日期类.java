package ������;
import java.util.Date;
import java.text.SimpleDateFormat;
public class ������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ȡϵͳ��ǰʱ��
		Date nowTime=new Date();
		
		System.out.println(nowTime);//Thu Nov 19 17:13:11 CST 2015
		//���ϳ���˵��java.util.Date�Ѿ���д��Object�е�toString����
		//ֻ������д�ķ������й��˲��������
		
		//���������ˡ���ʽ��������
		//java.util.Date-->String
		
		//�������ڸ�ʽ������
		//SimpleDateFormat(String pattern) 
		SimpleDateFormat s=new SimpleDateFormat("yyy��MM��dd�� HH:mm:ss SSS");
		/*
		 * y  ��  Year  1996; 96  
	M  ���е��·�  Month  July; Jul; 07  
	w  ���е�����  Number  27  
	W  �·��е�����  Number  2  
	D  ���е�����  Number  189  
	d  �·��е�����  Number  10  
	F  �·��е�����  Number  2  
	E  �����е�����  Text  Tuesday; Tue  
	a  Am/pm ���  Text  PM  
	H  һ���е�Сʱ����0-23��  Number  0  
	k  һ���е�Сʱ����1-24��  Number  24  
	K  am/pm �е�Сʱ����0-11��  Number  0  
	h  am/pm �е�Сʱ����1-12��  Number  12  
	m  Сʱ�еķ�����  Number  30  
	s  �����е�����  Number  55  
	S  ������  Number  978  
	z  ʱ��  General time zone  Pacific Standard Time; PST; GMT-08:00  
	Z  ʱ��  RFC 822 time zone  -0800  

		 */
		//��ʼ��ʽ����Date-->String��
		String StrTime=s.format(nowTime);
		System.out.println(StrTime);//2015��11��19�� 17:13:11 412
	}

}
