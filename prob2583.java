package Algorithm_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2583 영역 구하기
public class prob2583 {

	private static int N, M, K, tmp;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static void print() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static class point {
		int x; int y;
		point(int x, int y){ 
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean isInBound(int x,int y,int M,int N) {
		return x>=0 && y>=0 && x<M && y<N;
	}
	
	private static void BFS(int x, int y) {
		tmp = 1;
		Queue<point> queue = new LinkedList<>();
		queue.offer(new point(x,y));
		visited[x][y] = true;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		while(!queue.isEmpty()) {
			point current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = current.x + dx[i];
				int b = current.y + dy[i];
				if(isInBound(a,b,M,N) && !visited[a][b] && map[a][b]==0) {
					queue.offer(new point(a,b));
					visited[a][b] = true;
					tmp++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			int xtmp1 = Integer.parseInt(st.nextToken());
			int ytmp1 = Integer.parseInt(st.nextToken());
			int xtmp2 = Integer.parseInt(st.nextToken());
			int ytmp2 = Integer.parseInt(st.nextToken());
			int x1 = M - ytmp1 -1;
			int y1 = xtmp1;
			int x2 = M - ytmp2;
			int y2 = xtmp2 -1;
			for (int j = x2; j <= x1; j++) {
				for (int j2 = y1; j2 <= y2; j2++) {
					map[j][j2] = 1;
				}
			}
		}
		//print();
		List<Integer> result = new ArrayList<>();
		int domain = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					BFS(i,j);
					result.add(tmp);
					domain++;
				}
			}
		}
		Collections.sort(result);
		System.out.println(domain);
		for(int x : result) {
			System.out.print(x+" ");
		}
	}

}
