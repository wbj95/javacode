package 队列;

public class LinkedQueue {
	Node head;//头指针
	Node rear;//尾指针
	private int count;
	LinkedQueue() {
		
	}
	public int size(){
		 return count;
	 }
	public boolean isEmpty(){
		 return count==0;
	 }
	//像链表末尾添加结点
	public void enqueue(Object item){
		if(item==null)
			 throw new IllegalArgumentException("item is empty");
		Node newPoint=new Node(item,null);
		if(isEmpty()){
			head=newPoint;
		}else{
			rear.next=newPoint;
		}
		rear=newPoint;
		count++;
	}
	public Object dequeue(){//出队列，先进先出
		if(isEmpty())
			throw new IllegalStateException("queue is empty");
		Object item=head.data;
		head=head.next;
		if(head==null)rear=null;
		count--;
		return item;
	}
	public void print(Node node){
		head=node;
		Node current=node;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
	}
	public static void main(String[] args){
		LinkedQueue l=new LinkedQueue();
		for (int i = 1; i <10; i++) {
			l.enqueue(i);
		}
		//System.out.println(l.size());
		l.print(l.head);
		int len=l.size();
		System.out.println();
		for (int i = 0; i <len; i++) {
			System.out.print(l.dequeue()+" ");
		}
	}
}
class Node{
	Object data;
	Node next;
	Node(Object item,Node next){
		this.data=item;
		this.next=next;
	}
}