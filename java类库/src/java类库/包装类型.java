package java类库;
/*
 * java中八种基本数据类型对应的包装类型
 *     基本数据类型			包装类型
 *   
 *     byte					java.lang.Byte;
 *     short				java.lang.Short
 *     int 					java.lang.Integer
 *     long					java.lang.Long
 *     
 *     float				java.lang.Float;
 *     double				java.lang.Double;
 *     
 *     boolean				java.lang.Boolean;
 *     
 *     char					java.lang.Character;
 *     思考：
 *         java中提供的八种基本数据类型不够用吗，为什么java中还要提供对应的包装类型？
 *         方便
 */

public class 包装类型 {
	//入口	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//基本数据类型
		Byte b=10;
		//引用类型
		Byte b1=new Byte(b);
		
		Character c='s';
		char c1=new Character(c);
		m1(b1);//Byte已经将Object中的toString方法重写
		m1(c1);
	}
	//需求：规定m1方法可以接收java中任何一种数据类型
	//m1方法如果想接收byte类型的数据，可以将byte类型先包装成java.lang.Byte;再传参数
	
	public static void m1(Object o){
		System.out.println(o);
	}
}
