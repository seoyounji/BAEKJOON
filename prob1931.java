package Algorithm_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//백준 1931 회의실배정
public class ws01 {

	private static int num;
	private static meeting[] array;
	
	private static class meeting implements Comparable<meeting> {
		int start, end;
		public meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		public int compareTo(meeting o) {
			return Integer.compare(this.end, o.end);
		}
		public String toString() {
			return "start : "+start+","+"end : "+end;
		}
	}
	
	private static class meetingComparator implements Comparator<meeting> {
		public int compare(meeting o1, meeting o2) {
			if(o1.end == o2.end) {
				return o1.start - o2.start;
			}
			else return o1.end - o2.end;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(bf.readLine());
		array = new meeting[num];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			meeting tmp = new meeting(x,y);
			array[i] = tmp;
		}
		Arrays.sort(array, new meetingComparator());
		int count = 1;
		meeting start = new meeting(array[0].start, array[0].end);
		for (int i = 1; i < num; i++) {
			if(array[i].start>=start.end) {
				count++;
				start = new meeting(array[i].start, array[i].end);
				System.out.println(start.toString());
			}
			else continue;
		}
		System.out.println(count);
	}

}
