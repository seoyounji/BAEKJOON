package BAEKJOON;

import java.util.Scanner;

//백준 2193 이친수
public class prob2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] array = new long[N+1];
		array[0] = 0;
		array[1] = 1;
		if(N==1) System.out.println(array[1]);
		else {			
			for (int i = 2; i <= N; i++) {
				array[i] = array[i-1] + array[i-2];
			}
			System.out.println(array[N]);
		}
	}

}
