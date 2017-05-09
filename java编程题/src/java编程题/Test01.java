package java编程题;

import java.util.Scanner;

/*
 * 题目：隔一日问题
用功能性测试方法测试以下程序：
该程序有三个输入变量month、day、year（month 、 day 和year均为整数值，
并且满足：1≤month≤12，1≤day≤31和1900≤year≤2050），
分别作为输入日期的月份、日、年份，
通过程序可以输出该输入日期在日历上隔一天的日期。
例如，输入为 2004 年11 月29 日，则该程序的输出为2004 年12 月1 日。
 */
public class Test01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			int year, month, day;
			System.out.println("请分别输入年月日");
			while (true) {
				year = sc.nextInt();
				if (year >= 1900 && year <= 2050)
					break;
				System.out.println("输入年份不在范围内，请重新输入");
			}
			while (true) {
				month = sc.nextInt();
				if (month >= 1 && month <= 12)
					break;
				System.out.println("输入月份不在范围内，请重新输入");
			}
			while (true) {
				day = sc.nextInt();
				if (day >= 1 && day <= 31)
					break;
				System.out.println("输入日期不在范围内，请重新输入");
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
					nextday = 1;//闰年的28号
					month++;
					break;
				}else if(day==28){//平年的28号
					nextday = 2;
					month++;
					break;
				} else {
					System.out.println("无此日期");return;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				if(day>30){System.out.println("无此日期");return;}
				else{
					nextday=day+2;
					if(nextday>30){
						month++;
						nextday=nextday-30;
					}
				}
			}
		//输出
			if(year>2050){
				System.out.println("年份超出范围");
			}else
		System.out.println(year + "年" + month + "月" + nextday + "日");
	}
}
