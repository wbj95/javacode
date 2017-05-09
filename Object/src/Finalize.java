
public class Finalize {
/*
 * finalize方法什么时候调用
 * 1.finalize每个java对象都有
 * 2.finalize不需要程序员调用，由系统自动调用
 * 3.java对象如果没有更多引用指向它，则java对象为垃圾数据，等待GC回收
 *    GC在回收java对象之前会自动调用该对象方法
 *  finalize是该对象马上就要被回收了  
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         person p=new person();
         p=null;
         //程序员只能建议垃圾回收器回收垃圾
         System.gc();
         //hashCold方法返回对象的哈希码值，java对象内存地址经过哈希算法得出int类型数值
         Finalize f=new Finalize();
         
        System.out.println( f.hashCode());
	}

}
class person{
public void finalize() throws Throwable{
	System.out.println("垃圾回收");
	//让引用再次重新指向改对象，该对象不是垃圾数据，不会被垃圾回收器回收
	person p2=this;
    }
}