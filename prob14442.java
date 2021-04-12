package Algorithm_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 14442 벽 부수고 이동하기2
public class prob14442 {

	private static int N,M,K;
	private static int[][] map;
	private static int[][] visited;
	private static int result = -1;
	
	private static class point {
		int x; int y; int path; int wall;
		point(int x,int y,int path,int wall) {
			this.x = x;
			this.y = y;
			this.path = path;
			this.wall = wall;
		}
	}
	
	private static boolean isInBound(int x,int y,int N,int M) {
		return x>=0 && y>=0 && x<N && y<M;
	}
	
	private static void BFS() {
		Queue<point> queue = new LinkedList<>();
		queue.offer(new point(0,0,1,0));
		visited[0][0] = 0;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		while(!queue.isEmpty()) {
			point current = queue.poll();
			if(current.x==N-1 && current.y==M-1) {
				result = current.path;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int x = current.x + dx[i];
				int y = current.y + dy[i];
				if(isInBound(x,y,N,M)) {
					if(visited[x][y] > current.wall) {
						if(map[x][y]==0) {
							queue.offer(new point(x,y,current.path+1,current.wall));
							visited[x][y] = current.wall;
						} else {
							if(current.wall < K) {
								queue.offer(new point(x,y,current.path+1,current.wall+1));
								visited[x][y] = current.wall+1;
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] tmp = new String[M];
			tmp = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		BFS();
		System.out.println(result);
	}

}
