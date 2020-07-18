package BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 14226 이모티콘
public class prob14226 {

	private static int BFS(int S) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[10000][10000];
		int time = 0;
		//화면 / 클립보드
		queue.offer(new int[] {1,0});
		//화면 / 클립보드
		visited[1][0] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] now = queue.poll();
				
				if(now[0] == S) return time;
				
				if(now[1] == 0) {
					if(!visited[now[0]][now[0]]) {						
						queue.offer(new int[] {now[0],now[0]});
						visited[now[0]][now[0]] = true;
					}
					if(now[0] > 1 && !visited[now[0]-1][now[1]]) {
						queue.offer(new int[] {now[0]-1,now[1]});
						visited[now[0]-1][now[1]] = true;
					}
				}
				else {
					if(!visited[now[0]+now[1]][now[1]]) {
						queue.offer(new int[] {now[0]+now[1],now[1]});
						visited[now[0]+now[1]][now[1]] = true;
					}
					if(now[0] >= 1 && !visited[now[0]-1][now[1]]) {
						queue.offer(new int[] {now[0]-1,now[1]});
						visited[now[0]-1][now[1]] = true;
					}
					if(!visited[now[0]][now[0]]) {
						queue.offer(new int[] {now[0],now[0]});
						visited[now[0]][now[0]] = true;
					}
				}
			}
			time++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		
		System.out.println(BFS(S));
	}

}
