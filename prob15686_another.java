package Algorithm_0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 15686 치킨 배달 (BFS로 품)
public class prob15686_another {

	private static int N,M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int path = Integer.MAX_VALUE;
	private static List<point> chicken;
	private static boolean[] chickenvisited;
	private static List<List<point>> chickenCombi;
	
	private static class point {
		int x; int y;
		point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void combination(List<point> list,boolean[] visited,int start,int n,int r) {
		if(r==0) {
			save(list,visited,n);
			return;
		}
		if(start==n) return;
		visited[start] = true;
		combination(list,visited,start+1,n,r-1);
		visited[start] = false;
		combination(list,visited,start+1,n,r);
	}
	
	private static void save(List<point> list,boolean[] visited,int n) {
		List<point> tmp = new ArrayList<point>();
		for (int i = 0; i < n; i++) {
			if(visited[i]==true) {
				tmp.add(new point(list.get(i).x,list.get(i).y));
			}
		}
		chickenCombi.add(tmp);
	}
	
	private static boolean isInBound(int x,int y,int N) {
		return x>=0 && y>=0 && x<N && y<N;
	}
	
	private static int BFS(point input) {
		int path = 0;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		Queue<point> queue = new LinkedList<>();
		queue.offer(input);
		visited[input.x][input.y] = true;
		outer:
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				point current = queue.poll();
				if(map[current.x][current.y]==2) break outer;
				for (int j = 0; j < 4; j++) {
					int x = current.x + dx[j];
					int y = current.y + dy[j];
					//if(map[x][y]==2) break outer;
					if(isInBound(x,y,N+1) && !visited[x][y]) {
						//if(map[x][y]==2) break outer;
						queue.offer(new point(x,y));
						visited[x][y] = true;
					}
				}
			}
			path++;
		}
		return path;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		chicken = new ArrayList<point>();
		chickenCombi = new ArrayList<List<point>>();
		int num = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					chicken.add(new point(i,j));
					map[i][j]=0;
					num++;
				}
			}
		}
		chickenvisited = new boolean[num];
		combination(chicken,chickenvisited,0,num,M);
		for (int i = 0; i < chickenCombi.size(); i++) {
			List<point> tmp = chickenCombi.get(i);
			for (int k = 0; k < tmp.size(); k++) {
				map[tmp.get(k).x][tmp.get(k).y] = 2;
			}
			int result = 0;
			for (int j = 1; j < N+1; j++) {
				for (int j2 = 1; j2 < N+1; j2++) {
					if(map[j][j2]==1) {
						int t = BFS(new point(j,j2));
						for (int a = 0; a < N+1; a++) {
							for (int b = 0; b < N+1; b++) {
								visited[a][b] = false;
							}
						}
						result += t;
					}
				}
			}
			for (int k = 0; k < tmp.size(); k++) {
				map[tmp.get(k).x][tmp.get(k).y] = 0;
			}
			path = Integer.min(result, path);
		}
		System.out.println(path);
	}

}
