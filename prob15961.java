package Algorithm_0828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 15961 회전 초밥
public class prob15961 {

	private static int N,d,k,c,arr[],visit[];
	
	private static int solve() {
		int total=0,max=0;
		for (int i = 0; i < k; i++) {
			if(visit[arr[i]]==0) total++;
			visit[arr[i]]++;
		}
		max = total;
		for (int i = 1; i < N; i++) {
			if(max <= total) {
				if(visit[c] == 0) max = total + 1;
				else max = total;
			}
			visit[arr[i-1]]--;
			if(visit[arr[i-1]]==0) total--;
			if(visit[arr[(i+k-1)%N]]==0) total++;
			visit[arr[(i+k-1)%N]]++;
		}
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new int[d+1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		System.out.println(solve());
	}

}
