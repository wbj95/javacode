import java.io.*;
/*    �ֽ�
 * 	BufferedInputStream
 *  BufferedOutputStream
 * 
 *    �ַ�
 *    BufferedReader ���л��������ַ�������
 *    BufferedWriter ���л��������ַ������
 */

public class BufferedInpuStreamTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr;
		try {
			//����һ�����л��������ֽ�������
			fr = new FileReader("D:/javachengxu/IO��/src/BufferedInpuStreamTest01.java");
			//����һ���ļ��ַ�������
			
			BufferedReader bis=new BufferedReader(fr);//���ļ��ַ���������װ�ɴ����������ַ�������
			//FileReader fr �ǽڵ���
			//BufferedReader bis��һ����װ�������ߴ�����
			
			//��ʼ��
			String temp=null;
			while((temp=bis.readLine())!=null){//br.readLine()������ȡһ�У�������β�������з�
				
				System.out.println(temp);
			}
			bis.close();//�ر�
			//ע�⣺�رյ�ʱ��ֻ��Ҫ�ر������İ�װ����
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
