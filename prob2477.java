package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2477 참외밭
public class prob2477 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] array = new int[6][2];
		int width=0, height=0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			array[i][0] = direction;
			array[i][1] = length;
			if(i%2==0) {
				width = Integer.max(width, length);
			} else {
				height = Integer.max(height, length);
			}
		}
		int swidth=0, sheight=0;
		for (int i = 0; i < 6; i++) {
			if(array[(i+5)%6][1] + array[(i+1)%6][1]==width) {
				sheight = array[i%6][1];
			}
			if(array[(i+5)%6][1] + array[(i+1)%6][1]==height) {
				swidth = array[i%6][1];
			}
		}
		int result = width*height - swidth*sheight;
		result = result * N;
		System.out.println(result);
	
	}

}
