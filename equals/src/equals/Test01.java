package equals;
/*
 * 关于Object中的equals方法
 * Object中的equals方法   实现：
 *    public boolean equals(Object obj){
 *        return (this==obj);
 *        }
 *     o1.equals(o2) 中o1是this，o2是obj
 *     ==两边如果是引用数据类型，比较内存地址
 *     java对象中的equals方法设计的目的：判断两个对象是否相等
 */
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Object o1=new Object();
        Object o2=new Object();
        boolean b1=o1.equals(o2);
        System.out.println(o1==o2);//false
        System.out.println(b1);//false
        Start s1=new Start(100,"瘪陶");
        Start s2=new Start(100,"瘪陶");
        Start s3=new Start(100,"阿胆");
        System.out.println(s1==s2);//false
        System.out.println(s1.equals(s2));//true
        System.out.println(s2.equals(s3));//
	}

}
class Start{
	int id;
	String name;
	public Start(int id,String name){
		this.id=id;
		this.name=name;
	}
	 public boolean equals(Object obj){
		 if(this==obj) return true;
		      if(obj instanceof Start){
		    	  Start s=(Start)obj;
		    if(s.id==id&&s.name.equals(name)){//java中的字符串比较，不能用"==",应该调用equals方法
		    	return true;
		    }
		    	  
		}
		      return false;
    }
}

/*
 * 在现实的逻辑中，不应该比较内存地址，应该比较内容
 * 所以Object中的equals方法   也要重写
 * 根据需求规定，重写，，规定：如果身份证号一致，名字一致，则代表是同一个人
 */
