package Algorithm_0825;

import java.util.Scanner;

//백준 2606 바이러스 (가장 단순한 DFS)
public class prob2606 {
	
	private static int result;
	
	private static void DFS(boolean[][] map,int n,int start,boolean[] visited) {
		visited[start] = true;
		for (int i = 1; i <= n; i++) {
			if(map[start][i] && !visited[i]) {
				result++;
				DFS(map,n,i,visited);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] map = new boolean[N+1][N+1];
		int edge = sc.nextInt();
		for (int i = 0; i < edge; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = true;
			map[y][x] = true;
		}
		boolean[] visited = new boolean[N+1];
		DFS(map,N,1,visited);
		System.out.println(result);
	}
}
