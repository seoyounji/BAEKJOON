package Algorithm_0922;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

//정올 2283 RGB 마을, 백준 1149 RGB거리
public class prob2283 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] array = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		int[][] result = new int[N][3];
		result[0][0] = array[0][0];
		result[0][1] = array[0][1];
		result[0][2] = array[0][2];
		for (int i = 0; i < N-1; i++) {
			result[i+1][0] = Math.min(result[i][1], result[i][2]) + array[i+1][0];
			result[i+1][1] = Math.min(result[i][0], result[i][2]) + array[i+1][1];
			result[i+1][2] = Math.min(result[i][1], result[i][0]) + array[i+1][2];
		}
		int output = Math.min(result[N-1][0], result[N-1][1]);
		output = Math.min(output, result[N-1][2]);
		System.out.println(output);
	}

}
