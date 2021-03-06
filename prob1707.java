package Algorithm_0828;

import java.util.Scanner;

//백준 1707 이분 그래프
public class prob1707 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		for (int i = 1; i <= TestCase; i++) {
			int V = sc.nextInt();
			boolean[][] adjMatrix = new boolean[V+1][V+1];
			int E = sc.nextInt();
			for (int j = 0; j < E; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				adjMatrix[x][y] = true;
				adjMatrix[y][x] = true;
			}
			int num = 0;
			boolean[] visited = new boolean[V+1];
			for (int j = 1; j <= V; j++) {
				visited[j] = true;
				boolean flag = false;
				for (int j2 = 1; j2 <= V; j2++) {
					if(visited[j2]) continue;
					if(adjMatrix[j][j2]) {
						visited[j2] = true;
						flag = true;
					}
					if(flag) num++;
				}
			}
		}

	}

}
