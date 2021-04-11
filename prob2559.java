package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2559 수열
public class prob2559 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine()," ");
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int result = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i <= N-K; i++) {
			sum = 0;
			for (int j = i; j < i+K; j++) {
				sum += array[j];
			}
			result = Math.max(result, sum);
		}
		System.out.println(result);
	}

}
