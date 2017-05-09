package ’ª;
//¡¥±Ì’ª
import java.nio.channels.IllegalSelectorException;

public class LinkStack {
	Node top;
	private int count;
	 LinkStack() {
		top=null;
		count=0;
	}
	 public boolean isEmpty(){
		 return count==0;
	 }
	 public void push(Object item){
		 if(item==null)
			 throw new IllegalStateException("item is empty");
		 Node newPoint=new Node(item,top);
		 top=newPoint;
		 count++;
	 }
	 public Object pop(){
		 if(isEmpty())
			 throw new IllegalStateException("stack is empty");
		 count--;
		 Object item=top.data;
		 top=top.next;
		 return item;
	 }
	 public Object peek(){
		 if(isEmpty())
			 throw new IllegalStateException("stack is empty");
		 return top.data;
	 }
	 public int size(){
		 return count;
	 }
	 public static void main(String[] args){
		 LinkStack l=new LinkStack();
		 for (int i = 1; i < 10; i++) {
			l.push(i);
		}
		 System.out.println("’ª «∑Òø’£∫"+l.isEmpty());
		 System.out.println("’ª¥Û–°:"+l.size());
		 System.out.println("’ª∂•‘™Àÿ£∫"+l.peek());
		 System.out.print("≥ˆ’ª£∫");
		 int len=l.size();
		 for (int i = 0; i <len; i++) {
			System.out.print(l.pop()+" ");
		}
		 System.out.println("’ª «∑Òø’£∫"+l.isEmpty());
		 System.out.println("’ª¥Û–°:"+l.size());
		// System.out.println("’ª∂•‘™Àÿ£∫"+l.peek());
	 }
}

class Node {
	 Object data;
	 Node next;

	 Node() {
		this.data = null;
		this.next = null;
	}

	 Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
}