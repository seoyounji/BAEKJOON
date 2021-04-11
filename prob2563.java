package sw_typeIM;

import java.util.Scanner;

//백준 2563 색종이
public class prob2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = 99-y-9; j <= 99-y; j++) {
				for (int j2 = x; j2 <= x+9; j2++) {
					map[j][j2]=1;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]==1) result++;
			}
		}
		System.out.println(result);
	}

}
