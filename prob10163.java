package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 10163 색종이
public class prob10163 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] map = new int[102][102];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for (int j = 0; j < height; j++) {
				for (int j2 = 0; j2 < width; j2++) {
					map[101-y-j][x+j2] = i;
				}
			}
		}
		int result = 0;
		for (int k = 1; k <= N; k++) {
			result = 0;
			for (int i = 0; i < 102; i++) {
				for (int j = 0; j < 102; j++) {
					if(map[i][j]==k) result++;
				}
			}
			System.out.println(result);
		}
	}

}
