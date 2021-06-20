package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1912 연속합
public class prob1912 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = array[0];
		int[] result = new int[N];
		result[0] = array[0];
		for (int i = 1; i < N; i++) {
			result[i] = Math.max(array[i], result[i-1]+array[i]);
			answer = Math.max(answer, result[i]);
		}
		
		System.out.println(answer);
	}

}
