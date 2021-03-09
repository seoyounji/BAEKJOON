package Algorithm_0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//정올 1733 오목, 백준 2615 오목
public class prob1733 {

	private static boolean flag;
	private static int[] dx = {-1,0,1,1};
	private static int[] dy = {1,1,1,0};
	private static int[] reverse_dx = {1,0,-1,-1};
	private static int[] reverse_dy = {-1,-1,-1,0};
	
	private static void DFS(int i,int j,int x1,int y1,int index,int target,int num,int[][] map) {

		if(num==5) {
			flag = true;
			int x = x1 + dx[index];
			int y = y1 + dy[index];
			if(x>0 && y>0 && x<20 && y<20) {
				if(map[x][y]==target) flag = false;
			}
			x = i + reverse_dx[index];
			y = j + reverse_dy[index];
			if(x>0 && y>0 && x<20 && y<20) {
				if(map[x][y]==target) flag = false;
			}
		}
		int idx = index;
		int number = num + 1;
		for (int k = 0; k < 4; k++) {
			int x = x1 + dx[k];
			int y = y1 + dy[k];
			if(x<=0 || y<=0 || x>=20 || y>=20) continue;
			if(map[x][y]!=target) continue;
			index = idx;
			if(index==10) index=k;
			if(index!=k) continue;
			//System.out.println(x+" "+y+" "+index+" "+number);
			DFS(i,j,x,y,index,target,number,map);
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[][] map = new int[20][20];
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i < 20; i++) {
			String[] tmp = bf.readLine().split(" ");
			for (int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(tmp[j-1]);
			}
		}
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if(map[i][j]!=0) {
					flag = false;
					//System.out.println("start : "+i+" "+j);
					DFS(i,j,i,j,10,map[i][j],1,map);
					if(flag) {
						System.out.println(map[i][j]);
						System.out.println(i+" "+j);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(0);
	}
}
