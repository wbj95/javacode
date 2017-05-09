package 树;

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
		return h;// 根节点
	}

	// 访问节点
	public static void visit(BTNode p) {
		System.out.print(p.getValue() + " ");
	}

	// 递归实现前序遍历
	public static void preorder(BTNode p) {
		if (p != null) {
			visit(p);
			preorder(p.left);
			preorder(p.right);
		}
	}

	// 递归实现中序遍历
	public static void inorder(BTNode p) {
		if (p != null) {
			inorder(p.left);
			visit(p);
			inorder(p.right);
		}
	}

	// 递归实现后序遍历
	public static void postorder(BTNode p) {
		if (p != null) {
			postorder(p.left);
			postorder(p.right);
			visit(p);
		}
	}
	//非递归前序遍历
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
	//非递归中序遍历
	protected static void iterativeInorder(BTNode p)  
    {  
        Stack<BTNode> stack = new Stack<BTNode>();  
        while (p != null)  
        {  
            while (p != null)  
            {  
                if (p.getRight() != null)  
                    stack.push(p.getRight());   // 当前结点右子结点入栈  
                stack.push(p);                  // 当前结点入栈  
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
	
	// 非递归实现后序遍历  
    protected static void iterativePostorder(BTNode p)  
    {  
        BTNode q = p;  
        Stack<BTNode> stack = new Stack<BTNode>();  
        while (p != null)  
        {  
            // 左子树入栈  
            for (; p.getLeft() != null; p = p.getLeft())  
                stack.push(p);  
            // 当前结点无右子结点或右子结点已经输出  
            while (p != null && (p.getRight() == null || p.getRight() == q))  
            {  
                visit(p);  
                q = p;        // 记录上一个已输出结点  
                if (stack.empty())  
                    return;  
                p = stack.pop();  
            }  
            // 处理右子结点  
            stack.push(p);  
            p = p.getRight();  
        }  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinTree b = new BinTree(init());
		System.out.print(" 递归实现前序遍历:");
		preorder(b.getRoot());
		System.out.println("\n");
		System.out.print(" 递归实现中序遍历:");
		inorder(b.getRoot());
		System.out.println("\n");

		System.out.print(" 递归实现后序遍历:");
		postorder(b.getRoot());
		System.out.println("\n");
		
		System.out.print(" 非递归实现前序遍历:");  
        iterativePreorder(b.getRoot());  
        System.out.println("\n");  
        
        System.out.print(" 非递归实现中序遍历:");  
        iterativeInorder(b.getRoot());  
        System.out.println("\n");  
  
        System.out.print(" 非递归实现后序遍历:");  
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