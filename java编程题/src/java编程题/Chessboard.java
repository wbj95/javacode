package java�����;

import java.util.Scanner;

//���̸������� 2^k*2^k
/*
 * board[size][size]���̣� size = 2^k ȫ�ֱ���
 * �����̣����Ͻ��±�tr,tc,���̴�Сs
 * ���ⷽ��board[dr][dc] dr,dc��ʾ���ⷽ���ڶ�ά�����λ��
 * L�͹��Ʋ�1��ʼ����
 */
public class Chessboard {
	int board[][] = new int[100][100];
	int t = 0;

	void chessBoard(int tr, int tc, int dr, int dc, int size) {
		int s, t1;// t1��ʾ���θ������õ���L�͹��Ƶı��
		if (size == 1)
			return;// ��ʾ����ֻ��һ�������������ⷽ��
		s = size / 2;
		t1 = ++t;
		//System.out.println(t1);
		// ���ⷽ�������Ϸ�
		if (dr < tr + s && dc < tc + s) {
			try {
				chessBoard(tr, tc, dr, dc, s);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			try {
				board[tr + s - 1][tc + s - 1] = t1;
				chessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		// ���ⷽ�������Ͻ�
		if (dr < tr + s && dc >= tc + s) {
			try {
				chessBoard(tr, tc + s, dr, dc, s);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} else {
			try {
				board[tr + s - 1][tc + s] = t1;
				chessBoard(tr, tc + s, tr + s - 1, tc + s, s);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		// ���ⷽ�������½�
		if (dr >= tr + s && dc < tc + s) {
			try {
				chessBoard(tr + s, tc, dr, dc, s);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} else {
			try {
				board[tr + s][tc + s - 1] = t1;
				chessBoard(tr + s, tc, tr + s, tc + s - 1, s);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		// ���ⷽ�������½�
		if (dr >= tr + s && dc >= tc + s) {
			try {
				chessBoard(tr + s, tc + s, dr, dc, s);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} else {
			try {
				board[tr + s][tc + s] = t1;
				chessBoard(tr + s, tc + s, tr + s, tc + s, s);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���������̵Ľ�k��");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		Chessboard chessboard = new Chessboard();
		System.out.println("���������ⷽ��λ�ã�dr,dc");
		// int size = 2<<k;//2��k�η�
		int size = (int) Math.pow(2, k);
		//System.out.println(size);
		int dc, dr;
		while (true) {
			dr = sc.nextInt();
			if (dr < size)
				break;
			System.out.println("�±�Խ�磬����������");
		}
		while (true) {
			dc = sc.nextInt();
			if (dc < size)
				break;
			System.out.println("�±�Խ�磬����������");
		}
		chessboard.chessBoard(0, 0, dr, dc, size);
		System.out.println("�ϵ�");
		System.out.println(chessboard.board.length);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				//if(chessboard.board[i][j] ==0) return;
				try {
					System.out.print(chessboard.board[i][j] + "  ");
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			System.out.println();
		}

	}

}
