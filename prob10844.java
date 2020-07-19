package BAEKJOON;

import java.util.Scanner;

//백준 10844 쉬운 계단 수
public class prob10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] even = new long[10];
		long[] odd = new long[10];
		even[0] = 0;
		odd[0] = 0;
		for (int i = 1; i < 10; i++) {
			even[i] = 0;
			odd[i] = 1;
		}
		if(N == 1) {
			int result = 0;
			for (int i = 0; i < 10; i++) {
				result += odd[i];
			}
			System.out.println(result);
		}
		else {
			int start = 1;
			while(start != N) {
				if(start % 2 == 1) {
					even[0] = odd[1] % 1000000000;
					for (int i = 1; i < 9; i++) {
						even[i] = (odd[i-1]+odd[i+1]) % 1000000000;
					}
					even[9] = odd[8] % 1000000000;
				} else {
					odd[0] = even[1] % 1000000000;
					for (int i = 1; i < 9; i++) {
						odd[i] = (even[i-1]+even[i+1]) % 1000000000;
					}
					odd[9] = even[8] % 1000000000;
				}
				start++;
			}
			if(N % 2 == 0) {
				long result = 0;
				for (int i = 0; i < 10; i++) {
					result += even[i] % 1000000000;
				}
				System.out.println(result % 1000000000);
			} else {
				long result = 0;
				for (int i = 0; i < 10; i++) {
					result += odd[i] % 1000000000;
				}
				System.out.println(result % 1000000000);
			}
		}	
	}
}