package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 13300 방 배정
public class prob13300 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] array = new int[6][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			array[y-1][x]++;
		}
		int result = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				int num = array[i][j];
				if(num > K) {
					if(num%K==0) {
						result += num/K;
					} else {
						result += (num/K)+1;
					}
				} else if (num>0){
					result++;
				}
			}
		}
		System.out.println(result);
	}

}
