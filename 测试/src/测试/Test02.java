package ����;

import java.util.Arrays;

/**
 * @author Administrator
 * �����������Ⱦ�Ϊn�������������,ȷ�����������е�2n��Ԫ�ص���λ��
 */
public class Test02 {
	    //����������λ��
		public static double getOneMedium(int a[]){
			 double mid;
			 int length=a.length;
			 if((length%2)==0){//�ж�������ĳ�������������ż��
			      mid=(a[length/2]+a[length/2-1]+0.0)/2;
			   }else{
			          mid=a[length/2];
			      }
			  return mid;
		}  
		 public static double getMedium(int a[],int b[], int n){
	           double mid_x=getOneMedium(a);
			   double mid_y=getOneMedium(b);
			   if(n==1){//n=1
				   return (mid_x+mid_y)/2;
			   	}
			   if(mid_x==mid_y){
			       return mid_x;
			   }else if(mid_x>mid_y){//x����λ������y����λ��������x����λ��������ߵ�����y����λ�������ұߵ����������ݹ�
			        if (n%2==0) {//���鳤��Ϊż����ż�������������ڸ�������ʱ�뼰�´εݹ�ʱ�����鳤��ȡֵ��ͬ��
			        int[] x2=Arrays.copyOfRange(a,0,n/2);//��ֵ
			        int[] y2=Arrays.copyOfRange(b,n/2,n);
			        n=n/2;//ż������ĳ���
				    return getMedium(x2,y2,n);
				  }else {//���鳤��Ϊ����
					 int[] x2=Arrays.copyOfRange(a,0,n/2+1);
			         int[] y2=Arrays.copyOfRange(b,n/2,n);
			         n=n/2+1;
				     return getMedium(x2,y2,n);
				  }
			    }else{//x����λ��С��y����λ��������x����λ�������ұߵ�����y����λ���������ߵ����������ݹ�
			    	if (n%2==0) {//���鳤��Ϊż��
			    		int[] x2=Arrays.copyOfRange(a,n/2,n);
				        int[] y2=Arrays.copyOfRange(b,0,n/2);
				        n=n/2;
					    return getMedium(x2,y2,n);
					}else {//���鳤��Ϊ����
						int[] x2=Arrays.copyOfRange(a,n/2,n);
				        int[] y2=Arrays.copyOfRange(b,0,n/2+1);
				        n=n/2+1;
					    return getMedium(x2,y2,n);
					}
			        
			    }	
		 }
		 public static void main(String[] args) {
			 int[] a={23,29,20,32};
			 int[] b={23,21,33,24};
			 Arrays.sort(a);
			 Arrays.sort(b);
			 System.out.println(getMedium(a, b, 4));
		}

}
