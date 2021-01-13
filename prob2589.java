package sw_typeA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2589 보물섬
public class prob2589 {

	private static int result = 0;
	private static int h,w;
	
	private static class point {
		int x;int y;
		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void BFS(char[][] map, point start) {
		Queue<point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[h][w];
		queue.offer(start);
		visited[start.x][start.y] = true; 
		int dist = 0;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				point tmp = queue.poll();
				for (int j = 0; j < 4; j++) {
					int x = tmp.x + dx[j];
					int y = tmp.y + dy[j];
					if(x<0 || y<0 || x>=h || y>=w) continue;
					if(visited[x][y]) continue;
					if(map[x][y] == 'W') continue;
					queue.offer(new point(x,y));
					visited[x][y] = true;
				}
			}
			dist++;
		}
		result = Math.max(result, dist);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		char[][] map = new char[h][];
		for (int i = 0; i < h; i++) {
			map[i] = bf.readLine().toCharArray();
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if(map[i][j] == 'L') BFS(map,new point(i,j));
			}
		}
		System.out.println(result-1);
	}

}
