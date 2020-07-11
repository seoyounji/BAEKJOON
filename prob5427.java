package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 5427 불
public class prob5427 {

	private static int BFS(char[][] map,int x,int y,int startx,int starty,Queue<int[]> fire,boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {startx,starty});
		visited[startx][starty] = true;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		int time = 1;
		
		while(!queue.isEmpty()) {
			int fsize = fire.size();
			for (int i = 0; i < fsize; i++) {
				int[] firenow = fire.poll();
				for (int j = 0; j < 4; j++) {
					int firex = firenow[0] + dx[j];
					int firey = firenow[1] + dy[j];
					if(firex<0 || firey<0 || firex>=x || firey>=y) continue;
					if(map[firex][firey]=='.') {
						fire.offer(new int[] {firex,firey});
						map[firex][firey] = '*';
					}
				}
			}
			
			time++;
			
			int qsize = queue.size();
			for (int i = 0; i < qsize; i++) {
				int[] now = queue.poll();
				
				for (int j = 0; j < 4; j++) {
					int nowx = now[0] + dx[j];
					int nowy = now[1] + dy[j];
					
					if(nowx<0 || nowy<0 || nowx>=x || nowy>=y) continue;
					if(nowx == 0 || nowx == x-1 || nowy == 0 || nowy == y-1) {
						if(map[nowx][nowy] == '.') return time;
					}
					if(visited[nowx][nowy]) continue;
					if(map[nowx][nowy]=='.') {
						queue.offer(new int[] {nowx,nowy});
						visited[nowx][nowy] = true;
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		
		for (int t = 0; t < test_case; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			char[][] map = new char[x][y];
			for (int i = 0; i < x; i++) {
				map[i] = bf.readLine().toCharArray();
			}
			
			boolean[][] visited = new boolean[x][y];
			
			int startx = 0,starty = 0;
			Queue<int[]> fire = new LinkedList<>();
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if(map[i][j] == '@') {
						startx = i;
						starty = j;
						map[i][j] = '.';
					}
					if(map[i][j] == '*') {
						fire.offer(new int[] {i,j});
					}
					visited[i][j] = false;
				}
			}
			
			if(startx==0||startx==x-1||starty==0||starty==y-1) System.out.println(1);
			else {				
				int result = BFS(map,x,y,startx,starty,fire,visited);
				if(result == -1) System.out.println("IMPOSSIBLE");
				else System.out.println(result);
			}
		}
	}
	
}
