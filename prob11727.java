package baekjoon;

import java.util.Scanner;

//백준 11727 2xn 타일링 2
public class prob11727 {

	private static int[] ans;
	
	private static int dp(int i) {
		if(ans[i]>0) return ans[i];
		return ans[i] = (dp(i-1) + dp(i-2)*2) % 10007;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ans = new int[n+1];
		ans[0] = 1;
		ans[1] = 1;
		
		System.out.println(dp(n));

	}

}
