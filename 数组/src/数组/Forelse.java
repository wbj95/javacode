package 数组;

public class Forelse {
/*
 * 数组：
 *  1.数组是一种引用类型
 *  2.数组是一种简单的数据结构，线性的结构
 *  3.数组是一种容器，可以用来存储其他元素
 *  数组是可以存储任意类型的元素
 *  4.数组分为：一维数组，二维数组，多维数组
 *  5.数组中存储的元素类型时统一的
 *  6.数组长度不可改变，数组一旦创建长度是固定的
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] array=new int[(int)(Math.random()*10)+2];
        for(int i=0;i<array.length;i++){
        	array[i]=(int)(Math.random()*100);
        }
        for(int value:array){
        	System.out.println(value);
        }
	} 
}
//Math.random()产生随机数
//for(int value:array) 对array数组的每个元素进行遍历，被叫做for-each循环
//但是这种循环只能用来读取数组的元素，不能进行赋值，赋值还是得用传统的for循环
