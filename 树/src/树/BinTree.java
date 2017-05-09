package ��;

import java.util.Stack;

public class BinTree {

	BTNode root;

	public BinTree(BTNode root) {
		this.root = root;
	}

	public BTNode getRoot() {
		return root;
	}

	public static BTNode init() {
		BTNode a = new BTNode('A');
		BTNode b = new BTNode('B', null, a);
		BTNode c = new BTNode('C');
		BTNode d = new BTNode('D', b, c);
		BTNode e = new BTNode('E');
		BTNode f = new BTNode('F', e, null);
		BTNode g = new BTNode('G', null, f);
		BTNode h = new BTNode('H', d, g);
		return h;// ���ڵ�
	}

	// ���ʽڵ�
	public static void visit(BTNode p) {
		System.out.print(p.getValue() + " ");
	}

	// �ݹ�ʵ��ǰ�����
	public static void preorder(BTNode p) {
		if (p != null) {
			visit(p);
			preorder(p.left);
			preorder(p.right);
		}
	}

	// �ݹ�ʵ���������
	public static void inorder(BTNode p) {
		if (p != null) {
			inorder(p.left);
			visit(p);
			inorder(p.right);
		}
	}

	// �ݹ�ʵ�ֺ������
	public static void postorder(BTNode p) {
		if (p != null) {
			postorder(p.left);
			postorder(p.right);
			visit(p);
		}
	}
	//�ǵݹ�ǰ�����
	public static void iterativePreorder(BTNode p){
		Stack<BTNode> s=new Stack<BTNode>();
		if(p!=null){
			s.push(p);
			while(!s.isEmpty()){
				p=s.pop();
				visit(p);
				if(p.getRight()!=null)
					s.push(p.getRight());
				if(p.getLeft()!=null)
					s.push(p.getLeft());
			}
		}
	}
	//�ǵݹ��������
	protected static void iterativeInorder(BTNode p)  
    {  
        Stack<BTNode> stack = new Stack<BTNode>();  
        while (p != null)  
        {  
            while (p != null)  
            {  
                if (p.getRight() != null)  
                    stack.push(p.getRight());   // ��ǰ������ӽ����ջ  
                stack.push(p);                  // ��ǰ�����ջ  
                p = p.getLeft();  
            }  
            p = stack.pop();  
            while (!stack.empty() && p.getRight() == null)  
            {  
                visit(p);  
                p = stack.pop();  
            }  
            visit(p);  
            if (!stack.empty())  
                p = stack.pop();  
            else  
                p = null;  
        }  
    }  
	
	// �ǵݹ�ʵ�ֺ������  
    protected static void iterativePostorder(BTNode p)  
    {  
        BTNode q = p;  
        Stack<BTNode> stack = new Stack<BTNode>();  
        while (p != null)  
        {  
            // ��������ջ  
            for (; p.getLeft() != null; p = p.getLeft())  
                stack.push(p);  
            // ��ǰ��������ӽ������ӽ���Ѿ����  
            while (p != null && (p.getRight() == null || p.getRight() == q))  
            {  
                visit(p);  
                q = p;        // ��¼��һ����������  
                if (stack.empty())  
                    return;  
                p = stack.pop();  
            }  
            // �������ӽ��  
            stack.push(p);  
            p = p.getRight();  
        }  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinTree b = new BinTree(init());
		System.out.print(" �ݹ�ʵ��ǰ�����:");
		preorder(b.getRoot());
		System.out.println("\n");
		System.out.print(" �ݹ�ʵ���������:");
		inorder(b.getRoot());
		System.out.println("\n");

		System.out.print(" �ݹ�ʵ�ֺ������:");
		postorder(b.getRoot());
		System.out.println("\n");
		
		System.out.print(" �ǵݹ�ʵ��ǰ�����:");  
        iterativePreorder(b.getRoot());  
        System.out.println("\n");  
        
        System.out.print(" �ǵݹ�ʵ���������:");  
        iterativeInorder(b.getRoot());  
        System.out.println("\n");  
  
        System.out.print(" �ǵݹ�ʵ�ֺ������:");  
        iterativePostorder(b.getRoot());  
        System.out.println("\n");  
	}
}

class BTNode {
	Object value;
	BTNode left;
	BTNode right;

	public BTNode(char key) {
		this(key, null, null);
	}

	BTNode(Object value, BTNode leftNode, BTNode rightNode) {
		this.value = value;
		this.left = leftNode;
		this.right = rightNode;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object v) {
		this.value = v;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}
}