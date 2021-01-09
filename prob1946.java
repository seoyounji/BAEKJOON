package sw_typeA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 1946 신입 사원
public class prob1946 {

	private static class point implements Comparable<point>{
		int x; int y;
		point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(point o) {
			return this.x - o.x;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < test_case; i++) {
			int N = Integer.parseInt(sc.nextLine());
			
			int compare1 = 0;
			int compare2 = 0;
			
			ArrayList<int[]> list = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(x == 1) compare1 = y;
				if(y == 1) compare2 = x;
				list.add(new int[] {x,y});
			}
			
			ArrayList<point> array = new ArrayList<>();
			for(int[] t:list) {
				if(t[0] <= compare2 && t[1] <= compare1) array.add(new point(t[0],t[1]));
			}
			Collections.sort(array);
			
			int result = 1;
			int compare = array.get(0).y;
			for (int j = 1; j < array.size(); j++) {
				if(compare > array.get(j).y) {
					result++;
					compare = array.get(j).y;
				}
			}
			
			System.out.println(result);
		}

	}

}
