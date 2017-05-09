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
	 * realCoin真币  start起始数组下标 end数组结束下标
	 * 
	 */
	public  int findFalseCoin2(int r[],int realCoin,int start,int end){
		if(start==end)return start;//如果起始下标等于结束下标，说明唯一的货币是假币
		if(r.length==2)return 0;//如果只有两张货币，无法比较
		if(end-start==1){//如果分组后有两张货币，必定有一张是假币
			if(realCoin==r[start])return end;
			else return start;
		}
		int m;//记录分组下标
		if(end-start<=3){//如果分组后货币数量小于等于四张，令m=0
			m=0;
		}else{//分组后货币数量大于四张
			m=(start+end)/3;
		}
		int sumNum1=0,sumNum2=0,sumNum3=0;//分成三组
		for (int i = start; i <=start+m; i++) {
			sumNum1+=r[i];
		}
		for (int i = start; i <=start+m; i++) {
			sumNum2+=r[i+m+1];
		}
		for (int i = start; i <=end-2*(m+1); i++) {
			sumNum3+=r[i+2*(m+1)];
		}
		if(sumNum1==sumNum2){//如果第一组货币重量等于第二组货币重量，则假币在第三组
			if(realCoin==0)realCoin=r[start];
			start=start+2*(m+1);
			return findFalseCoin2(r,realCoin,start,end);
		}else{//第一组和第二组货币重量不相等，则第三组货币是真币
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
