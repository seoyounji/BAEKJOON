package sw_typeIM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 2941 크로아티아 알파벳
public class prob2941 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String in = bf.readLine();
		char[] input = in.toCharArray();
		int index = 0;
		int result = 0;
		int length = input.length;
		while(index < length) {
			//System.out.println(index);
			if(input[index]=='c') {
				if(index+1 < length) {
					if(input[index+1]=='=' || input[index+1]=='-') {
						result++;
						index += 2;
					}
					else {
						result++;
						index += 1;
					}
				}
				else {
					result++;
					break;
				}
			}
			else if(input[index]=='d') {
				if(index+1 < length) {
					if(input[index+1]=='z') {
						if(index+2 < length) {
							if(input[index+2]=='=') {
								result++;
								index += 3;
							}
							else {
								result+=2;
								index += 2;
							}
						}
						else {
							result+=2;
							break;
						}
					}
					else if(input[index+1]=='-') {
						result++;
						index += 2;
					}
					else {
						result++;
						index += 1;
					}					
				}
				else {
					result++;
					break;
				}
			}
			else if(input[index]=='l') {
				if(index+1 < length) {
					if(input[index+1]=='j') {
						result++;
						index += 2;
					}
					else {
						result++;
						index += 1;
					}
				}
				else {
					result++;
					break;
				}
			}
			else if(input[index]=='n') {
				if(index+1 < length) {
					if(input[index+1]=='j') {
						result++;
						index += 2;
					}
					else {
						result++;
						index += 1;
					}
				}
				else {
					result++;
					break;
				}
			}
			else if(input[index]=='s') {
				if(index+1 < length) {
					if(input[index+1]=='=') {
						result++;
						index += 2;
					}
					else {
						result++;
						index += 1;
					}					
				}
				else {
					result++;
					break;
				}
			}
			else if(input[index]=='z') {
				if(index+1 < length) {
					if(input[index+1]=='=') {
						result++;
						index += 2;
					}
					else {
						result++;
						index += 1;
					}					
				}
				else {
					result++;
					break;
				}
			}
			else {
				result++;
				index += 1;
			}
		}
		System.out.println(result);
	}

}
