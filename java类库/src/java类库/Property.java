//: Property.java
package java���;

import java.util.Date;
import java.util.Properties;
/** The first Thinking in Java example program.
* Lists system information on current machine.
* @author Bruce Eckel
* @author http://www.BruceEckel.com
* @version 1.0
*/
public class Property {
	/** Sole entry point to class & application
	* @param args array of string arguments
	* @return No return value
	* @exception exceptions No exceptions thrown
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Date());
		Properties p=System.getProperties();//��ȡsystem������ԣ���ȡָ����ָʾ��ϵͳ���ԡ�
		p.list(System.out);
		System.out.println("---Memory Usage:");
		Runtime rt=Runtime.getRuntime();
		System.out.println("Total Memory="+rt.totalMemory()+"Free Mrmory="+rt.freeMemory());
	}
}///:~
