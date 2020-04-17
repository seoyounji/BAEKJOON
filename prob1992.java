package Algorithm_0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 1992 쿼드트리
public class prob1992 {

	private static StringBuilder sb;
	private static int[][] map;
	private static int N;
	
	private static boolean go(int x,int y,int size) {
		int tmp = map[x][y];
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(tmp != map[i][j]) return false;
			}
		}
		return true;
	}
	private static void Tree(int x,int y,int size) {
		if(go(x,y,size)) sb.append(map[x][y]);
		else {
			sb.append("(");
			int newSize = size/2;
			Tree(x,y,newSize);
			Tree(x,y+newSize,newSize);
			Tree(x+newSize,y,newSize);
			Tree(x+newSize,y+newSize,newSize);
			sb.append(")");
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] tmp = bf.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		sb = new StringBuilder();
		Tree(0,0,N);
		System.out.println(sb.toString());
	}

}
