package BAEKJOON;

import java.util.Scanner;

//백준 2579 계단 오르기
public class prob2579 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] stairs = new int[n+1], sum = new int[n+1];
		stairs[0] = 0;
		sum[0] = 0;
		for (int i = 1; i <= n; i++) {
			stairs[i] = sc.nextInt();
		}
		sum[1] = stairs[1];
		if(n == 1) System.out.println(sum[1]);
		else {
			sum[2] = stairs[1]+stairs[2];
			if(n == 2) System.out.println(sum[2]);
			else {
				for (int i = 3; i <= n; i++) {
					sum[i] = Math.max(sum[i-3]+stairs[i-1]+stairs[i], sum[i-2]+stairs[i]);
				}
				System.out.println(sum[n]);							
			}
		}
	}

}
