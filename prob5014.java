package sw_typeA;

import java.util.Scanner;

//백준 5014 스타트링크
public class prob5014 {

	private static int result;
	
	private static boolean sol(int F,int dist,int U,int D,int now,boolean[] visited) {
		while(dist != 0) {
			visited[now] = true;
			if(dist < 0 && now-D >= 1) {
				if(visited[now-D]) return false;
				dist += D;
				now -= D;
			} else if(dist > 0 && now+U <= F) {
				if(visited[now+U]) return false;
				dist -= U;
				now += U;
			} else if(dist < 0 && now-D < 1) {
				if(now+U > F) return false;
				if(visited[now+U]) return false;
				dist -= U;
				now += U;
			} else if(dist > 0 && now+U > F) {
				if(now-D < 1) return false;
				if(visited[now-D]) return false;
				dist += D;
				now -= D;
			}
			result++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();
		int dist = G-S;
		result = 0;
		boolean[] visited = new boolean[1000010];
		if(dist == 0) System.out.println(0);
		else {
			if(dist > 0 && U == 0) System.out.println("use the stairs");	
			else if(dist < 0 && D == 0) System.out.println("use the stairs");
			else {
				if(sol(F,dist,U,D,S,visited)) System.out.println(result);
				else System.out.println("use the stairs");							
			}
		}
	}

}
