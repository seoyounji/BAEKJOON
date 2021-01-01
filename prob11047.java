package sw_typeA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 11047 동전 0
public class prob11047 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(bf.readLine());
		}
		int result = 0;
		int tmp = 0;
		for (int i = N-1; i >= 0; i--) {
			if(K < array[i]) continue;
			if(K==0) break;
			tmp = K/array[i];
			K -= array[i] * tmp;
			result += tmp;
		}
		System.out.println(result);
		
	}

}
