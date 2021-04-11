package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2491 수열
public class prob2491 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int numA = 1;
		int numD = 1;
		int result = 1;
		
		for (int i = 0; i < N-1; i++) {
			if(array[i]<=array[i+1]) {
				numA++;
			}
			else {
				result = Integer.max(result, numA);
				numA=1;
			}
		}
		result = Integer.max(result, numA);
		for (int i = 0; i < N-1; i++) {
			if(array[i]>=array[i+1]) {
				numD++;
			}
			else {
				result = Integer.max(result, numD);
				numD=1;
			}
		}
		result = Integer.max(result, numD);
		System.out.println(result);
	}

}
