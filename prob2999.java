package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 2999 비밀 이메일
public class prob2999 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String in = bf.readLine();
		char[] input = in.toCharArray();
		int N = input.length;
		int R=1, C=1;
		for (int i = 1; i <= (N/2)+1; i++) {
			if(N%i==0) {
				if(N/i < i) break;
				R = i;
				C = N/i;
			}
		}
		char[][] map = new char[R][C];
		int index = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				map[j][i] = input[index++];
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
		}
		
	}

}
