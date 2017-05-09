package �������;

import java.io.*;
import java.util.*;

//IO+properties

//dbinfo�������ļ����ǳ�Ϊ�����ļ�
//�����ļ��������ǣ��ǳ�������
//ע�⣺һ���ڳ����пɱ�Ķ�����Ҫд�����Ƽ�д�������ļ��У�����ͬ�����ļ��õ���ͬ�Ľ��

//��dbinfo����һ�������������ݵ������ļ����ǽ����������ļ���
//java�淶��Ҫ�������ļ��ԡ�properties��,���Ǳ���ģ�ֻ�ǽ���

//�����ļ�������Ҫ��
//key��value֮�����ʹ�á��ո񡱣���ð�š������Ⱥš���
//������ո񡱣���ð�š������Ⱥš����У�������ǰ����Ϊ�ָ���

public class Test01 {
	public static void main(String[] args) throws IOException{
		//1,�������Զ���
		Properties p=new Properties();//��Mapһ����ֻ����key��valueֻ�ܴ洢�ַ�������
		//key�����ظ�������ظ���value����
		
		
		//����������
		//FileInputStream f=new FileInputStream("D:/javachengxu/123.txt");
		FileInputStream f=new FileInputStream("dbinfo.txt");
		
		//��f���е��������ݼ��ص����Զ�����
		//�����������Զ������У�key=sdjfhshf,value=adfdg)
		try {
			p.load(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ر���
		f.close();
		
		//ͨ��key��ȡvalue
		String s1 =p.getProperty("driver");
		String s2 =p.getProperty("url");
		String s3 =p.getProperty("username");
		String s4 =p.getProperty("password");
		
		
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		
	}
}
