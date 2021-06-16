package BAEKJOON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 13913 숨바꼭질 4
public class prob13913 {

	private static int time;
	
	private static ArrayList<Integer> DOWN(int N,int K) {
		ArrayList<Integer> origin = new ArrayList<>(); 
		for (int i = 0; i < N-K+1; i++) {
			origin.add(N-i);
		}
		return origin;
	}
	
	private static ArrayList<Integer> copy(ArrayList<Integer> input) {
		ArrayList<Integer> output = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			output.add(input.get(i));
		}
		return output;
	}
	
	
	private static ArrayList<Integer> BFS(int N, int K) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		Queue<ArrayList<Integer>> list = new LinkedList<>();
		
		queue.offer(N);
		ArrayList<Integer> tmp = new ArrayList<>();
		tmp.add(N);
		list.offer(tmp);
		visited[N] = true;
		
		if(N == K) {
			time = 0;
			return tmp;
		}
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				
				int now = queue.poll();
				ArrayList<Integer> seq = list.poll();
				
				if(now-1 == K || now+1 == K || 2*now == K) {
					time = seq.size();
					seq.add(K);
					return seq;
				}
				
				if(now < K) {					
					if(now+1 >= 0 && now+1 <= 100000 && !visited[now+1]) {
						queue.offer(now+1);
						visited[now+1] = true;
						ArrayList<Integer> temp = copy(seq);
						temp.add(now+1);
						list.offer(temp);
					}
					if(now*2 >= 0 && now*2 <= 100000 && !visited[now*2]) {
						queue.offer(now*2);
						visited[now*2] = true;
						ArrayList<Integer> temp = copy(seq);
						temp.add(now*2);
						list.offer(temp);
					}
					if(now-1 >= 0 && now-1 <= 100000 && !visited[now-1]) {
						queue.offer(now-1);
						visited[now-1] = true;
						ArrayList<Integer> temp = copy(seq);
						temp.add(now-1);
						list.offer(temp);
					}
				}
				else {
					if(now-1 >= 0 && now-1 <= 100000 && !visited[now-1]) {
						queue.offer(now-1);
						visited[now-1] = true;
						ArrayList<Integer> temp = copy(seq);
						temp.add(now-1);
						list.offer(temp);
					}					
				}
				
			}
		}
		
		return tmp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		if(N > K) {
			System.out.println(N-K);
			ArrayList<Integer> result = DOWN(N,K);
			for (int i = 0; i < result.size(); i++) {
				System.out.print(result.get(i)+" ");
			}
		}
		else {
			ArrayList<Integer> result = BFS(N,K);
			System.out.println(time);
			for (int i = 0; i < result.size(); i++) {
				System.out.print(result.get(i)+" ");
			}			
		}
	}

}
