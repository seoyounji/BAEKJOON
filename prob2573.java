package Algorithm_0828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2573 빙산
public class prob2573 {

	private static int[][] map;
	private static boolean[][] visited;
	
	private static class point {
		int x; int y;
		point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static void BFS(int x1,int y1,int N,int M) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		Queue<point> queue = new LinkedList<>();
		queue.offer(new point(x1,y1));
		visited[x1][y1] = true;
		while(!queue.isEmpty()) {
			point current = queue.poll();
			int zero = 0;
			for (int i = 0; i < 4; i++) {
				int x = current.x+dx[i];
				int y = current.y+dy[i];
				if(x<0 || y<0 || x>=N || y>=M) continue;
				if(visited[x][y]) continue;
				if(map[x][y]==0) zero++;
				else {
					visited[x][y] = true;
					queue.offer(new point(x,y));
				}
			}
			if(map[current.x][current.y]-zero <= 0) map[current.x][current.y]=0;
			else map[current.x][current.y] -= zero; 
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] tmp = bf.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				if(map[i][j]!=0) {
				}
			}
		}
		visited = new boolean[N][M];
		int year = 0;
		while(true) {
			int result = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]!=0 && !visited[i][j]) {
						//System.out.println("BFS");
						BFS(i,j,N,M);
						//System.out.println(i+" "+j);
						flag = true;
						result++;
						
					}						
				}
			}
			for (int j2 = 0; j2 < N; j2++) {
				for (int k = 0; k < M; k++) {
					visited[j2][k] = false;
				}
			}
			if(result >= 2) break;
			if(!flag) {
				year = 0;
				break;
			}
			year++;
		}
		System.out.println(year);
	}
}
