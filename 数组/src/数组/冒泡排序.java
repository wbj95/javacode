package Êý×é;

public class Ã°ÅÝÅÅÐò {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={5,2,9,32,6,22};
		int temp;
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		for(int k=0;k<a.length;k++){
			System.out.println(a[k]);
		}
	}

}
