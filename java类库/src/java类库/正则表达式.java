package java���;
/*
 * ������ʽ
 * 	1.������ʽ��һ�Ŷ�����ѧ��
 * 2.������ʽ��һ���ַ�ģ�ͣ�ר�����ʲ���ʽƥ���
 * 3.������ʽ��ͨ�õ�
 *   
 *   ���磬������ʽ��a()$����ʾ 2��a�ַ���ͬ��"aa"
 		
 		\d ����
 		\D ������
 		\w  Ӣ����ĸ
 		\W ��Ӣ����ĸ
 */

public class ������ʽ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aak4cfddv5aads45f2cx1v5df4d5s2d3x2cd5sf";
		
		System.out.println(s.replaceAll("d(2)", "��"));
		System.out.println(s.replaceAll("\\d", "����"));
		System.out.println(s.replaceAll("\\w", "����"));
		System.out.println(s.replaceAll("\\D", "1"));
	}

}
