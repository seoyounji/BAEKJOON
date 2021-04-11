package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2304 창고 다각형
public class prob2304 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] map = new int[1002][1002];
		int[][] input = new int[N][2];
		int large = 0;
		int value = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int position = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			input[i][0] = position;
			input[i][1] = height;
			if(value < height) {
				large = position;
				value = height;
			}
		}
		for (int i = 0; i < N; i++) {
			if(input[i][0]<large) {
				for (int j = 0; j < input[i][1]; j++) {
					for (int j2 = input[i][0]; j2 < large; j2++) {
						map[1001-j][j2]=1;
					}					
				}
			}
			else if(input[i][0] > large) {
				for (int j = 0; j < input[i][1]; j++) {
					for (int j2 = large+1; j2 <= input[i][0]; j2++) {
						map[1001-j][j2]=1;
					}
				}
			}
			else if(input[i][0]==large) {
				for (int j = 0; j < input[i][1]; j++) {
					map[1001-j][large]=1;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 1002; i++) {
			for (int j = 0; j < 1002; j++) {
				if(map[i][j]==1) result++;
			}
		}
		System.out.println(result);
	}

}
