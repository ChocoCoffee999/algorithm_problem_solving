package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10815 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] map = new int[N];
		for (int i=0;i<N;i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(map);
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int s;
		int e;
		int point;
		int target;
		for (int i=0;i<M;i++) {
			target = Integer.parseInt(st.nextToken());
			s = 0;
			e = N-1;
			while (true) {
				point = (s+e)/2;
				if (point<0||point>=N||s>e) {
					sb.append(0).append("\n");
					break;
				}
				if (map[point]==target) {
					sb.append(1).append("\n");
					break;
				}
				else if (map[point]<target) s=point+1;
				else if (map[point]>target) e=point-1;
			}
		}
		System.out.println(sb.toString());
	}
}
