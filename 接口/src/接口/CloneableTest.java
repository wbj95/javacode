package 接口;

public class CloneableTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		// SomeClass sourceObj = new SomeClass("java", 10);
		// SomeClass targetObj = (SomeClass) sourceObj.clone();
		SomeClass2 sourceObj = new SomeClass2("java", 10);
		SomeClass2 targetObj2 = (SomeClass2) sourceObj.clone();
		System.out.println("content of sourceObj:" + sourceObj);
		System.out.println("content of targetObj:" + targetObj2);

		// targetObj.setTitle("JSP");
		// sourceObj.setN(20);
		// sourceObj.setInteger(0);
		// System.out.println("浅复制After modify:");
		// System.out.println("content of sourceObj:" + sourceObj);
		// System.out.println("content of targetObj:" + targetObj);
		/*
		 * content of sourceObj:other:java n:10 myInt:100 
		 * content of targetObj:other:java n:10 myInt:100 
		 * After modify: 
		 * content of sourceObj:other:JSP n:20 myInt:0 
		 * content of targetObj:other:JSP n:10 myInt:100
		 */
		targetObj2.setTitle("JSP");
		targetObj2.setN(20);
		targetObj2.setInteger(0);
		System.out.println("深复制After modify:");
		System.out.println("content of sourceObj:" + sourceObj);
		System.out.println("content of targetObj:" + targetObj2);
		/*
		 * content of sourceObj:other:java n:10 myInt:100
			content of targetObj:other:java n:10 myInt:100
			深复制After modify:
			content of sourceObj:other:java n:10 myInt:100
			content of targetObj:other:JSP n:20 myInt:0
		 */
	}

}