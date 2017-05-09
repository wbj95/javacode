package 排序;
//堆排序
public class Heap {

	public void build_heap(int []r,int len,int index){
		int left,right;
		int maxindex=index;
		left=index*2+1;//左孩子的下标
		right=index*2+2;//右孩子的下标
		if(left<len&&r[left]>r[maxindex])maxindex=left;
		if(right<len&&r[right]>r[maxindex])maxindex=right;
		if(maxindex!=index){
			int temp=r[maxindex];
			r[maxindex]=r[index];
			r[index]=temp;
			build_heap(r, len, maxindex);
		}
	}
	
	public void heap_sort(int []r,int len){
		//最后一个分支的下标为(len-1)/2
		for (int i = (len-1)/2; i>=0; i--) {//变成最大堆，父节点的数要比子节点的数大，二叉树
			build_heap(r, len, i);
		}
		for (int i = len-1; i>0; i--) {//重复执行移走堆顶的元素并重建堆的操作
			int temp=r[0];
			r[0]=r[i];
			r[i]=temp;
			build_heap(r, i, 0);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []r={3,533,23,44,333,33,6};
		Heap h=new Heap();
		h.heap_sort(r, r.length);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i]+" ");
		}
	}

}
