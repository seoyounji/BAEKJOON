package sw_typeA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2798 블랙잭
public class prob2798 {

	private static int result;
	private static int[] output;
	
	private static void sol(int[] array,int M,int idx,int N,int start) {
		if(idx == 3) {
			int tmp = 0;
			for (int i = 0; i < 3; i++) {
				tmp += output[i];
			}
			if(tmp <= M) result = Math.max(result, tmp);
			return;
		}
		for (int i = start; i < N; i++) {
			output[idx] = array[i];
			sol(array,M,idx+1,N,i+1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[] card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		result = Integer.MIN_VALUE;
		output = new int[3];
		sol(card,M,0,N,0);
		System.out.println(result);
	}

}
