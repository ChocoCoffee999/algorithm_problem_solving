package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Baekjoon3954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case=0;test_case<T;test_case++) {
			String[] input = br.readLine().trim().split(" ");
			int memLen = Integer.parseInt(input[0]);
			int codeLen = Integer.parseInt(input[1]);
			int inLen = Integer.parseInt(input[2]);
			String code = br.readLine().trim();
			char[] codeArray = code.toCharArray();
			Queue<Character> inp = br.readLine().trim().chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(LinkedList::new));
			
			int count = 0;
			int pointer = 0;
			int[] mem = new int[memLen];
			int loopStart = 0;
			int loopEnd = 0;
			while (true) {
				if (count>0&&count%200 == 0) {
					System.out.println(count);
				}
//				if (test_case==2) {
//					System.out.printf("count : %d, curCommand : %c, pointer : %d, mem[pointer] : %d\n", count%codeLen, codeArray[count%codeLen], pointer, mem[pointer]);
//					if (count>0&&count%100==0) br.readLine();
//				}
				switch(codeArray[count%codeLen]) {
				case '-': 
					mem[pointer]--;
					break;
				case '+':
					mem[pointer]++;
					break;
				case '<':
					pointer = pointer-1<0 ? memLen-1:pointer-1;
					break;
				case '>':
					pointer = pointer+1==memLen ? 0:pointer+1;
					break;
				case '[':
					if (mem[pointer]==0) {
						int countLoop=0;
						loopStart = count%codeLen;
						while (true) {
							count++;
							if (codeArray[count%codeLen]=='[') countLoop++;
							if (codeArray[count%codeLen]==']') {
								if (countLoop>0) countLoop--;
								else {
									loopEnd = count%codeLen;
									break;
								}
							}
						}
					}
					break;
				case ']':
					if (mem[pointer]!=0) {
						int countLoop = 0;
						loopStart = count%codeLen;
						while (true) {
							count++;
							if (codeArray[count%codeLen]==']')countLoop++;
							if (codeArray[count%codeLen]=='[') {
								if (countLoop >0) countLoop--;
								else {
									loopEnd = count%codeLen;
									break;
								}
							}
						}
					}
					break;
				case ',':
					if (inp.size()>0) mem[pointer] = inp.poll();
					else mem[pointer] = 255;
					break;
				default:
					break;
				}
				if (count%codeLen==codeLen-1) {
					System.out.println("Terminnates");
					break;
				}
				count++;
				if (count>500000) {
					System.out.printf("Loops %d %d\n",loopStart, loopEnd);
					break;
				}
			}
			System.out.printf("count : %d, curCommand : %c, pointer : %d, mem[pointer] : %d\n", count%codeLen, codeArray[count%codeLen], pointer, mem[pointer]);
		}
	}

}
