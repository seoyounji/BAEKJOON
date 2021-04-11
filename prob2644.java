package Algorithm_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2644 촌수계산
public class prob2644 {

	private static int N,x,y;
	private static int[][] adjMatrix;
	private static boolean[] visited;
	private static int result = -1;
	
	private static class point {
		int x; int cnt;
		point(int x,int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	private static void BFS(int start,int end) {
		Queue<point> queue = new LinkedList<>();
		queue.offer(new point(start,0));
		visited[start] = true;
		while(!queue.isEmpty()) {
			point current = queue.poll();
			//부모 찾기
			for (int i = 0; i < N; i++) {
				if(adjMatrix[current.x-1][i]==1 && !visited[i+1]) {
					if(i==end-1) {
						result = current.cnt+1;
					} else {
						queue.offer(new point(i+1,current.cnt+1));
						visited[i+1] = true;
					}
				}
			}
			//자식 찾기
			for (int i = 0; i < N; i++) {
				if(adjMatrix[i][current.x-1]==1 && !visited[i+1]) {
					if(i==end-1) {
						result = current.cnt+1;
					} else {
						queue.offer(new point(i+1,current.cnt+1));
						visited[i+1] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine()," ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		adjMatrix = new int[N][N];
		visited = new boolean[N+1];
		int tmp = Integer.parseInt(bf.readLine());
		for (int i = 0; i < tmp; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjMatrix[y-1][x-1] = 1;
		}
		BFS(x,y);
		System.out.println(result);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(adjMatrix[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

}
