package �쳣;
import java.io.*;
/*
 * ����finally����
 * 1.finally�������ֱ�Ӻ�try�������ã���try...finally
 * 2.try...catch...finallyҲ����
 * 3.��finally�����еĴ�����һ����ִ��
 * 
 * finally����һ����ִ�У�����ͨ���ڳ�����
 * Ϊ��֤ĳ��Դһ�����ͷţ�����һ����finally����
 * ���ͷ���Դ
 */
public class Finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     /* try{
    	  System.out.println("����ϲ���Ա�");
    	  return; 
      }finally{
    	  System.out.println("����Ҳϲ��");
      }*/
		//ֻҪ��ִ��finally����֮ǰ �˳�JVM����finally���鲻��ִ��
		
     try{
    	 //�˳�JVM
    	 System.out.println("����");
    	 System.exit(0);
     }finally{
    	 //����ִ��
    	 System.out.println("finally");
     }
		/*FileInputStream fls=null;
		try{
			 fls=new FileInputStream("Finally.java");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally{
			if(fls!=null){
				try{
					fls.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}*/
	}

}
