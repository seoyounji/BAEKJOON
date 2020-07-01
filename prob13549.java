package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 13549 숨바꼭질 3
public class prob13549 {

	private static int N,K;
	private static boolean[] visited;
	
	private static int BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		if(N == 0) {
			if(K == 0) return 0;
			queue.offer(N);
			visited[N] = true;
		} else {
			for (int i = N; i <= 100000; i = i*2) {
				if(i == K) return 0;
				queue.offer(i);
				visited[i] = true;
			}			
		}
		int time = 1;
		out:
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int tmp = queue.poll();
				if(tmp-1 == 0 && !visited[tmp-1]) {
					if(K == 0) break out;
					queue.offer(0);
					visited[0] = true;
				}
				if(tmp-1 > 0 && !visited[tmp-1]) {
					for (int j = tmp-1; j <= 100000; j = j*2) {
						if(j == K) break out;
						if(!visited[j]) {
							queue.offer(j);
							visited[j] = true;
						}
					}
				}
				if(tmp+1 <= 100000 && !visited[tmp+1]) {
					for (int j = tmp+1; j <= 100000; j = j*2) {
						if(j == K) break out;
						if(!visited[j]) {
							queue.offer(j);
							visited[j] = true;
						}
					}
				}
			}
			time++;
		}
		return time;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visited = new boolean[100001];
		System.out.println(BFS());

	}

}
