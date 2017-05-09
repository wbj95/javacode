package 参数的传递;

public class Super {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Book1 b=new Book1(55);
        
	}

}
class book{
	book(int i){
		System.out.println("book"+i);
	}
}
class  Book1 extends book{
	Book1(int i){
		super(i);
		System.out.println("Book1"+i);
	}
}