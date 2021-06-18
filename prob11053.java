package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 11053 가장 긴 증가하는 부분 수열
public class prob11053 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] array = new int[N];
		int[] length = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			length[i] = 1;
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(array[i] > array[j] && length[i] < length[j]+1) {
					length[i] = length[j]+1;
				}
			}
			result = Math.max(result, length[i]);
		}
		System.out.println(result);
	}

}
