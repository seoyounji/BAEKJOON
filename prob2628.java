package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 2628 종이자르기
public class prob2628 {

	private static class point {
		int size; int h1; int h2; int w1; int w2;
		point(int size,int h1,int h2,int w1,int w2) {
			this.size = size;
			this.h1 = h1;
			this.h2 = h2;
			this.w1 = w1;
			this.w2 = w2;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(bf.readLine());
		Queue<point> list = new LinkedList<>();
		list.offer(new point(width*height,0,height,0,width));
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			switch(x) {
			case(0):
				int si = list.size();
				for (int j = 0; j < si; j++) {
					point tmp = list.poll();
					if(tmp.h1<y && y<tmp.h2) {
						point temp1=new point(0,0,0,tmp.w1,tmp.w2);
						point temp2=new point(0,0,0,tmp.w1,tmp.w2);
						temp1.size = (tmp.size*(y-tmp.h1))/(tmp.h2-tmp.h1);
						temp2.size = (tmp.size*(tmp.h2-y))/(tmp.h2-tmp.h1);
						temp1.h1 = tmp.h1;
						temp1.h2 = y;
						temp2.h1 = y;
						temp2.h2 = tmp.h2;
						list.offer(temp1);
						list.offer(temp2);
					} else {
						list.offer(tmp);
					}
				}
				break;
			case(1):
				si = list.size();
				for (int j = 0; j < si; j++) {
					point tmp = list.poll();
					if(tmp.w1<y && y<tmp.w2) {
						point temp1=new point(0,tmp.h1,tmp.h2,0,0);
						point temp2=new point(0,tmp.h1,tmp.h2,0,0);
						temp1.size = (tmp.size*(y-tmp.w1))/(tmp.w2-tmp.w1);
						temp2.size = (tmp.size*(tmp.w2-y))/(tmp.w2-tmp.w1);
						temp1.w1 = tmp.w1;
						temp1.w2 = y;
						temp2.w1 = y;
						temp2.w2 = tmp.w2;
						list.offer(temp1);
						list.offer(temp2);
					} else {
						list.offer(tmp);
					}
				}
				break;
			}
		}
		int result = 0;
		while(!list.isEmpty()) {
			result = Math.max(result, list.poll().size);
		}
		System.out.println(result);
	}

}
