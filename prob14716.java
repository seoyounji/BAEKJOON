package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 14716 현수막
public class prob14716 {

	private static int[] dx = {-1,-1,-1,0,0,1,1,1};
	private static int[] dy = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		boolean[][] visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				if(map[i][j]==0) continue;
				answer++;
				BFS(map,visited,M,N,i,j);
			}
		}
		System.out.println(answer);
	}

	private static void BFS(int[][] map, boolean[][] visited, int m, int n,int x,int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x,y});
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 8; i++) {
				int xx = now[0] + dx[i];
				int yy = now[1] + dy[i];
				if(xx<0 || yy<0 || xx>=m || yy>=n) continue;
				if(map[xx][yy]==0) continue;
				if(visited[xx][yy]) continue;
				visited[xx][yy] = true;
				queue.offer(new int[] {xx,yy});
			}
		}
	}

}
