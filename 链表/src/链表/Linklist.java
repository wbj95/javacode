package 链表;

import java.util.Stack;

//单向链表初始化
public class Linklist {

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

	//3 返回节点的个数
	public int getLenght(Node node) {
		if (node == null)
			return 0;
		int num = 0;
		current = node;
		while (current != null) {
			num++;
			current = current.next;
		}
		return num;
	}

	//4 返回第k个节点的值
	public int findK(Node node, int k) {
		if (node == null)
			return -1;
		current = node;
		for (int i = 1; i < k; i++) {
			current = current.next;
		}
		int num = 0;
		num = current.data;
		return num;
	}

	//5 返回倒数第k个元素
	public int findLastNum(Node node, int k) {
		if (node == null)
			return -1;
		int num = 0;
		current = node;
		while (current != null) {
			num++;
			current = current.next;
		}
		current = head;
		for (int i = 0; i < num - k; i++) {
			current = current.next;
		}
		return current.data;
	}

	// 方法2：返回倒数第k个元素
	public Node FinLastNum(Node node, int k) {
		if (node == null || k == 0)
			return null;
		Node first = head;
		Node second = head;
		// 让second结点往后挪k-1个位置
		for (int i = 0; i < k - 1; i++) {
			second = second.next;
			if (second.next == null) {// 说明k的值已经大于链表的长度了
				return null;
			}
		}
		// 让first和second结点整体向后移动，直到second走到最后一个结点
		while (second.next != null) {
			first = first.next;
			second = second.next;
		}
		// 当second结点走到最后一个节点的时候，此时first指向的结点就是我们要找的结点
		return first;
	}

	//6 查找单链表中的中间结点：方法1：先遍历整个链表得到链表节点数，再算出中位数，用for循环到中位数
	// 方法2
	/*
	 * 也是设置两个指针first和second，只不过这里是，两个指针同时向前走，second指针每次走两步，
	 * first指针每次走一步，直到second指针走到最后一个结点时， 此时first指针所指的结点就是中间结点。注意链表为空，
	 * 链表结点个数为1和2的情况。时间复杂度为O（n）。
	 */
	public Node findMidNum(Node node) {
		if (node == null)
			return null;
		Node first = head;
		Node second = head;
		// 每次移动时，让second结点移动两位，first结点移动一位
		while (second != null && second.next != null) {
			first = first.next;
			second = second.next.next;
		}
		// 直到second结点移动到null时，此时first指针指向的位置就是中间结点的位置
		return first;
	}

	//7 合并两个有序的单链表，合并之后的链表依然有序：挨着比较链表1和链表2。
	// 这个类似于归并排序。尤其要注意两个链表都为空、和其中一个为空的情况。只需要O (1) 的空间。时间复杂度为O (max(len1,len2))
	public Node mergeLinkList(Node head1, Node head2) {
		if (head1 == null && head2 == null)
			return null;// 如果两个链表都是空
		if (head1 == null)
			return head1;
		if (head2 == null)
			return head2;
		Node head;// 新链表头结点
		Node current;// current节点指向新链表
		// 让current指向head1和head2中比较小的数据，得到head结点
		if (head1.data < head2.data) {
			head = head1;
			current = head1;
			head1 = head1.next;
		} else {
			head = head2;
			current = head2;
			head2 = head2.next;
		}
		// 类似归并排序
		while (head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				current.next = head1;// 新链表中，current指针的下一个结点对应较小的那个数据
				current = current.next;// current指针下移
				head1 = head1.next;
			} else {
				current.next = head2;
				current = current.next;
				head2 = head2.next;
			}
		}
		// 合并剩余元素，说明链表2已经遍历完了，是空的
		while (head1 != null) {
			current.next = head1;
			current = current.next;
			head1 = head1.next;
		}
		// 说明链表1已经遍历完了
		while (head2 != null) {
			current.next = head2;
			current = current.next;
			head2 = head2.next;
		}
		return head;// 返回新的链表的头结点
	}

	//8 从尾到头打印单链表：
	/*
	 * 对于这种颠倒顺序的问题，我们应该就会想到栈，后进先出。所以，这一题要么自己使用栈，要么让系统使用栈，也就是递归。注意链表为空的情况。时间复杂度为O
	 * （n） 注：不要想着先将单链表反转，然后遍历输出，这样会破坏链表的结构，不建议。 方法1：（自己新建一个栈）
	 */
	public void reversePrint(Node node) {
		if (node == null)
			return;
		Stack<Node> s = new Stack<Node>();
		Node current = node;
		while (current != null) {
			s.push(current);
			current=current.next;
		}
		
		while(s.size()>0){
			System.out.print(s.pop().data+"-->");
		}
	}
	//方法2递归
	public void reversePrint2(Node node){
		if(node==null)return;
		reversePrint2(node.next);
		System.out.print(node.data+"-->");
	}
	
	//9判断单链表是否有环：
	public boolean hasCycle(Node node){
		if(node==null)return false;
		Node first=node;
		Node second=node;
		while(second!=null){
			first=first.next;//first指针走一步
			second=second.next.next;//second指针走两步
			if(first==second){//一旦两个指针相遇，说明链表是有环的
				return true;
			}
		}
		return false;
	}
	
	// 主函数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linklist l = new Linklist();
		Linklist l2 = new Linklist();
		// 添加链表元素
		for (int i = 1; i < 10; i++) {
			l.add(i);
		}
		for (int i = 4; i < 8; i++) {
			l2.add(i);
		}
		// 遍历链表元素
		l.print(l.head);
		// 求链表个数
		System.out.println();
		System.out.println("链表元素个数：" + l.getLenght(l.head));
		// 返回第k个元素的值
		System.out.println("返回第五个元素：" + l.findK(l.head, 5));
		// 返回倒数第k个元素
		System.out.println("返回倒数第二个元素：" + l.findLastNum(l.head, 2));
		// 返回倒数第k个元素
		System.out.println("返回倒数第四个元素：" + l.FinLastNum(l.head, 4).data);
		// 返回中间数
		System.out.println("中间数：" + l.findMidNum(l.head).data);
		// 合并两个有序的单链表
		System.out.print("合并两个有序的单链表：");
		Linklist l3 = new Linklist();
		l3.head = l3.mergeLinkList(l.head, l2.head);
		l3.print(l3.head);
		//从尾到头打印单链表：
		System.out.println();
		System.out.print("从尾到头打印单链表：");
		l.reversePrint(l.head);
		System.out.println();
		System.out.print("从尾到头打印单链表：");
		l.reversePrint2(l.head);
		//判断链表是否有环
		System.out.println("");
		l.add(l.head);//将头结点添加到链表当中，于是，单链表就有环了。
		System.out.println("链表是否有环："+l.hasCycle(l.head));
	}

}

// 节点类
class Node {
	int data;// 数据域
	Node next;// 指针域

	Node(int data) {
		this.data = data;
	}
}