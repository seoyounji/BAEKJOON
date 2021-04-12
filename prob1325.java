package Algorithm_0828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 1325 효율적인 해킹
public class prob1325 {

	private static List<Integer>[] adj;
	private static int N;
	private static int[] map;
	
	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(start);
		map[start]++;
		visited[start] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 0; i < adj[current].size(); i++) {
				int x = adj[current].get(i);
				if(!visited[x]) {
					queue.offer(x);
					map[start]++;
					visited[x] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1];
		int M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[y].add(x);
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			BFS(i);
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, map[i]);
		}
		for (int i = 1; i <= N; i++) {
			if(map[i]==max) System.out.print(i+" ");
		}
	}
}
