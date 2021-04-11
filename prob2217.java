package sw_typeA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//백준 2217 로프
public class prob2217 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			array.add(Integer.parseInt(bf.readLine()));
		}
		Collections.sort(array);
		int result = array.get(N-1);
		int num = 2;
		for (int i = N-2; i >= 0; i--) {
			result = Math.max(result, array.get(i)*num);
			num++;
		}
		System.out.println(result);
	}
	
}
