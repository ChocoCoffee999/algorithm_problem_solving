package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] map = new int[N];
		for (int i=0;i<N;i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(map);
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int s;
		int e;
		int point;
		for (int i=0; i<M; i++) {
			s=0;
			e=N-1;
			while (true) {
				point=(s+e)/2;
				if (s<0||e>=N||e<s) {
					sb.append(0).append("\n");
					break;
				}
				if (map[point]==nums[i]) {
					sb.append(1).append("\n");
					break;
				}
				else if (map[point]<nums[i]) {
					s=point+1;
				}
				else if (map[point]>nums[i]) {
					e=point-1;
				}
			}
			
		}
		System.out.print(sb.toString());
	}
}
