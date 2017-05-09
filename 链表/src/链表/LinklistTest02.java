package ����;

public class LinklistTest02 {

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
	//��ͷ����
	public void addFirst(Node head1,int newNum){
		head=new Node(newNum);//�����µ�ͷ���
		head.next=head1;
	}
	//��β����
	public void addLast(Node node,int newNum){
		//head=node;
		current=node;
		while(current.next!=null){
			current=current.next;
		}
	   Node	newPoint=new Node(newNum);
		current.next=newPoint;
	}
	//�ڵڼ�λ����
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
	
	//ɾ��ͷ���
	public void deleteFirst(Node node){
		head=node;
		if(head==null)return;
		head=head.next;
	}
	//ɾ��β���ڵ�
	public void deleteLast(Node node){
		head=node;
		if(head==null)return;
		current=node;
		while(current.next.next!=null){
			current=current.next;
		}
		current.next=null;
	}
	//ɾ���ڼ�λ
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
	
	//����ĳ�������Ƿ���������
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
	
	//�滻������ߵ�i��Ԫ��
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
	//�滻��i��
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
	
	//������
	public Node reverseOrder(Node head){
		if(head==null||head.next==null)return head;//�������Ϊ�ջ���ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���ԭ�����ͷ���
		current=head;
		Node next=null;//���嵱ǰ������һ�����
		Node reverseHead=null;//��ת��������ı�ͷ
		while(current!=null){
			next=current.next;//��ʱ����ס��ǰ������һ����㣬��Ϊ��һ��Ҫ��
			current.next=reverseHead;//��current����һ�����ָ���������ͷ���
			reverseHead=current;
			current=next;// ����������current�ڵ����
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
		//�滻
		System.out.println("�滻Ԫ��:");
		System.out.println(l.replace(l.head, 5,110));
		l.print(l.head);
		System.out.println();
		System.out.println(l.replace2(l.head, 3, 120));
		l.print(l.head);
		System.out.println();
		System.out.println("��ͷ����0");
		l.addFirst(l.head, 0);
		l.print(l.head);
		System.out.println();
		System.out.println("��β����119");
		l.addLast(l.head, 119);
		l.print(l.head);
		System.out.println();
		System.out.println("��ͷ���ɾ��");
		l.deleteFirst(l.head);
		l.print(l.head);
		System.out.println();
		System.out.println("��β���Ƴ�");
		l.deleteLast(l.head);
		l.print(l.head);
		System.out.println();
		System.out.println("�ڵڶ�λ֮�����");
		l.addIndex(l.head, 2, 2233);
		l.print(l.head);
		System.out.println();
		System.out.println("ɾ���ڶ�λ֮����Ǹ�Ԫ��");
		l.delectIndex(l.head, 2);
		l.print(l.head);
		System.out.println();
		System.out.println("����ת");
		LinklistTest02 l3=new LinklistTest02();
		l3.head=l.reverseOrder(l.head);
		l3.print(l3.head);
	}

}
//�ڵ���
//class Node {
//	int data;// ������
//	Node next;// ָ����
//
//	Node(int data) {
//		this.data = data;
//	}
//}