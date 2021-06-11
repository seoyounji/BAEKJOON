package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//백준 9205 맥주 마시면서 걸어가기
public class prob9205 {
	
	private static int cal(int[] start,int[] end) {
		return Math.abs(start[0]-end[0]) + Math.abs(start[1]-end[1]);
	}
	
	private static boolean judge(int storeN,int[] house,int[] rock,ArrayList<int[]> store) {
		Queue<int[]> position = new LinkedList<>();
		Queue<boolean[]> visited = new LinkedList<>();
		position.offer(house);
		boolean[] tmp = new boolean[storeN];
		visited.offer(tmp);
		while(!position.isEmpty()) {
			int[] now = position.poll();
			boolean[] visit = visited.poll();
			if(cal(now,rock) <= 1000) return true;
			for (int i = 0; i < storeN; i++) {
				if(visit[i]) continue;
				if(cal(now,store.get(i)) <= 1000) {
					position.offer(store.get(i));
					visit[i] = true;
					visited.offer(visit);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(bf.readLine());
		for (int t = 0; t < test_case; t++) {
			int storeN = Integer.parseInt(bf.readLine());
			ArrayList<int[]> store = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[] house = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			for (int n = 0; n < storeN; n++) {
				st = new StringTokenizer(bf.readLine());
				int[] tmp = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
				store.add(tmp);
			}
			st = new StringTokenizer(bf.readLine());
			int[] rock = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			
			if(judge(storeN,house,rock,store)) System.out.println("happy");
			else System.out.println("sad");
		}
	}

}
