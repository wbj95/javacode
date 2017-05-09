//static语句块在类加载的时候执行，并且只执行一次，自上而下的顺序
public class Static {
      static{
    	  System.out.println("尼玛");
      }
      static {
    	  System.out.println("草泥马");
      }
      public static void main(String[]args){
    	  System.out.println("你麻痹");
      }
}
