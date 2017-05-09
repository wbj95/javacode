package 栈;

import java.nio.channels.IllegalSelectorException;

//数组栈
public class ArrayStack {
	public static final int DEFAULT_CAPACITY=100;//容量
	private Object stack[];
	private int top;
	ArrayStack(){//初始化
		this(DEFAULT_CAPACITY);
	}
	ArrayStack(int capatity){//初始化数组容量
		if(capatity<1)
			throw new IllegalArgumentException("capacity must be >0");
		stack=new Object[DEFAULT_CAPACITY];
		top=-1;
	}
	public boolean isEmpty(){//判断栈是否空
		return top==-1;
	}
	public boolean isFull(){//判断栈是否已经满
		return top==stack.length;
	}
	public int size(){//栈的大小
		return top+1;
	}
	public Object peek(){//返回栈顶元素，但是不删除
		if(isEmpty())
			throw new IllegalStateException("Stack is Emty");
		Object item=stack[top];
		return item;
	}
	public Object pop(){//返回栈顶元素，并删除
		if(isEmpty())
			throw new IllegalStateException("Stack is Emty");
		Object item=stack[top];
		stack[top]=null;
		top--;
		return item;
	}
	public void push(Object item){//进栈
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
		System.out.println("栈是否是空："+arr.isEmpty());
		System.out.println("栈是否满："+arr.isFull());
		System.out.println("栈的大小："+arr.size());
		System.out.print("栈顶元素：");
			System.out.println(arr.peek()+" ");
		System.out.print("出栈：");//为什么用arr.size()不行
		int len=arr.size();
		for (int i = 0; i < len; i++) {
			System.out.print(arr.pop());
		}
		System.out.println();
		System.out.println("栈的大小："+arr.size());
		System.out.println("栈是否是空："+arr.isEmpty());
		System.out.println("栈是否满："+arr.isFull());
	}
}
