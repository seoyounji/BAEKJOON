package Algorithm_0828;

import java.util.Scanner;

//백준 15649 N과 M(1) (가장 단순한 사전식 수열)
public class prob15649 {

	private static void perm(int[] arr,int[] output,boolean[] visited,int start,int n,int r) {
		if(start==r) {
			for (int i = 0; i < r; i++) {
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[start] = arr[i+1];
			perm(arr,output,visited,start+1,n,r);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		boolean[] visited = new boolean[N];
		int[] output = new int[M];
		perm(arr,output,visited,0,N,M);
	}

}
