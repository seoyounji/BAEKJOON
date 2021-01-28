package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2116 주사위 쌓기
public class prob2116 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] map = new int[N][6];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 6; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		for (int i = 1; i <= 6; i++) {
			int[][] add = new int[N][4];
			int tmpDown = 0;
			int tmpUp = 0;
			int target = i;
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < 6; j++) {
					if(map[k][j]==target) {
						tmpDown=j;
						break;
					}
				}
				switch(tmpDown) {
				case(0): tmpUp=5; break;
				case(1): tmpUp=3; break;
				case(2): tmpUp=4; break;
				case(3): tmpUp=1; break;
				case(4): tmpUp=2; break;
				case(5): tmpUp=0; break;
				}
				target = map[k][tmpUp];
				int index = 0;
				for (int j = 0; j < 6; j++) {
					if(j!=tmpDown && j!=tmpUp) add[k][index++] = map[k][j];
				}
			}
			int sum = 0;
			for (int j = 0; j < N; j++) {
				int tmp=0;
				for (int k = 0; k < 4; k++) {
					tmp = Math.max(tmp, add[j][k]);
				}
				sum+=tmp;
			}
			result = Math.max(result, sum);
		}
		System.out.println(result);
		
	}

}
