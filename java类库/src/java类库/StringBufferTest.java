package java类库;
/*
 * 1.StringBuffer和StringBuilder是什么
 *  是一个字符串缓冲区
 *  2.工作原理
 *  	预先在内存申请一块空间，以容纳字符序列
 *  	如果预留的空间不够用，则进行自动扩容，以容纳更多的字符序列
 	3.StringBuffer,StringBuilder和String 最大区别
 		String是不可变的字符序列，存储字符串常量池中
 		StringBuffer底层是一个char数组，但是该char数组是可变的
 		
 	4.StringBuffer和StringBuider的默认初始化都是16
 	
 	5.如何优化优化StringBuffer和StringBuider呢
 		 最后试在创建StringBuffer之前，就预测StringBuffer的存储字符数量
 		 然后再创建StringBuffer的时候采用指定初始化容量的方法创建StringBuffer
 		 为减少底层数组的拷贝，提高效率
    6.StringBuffer和StringBuider的区别？
    
     StringBuffer是线程安全的（可以在多线程的环境下使用不会出现问题）
     StringBuider是非线性安全的，（在多线程环境下使用可能出现问题）
 */

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String [] ins={"体育","音乐","睡觉","美食"};
		for(int i=0;i<ins.length;i++){
			if(i==ins.length-1){
				sb.append(ins[i]);
			}else
			{
				sb.append(ins[i]);
				sb.append(",");
			}
		}
		
			System.out.println(sb);
	}

}
