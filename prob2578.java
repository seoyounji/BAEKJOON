package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2578 빙고
public class prob2578 {

	private static boolean[][] visited;
	
	private static boolean checkRow(int x) {
		for (int i = 0; i < 5; i++) {
			if(!visited[x][i]) return false;
		}
		return true;
	}
	private static boolean checkCol(int x) {
		for (int i = 0; i < 5; i++) {
			if(!visited[i][x]) return false;
		}
		return true;
	}
	private static boolean checkCrossR() {
		for (int i = 0; i < 5; i++) {
			if(!visited[i][i]) return false;
		}
		return true;
	}
	private static boolean checkCrossL() {
		for (int i = 0; i < 5; i++) {
			if(!visited[i][4-i]) return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[5][5];
		visited = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] call = new int[25];
		int index = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				call[index] = Integer.parseInt(st.nextToken());
				index++;
			}
		}
		int num = 0;
		for (int i = 0; i < 25; i++) {
			num=0;
			outer:
			for (int j = 0; j < 5; j++) {
				for (int j2 = 0; j2 < 5; j2++) {
					if(map[j][j2]==call[i]) {
						visited[j][j2] = true;
						break outer;
					}
				}
			}
			if(i>=11) {
				for (int j = 0; j < 5; j++) {
					if(checkRow(j)) {
						num++;
					}
				}
				if(num>=3) {
					System.out.println(i+1);
					System.exit(0);
				}
				for (int j = 0; j < 5; j++) {
					if(checkCol(j)) {
						num++;
					}
				}
				if(num>=3) {
					System.out.println(i+1);
					System.exit(0);
				}
				if(checkCrossR()) {
					num++;
					if(num>=3) {
						System.out.println(i+1);
						System.exit(0);
					}
				}
				if(checkCrossL()) {
					num++;
					if(num>=3) {
						System.out.println(i+1);
						System.exit(0);
					}
				}
			}
		}
	}
}
