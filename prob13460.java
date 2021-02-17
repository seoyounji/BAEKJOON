package Algorithm_0828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 13460 구슬 탈출 2
public class prob13460 {

	private static int result=-1;
	private static int N,M;
	private static boolean flag,yet;
	private static int R,B;
	
	private static class point {
		int rx; int ry; int bx; int by; int path; int num;
		point(int rx,int ry,int bx,int by,int path,int num) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.path = path;
			this.num = num;
		}
	}
	private static void BFS(char[][]map,int rx,int ry,int bx,int by) {
		Queue<point> queue = new LinkedList<>();
		queue.offer(new point(rx,ry,bx,by,0,0));
		int[] dx = {-1,1,0,0}; //위 아래 왼 오
		int[] dy = {0,0,-1,1};
		
		while(!queue.isEmpty()) {
			point current = queue.poll();
			if(flag) break;
			if(current.num>10) {
				result = -1;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int Rx = current.rx;
				int Ry = current.ry;
				int Bx = current.bx;
				int By = current.by;
				if(R==i && B==i) continue;
				if(Rx<1 || Ry<1 || Rx>=N-1 || Ry>=N-1) continue;
				if(Bx<1 || By<1 || Bx>=N-1 || By>=N-1) continue;
				if(Rx+dx[i]==Bx && Ry+dy[i]==By) { //BR
					while(true) {
						Bx += dx[i];
						By += dy[i];
						if(map[Bx][By]=='#') break;
						if(map[Bx][By]=='O') {
							result = current.path+1;
							flag = true;
							if(map[Bx+dx[i]][By+dy[i]]=='.') {
								yet = true;
							}
							break;
						}
						B = i;
					}
					while(true) {
						Rx += dx[i];
						Ry += dy[i];
						if(map[Rx][Ry]=='#') break;
						if(map[Rx][Ry]=='O') {
							result = -1;
							flag = true;
							break;
						}
						if(!yet) {
							if(Bx==Rx+dx[i] && By==Ry+dy[i]) {
								break;
							}						
						}
						R = i;
					}
				}
				else if(Bx+dx[i]==Rx && By+dy[i]==Ry) { //RB
					while(true) {
						Rx += dx[i];
						Ry += dy[i];
						if(map[Rx][Ry]=='#') break;
						if(map[Rx][Ry]=='O') {
							if(map[Rx+dx[i]][Ry+dy[i]]=='.') {
								yet = true;
							}
							result = current.path+1;
							flag = true;
							break;
						}
						R = i;
					}
					while(true) {
						Bx += dx[i];
						By += dy[i];
						if(map[Bx][By]=='#') break;
						if(map[Bx][By]=='O') {
							result = -1;
							flag = true;
							break;
						}
						if(!yet) {
							if(Bx==Rx-dx[i] && By==Ry-dy[i]) {
								break;
							}						
						}
						B = i;
					}
				} else {
					while(true) {
						Rx += dx[i];
						Ry += dy[i];
						if(map[Rx][Ry]=='#') break;
						if(map[Rx][Ry]=='O') {
							if(map[Rx+dx[i]][Ry+dy[i]]=='.') {
								yet = true;
							}
							result = current.path+1;
							flag = true;
							break;
						}
						R = i;
					}
					while(true) {
						Bx += dx[i];
						By += dy[i];
						if(map[Bx][By]=='#') break;
						if(map[Bx][By]=='O') {
							result = -1;
							flag = true;
							break;
						}
						if(!yet) {
							if(Bx==Rx-dx[i] && By==Ry-dy[i]) {
								break;
							}						
						}
						B = i;
					}
				}
				System.out.println(i+" "+(Rx-dx[i])+" "+(Ry-dy[i])+" "+(Bx-dx[i])+" "+(By-dy[i])+" "+current.path);
				queue.offer(new point(Rx-dx[i],Ry-dy[i],Bx-dx[i],By-dy[i],current.path+1,current.num+1));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][];
		//int[][] visited = new int[N][M];
		int rx=0,ry=0,bx=0,by=0;
		for (int i = 0; i < N; i++) {
			String tmp = bf.readLine();
			map[i] = tmp.toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='R') {
					rx = i; ry = j;
					map[i][j] = '.';
				} else if(map[i][j]=='B') {
					bx = i; by = j;
					map[i][j] = '.';
				} 
			}
		}
		BFS(map,rx,ry,bx,by);
		System.out.println(result);
		
	}

}
