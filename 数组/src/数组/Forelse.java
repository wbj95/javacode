package ����;

public class Forelse {
/*
 * ���飺
 *  1.������һ����������
 *  2.������һ�ּ򵥵����ݽṹ�����ԵĽṹ
 *  3.������һ�����������������洢����Ԫ��
 *  �����ǿ��Դ洢�������͵�Ԫ��
 *  4.�����Ϊ��һά���飬��ά���飬��ά����
 *  5.�����д洢��Ԫ������ʱͳһ��
 *  6.���鳤�Ȳ��ɸı䣬����һ�����������ǹ̶���
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] array=new int[(int)(Math.random()*10)+2];
        for(int i=0;i<array.length;i++){
        	array[i]=(int)(Math.random()*100);
        }
        for(int value:array){
        	System.out.println(value);
        }
	} 
}
//Math.random()���������
//for(int value:array) ��array�����ÿ��Ԫ�ؽ��б�����������for-eachѭ��
//��������ѭ��ֻ��������ȡ�����Ԫ�أ����ܽ��и�ֵ����ֵ���ǵ��ô�ͳ��forѭ��
