
public class ToString{
/*
 * 关于Object中的toString方法
 *   SUN在Object类中设计toString的目的：返回java对象的字符串表示
 *   在现实中，Object中toString方法已经不够用了，所以Object的toString的方法实现不满意
 *   Object中toString方法要被重写
 *   SUN是这样实现toString
 *   public String toString(){
 *   return getClass().getName()+"@"+Integer.toHexString(hashCode());
 *   Object toString方法返回 ：类名 @ java对象的内存地址经过哈希算法得出的int类型
 *                            值转换成十六进制，结果可以等同看作java对象在堆中内存地址
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个Object类型对象
       Object o1=new Object();
       //调用toString
       String s1=o1.toString();
       //输出
       System.out.println(s1);//java.lang.Object@2a139a55
       //创建一个Person类型的对象
       Person1 o2=new Person1("阿胆",50);//Person[name=阿胆,age=50]
       //调用toString
       String s2=o2.toString();
       System.out.println(s2);//Person@15db9742
       Person1 o3=new Person1("瘪陶",110);
       String s3=o3.toString();
       System.out.println(s3.toString());//Person[name=瘪陶,age=110]
       //如果print方法的括号中是个引用类型，会默认调用引用类型的toString方法
       System.out.println(s3);//Person[name=瘪陶,age=110]
       
	}

}
class Person1{
	String name;
	int age;
	Person1(String name,int age){
		this.name=name;
		this.age=age;
	}
  //重写toString方法，根据项目的需求而定，需求规定，显示格式：Person[name=某某，age=xx]
    public String toString(){
	return "Person[name="+name+",age="+age+"]";
    }
}