package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2669 직사각형 네개의 합집합의 면적 구하기
public class prob2669 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100][100];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int j = x1; j < x2; j++) {
				for (int j2 = y1; j2 < y2; j2++) {
					map[j][j2]=1;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]==1) result++;
			}
		}
		System.out.println(result);
	}

}
