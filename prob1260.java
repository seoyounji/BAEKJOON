package sw_typeA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//백준 1260 DFS와 BFS
public class prob1260 {

	private static ArrayList<Integer> BFS;
	private static ArrayList<Integer> DFS;
	
	private static void sol(boolean[][] map,int V,int N,boolean[] visited1,boolean[] visited2) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		visited1[V] = true;
		BFS.add(V);
		while(!queue.isEmpty()) {
			int t = queue.poll();
			for (int i = 1; i <= N; i++) {
				if(map[t][i] && !visited1[i]) {
					queue.offer(i);
					visited1[i] = true;
					BFS.add(i);
				}
			}
		}
		Stack<Integer> stack = new Stack<>();
		stack.add(V);
		while(!stack.isEmpty()) {
			int t = stack.pop();
			if(visited2[t]) continue;
			visited2[t] = true;
			DFS.add(t);
			for (int i = N; i >= 1; i--) {
				if(map[t][i] && !visited2[i]) {
					stack.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = true;
			map[end][start] = true;
		}
		boolean[] visited1 = new boolean[N+1];
		boolean[] visited2 = new boolean[N+1];
		
		BFS = new ArrayList<>();
		DFS = new ArrayList<>();
		
		sol(map,V,N,visited1,visited2);
		for(int n:DFS) System.out.print(n+" ");
		System.out.println();
		for(int n:BFS) System.out.print(n+" ");
	}

}
