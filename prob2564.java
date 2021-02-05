package sw_typeIM;

import java.util.Scanner;

//백준 2564 경비원
public class prob2564 {

	private static int width, height;
	
	private static int cal(int x,int y,int sa,int sb) {
		int distance = 0;
		if(sa+x==3 || sa+x==7) {
			int tmp1 = height+y+sb;
			int tmp2 = height+(width-y)+(width-sb);
			distance = Math.min(tmp1, tmp2);
		} else if(Math.abs(sa-x)==0) {
			distance = Math.abs(y-sb);
		} else {
			if(sa==1) {
				if(x==3) distance=sb+y;
				else distance=(width-sb)+y;
			} else if(sa==2) {
				if(x==3) distance=sb+(height-y);
				else distance=(width-sb)+(height-y);
			} else if(sa==3) {
				if(x==1) distance=sb+y;
				else distance=(height-sb)+y;
			} else if(sa==4) {
				if(x==1) distance=sb+(width-y);
				else distance=(height-sb)+(width-y);
			}
		}
		return distance;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		width = sc.nextInt();
		height = sc.nextInt();
		int num = sc.nextInt();
		int[][] map = new int[num][2]; //1번째 열은 방향 2번째 열은 
		for (int i = 0; i < num; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
		}
		int x = sc.nextInt();
		int y = sc.nextInt();
		int result = 0;
		for (int i = 0; i < num; i++) {
			result += cal(map[i][0],map[i][1],x,y);
		}
		System.out.println(result);
	}
}
