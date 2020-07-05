package BAEKJOON;

import java.util.Scanner;

//백준 10870 피보나치 수 5
public class prob10870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n+1];
		array[0] = 0;
		
		if(n == 0) System.out.println(0);
		else {
			array[1] = 1;
			if(n == 1) System.out.println(1);
			else {
				for (int i = 2; i <= n; i++) {
					array[i] = array[i-2] + array[i-1];
				}				
				System.out.println(array[n]);
			}
		}
	}

}
