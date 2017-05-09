package ����;

import java.util.Stack;

//���������ʼ��
public class Linklist {

	public Node head;
	public Node current;

	// 1,�������Ԫ��
	public void add(int data) {
		if (head == null) {// ���ͷ���Ϊ�գ�˵���������û�д������ǾͰ��µĽ�㸳��ͷ���
			head = new Node(data);
			current = head;
		} else {
			// �����µĽ�㣬���ڵ�ǰ�ڵ�ĺ��棨���µĽ���������й�����
			current.next = new Node(data);
			// ������ĵ�ǰ��������ƶ�һλ
			current = current.next;// �˲��������֮��current���ָ������ӵ��Ǹ����
		}
	}
	
	//add����:����������ӽ��
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
	
	//2 ����������������ӡ������������Ĳ�����ʾ�ӽڵ�node��ʼ���б���
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

	//3 ���ؽڵ�ĸ���
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

	//4 ���ص�k���ڵ��ֵ
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

	//5 ���ص�����k��Ԫ��
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

	// ����2�����ص�����k��Ԫ��
	public Node FinLastNum(Node node, int k) {
		if (node == null || k == 0)
			return null;
		Node first = head;
		Node second = head;
		// ��second�������Ųk-1��λ��
		for (int i = 0; i < k - 1; i++) {
			second = second.next;
			if (second.next == null) {// ˵��k��ֵ�Ѿ���������ĳ�����
				return null;
			}
		}
		// ��first��second�����������ƶ���ֱ��second�ߵ����һ�����
		while (second.next != null) {
			first = first.next;
			second = second.next;
		}
		// ��second����ߵ����һ���ڵ��ʱ�򣬴�ʱfirstָ��Ľ���������Ҫ�ҵĽ��
		return first;
	}

	//6 ���ҵ������е��м��㣺����1���ȱ�����������õ�����ڵ������������λ������forѭ������λ��
	// ����2
	/*
	 * Ҳ����������ָ��first��second��ֻ���������ǣ�����ָ��ͬʱ��ǰ�ߣ�secondָ��ÿ����������
	 * firstָ��ÿ����һ����ֱ��secondָ���ߵ����һ�����ʱ�� ��ʱfirstָ����ָ�Ľ������м��㡣ע������Ϊ�գ�
	 * ���������Ϊ1��2�������ʱ�临�Ӷ�ΪO��n����
	 */
	public Node findMidNum(Node node) {
		if (node == null)
			return null;
		Node first = head;
		Node second = head;
		// ÿ���ƶ�ʱ����second����ƶ���λ��first����ƶ�һλ
		while (second != null && second.next != null) {
			first = first.next;
			second = second.next.next;
		}
		// ֱ��second����ƶ���nullʱ����ʱfirstָ��ָ���λ�þ����м����λ��
		return first;
	}

	//7 �ϲ���������ĵ������ϲ�֮���������Ȼ���򣺰��űȽ�����1������2��
	// ��������ڹ鲢��������Ҫע����������Ϊ�ա�������һ��Ϊ�յ������ֻ��ҪO (1) �Ŀռ䡣ʱ�临�Ӷ�ΪO (max(len1,len2))
	public Node mergeLinkList(Node head1, Node head2) {
		if (head1 == null && head2 == null)
			return null;// ������������ǿ�
		if (head1 == null)
			return head1;
		if (head2 == null)
			return head2;
		Node head;// ������ͷ���
		Node current;// current�ڵ�ָ��������
		// ��currentָ��head1��head2�бȽ�С�����ݣ��õ�head���
		if (head1.data < head2.data) {
			head = head1;
			current = head1;
			head1 = head1.next;
		} else {
			head = head2;
			current = head2;
			head2 = head2.next;
		}
		// ���ƹ鲢����
		while (head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				current.next = head1;// �������У�currentָ�����һ������Ӧ��С���Ǹ�����
				current = current.next;// currentָ������
				head1 = head1.next;
			} else {
				current.next = head2;
				current = current.next;
				head2 = head2.next;
			}
		}
		// �ϲ�ʣ��Ԫ�أ�˵������2�Ѿ��������ˣ��ǿյ�
		while (head1 != null) {
			current.next = head1;
			current = current.next;
			head1 = head1.next;
		}
		// ˵������1�Ѿ���������
		while (head2 != null) {
			current.next = head2;
			current = current.next;
			head2 = head2.next;
		}
		return head;// �����µ������ͷ���
	}

	//8 ��β��ͷ��ӡ������
	/*
	 * �������ֵߵ�˳������⣬����Ӧ�þͻ��뵽ջ������ȳ������ԣ���һ��Ҫô�Լ�ʹ��ջ��Ҫô��ϵͳʹ��ջ��Ҳ���ǵݹ顣ע������Ϊ�յ������ʱ�临�Ӷ�ΪO
	 * ��n�� ע����Ҫ�����Ƚ�������ת��Ȼ�����������������ƻ�����Ľṹ�������顣 ����1�����Լ��½�һ��ջ��
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
	//����2�ݹ�
	public void reversePrint2(Node node){
		if(node==null)return;
		reversePrint2(node.next);
		System.out.print(node.data+"-->");
	}
	
	//9�жϵ������Ƿ��л���
	public boolean hasCycle(Node node){
		if(node==null)return false;
		Node first=node;
		Node second=node;
		while(second!=null){
			first=first.next;//firstָ����һ��
			second=second.next.next;//secondָ��������
			if(first==second){//һ������ָ��������˵���������л���
				return true;
			}
		}
		return false;
	}
	
	// ������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linklist l = new Linklist();
		Linklist l2 = new Linklist();
		// �������Ԫ��
		for (int i = 1; i < 10; i++) {
			l.add(i);
		}
		for (int i = 4; i < 8; i++) {
			l2.add(i);
		}
		// ��������Ԫ��
		l.print(l.head);
		// ���������
		System.out.println();
		System.out.println("����Ԫ�ظ�����" + l.getLenght(l.head));
		// ���ص�k��Ԫ�ص�ֵ
		System.out.println("���ص����Ԫ�أ�" + l.findK(l.head, 5));
		// ���ص�����k��Ԫ��
		System.out.println("���ص����ڶ���Ԫ�أ�" + l.findLastNum(l.head, 2));
		// ���ص�����k��Ԫ��
		System.out.println("���ص������ĸ�Ԫ�أ�" + l.FinLastNum(l.head, 4).data);
		// �����м���
		System.out.println("�м�����" + l.findMidNum(l.head).data);
		// �ϲ���������ĵ�����
		System.out.print("�ϲ���������ĵ�����");
		Linklist l3 = new Linklist();
		l3.head = l3.mergeLinkList(l.head, l2.head);
		l3.print(l3.head);
		//��β��ͷ��ӡ������
		System.out.println();
		System.out.print("��β��ͷ��ӡ������");
		l.reversePrint(l.head);
		System.out.println();
		System.out.print("��β��ͷ��ӡ������");
		l.reversePrint2(l.head);
		//�ж������Ƿ��л�
		System.out.println("");
		l.add(l.head);//��ͷ�����ӵ������У����ǣ���������л��ˡ�
		System.out.println("�����Ƿ��л���"+l.hasCycle(l.head));
	}

}

// �ڵ���
class Node {
	int data;// ������
	Node next;// ָ����

	Node(int data) {
		this.data = data;
	}
}