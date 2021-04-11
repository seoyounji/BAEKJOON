package Algorithm_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 7562 나이트의 이동
public class prob7562 {

	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int result;
	
	private static class point {
		int x; int y;
		point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean isInBound(int x,int y,int N) {
		return x>=0 && y>=0 && x<N && y<N;
	}
	
	private static void BFS(point start, point desc) {
		Queue<point> queue = new LinkedList<>();
		queue.offer(start);
		int cnt = 1;
		visited[start.x][start.y] = true;
		int[] dx = {-2,-1,1,2,2,1,-1,-2};
		int[] dy = {1,2,2,1,-1,-2,-2,-1};
		outer:
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				point current = queue.poll();
				for (int i = 0; i < 8; i++) {
					int x = current.x + dx[i];
					int y = current.y + dy[i];
					if(isInBound(x,y,N) && !visited[x][y]) {
						if(x==desc.x && y==desc.y) {
							result = cnt;
							break outer;
						}
						else {
							queue.offer(new point(x,y));
							visited[x][y] = true;
						}
					}
				}
			}
			cnt++;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for (int i = 0; i < test_case; i++) {
			result = 0;
			N = Integer.parseInt(bf.readLine());
			//map = new int[N][N];
			visited = new boolean[N][N];
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			point start = new point(x,y);
			st = new StringTokenizer(bf.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			point desc = new point(x,y);
			if(start==desc) {
				System.out.println(0);
			}
			else {
				BFS(start,desc);
				System.out.println(result);
			}
		}
	}

}
