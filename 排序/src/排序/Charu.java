package ≈≈–Ú;
//≤Â»Î≈≈–Ú
public class Charu {

	public void Fun(int[] r,int n){
		int i,j;
		int temp;
		for ( i = 1; i <n; i++) {
			j=i;
			temp=r[i];//‘›¥Ê¥˝≈≈º«¬º
			while(j>0&&temp<r[j-1]){
				r[j]=r[j-1];
				j--;//º«¬ºÕ˘∫Û“∆
			}
			r[j]=temp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] r = {4,2,6,34,23,22};
		int n=r.length;
		Charu c=new Charu();
		c.Fun(r,n);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i]+" ");
		}
	}

}
