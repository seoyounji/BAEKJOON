package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1244 스위치 켜고 끄기
public class prob1244 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] sw = new int[N+1];
		for (int i = 1; i <= N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(bf.readLine());
		int student=0;
		int num=0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			student=Integer.parseInt(st.nextToken());
			num=Integer.parseInt(st.nextToken());
			switch(student) {
			case(1):
				int plus = num;
				while(num<=N) {
					sw[num] = (sw[num]+1)%2;
					num += plus;
				}
				break;
			case(2):
				sw[num] = (sw[num]+1)%2;
				int tmp=1;
				if(num-tmp>=0 && num+tmp<=N) {
					while(sw[num-tmp]==sw[num+tmp]) {
						sw[num-tmp] = (sw[num-tmp]+1)%2;
						sw[num+tmp] = (sw[num+tmp]+1)%2;
						tmp++;
						if(num-tmp<0 || num+tmp>N) break;
					}					
				}
				break;
			}
			for (int j = 1; j <= N; j++) {
				System.out.print(sw[j]+" ");
			}
			System.out.println();
		}
		for (int i = 1; i <= N; i++) {
            System.out.print(sw[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
	}

}
