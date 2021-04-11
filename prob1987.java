package Algorithm_0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1987 알파벳
public class prob1987 {

	private static int R,C;
	private static char[][] map;
	private static int result = 1;
	private static boolean[] alphabet;
	private static int bridge = 1;
	
	private static void search(int x1,int y1) {
		alphabet[(int)map[x1][y1]] = true;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		for (int i = 0; i < 4; i++) {
			int x = x1 + dx[i];
			int y = y1 + dy[i];
			if(x<0 || y<0 || x>=R || y>=C || alphabet[(int)map[x][y]]) continue;
			bridge = Integer.max(bridge, ++result);
			search(x,y);
		}
		--result;
		alphabet[(int)map[x1][y1]] = false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabet = new boolean[26];
		map = new char[R][];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = (char) (map[i][j] - 'A');
			}
		}
		search(0,0);
		
		System.out.println(bridge);
	}

}
