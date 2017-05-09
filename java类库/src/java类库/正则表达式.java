package java类库;
/*
 * 正则表达式
 * 	1.正则表达式是一门独立的学科
 * 2.正则表达式是一种字符模型，专门做资产格式匹配的
 * 3.正则表达式是通用的
 *   
 *   例如，正则表达式“a()$”表示 2个a字符等同于"aa"
 		
 		\d 数字
 		\D 非数字
 		\w  英文字母
 		\W 非英文字母
 */

public class 正则表达式 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aak4cfddv5aads45f2cx1v5df4d5s2d3x2cd5sf";
		
		System.out.println(s.replaceAll("d(2)", "瘪"));
		System.out.println(s.replaceAll("\\d", "瘪陶"));
		System.out.println(s.replaceAll("\\w", "瘪陶"));
		System.out.println(s.replaceAll("\\D", "1"));
	}

}
