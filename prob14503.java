package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 14503 로봇 청소기
public class prob14503 {

	private static int BFS(int N,int M,int[][] map,int[] start) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int[] bx = {1,0,-1,0};
		int[] by = {0,-1,0,1};
		
		int answer = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start[0],start[1],start[2]});
		outer:
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(map[now[0]][now[1]]!=2) {
				answer++;
				map[now[0]][now[1]] = 2;
			}
			int d = now[2];
			for (int i = 0; i < 4; i++) {
				d = (d+3)%4;
				int x = now[0] + dx[d];
				int y = now[1] + dy[d];
				//if(x<0 || y<0 || x>=N || y>=M) continue;
				if(map[x][y]!=1 && map[x][y]!=2) {
					queue.offer(new int[] {x,y,d});
					continue outer;
				}
			}
			int x = now[0] + bx[now[2]];
			int y = now[1] + by[now[2]];
			//if(x<0 || y<0 || x>=N || y>=M) continue outer;
			if(map[x][y]==1) return answer;
			queue.offer(new int[] {x,y,now[2]});
		}
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(BFS(N,M,map,new int[] {r,c,d}));
	}

}
