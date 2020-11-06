package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 16953 A -> B
public class prob16953 {

	private static int BFS(int a,int b) {
		boolean[] visited = new boolean[b+1];
		Queue<String> queue = new LinkedList<>();
		queue.offer(Integer.toString(a));
		visited[a] = true;
		int attemp = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int s = 0; s < size; s++) {				
				String now = queue.poll();
				int tmp = Integer.parseInt(now);
				if(tmp == b) return attemp+1;
				if(tmp > b) continue;
				
				if(tmp*2<=b && !visited[tmp*2]) {
					queue.offer(Integer.toString(tmp*2));
					visited[tmp*2] = true;
				}
				String temp = now+"1";
				if(Long.parseLong(temp) > b) continue;
				int ttemp = Integer.parseInt(temp);
				if(ttemp<=b && !visited[ttemp]) {
					visited[ttemp] = true;
					queue.offer(temp);
				}
			}
			attemp++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(BFS(a,b));

	}

}
