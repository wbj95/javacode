package ����;

public class ��ά���� {

	public static void main(String[]args) {
		// TODO Auto-generated method stub
       int[][] a1={{11,22,33,44},{5,6,7,8},{55,66,77},{1,2,3,9}};
       System.out.println(a1.length+"��һά����");
       //����
       for(int i=0;i<a1.length;i++){
    	   for(int j=0;j<a1[i].length;j++){
    		   System.out.println(a1[i][j]);
    	   }
       }
       //���һ��Ԫ��
       System.out.println(a1[a1.length-1][a1[a1.length-1].length-1]);
	}

}
