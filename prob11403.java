package Algorithm_0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 11403 경로 찾기
public class prob11403 {

	private static int N;
	private static int[][] adjMatrix;
	private static boolean[][] visited;
	private static int[][] result;
	
	private static void BFS (int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 0; i < N; i++) {
				if(adjMatrix[current][i]==1 && !visited[x][i]) {
					queue.offer(i);
					visited[x][i] = true;
					result[x][i] = 1;
				}
			}
		}
	}
	
	private static void print(int[][] array) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No Input!");
		}
		adjMatrix = new int[N][N];
		visited = new boolean[N][N];
		result = new int[N][N];
		
		String tmp = null;
		for (int i = 0; i < N; i++) {
			try {
				tmp = bf.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("No Input!");
			}
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(tmp.split(" ")[j]);				
			}
		}
		
		for (int i = 0; i < N; i++) {
			BFS(i);
		}
		print(result);
	}

}
