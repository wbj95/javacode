package 集合;
/*
 * List集合存储元素特点
 * 1.有序（List集合中存储有下标）：存进去是这样的顺序，取出来还是这样的顺序。
 * 2.可重复
 * 深入List集合
 * ArrayList集合底层是数组，数组是有下标的。
 * 所以ArrayList集合有很多自己的特性
 * 
 * ArrayList集合底层默认初始值容量是10，扩大后的容量是原容量的1.5倍
 * Vector集合底层默认初始化容量是10，扩大后的容量是原容量的2倍
 * 
 * 如何优化ArrayList和Vector？
 *  尽量减少扩容操作，因为扩容需要数组拷贝，数组拷贝很耗内存
 *  一般推荐在创建集合的时候指定初始化容量
 */

import java.util.*;
public class ListTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//List l=new ArrayList();
		List l=new LinkedList();	
		
			l.add(123);
			l.add(456);
			l.add(789);
			l.add(123);
			l.add(1,555);//在下边为1的位置添加555
			
			//System.out.println(l.get(0));//123
			
			Iterator i=l.iterator();
			while(i.hasNext()){
				System.out.println(i.next());//省略Object o=i.next(); 因为Object中的toString被重写了
			}
			/*
			for(int ii=0;ii<l.size();ii++){
				System.out.println(l.get(ii));
			}*/
	}

}
