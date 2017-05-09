package ջ;

import java.nio.channels.IllegalSelectorException;

//����ջ
public class ArrayStack {
	public static final int DEFAULT_CAPACITY=100;//����
	private Object stack[];
	private int top;
	ArrayStack(){//��ʼ��
		this(DEFAULT_CAPACITY);
	}
	ArrayStack(int capatity){//��ʼ����������
		if(capatity<1)
			throw new IllegalArgumentException("capacity must be >0");
		stack=new Object[DEFAULT_CAPACITY];
		top=-1;
	}
	public boolean isEmpty(){//�ж�ջ�Ƿ��
		return top==-1;
	}
	public boolean isFull(){//�ж�ջ�Ƿ��Ѿ���
		return top==stack.length;
	}
	public int size(){//ջ�Ĵ�С
		return top+1;
	}
	public Object peek(){//����ջ��Ԫ�أ����ǲ�ɾ��
		if(isEmpty())
			throw new IllegalStateException("Stack is Emty");
		Object item=stack[top];
		return item;
	}
	public Object pop(){//����ջ��Ԫ�أ���ɾ��
		if(isEmpty())
			throw new IllegalStateException("Stack is Emty");
		Object item=stack[top];
		stack[top]=null;
		top--;
		return item;
	}
	public void push(Object item){//��ջ
		if(isFull())
			throw new IllegalStateException("Stack is full");
		if(item==null)
			throw new IllegalStateException("item is null");
		top++;
		stack[top]=item;
	}
	public static void main(String[] args){
		ArrayStack arr=new ArrayStack();
		for (int i = 1; i < 10; i++) {
			arr.push(i);
		}
		System.out.println("ջ�Ƿ��ǿգ�"+arr.isEmpty());
		System.out.println("ջ�Ƿ�����"+arr.isFull());
		System.out.println("ջ�Ĵ�С��"+arr.size());
		System.out.print("ջ��Ԫ�أ�");
			System.out.println(arr.peek()+" ");
		System.out.print("��ջ��");//Ϊʲô��arr.size()����
		int len=arr.size();
		for (int i = 0; i < len; i++) {
			System.out.print(arr.pop());
		}
		System.out.println();
		System.out.println("ջ�Ĵ�С��"+arr.size());
		System.out.println("ջ�Ƿ��ǿգ�"+arr.isEmpty());
		System.out.println("ջ�Ƿ�����"+arr.isFull());
	}
}
