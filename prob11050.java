package baekjoon;

import java.util.Scanner;

//백준 11050 이항 계수 1
public class prob11050 {

	private static int answer = 0;
	
	private static void combi(int n,int r,boolean[] visited,int start) {
		if(r==0) {
			answer++;
			return;
		}
		for (int i = start; i < n; i++) {
			visited[i] = true;
			combi(n,r-1,visited,i+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		boolean[] visited = new boolean[n];
		combi(n,r,visited,0);
		System.out.println(answer);
	}

}
