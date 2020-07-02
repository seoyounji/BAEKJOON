package BAEKJOON;

import java.util.Scanner;

//백준 11726 2xn 타일링
public class prob11726 {

	private static int[] memo;
	
	private static int cal(int n) {
		if(memo[n] > 0) return memo[n];
		memo[n] = (cal(n-1)+cal(n-2)) % 10007;
		return memo[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n+1];
		memo[0] = 1;
		memo[1] = 1;
		System.out.println(cal(n));
	}

}
