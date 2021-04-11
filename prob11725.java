package sw_typeA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준 11725 트리의 부모 찾기
public class prob11725 {

	private static int[] array;
	private static ArrayList<ArrayList<Integer>> map;
	
	private static void DFS (int start) {
		for (int i = 0; i < map.get(start).size(); i++) {
			int tmp = map.get(start).get(i);
			if(array[tmp]==0) {
				array[tmp] = start;
				DFS(tmp);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		array = new int[100001]; //각 node의 부모가 적혀있다.
		map = new ArrayList<>();
		for (int i = 0; i <= 100000; i++) {
			map.add(new ArrayList<Integer>());
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x==1) map.get(1).add(y);
			else if(y==1) map.get(1).add(x);
			else {
				map.get(x).add(y);
				map.get(y).add(x);
			}
		}
		for (int i = 1; i <= 100000; i++) {
			if(array[i]==0) DFS(i);
		}
		for (int i = 2; i <= 100000; i++) {
			if(array[i]!=0) System.out.println(array[i]);
		}
	}

}
