package 包;
/*
 * 软件包机制
 * 1.为了解决类的命名冲突问题，在类名前加命名空间（包机制）
 * 2.在java'中使用package语句定义包（单包，复包）
 * 3.package只能出现在.java源文件的第一行
 * 4.package定义格式，通常采用公司域名倒叙方式
 *    例如：com.bjpwernode.oa.system
 *    含义：bjpowernode公司开发oa项目，system是oa项目中的其中一个模块
 *    全格式：公司域名倒叙.项目名.模块名 
 *  5.完整的类都带有包名的
 *  6.带有package语句的java源文件必须这样编译：
 *  javac -d 生成路径  源文件路径（或javac -d . *.java）
 *  7.运行  ：java com.bjpowernode.javase.day05.User
 *  
 *  import可以引入其他类
 *  import语句 出现在package之下class之上
 *  
 */
import java.util.Date;//import com.bjpowernode.javase.day05.User
public class Test01 {

	public static void main(String[] args) {
		
     Date d=new Date();
     System.out.println(d);
	}
}
