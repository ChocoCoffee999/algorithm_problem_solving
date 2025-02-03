package Baekjoon;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon11399 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int humanNum = Integer.parseInt(br.readLine().trim()); //사람의 수
		int[] consumeTime = new int[humanNum]; //소모하는 시간
		int sum = 0; // for문 속 합
		int sol = 0; // 해답
		
		String[] input = br.readLine().trim().split(" ");
		
		for (int i=0;i<humanNum;i++) consumeTime[i] = Integer.parseInt(input[i]);
		Arrays.sort(consumeTime);
		
		for (int i=0;i<humanNum;i++) {
			sum += consumeTime[i];
			sol += sum;
		}
		System.out.println(sol);
	}
}
