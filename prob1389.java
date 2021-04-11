package Algorithm_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 1389 케빈 베이컨의 6단계 법칙
public class prob1389 {

	private static int N;
	private static int[][] adjMatrix;
	private static boolean[] visited;
	private static int max = Integer.MAX_VALUE;
	private static int number;
	
	private static class point {
		int x; int path;
		point(int x,int path) {
			this.x = x;
			this.path = path;
		}
	}
	private static void BFS(point start) {
		Queue<point> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x] = true;
		int path = 0;
		while(!queue.isEmpty()) {
			point current = queue.poll();
			path += current.path;
			for (int i = 1; i <= N; i++) {
				//if(i==current.x) continue;
				if(adjMatrix[current.x][i]==1 && !visited[i]) {
					queue.offer(new point(i,current.path+1));
					visited[i] = true;
				}
			}
		}
		if(max > path) {
			max = path;
			number = start.x;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = bf.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		adjMatrix = new int[N+1][N+1];

		for (int i = 0; i < M; i++) {
			String[] s = bf.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			adjMatrix[x][y] = 1;
			adjMatrix[y][x] = 1;
		}
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			BFS(new point(i,0));
		}
		System.out.println(number);
	}
	
}
