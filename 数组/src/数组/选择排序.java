package Êı×é;

public class Ñ¡ÔñÅÅĞò {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={5,6,1,63,55,23,45,12};
		for(int i=0;i<a.length-1;i++){
			int min=i;
			for(int j=i+1;j<a.length;j++){
				if(a[min]>a[j]){
					min=j;
				}
				
			}
			if(min!=i){
				int temp;
				temp=a[i];
				a[i]=a[min];
				a[min]=temp;
			}
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
