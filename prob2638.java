package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2638 치즈
public class prob2638 {

	private static int[][] clone(int[][] map,int N,int M) {
		int[][] output = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				output[i][j] = map[i][j];
			}
		}
		return output;
	}
	
	private static int BFS(int[][] map,int N,int M,int cheese) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		int time = 0;
		
		while(cheese != 0) {	
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.offer(new int[] {0,0});
			boolean[][] visited = new boolean[N][M];
			visited[0][0] = true;
			int[][] cloneMap = clone(map,N,M);
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				for (int i = 0; i < 4; i++) {
					int x = now[0] + dx[i];
					int y = now[1] + dy[i];
					if(x<0 || y<0 || x>=N || y>=M) continue;
					if(cloneMap[x][y] == 0 && !visited[x][y]) {
						queue.offer(new int[] {x,y});
						visited[x][y] = true;
						cloneMap[x][y] = 2;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(cloneMap[i][j] == 1) {
						int air = 0;
						for (int k = 0; k < 4; k++) {
							int x = i + dx[k];
							int y = j + dy[k];
							if(x<0 || y<0 || x>=N || y>=M) continue;
							if(cloneMap[x][y] == 2) air++;
						}
						if(air >= 2) {
							cheese--;
							map[i][j] = 0;
						}
					}
				}
			}
			time++;
		}
		return time;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int cheese = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheese++;
			}
		}
		
		System.out.println(BFS(map,N,M,cheese));
	}

}
