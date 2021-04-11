package Algorithm_0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 3055 탈출
public class prob3055 {

	private static int R,C;
	private static char[][] map;
	private static boolean[][] visited;
	private static String result = "KAKTUS";
	private static Queue<point> water = new LinkedList<>();
	
	private static class point {
		int x; int y; int cnt;
		point(int x,int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	private static boolean isInBound(int x,int y,int R,int C) {
		return x>=0 && y>=0 && x<R && y<C;
	}
	
	private static void BFS(point start,Queue<point> water) {
		Queue<point> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x][start.y]= true;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		outer:
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				point current = queue.poll();
				
				for (int j = 0; j < 4; j++) {
					int x = current.x + dx[j];
					int y = current.y + dy[j];
					
					if(isInBound(x,y,R,C) && !visited[x][y]) {
						if(map[x][y]=='D') {
							result = Integer.toString(current.cnt+1);
							break outer;
						}
						else if(map[x][y]=='.') {
							boolean flag = true;
							for (int k = 0; k < 4; k++) {
								int tx = x + dx[k];
								int ty = y + dy[k];
								if(isInBound(tx,ty,R,C)) {
									if(map[tx][ty]=='*') {
										flag = false;
										break;
									} else {
										continue;
									}
								}
							}
							if(flag==true) {
								queue.offer(new point(x,y,current.cnt+1));
								visited[x][y] = true;
							}
						}
					}
				}
			}
			
			int waterSize = water.size();
			for (int i = 0; i < waterSize; i++) {
				point current = water.poll();
				for (int j = 0; j < 4; j++) {
					int x = current.x + dx[j];
					int y = current.y + dy[j];
					if(isInBound(x,y,R,C) && map[x][y]=='.') {
						map[x][y] = '*';
						water.offer(new point(x,y,0));
					}
				}
			}
		}
	}
	
//	private static void print() {
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		point start = new point(0,0,0);
		for (int i = 0; i < R; i++) {
			String tmp = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j]=='S') {
					//start = new point(i,j,0);
					start = new point(i,j,0);
					map[i][j]='.';
				}
				if(map[i][j]=='*') {
					water.offer(new point(i,j,0));
				}
			}
		}
		BFS(start,water);
		System.out.println(result);

	}

}
