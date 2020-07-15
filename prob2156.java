package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 2156 포도주 시식
public class prob2156 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(bf.readLine());
		}
		
		if(N == 1) System.out.println(array[0]);
		else if(N == 2) {
			System.out.println(array[0]+array[1]);
		}
		else {
			int[] result = new int[N];
			result[0] = array[0];
			result[1] = array[0] + array[1];
			result[2] = Math.max(array[0], array[1]) + array[2];
			result[2] = Math.max(result[1], result[2]);
			int answer = result[2];
			for (int i = 3; i < N; i++) {
				result[i] = Math.max(result[i-3]+array[i-1], result[i-2]) + array[i];
				result[i] = Math.max(result[i-1], result[i]);
				answer = Math.max(answer, result[i]);
			}
			System.out.println(answer);
		}
		
	}

}
