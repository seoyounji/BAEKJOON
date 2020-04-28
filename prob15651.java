package Algorithm_0828;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//백준 15651 N과 M(3)
public class prob15651 {

	private static BufferedWriter bw;
	
	private static void perm(int[] output,boolean[] visited,int start,int n,int r) throws IOException {
		if(start==r) {
			for (int i = 0; i < r; i++) {
				bw.write(output[i]+" ");
				
				//System.out.print(output[i]+" ");
			}
			//System.out.println();
			bw.newLine();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			//if(visited[i]) continue;
			visited[i] = true;
			output[start] = i;
			perm(output,visited,start+1,n,r);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] output = new int[M];
		boolean[] visited = new boolean[N+1];

		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		perm(output,visited,0,N,M);
		bw.flush();
		bw.close();
	}

}
