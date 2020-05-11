package sw_typeA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1080 행렬
public class prob1080 {

	private static int sol(int[][] original,int[][] result,int N,int M) {
		int num = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(original[i][j] != result[i][j]) {
					if(i > N-3 || j > M-3) return -1;
					original = change(original,N,M,i,j);
					num++;
				}
			}
		}
		return num;
	}
	
	private static int[][] change(int[][] original,int N,int M,int ii,int jj) {
		for (int i = ii; i < ii+3; i++) {
			for (int j = jj; j < jj+3; j++) {
				original[i][j] = (original[i][j] == 0) ? 1:0;
			}
		}
		return original;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] original = new int[N][M];
		int[][] result = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] tmp = bf.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				original[i][j] = tmp[j] - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			char[] tmp = bf.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				result[i][j] = tmp[j] - '0';
			}
		}

		System.out.println(sol(original,result,N,M));
	}

}
