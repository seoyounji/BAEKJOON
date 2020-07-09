package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1600 말이 되고픈 원숭이
public class prob1600 {

	private static int BFS(int K,int x,int y,int[][] map) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		int[] hx = {2,2,-2,-2,1,1,-1,-1};
		int[] hy = {1,-1,1,-1,2,-2,2,-2};
		
		int[][][] visited = new int[x][y][K+1];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for (int j2 = 0; j2 < K+1; j2++) {
					visited[i][j][j2] = Integer.MAX_VALUE;
				}
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		int[] in = {0,0,K,0};
		queue.offer(in);
		visited[0][0][K] = 0;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0] == x-1 && now[1] == y-1) return now[3];
			//일단 한칸씩 움직이는것부터
			for (int i = 0; i < 4; i++) {
				int nowx = now[0] + dx[i];
				int nowy = now[1] + dy[i];
				if(nowx < 0 || nowy < 0 || nowx >= x || nowy >= y) continue;
				if(map[nowx][nowy] == 1) continue;
				if(visited[nowx][nowy][now[2]] <= now[3]+1) continue;
				int[] t = {nowx,nowy,now[2],now[3]+1};
				queue.offer(t);
				visited[nowx][nowy][now[2]] = now[3]+1;
			}
			//말처럼 움직이기
			if(now[2] >= 1) {
				for (int i = 0; i < 8; i++) {
					int nowx = now[0] + hx[i];
					int nowy = now[1] + hy[i];
					if(nowx < 0 || nowy < 0 || nowx >= x || nowy >= y) continue;
					if(map[nowx][nowy] == 1) continue;
					if(visited[nowx][nowy][now[2]-1] <= now[3]+1) continue;
					int[] t = {nowx,nowy,now[2]-1,now[3]+1};
					queue.offer(t);
					visited[nowx][nowy][now[2]-1] = now[3]+1;
				}				
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[][] map = new int[x][y];
		
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = BFS(K,x,y,map);
		System.out.println(result);
		
	}

}
