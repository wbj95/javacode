package 链表;

public class LinklistTest02 {

	public Node head;
	public Node current;

	// 1,链表添加元素
	public void add(int data) {
		if (head == null) {// 如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
			head = new Node(data);
			current = head;
		} else {
			// 创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
			current.next = new Node(data);
			// 把链表的当前索引向后移动一位
			current = current.next;// 此步操作完成之后，current结点指向新添加的那个结点
		}
	}
	
	//add重载:向链表中添加结点
	public void add(Node node){
		if(node==null){
			return;
		}
		if(head==null){
			head=node;
			current=head;
		}else{
			current.next=node;
			current=current.next;
		}
	}
	//在头插入
	public void addFirst(Node head1,int newNum){
		head=new Node(newNum);//创建新的头结点
		head.next=head1;
	}
	//在尾插入
	public void addLast(Node node,int newNum){
		//head=node;
		current=node;
		while(current.next!=null){
			current=current.next;
		}
	   Node	newPoint=new Node(newNum);
		current.next=newPoint;
	}
	//在第几位插入
	public void addIndex(Node node,int index,int newNum){
		head=node;
		current=node;
		if(head==null||index<0)head=new Node(newNum);
		else{
			for (int i = 1; i <index; i++) {
				current=current.next;
			}
			Node newPoint=new Node(newNum);
			newPoint.next=current.next;
			current.next=newPoint;
		}
	}
	
	//删除头结点
	public void deleteFirst(Node node){
		head=node;
		if(head==null)return;
		head=head.next;
	}
	//删除尾部节点
	public void deleteLast(Node node){
		head=node;
		if(head==null)return;
		current=node;
		while(current.next.next!=null){
			current=current.next;
		}
		current.next=null;
	}
	//删除第几位
	public void delectIndex(Node node,int index){
		head=node;
		current=node;
		if(head==null||index<0)return;
		else{
			for (int i = 1; i < index; i++) {
				current=current.next;
			}
			current.next=current.next.next;
		}
	}
	//2 方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
	public void print(Node node) {
		if (node == null) {
			return;
		}
		current = node;
		while (current != null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
	}
	
	//查找某个对象是否在链表中
	public boolean findInt(Node head,int n){
		current =head;
		while(current!=null&&n!=current.data){
			current=current.next;
		}
		if(current!=null){
			return true;
		}
		return false;
	}
	
	//替换对象或者第i项元素
	public boolean replace(Node head,int n,int newNum){
		current=head;
		while(current!=null&&n!=current.data){
			current=current.next;
			
		}
		if(current!=null){
			current.data=newNum;
			return true;
		}
		return false;
	}
	//替换第i项
	public boolean replace2(Node head,int index,int newNum){
		current=head;
		for (int i = 0; i <index-1; i++) {
			current=current.next;
		}
		if(current!=null){
			current.data=newNum;
			return true;
		}
		return false;
	}
	
	//链表倒序
	public Node reverseOrder(Node head){
		if(head==null||head.next==null)return head;//如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
		current=head;
		Node next=null;//定义当前结点的下一个结点
		Node reverseHead=null;//反转后新链表的表头
		while(current!=null){
			next=current.next;//暂时保存住当前结点的下一个结点，因为下一次要用
			current.next=reverseHead;//将current的下一个结点指向新链表的头结点
			reverseHead=current;
			current=next;// 操作结束后，current节点后移
		}
		return reverseHead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinklistTest02 l=new LinklistTest02();
		for (int i = 1; i < 10; i++) {
			l.add(i);
		}
		LinklistTest02 l2=new LinklistTest02();
		for (int i = 22; i <30; i++) {
			l2.add(i);
		}
		System.out.println(l.findInt(l.head, 1));
		//替换
		System.out.println("替换元素:");
		System.out.println(l.replace(l.head, 5,110));
		l.print(l.head);
		System.out.println();
		System.out.println(l.replace2(l.head, 3, 120));
		l.print(l.head);
		System.out.println();
		System.out.println("在头插入0");
		l.addFirst(l.head, 0);
		l.print(l.head);
		System.out.println();
		System.out.println("在尾插入119");
		l.addLast(l.head, 119);
		l.print(l.head);
		System.out.println();
		System.out.println("把头结点删除");
		l.deleteFirst(l.head);
		l.print(l.head);
		System.out.println();
		System.out.println("从尾部移除");
		l.deleteLast(l.head);
		l.print(l.head);
		System.out.println();
		System.out.println("在第二位之后插入");
		l.addIndex(l.head, 2, 2233);
		l.print(l.head);
		System.out.println();
		System.out.println("删除第二位之后的那个元素");
		l.delectIndex(l.head, 2);
		l.print(l.head);
		System.out.println();
		System.out.println("链表翻转");
		LinklistTest02 l3=new LinklistTest02();
		l3.head=l.reverseOrder(l.head);
		l3.print(l3.head);
	}

}
//节点类
//class Node {
//	int data;// 数据域
//	Node next;// 指针域
//
//	Node(int data) {
//		this.data = data;
//	}
//}