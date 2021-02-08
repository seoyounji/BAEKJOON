package sw_typeIM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//백준 2635 수 이어가기
public class prob2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int x = ((2*N)/3)+1; //얘보단 작아야하고
		int y = (N/2); //얘보단 커야함
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		int result=0;
		for (int i = y; i <= x; i++) {
			list1.clear();
			int num=N;
			list1.add(num);
			int tmp1=N;
			list1.add(i);
			int tmp2=i;
			while(num>=0) {
				num = tmp1- tmp2;
				if(num<0) break;
				tmp1=tmp2;
				tmp2=num;
				list1.add(tmp2);
			}
			if(result < list1.size()) {
				result = list1.size();
				list2.clear();
				for (int j = 0; j < result; j++) {
					list2.add(list1.get(j));
				}
			}
		}
		System.out.println(result);
		for (int i = 0; i < result; i++) {
			System.out.print(list2.get(i)+" ");
		}
	}

}
