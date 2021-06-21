package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 12851 숨바꼭질 2
public class prob12851 {

	private static int time;
	
	private static int BFS(int N,int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[100001];
		queue.offer(N);
		visited[N] = true;
		int way = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			Queue<Integer> visit = new LinkedList<>();

			for (int i = 0; i < size; i++) {
				int now = queue.poll();
				
				if(now+1>=0 && now+1<=100000 && !visited[now+1]) {
					queue.offer(now+1);
					visit.offer(now+1);
					if(now+1==K) way++;
				}
				if(now-1>=0 && now-1<=100000 && !visited[now-1]) {
					queue.offer(now-1);
					visit.offer(now-1);
					if(now-1==K) way++;
				}
				if(now*2>=0 && now*2<=100000 && !visited[2*now]) {
					queue.offer(2*now);
					visit.offer(now*2);
					if(2*now==K) way++;
				}				
			}
			while(!visit.isEmpty()) {
				visited[visit.poll()] = true;
			}
			time++;
			if(way>0) return way;
		}
		return way;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		time = 0;
		
		if(N == K) {
			System.out.println(0);
			System.out.println(1);
		}
		else if(N > K) {
			System.out.println(N - K);
			System.out.println(1);
		}
		else {
			int t = BFS(N,K);
			System.out.println(time);
			System.out.println(t);
		}
		
	}

}
