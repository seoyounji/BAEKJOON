package Algorithm_0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 19236 청소년 상어
public class prob19236 {

	private static int result = Integer.MIN_VALUE;
	
	private static class point {
		int size; int dir;
		point(int size,int dir) {
			this.size = size;
			this.dir = dir;
		}
	}
	private static int[] direction(int x) {
		int[] tmp = null;
		switch(x) {
		case 1:
			tmp = new int[] {-1,0}; break;
		case 2:
			tmp = new int[] {-1,-1}; break;
		case 3:
			tmp = new int[] {0,-1}; break;
		case 4:
			tmp = new int[] {1,-1}; break;
		case 5:
			tmp = new int[] {1,0}; break;
		case 6:
			tmp = new int[] {1,1}; break;
		case 7:
			tmp = new int[] {0,1}; break;
		case 8:
			tmp = new int[] {-1,1}; break;
		}
		return tmp;
	}
	
	public static void main(String[] args) throws Exception {
		point[][] map = new point[4][4];
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			for (int j = 0; j < 4; j++) {
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[i][j] = new point(size,dir);
			}
		}
		int max = 0,sum = 0;
		if(map[0][0].size==16) {
			max = 15;
		} else max = 16;
		sum += map[0][0].size;
		map[0][0].size = 100;

		DFS(map,0,0,map[0][0].dir,sum,max);
		System.out.println(result);
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(map[i][j].size+" "+map[i][j].dir+" ");
//			}
//			System.out.println();
//		}
	}
	private static point[][] change(point[][] map,int num) {
		int start = 1;
		while(start <= num) {
			outer:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if(map[i][j].size==start) {
						int direction = map[i][j].dir;
						for (int k = direction; k < 16; k++) {
							if(k>8) k=k-8;
							int[] tmp = direction(k);
							int x = i + tmp[0];
							int y = j + tmp[1];
							if(x<0 || y<0 || x>=4 || y>=4) continue;
							if(map[x][y].size==100) continue;
							map[i][j].dir = k;
							if(map[x][y].size==0) { //물고기가 가려는 곳이 비었으면 그냥 들어가고 원래 있던 곳은 비우기
								map[x][y] = map[i][j];
								map[i][j].size = 0;
								map[i][j].dir = 0;
							} else { //안비었을때는 자리 바꾸기
								point temp = map[i][j];
								map[i][j] = map[x][y];
								map[x][y] = temp;
							}
							break outer;
						}
					}
				}
			}
			start++;
		}
		return map;
	}
	private static void DFS(point[][] maptmp,int x,int y,int direction,int sum,int max) {
		
		point[][] map = new point[4][4];
		map = change(maptmp,max);
		
		int[] tmp = direction(direction);
		for (int i = 1; i <= 4; i++) {
			int x1 = x+(tmp[0]*i);
			int y1 = y+(tmp[1]*i);
			if(x1>=0 && y1>=0 && x1<4 && y1<4) {
				if(map[x1][y1].size!=0) { //물고기가 없는 곳으로는 상어가 갈 수 없다
					if(map[x1][y1].size==max) max=map[x1][y1].size-1; //만약 잡아먹히는 물고기가 제일 큰 물고기였다면 max값 수정
	
					point[][] mapClone = new point[4][];
					for (int j = 0; j < 4; j++) {
						mapClone[j] = Arrays.copyOf(map[j], 4);
					}
					
					sum += mapClone[x1][y1].size;
					mapClone[x1][y1].size=100;
					mapClone[x][y].size=0;
					mapClone[x][y].dir=0;
					
					for (int j = 0; j < 4; j++) {
						for (int j2 = 0; j2 < 4; j2++) {
							System.out.print(mapClone[j][j2].size+" ");
						}
						System.out.println();
					}
					System.out.println();
					
					DFS(mapClone,x1,y1,map[x1][y1].dir,sum,max);
					
				} else {
					result = Integer.max(result, sum);
					return;
				}
			} else {
				result = Integer.max(result,sum);
				return;
			}
		}
	}

	
}
