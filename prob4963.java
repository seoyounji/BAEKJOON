package Algorithm_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 4963 섬의 개수
public class prob4963 {

	private static int w,h;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static class point {
		int x; int y;
		point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void BFS(point start) {
		int[] dx = {1,0,-1,0,1,1,-1,-1};
		int[] dy = {0,1,0,-1,1,-1,1,-1};
		Queue<point> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x][start.y] = true;
		while(!queue.isEmpty()) {
			point current = queue.poll();
			for (int i = 0; i < 8; i++) {
				int x = current.x + dx[i];
				int y = current.y + dy[i];
				if(x>=0 && y>=0 && x<h && y<w) {
					if(map[x][y]==1 && !visited[x][y]) {
						queue.offer(new point(x,y));
						visited[x][y] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] tmp = bf.readLine().split(" ");
			w = Integer.parseInt(tmp[0]);
			h = Integer.parseInt(tmp[1]);
			if(w==0 && h==0) break;
			map = new int [h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				String[] s = bf.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			int result = 0;
//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			//System.out.println();
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j]==1) {
						//System.out.println(i+" "+j);
						BFS(new point(i,j));
						result++;
					}
					//result++;
				}
			}
			System.out.println(result);
		}
	
		
	}

}
