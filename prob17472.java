package Algorithm_0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 17472 다리 만들기 2
public class prob17472 {

	private static int[][] island;
	private static int N,M,result;
	private static PriorityQueue<point> bridge;
	private static int[] parent;
	
	static class point implements Comparable<point> {
		int from; int to; int weight;
		point(int from,int to,int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(point o) {
			if(this.weight==o.weight) {
				return Integer.compare(this.from, o.from);
			}
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		island = new int[N][M];
		bridge = new PriorityQueue<>();
		result = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] visited = new boolean[N][M];
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					BFS(i,j,visited,map,num);
					num++;
				}
			}
		}
		parent = new int[num];
		for (int i = 1; i < num; i++) {
			parent[i] = i;
		}
		//boolean[] pointVisited = new boolean[num];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(island[i][j]!=0) {
					searchBridge(i,j,island[i][j]);
				}
			}
		}
		int edge = num-2;
		int cnt = 0;
		while(!bridge.isEmpty()) {
			if(cnt==edge) break;
			point tmp = bridge.poll();
			//if(!pointVisited[tmp.from] || !pointVisited[tmp.to]) {
				if(union(tmp.from,tmp.to)) {
					result += tmp.weight;
					cnt++;
					//pointVisited[tmp.from] = true;
					//pointVisited[tmp.to] = true;
				}
			//}
		}
		if(cnt!=edge) System.out.println("-1");
		else if (cnt==edge){
			System.out.println(result);
		}
	}

	private static void BFS(int i, int j, boolean[][] visited, int[][] map,int num) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		island[i][j] = num;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = current[0] + dx[k];
				int y = current[1] + dy[k];
				if(x<0 || y<0 || x>=N || y>=M) continue;
				if(visited[x][y]) continue;
				if(map[x][y]==0) continue;
				queue.offer(new int[] {x,y});
				visited[x][y] = true;
				island[x][y] = num;
			}
		}
	}
	
	private static void searchBridge(int x1,int y1,int num) {
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		boolean flag = false;
		int length = 0;
		for (int i = 0; i < 4; i++) {
			flag = false;
			length = -1;
			int x=x1,y=y1;
			while(true) {
				x += dx[i];
				y += dy[i];
				if(x<0 || y<0 || x>=N || y>=M) break;
				if(island[x][y]==num) break;
				length++;
				if(island[x][y]!=0 && island[x][y]!=num) {
					if(length<2) break;
					else {
						flag = true;
						break;
					}
					
				}
			}
			if(flag) {
				bridge.add(new point(num,island[x][y],length));
			}
		}
	}

	private static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
	private static boolean union(int x,int y) {
		if(find(x)==find(y)) return false;
		parent[find(y)] = find(x);
		return true;
	}
}
