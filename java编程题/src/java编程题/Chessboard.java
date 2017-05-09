package java编程题;

import java.util.Scanner;

//棋盘覆盖问题 2^k*2^k
/*
 * board[size][size]棋盘， size = 2^k 全局变量
 * 子棋盘：左上角下标tr,tc,棋盘大小s
 * 特殊方格：board[dr][dc] dr,dc表示特殊方格在二维数组的位置
 * L型骨牌才1开始编数
 */
public class Chessboard {
	int board[][] = new int[100][100];
	int t = 0;

	void chessBoard(int tr, int tc, int dr, int dc, int size) {
		int s, t1;// t1表示本次覆盖所用到的L型骨牌的编号
		if (size == 1)
			return;// 表示棋盘只有一个方格且是特殊方格
		s = size / 2;
		t1 = ++t;
		//System.out.println(t1);
		// 特殊方格在左上方
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
		// 特殊方格在右上角
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
		// 特殊方格在左下角
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
		// 特殊方格在右下角
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
		System.out.println("请输入棋盘的阶k：");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		Chessboard chessboard = new Chessboard();
		System.out.println("请输入特殊方格位置：dr,dc");
		// int size = 2<<k;//2的k次方
		int size = (int) Math.pow(2, k);
		//System.out.println(size);
		int dc, dr;
		while (true) {
			dr = sc.nextInt();
			if (dr < size)
				break;
			System.out.println("下标越界，请重新输入");
		}
		while (true) {
			dc = sc.nextInt();
			if (dc < size)
				break;
			System.out.println("下标越界，请重新输入");
		}
		chessboard.chessBoard(0, 0, dr, dc, size);
		System.out.println("断点");
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
