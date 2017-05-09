package 数组;

public class Arraycopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int[] a1={1,2,3,4,5,6};
          int[] a2={10,11,12,13,14,15,16};
          System.arraycopy(a1, 2, a2, 2, 3);
          //System.arraycopy(源数组, 源数组的开始下标, 目标数组, 目标数组的下标, 拷贝的长度);
          for(int i=0;i<a2.length;i++){
        	  System.out.println(a2[i]);
          }
	}

}
