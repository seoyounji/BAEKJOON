package sw_typeA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2146 다리 만들기
public class prob2146 {

	private static int result,N;
	
	private static void set(int x1,int y1,int start,int[][] map) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x1,y1});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = tmp[0] + dx[i];
				int y = tmp[1] + dy[i];
				if(x<0 || y<0 || x>=N || y>=N) continue;
				if(map[x][y] == 1) {
					map[x][y] = start;
					queue.offer(new int[] {x,y});
				}
			}
		}
	}
	
	private static void sol(int x1,int y1,int num,int[][] map,boolean[][] visited) {
		int dist = 0;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x1,y1});
		visited[x1][y1] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int t = 0; t < size; t++) {
				int[] tmp = queue.poll();
				for (int i = 0; i < 4; i++) {
					int x = tmp[0] + dx[i];
					int y = tmp[1] + dy[i];
					if(x<0 || y<0 || x>=N || y>=N) continue;
					if(map[x][y] != 0 && map[x][y] != num) {
						result = Math.min(result, dist);
						return;
					}
					if(map[x][y] == 0 && !visited[x][y]) {
						queue.offer(new int[] {x,y});
						visited[x][y] = true;
					}
				}
			}
			dist++;
			if(dist >= result) return;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = Integer.MAX_VALUE;
		int start = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					map[i][j] = start;
					set(i,j,start,map);
					start++;
				}
			}
		}
		for (int i = 2; i < start; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(map[j][j2] == i) {
						boolean[][] visited = new boolean[N][N];
						sol(j,j2,i,map,visited);
					}
				}
			}
		}
		System.out.println(result);
	}

}
