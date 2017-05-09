package 异常;
/*
 * 处理异常的两种方式：
 * 1.声明抛出  throws
 *  2.捕捉   try ...catch...
 *  以下程序演示第一种方式：声明抛出，在方法声明的位置上使用trows关键字向上抛出异常
 */
import java.io.*;
public class 声明抛出 {
	//public static void main(String[] args) throws Exception{
		//public static void main(String[] args) throws IOException{
			public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
				//建立文件输入流，读取文件
				//思考：java编译器是如何知道以下的代码执行过程中可能出现异常
				//java编译器不是那么智能，因为FileInputStreamzhege 这个构造方法在声明的位置上使用了throws FileNotFoundException
       FileInputStream  fls=new  FileInputStream("c:/aas.txt");
	}

}
//以上程序不通过，报告异常，必须进行捕捉或声明
