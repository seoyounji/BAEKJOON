package baekjoon;

import java.util.Scanner;

//백준 9461 파도반 수열
public class prob9461 {

	public static void main(String[] args) {
		long[] num = new long[100];
		num[0] = 1;
		num[1] = 1;
		num[2] = 1;
		num[3] = 2;
		num[4] = 2;
		num[5] = 3;
		
		int latest = 5;
		
		Scanner sc = new Scanner(System.in);
		int test_case= sc.nextInt();
		for (int t = 0; t < test_case; t++) {
			int n = sc.nextInt();
			if(num[n-1]==0) {
				for (int i = latest+1; i <= n-1; i++) {
					num[i] = num[i-1] + num[i-5];
				}
				latest = n-1;
			}
			System.out.println(num[n-1]);
		}
		
	}

}
