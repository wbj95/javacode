package 异常;
import java.io.*;
/*
 * 关于finally语句块
 * 1.finally语句块可以直接和try语句块连用，。try...finally
 * 2.try...catch...finally也可以
 * 3.在finally语句块中的代码是一定会执行
 * 
 * finally语句块一定会执行，所以通常在程序中
 * 为保证某资源一定会释放，所以一般在finally语句块
 * 中释放资源
 */
public class Finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     /* try{
    	  System.out.println("瘪陶喜欢吃瘪");
    	  return; 
      }finally{
    	  System.out.println("阿胆也喜欢");
      }*/
		//只要在执行finally语句块之前 退出JVM，则finally语句块不会执行
		
     try{
    	 //退出JVM
    	 System.out.println("都不");
    	 System.exit(0);
     }finally{
    	 //不会执行
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
