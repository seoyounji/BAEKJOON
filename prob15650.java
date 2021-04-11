package Algorithm_0828;

import java.util.Scanner;

//백준 15650 N과 M(2)
public class prob15650 {
	
	private static void perm(boolean[] visited,int[] output,int start,int n,int r,int prev) {
		if(start==r) {
			for (int i = 0; i < output.length; i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
			if(visited[i]) continue;
			if(prev>=0) {
				if(prev>i) continue;
			}
			visited[i] = true;
			output[start] = i;
			perm(visited,output,start+1,n,r,output[start]);
			visited[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] visited = new boolean[N+1];
		int[] output = new int[M];
		
		perm(visited,output,0,N,M,-1);
		
	}

}
