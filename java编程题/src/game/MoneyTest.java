package game;

public class MoneyTest {
	/*
	public static int findFalseCoin(int []r){
		int index=0;
		//int num1[]=new int[3],num2[]=new int[3],num3[]=new int[2];
	
		int sumNum1=r[0]+r[1]+r[2];
		int sumNum2=r[3]+r[4]+r[5];
		int sumNum3=r[6]+r[7];
		if(sumNum1==sumNum2){
			if(r[0]==r[6])index=7;
			else index=6;
		}
		int sum11=r[0]+r[1];
		int sum22=r[2]+r[3];
		int sum33=r[4]+r[5];
		if(sum11==sum22){
			if(r[0]==r[4])index=5;
			else index=4;
		}
		if(sum11==sum33){
			if(r[0]==r[2])index=3;
			else index=2;
		}else{
			if(r[0]==r[2])index=1;
			else index=0;
		}
		return index;
	}*/
	/*
	 * realCoin���  start��ʼ�����±� end��������±�
	 * 
	 */
	public  int findFalseCoin2(int r[],int realCoin,int start,int end){
		if(start==end)return start;//�����ʼ�±���ڽ����±꣬˵��Ψһ�Ļ����Ǽٱ�
		if(r.length==2)return 0;//���ֻ�����Ż��ң��޷��Ƚ�
		if(end-start==1){//�������������Ż��ң��ض���һ���Ǽٱ�
			if(realCoin==r[start])return end;
			else return start;
		}
		int m;//��¼�����±�
		if(end-start<=3){//���������������С�ڵ������ţ���m=0
			m=0;
		}else{//��������������������
			m=(start+end)/3;
		}
		int sumNum1=0,sumNum2=0,sumNum3=0;//�ֳ�����
		for (int i = start; i <=start+m; i++) {
			sumNum1+=r[i];
		}
		for (int i = start; i <=start+m; i++) {
			sumNum2+=r[i+m+1];
		}
		for (int i = start; i <=end-2*(m+1); i++) {
			sumNum3+=r[i+2*(m+1)];
		}
		if(sumNum1==sumNum2){//�����һ������������ڵڶ��������������ٱ��ڵ�����
			if(realCoin==0)realCoin=r[start];
			start=start+2*(m+1);
			return findFalseCoin2(r,realCoin,start,end);
		}else{//��һ��͵ڶ��������������ȣ����������������
			if(realCoin==0)realCoin=r[end];
			end=start+2*(m+1)-1;
		return findFalseCoin2(r, realCoin, start, end);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []r2={5,5,5,5,5,5,5,9};
		MoneyTest m=new MoneyTest();
		System.out.println(m.findFalseCoin2(r2, 0, 0, r2.length-1));
	}

}
