package sw_typeIM;

import java.util.Scanner;

//백준 10157 자리배정
public class prob10157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int N = sc.nextInt();
		if(N>C*R) {
			System.out.println("0");
		}
		else {
			int index = 1;
			int tmpC = C-1;
			int tmpR = R;
			int row = R, col = 0;
			int inc = -1;
			int[][] map = new int[R][C];
			outer:
			while(index <= N) {
				for (int i = 0; i < tmpR; i++) {
					row += inc;
					map[row][col] = index;
					if(index==N) break outer;
					index++;
				}
				tmpR--;
				for (int i = 0; i < tmpC; i++) {
					col -= inc;
					map[row][col] = index;
					if(index==N) break outer;
					index++;
				}
				tmpC--;
				inc *= -1;
			}
			System.out.println((col+1)+" "+(R-row));
		}
	}

}
