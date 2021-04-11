package Algorithm_0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//백준 1753 최단경로
public class prob1753 {
	
	static class Edge{
		int v, weight;
		Edge(int v, int weight){
			this.v = v;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); //정점의 개수
		int E = Integer.parseInt(st.nextToken());// 간선의 개수
		int K = Integer.parseInt(br.readLine());
		List<Edge>[] adj = new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken())-1].add(new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		int[] D = new int[V];
		Arrays.fill(D, Integer.MAX_VALUE);
		boolean[] check = new boolean[V];
		//dijkstra 시작점이 a정점이라면 D[a] = 0
		D[K-1] = 0;
		for(int i = 0; i < V-1; i++) {
			int min = Integer.MAX_VALUE;//가장 작은 값을 기억할 변수
			int index = -1; //그 위치를 기억할 변수
			for( int j = 0; j < V; j++ ) {
				//아직 처리하지 않았으면서, 가장 짧은 거리라면
				if(!check[j] && min > D[j]) {
					min = D[j];
					index = j;
				}
			}
			//연결이 없는 경우 끝
			if(index == -1)
				break;
			
			//새로운 친구로부터 갈수있는 경로들을 업데이트
			for( Edge next : adj[index] ) {
				// check되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
				if( !check[next.v] && D[next.v] > D[index] + next.weight ) {
					D[next.v] = D[index] + next.weight;
				}
			}
			//처리된놈으로 체크
			check[index] = true;
		}	
		for(int i = 0; i < V; i++) {
			if( D[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(D[i]);
		}
	}
}

/*
priorityQueue 방식
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_PQ_1753 {
	static class Edge implements Comparable<Edge>{
		int v, weight;
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		@Override
		public String toString() {
			return weight + "";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		//K
		int K = sc.nextInt()-1;
		///////////////////////////
		List<Edge>[] adj = new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			//첫번째가 출발지, 두번째가 도착지, 세번째가 가중치
			adj[sc.nextInt()-1].add(new Edge(sc.nextInt()-1, sc.nextInt()));
		}
		//
		//dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		Edge[] D = new Edge[V];
		//0번에서 출발하는걸로.
		for(int i = 0; i < V; i++) {
			//원하는 출발지
			if( i == K ) {
				D[i] = new Edge(i, 0);
				check[i] = true;
			}
			else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		while( !pq.isEmpty() ) {
			Edge edge = pq.poll();
			if(edge.weight == Integer.MAX_VALUE)
				break;
			for( Edge next : adj[edge.v] ) {
				// check되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
				if( !check[next.v] && D[next.v].weight > D[edge.v].weight + next.weight ) {
					D[next.v].weight = D[edge.v].weight + next.weight;
					pq.add(D[next.v]);
				}
			}
			check[edge.v] = true;
		}
		
		for(int i = 0; i < V; i++) {
			if( D[i].weight == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(D[i]);
		}
	}
}
*/