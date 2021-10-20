package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 14719 빗물
public class prob14719 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] height = new int[W];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		for (int i = 1; i < W-1; i++) {
			int left = height[i],right = height[i];
			for (int j = 0; j < i; j++) {
				left = Math.max(left, height[j]);
			}
			for (int j = i+1; j < W; j++) {
				right = Math.max(right, height[j]);
			}
			if(height[i]<left && height[i]<right) {
				answer += Math.min(left, right) - height[i];
			}
		}
		
		System.out.println(answer);
	}

}
