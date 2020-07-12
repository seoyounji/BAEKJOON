package BAEKJOON;

import java.util.Scanner;

//백준 2748 피보나치 수 2
public class prob2748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long x = 0;
		long y = 1;
		if(N==1) System.out.println(y);
		else {
			for (int i = 0; i < N-1; i++) {
				long tmpx = x;
				x = y;
				y = tmpx+x;
			}
			System.out.println(y);			
		}
	}

}
