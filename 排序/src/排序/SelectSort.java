package ≈≈–Ú;
//—°‘Ò≈≈–Ú
public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in[]={1,3,99,45,34,76,978,65};
		P p=new P();
		//p.Select(in);
		System.out.println(" ");
		p.Maopao(in);
	}
}
class P{
	public void Select(int in[]){
		int index,temp;
		for(int i=0;i<in.length-1;i++){
			index=i;
			for(int j=i+1;j<in.length;j++){
				if(in[j]<in[index]) index=j;
			}
			if(index!=i){
				temp=in[index];
				in[index]=in[i];
				in[i]=temp;
			}
		}
		for(int i=0;i<in.length;i++){
			System.out.println(in[i]);
		}
	}
	public void Maopao(int in[]){
		int bound,exchange=in.length-1;
		while(exchange!=0){
			bound=exchange;exchange=0;
			for(int j=0;j<bound;j++){
				if(in[j]>in[j+1]) {
					int temp=in[j];in[j]=in[j+1];in[j+1]=temp;
					exchange=j;
				}
			}
		}
		for(int i=0;i<in.length;i++){
			System.out.println(in[i]);
		}
	}
}
