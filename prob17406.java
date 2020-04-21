package Algorithm_0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//백준 17406 배열돌리기 4
public class prob17406 {

	private static int N,M;
	private static int Result = Integer.MAX_VALUE;
	private static int[][] map;
	private static int[][] mid;
	private static List<List<Integer>> result;
	
	private static class point {
		int x; int y;
		point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int[][] deepCopy(int[][] original) {
		if(original==null) return null;
		int[][] result = new int[original.length][original[0].length];
		for (int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, result[i], 0, original[0].length);
		}
		return result;
	}
	
	private static void permutation(int[] arr,int[] output,boolean[] visited,int start,int n,int r) {
		if(start==r) {
			save(output,r);
			return;
		}
		for (int i = 0; i < n; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				output[start] = arr[i];
				permutation(arr,output,visited,start+1,n,r);
				visited[i] = false;
			}
		}
	}
	
	private static void save(int[] arr,int r) {
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			temp.add(arr[i]);
		}
		result.add(temp);
	}
	
	private static int boundary(point point,int r,int c,int s) {
		int result = 0;
		int x1 = r-s; int y1 = c-s;
		int x2 = r-s; int y2 = c+s;
		int x3 = r+s; int y3 = c-s;
		int x4 = r+s; int y4 = c+s;
		if(point.x == x1) {
			if(point.y != y1 && point.y <= y2) {
				result = 1;
				return result;
			}
		}
		if(point.x == x3) {
			if(point.y != y4 && point.y >= y3) {
				result = 3;
				return result;
			}
		}
		if(point.y == y2) {
			if(point.x != x2 && point.x <= x4) {
				result = 2;
				return result;
			}
		}
		if(point.y == y1) {
			if(point.x != x3 && point.x >= x1) {
				result = 4;
				return result;
			}
		}
		return 0;
	}
	
	private static void change(int[][] array,int r,int c,int s) {
		for (int i = s; i > 0; i--) {
			int x1 = r-i; int y1 = c-i;
			int x2 = r-i; int y2 = c+i;
			int x3 = r+i; int y3 = c-i;
			int x4 = r+i; int y4 = c+i;
			for (int j = 1; j <= N; j++) {
				for (int j2 = 1; j2 <= M; j2++) {
					int num = 0;
					if(j >= x1 && j <= x3) {
						if(j2 >= y1 && j2 <= y2) {
							num = boundary(new point(j,j2),r,c,i);
							switch(num) {
							case 1:
								array[j][j2] = mid[j][j2-1];
								break;
							case 2:
								array[j][j2] = mid[j-1][j2];
								break;
							case 3:
								array[j][j2] = mid[j][j2+1];
								break;
							case 4:
								array[j][j2] = mid[j+1][j2];
								break;
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		mid = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = new ArrayList<List<Integer>>();
		int[] index = new int[k];
		int[] tmp = new int[k];
		boolean[] visited = new boolean[k];
		for (int i = 0; i < k; i++) {
			index[i] = i+1;
		}
		List<int[]> circle = new ArrayList<int[]>();
		for (int i = 0; i < k; i++) {
			int[] temp = new int[3];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			circle.add(temp);
		}
		permutation(index, tmp, visited, 0, k, k);
		
		for (int i = 0; i < result.size(); i++) {
			int[][] array = new int[N+1][M+1];
			array = deepCopy(map);
			mid = deepCopy(map);
			List<Integer> temp = new ArrayList<Integer>();
			temp = result.get(i);
			for (int j = 0; j < temp.size(); j++) {
				int r,c,s = 0;
				int[] a = circle.get(temp.get(j)-1);
				r = a[0];
				c = a[1];
				s = a[2];
				change(array,r,c,s);
				mid = deepCopy(array);
			}
			for (int j = 1; j <= N; j++) {
				int sum = 0;
				for (int j2 = 1; j2 <= M; j2++) {
					sum += mid[j][j2];
				}
				Result = Integer.min(Result, sum);
			}
		}
		System.out.println(Result);
	}
}
