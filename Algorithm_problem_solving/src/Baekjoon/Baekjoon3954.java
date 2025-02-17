package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
			List<int[]> loop = new ArrayList<>();
			List<Integer> v = new ArrayList<>();
			int loopStart = 0;
			int loopEnd = 0;
			while (true) {
//				System.out.printf("count : %d\n", count);
//				if (count>0&&count%200 == 0) {
//					System.out.println(count);
//				}
//				if (test_case==2) {
//					System.out.printf("count : %d, curCommand : %c, pointer : %d, mem[pointer] : %d\n", count%codeLen, codeArray[count%codeLen], pointer, mem[pointer]);
//					if (count>0&&count%100==0) br.readLine();
//				}
				switch(codeArray[count%codeLen]) {
				case '-': 
					mem[pointer] = mem[pointer]-1 < 0 ? 255 : mem[pointer]-1;
					break;
				case '+':
					mem[pointer] = mem[pointer]+1 > 255 ? 0 : mem[pointer]+1;
					
					break;
				case '<':
					pointer = pointer-1<0 ? memLen-1:pointer-1;
					break;
				case '>':
					pointer = pointer+1==memLen ? 0:pointer+1;
					break;
				case '[':
//					System.out.printf("count : %d\n", count);
					if (mem[pointer]==0) {
						int countLoop=0;
//						loopStart = count%codeLen;
						L:while (true) {
							count++;
							if (codeArray[count%codeLen]=='[') countLoop++;
							if (codeArray[count%codeLen]==']') {
								if (countLoop>0) countLoop--;
								else {
//									loopEnd = count%codeLen;
//									if (loopStart>loopEnd) {
//										int tmp = loopStart;
//										loopStart = loopEnd;
//										loopEnd = loopStart;
//									}
//									for (int i=0;i<loop.size();i++) {
//										if (Arrays.equals(loop.get(i), new int[] {loopStart, loopEnd})) {
//											v.set(i, v.get(i)+1);
//										};
//									}
//									for (int i=0;i<loop.size();i++) {
//										if (Arrays.equals(loop.get(i), new int[] {loopStart, loopEnd})) {
//											v.set(i, v.get(i)+1);
//											break L;
//										}
//									}
//									loop.add(new int[] {loopStart, loopEnd});
//									v.add(1);
									break;
								}
							}
						}
					}
					break;
				case ']':
//					System.out.printf("count : %d\n", count);
					if (mem[pointer]!=0) {
						int countLoop = 0;
						int curCount = count;
						loopEnd = count%codeLen;
						L:while (true) {
							curCount--;
							if (codeArray[curCount%codeLen]==']')countLoop++;
							if (codeArray[curCount%codeLen]=='[') {
								if (countLoop >0) countLoop--;
								else {
									loopStart = curCount%codeLen;
									count = curCount+codeLen;
									for (int i=0;i<loop.size();i++) {
										if (Arrays.equals(loop.get(i), new int[] {loopStart, loopEnd})) {
											v.set(i, v.get(i)+1);
											break L;
										}
									}
									loop.add(new int[] {loopStart, loopEnd});
									v.add(1);
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
					System.out.println("Terminates");
					break;
				}
				count++;
				if (count>50000000) {
					int max = 0;
					int maxIdx = 0;
					for (int i =0;i<v.size();i++) {
						if (max<v.get(i)) {
							max = v.get(i);
							maxIdx = i;
						}
						
					}
					for (int i =0;i<loop.size();i++) {
						System.out.println(Arrays.toString(loop.get(i)));
					}
					System.out.printf("Loops %d %d\n",loop.get(maxIdx)[0], loop.get(maxIdx)[1]);
					break;
				}
			}
//			System.out.printf("count : %d, curCommand : %c, pointer : %d, mem[pointer] : %d\n", count%codeLen, codeArray[count%codeLen], pointer, mem[pointer]);
		}
	}

}
