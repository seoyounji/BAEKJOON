package baekjoon;

import java.util.Scanner;

//백준 1010 다리 놓기
public class prob1010 {

	private static int[][] dp = new int[31][31];
	
	private static int combi(int n,int r) {
		if(dp[n][r]>0) return dp[n][r];
		if(r==0 || n==r) return dp[n][r]=1;
		return dp[n][r] = combi(n-1,r-1)+combi(n-1,r);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int t = 0; t < test_case; t++) {		
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(combi(M,N));
		}
	}

}
