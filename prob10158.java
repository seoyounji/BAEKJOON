package sw_typeIM;

import java.util.Scanner;

//백준 10158 개미
public class prob10158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();
		
		p += t; q += t;
		int x=0,y=0;
		if((p/w)%2==1) {
			x=w-(p%w);
		} else if((p/w)%2==0) {
			x=p%w;
		}
		if((q/h)%2==1) {
			y=h-(q%h);
		} else if((q/h)%2==0) {
			y=q%h;
		}
		System.out.println(x+" "+y);
	}

}
