package sw_typeA;

import java.util.Scanner;

//백준 9095 1, 2, 3 더하기
public class prob9095 {

	private static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(sc.nextLine());
			result = 0;
			cal(N);
			System.out.println(result);
		}
		
	}

	private static void cal(int n) {
		if(n == 0) {
			result++;
			return;
		}
		
		if(n < 0) return;
		
		cal(n-1);
		cal(n-2);
		cal(n-3);
	}

}
