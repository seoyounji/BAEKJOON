package Algorithm_0806;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 1012 유기농 배추
public class test01 {
	
	private static int[][] map;
	private static int N,M,k;
	private static boolean[][] visited;
	private static int num;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int i = 0; i < test_case; i++) {
			num = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			k = sc.nextInt();
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int j = 0; j < k; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(map[j][j2]==1 && !visited[j][j2]) {
						point start = new point(j,j2);
						BFS(start);
						num++;
					}
				}
			}
			System.out.println(num);
		}
	}
	
	private static boolean isInBound(int x, int y, int N, int M) {
		return x>=0 && y>=0 && x<N && y<M;
	}

	public static class point {
		int x; int y;
		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void BFS(point tmp) {
		Queue<point>queue = new LinkedList<>();
		queue.offer(tmp);
		visited[tmp.x][tmp.y]= true;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		while(!queue.isEmpty()) {
			point current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int tmp_x = current.x + dx[i];
				int tmp_y = current.y + dy[i];
				if (isInBound(tmp_x,tmp_y,N,M) && map[tmp_x][tmp_y]==1 && !visited[tmp_x][tmp_y]) {
					point t = new point(tmp_x,tmp_y);
					queue.offer(t);
					visited[tmp_x][tmp_y] = true;
				}
			}
		}
	}
}
