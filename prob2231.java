package Algorithm_0809;

import java.util.Scanner;

//백준 2231 분해합
public class prob2231 {

	private static int sum (int x) {
		String tmp = Integer.toString(x);
		int sum = 0;
		for (int i = 0; i < tmp.length(); i++) {
			sum+=tmp.charAt(i)-'0';
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int n = Integer.parseInt(N);
		int start = n-(9*N.length());
		int result = 0;
		for (int i = start; i < n; i++) {
			if(i+sum(i) == n) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(result);
	}
}
