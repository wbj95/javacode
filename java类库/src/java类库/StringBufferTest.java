package java���;
/*
 * 1.StringBuffer��StringBuilder��ʲô
 *  ��һ���ַ���������
 *  2.����ԭ��
 *  	Ԥ�����ڴ�����һ��ռ䣬�������ַ�����
 *  	���Ԥ���Ŀռ䲻���ã�������Զ����ݣ������ɸ�����ַ�����
 	3.StringBuffer,StringBuilder��String �������
 		String�ǲ��ɱ���ַ����У��洢�ַ�����������
 		StringBuffer�ײ���һ��char���飬���Ǹ�char�����ǿɱ��
 		
 	4.StringBuffer��StringBuider��Ĭ�ϳ�ʼ������16
 	
 	5.����Ż��Ż�StringBuffer��StringBuider��
 		 ������ڴ���StringBuffer֮ǰ����Ԥ��StringBuffer�Ĵ洢�ַ�����
 		 Ȼ���ٴ���StringBuffer��ʱ�����ָ����ʼ�������ķ�������StringBuffer
 		 Ϊ���ٵײ�����Ŀ��������Ч��
    6.StringBuffer��StringBuider������
    
     StringBuffer���̰߳�ȫ�ģ������ڶ��̵߳Ļ�����ʹ�ò���������⣩
     StringBuider�Ƿ����԰�ȫ�ģ����ڶ��̻߳�����ʹ�ÿ��ܳ������⣩
 */

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String [] ins={"����","����","˯��","��ʳ"};
		for(int i=0;i<ins.length;i++){
			if(i==ins.length-1){
				sb.append(ins[i]);
			}else
			{
				sb.append(ins[i]);
				sb.append(",");
			}
		}
		
			System.out.println(sb);
	}

}
