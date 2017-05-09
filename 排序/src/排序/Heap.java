package ����;
//������
public class Heap {

	public void build_heap(int []r,int len,int index){
		int left,right;
		int maxindex=index;
		left=index*2+1;//���ӵ��±�
		right=index*2+2;//�Һ��ӵ��±�
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
		//���һ����֧���±�Ϊ(len-1)/2
		for (int i = (len-1)/2; i>=0; i--) {//������ѣ����ڵ����Ҫ���ӽڵ�����󣬶�����
			build_heap(r, len, i);
		}
		for (int i = len-1; i>0; i--) {//�ظ�ִ�����߶Ѷ���Ԫ�ز��ؽ��ѵĲ���
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
