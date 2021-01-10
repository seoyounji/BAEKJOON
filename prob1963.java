package sw_typeA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 1963 소수 경로
public class prob1963 {

	private static boolean judge(int N) {
		for (int i = 2; i <= (Math.sqrt(N)); i++) {
			if(N % i == 0) return false;
		}
		return true;
	}
	
	private static int[] change(int input) {
		int[] output = new int[4];
		for (int i = 0; i < 4; i++) {
			int tmp = (int) (input / Math.pow(10, 3-i));
			input -= (tmp * Math.pow(10, 3-i));
			output[i] = tmp;
		}
		return output;
	}
	
	private static int changetwo(int[] input) {
		int output = 0;
		for (int i = 0; i < 4; i++) {
			output += input[i] * Math.pow(10, 3-i);
		}
		return output;
	}
	
	private static int[] copy(int[] input) {
		int[] output = new int[4];
		for (int i = 0; i < 4; i++) {
			output[i] = input[i];
		}
		return output;
	}
	
	private static int BFS(int A,int B) {
		int result = 0;
		boolean flag = false;
		Queue<Integer> list = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		list.add(A);
		outer:
		while(!list.isEmpty()) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int tmp = list.poll();
				if(tmp == B) {
					flag = true;
					break outer;
				}
				int[] temp = change(tmp);
				for (int j = 0; j < 4; j++) {
					for (int j2 = 1; j2 < 10; j2++) {
						int[] t = copy(temp);
						t[j] = (t[j] + j2) % 10;
						if(t[0] == 0 || t[3] == 0) continue;
						int re = changetwo(t);
						if(!visited[re] && judge(re)) {
							visited[re] = true;
							list.add(re);
						}
					}
				}
			}
			result++;
		}
		if(flag) return result;
		else return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < t; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int result = BFS(A,B);
			if(A == B) System.out.println("0");
			else {
				if(result != Integer.MAX_VALUE) System.out.println(result);
				else System.out.println("Impossible");				
			}
		}

	}

}
