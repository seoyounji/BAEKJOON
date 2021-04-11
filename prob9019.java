package sw_typeA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 9019 DSLR
public class prob9019 {

	private static class point {
		int num; ArrayList<Character> list;
		point(int num,ArrayList<Character> list) {
			this.num = num;
			this.list = list;
		}
	}
	
	private static ArrayList<Character> copy(ArrayList<Character> original) {
		ArrayList<Character> result = new ArrayList<Character>();
		for(char t:original) {
			result.add(t);
		}
		return result;
	}
	
	private static ArrayList<Character> BFS(int start,int end) {
		Queue<point> queue = new LinkedList<>();
		boolean[] visited = new boolean[10001];
		queue.offer(new point(start,new ArrayList<Character>()));
		visited[start] = true;
		while(!queue.isEmpty()) {
			point now = queue.poll();
			int num = now.num;
			ArrayList<Character> list = now.list;
			if(num == end) return list;

			int D = (2*num) % 10000;
			if(!visited[D]) {
				ArrayList<Character> tmp = copy(list);
				tmp.add('D');
				queue.offer(new point(D,tmp));
				visited[D] = true;
			}
			
			int S = (num+9999) % 10000;
			if(!visited[S]) {
				ArrayList<Character> tmp = copy(list);
				tmp.add('S');
				queue.offer(new point(S,tmp));
				visited[S] = true;
			}
			
			int d1 = num / 1000;
			int d2 = (num - (1000*d1)) / 100;
			int d3 = (num - (1000*d1) - (100*d2)) / 10;
			int d4 = (num - (1000*d1) - (100*d2) - (10*d3));
			
			int L = ((d2*10 + d3)*10 + d4)*10 + d1;
			if(!visited[L]) {
				ArrayList<Character> tmp = copy(list);
				tmp.add('L');
				queue.offer(new point(L,tmp));
				visited[L] = true;
			}
			
			int R = ((d4*10 + d1)*10 + d2)*10 + d3;
			if(!visited[R]) {
				ArrayList<Character> tmp = copy(list);
				tmp.add('R');
				queue.offer(new point(R,tmp));
				visited[R] = true;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		for (int t = 0; t < test_case; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			ArrayList<Character> result = BFS(x,y);
			for(char i:result) System.out.print(i);
			System.out.println();
		}

	}

}
