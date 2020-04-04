package Algorithm_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 10026 적록색약
public class prob10026 {

	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	private static boolean[][] wvisited;
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
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
	
	private static void BFS(point start) {
		Queue<point> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x][start.y]= true;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		while(!queue.isEmpty()) {
			point current = queue.poll();
			char color = map[current.x][current.y];
			for (int i = 0; i < 4; i++) {
				int x = current.x+dx[i];
				int y = current.y+dy[i];
				if(isInBound(x,y,N) && !visited[x][y] && map[x][y]==color) {
					queue.offer(new point(x,y));
					visited[x][y] = true;
				}
			}
		}
	}
	
	private static void wBFS(point start) {
		Queue<point> queue = new LinkedList<>();
		queue.offer(start);
		wvisited[start.x][start.y]= true;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		while(!queue.isEmpty()) {
			point current = queue.poll();
			char color = map[current.x][current.y];
			for (int i = 0; i < 4; i++) {
				int x = current.x + dx[i];
				int y = current.y + dy[i];
				if(isInBound(x,y,N) && !wvisited[x][y]) {
					if(color=='R' || color=='G') {
						if(map[x][y]=='R' || map[x][y]=='G') {
							queue.offer(new point(x,y));
							wvisited[x][y] = true;
						}
					} else {
						if(map[x][y]==color) {
							queue.offer(new point(x,y));
							wvisited[x][y] = true;
						}
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
		map = new char[N][N];
		visited = new boolean[N][N];
		wvisited = new boolean[N][N];
		int with = 0;
		int without = 0;
		for (int i = 0; i < N; i++) {
			String tmp = bf.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					BFS(new point(i,j));
					without++;
				}
				if(!wvisited[i][j]) {
					wBFS(new point(i,j));
					with++;
				}
			}
		}
		System.out.println(without+" "+with);
	}

}
