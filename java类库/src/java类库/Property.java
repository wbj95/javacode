//: Property.java
package java类库;

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
		Properties p=System.getProperties();//获取system类的属性，获取指定键指示的系统属性。
		p.list(System.out);
		System.out.println("---Memory Usage:");
		Runtime rt=Runtime.getRuntime();
		System.out.println("Total Memory="+rt.totalMemory()+"Free Mrmory="+rt.freeMemory());
	}
}///:~
