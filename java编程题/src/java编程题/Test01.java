package java�����;

import java.util.Scanner;

/*
 * ��Ŀ����һ������
�ù����Բ��Է����������³���
�ó����������������month��day��year��month �� day ��year��Ϊ����ֵ��
�������㣺1��month��12��1��day��31��1900��year��2050����
�ֱ���Ϊ�������ڵ��·ݡ��ա���ݣ�
ͨ�����������������������������ϸ�һ������ڡ�
���磬����Ϊ 2004 ��11 ��29 �գ���ó�������Ϊ2004 ��12 ��1 �ա�
 */
public class Test01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			int year, month, day;
			System.out.println("��ֱ�����������");
			while (true) {
				year = sc.nextInt();
				if (year >= 1900 && year <= 2050)
					break;
				System.out.println("������ݲ��ڷ�Χ�ڣ�����������");
			}
			while (true) {
				month = sc.nextInt();
				if (month >= 1 && month <= 12)
					break;
				System.out.println("�����·ݲ��ڷ�Χ�ڣ�����������");
			}
			while (true) {
				day = sc.nextInt();
				if (day >= 1 && day <= 31)
					break;
				System.out.println("�������ڲ��ڷ�Χ�ڣ�����������");
			}
			find(year, month, day);
		}
	}
	public static void find(int year, int month, int day) {
		int nextday = 0;
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				nextday=day+2;
				if(nextday>31){
					month++;
					if(month>12){month=1;year++;}
					nextday=nextday-31;
				}
				break;
			case 2:
				if (day == 29&&(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
					nextday = 2;
					month++;
					break;
				} else if (day >= 1 && day < 28) {
					nextday = day + 2;
					break;
				} else if (day == 28&&(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
					nextday = 1;//�����28��
					month++;
					break;
				}else if(day==28){//ƽ���28��
					nextday = 2;
					month++;
					break;
				} else {
					System.out.println("�޴�����");return;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				if(day>30){System.out.println("�޴�����");return;}
				else{
					nextday=day+2;
					if(nextday>30){
						month++;
						nextday=nextday-30;
					}
				}
			}
		//���
			if(year>2050){
				System.out.println("��ݳ�����Χ");
			}else
		System.out.println(year + "��" + month + "��" + nextday + "��");
	}
}
