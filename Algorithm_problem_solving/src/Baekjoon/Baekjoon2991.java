package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2991 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().trim().split(" ");
		
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		int d = Integer.parseInt(input[3]);
		
		input = br.readLine().trim().split(" ");
		
		int p = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int n = Integer.parseInt(input[2]);
		
		int dogP = 0;
		int dogM = 0;
		int dogN = 0;
		
		int tmp = p%(a+b);
		if (0<tmp && tmp<=a) dogP++;
		tmp = p%(c+d);
		if (0<tmp && tmp<=c) dogP++;
		
		tmp = m%(a+b);
		if (0<tmp && tmp<=a) dogM++;
		tmp = m%(c+d);
		if (0<tmp && tmp<=c) dogM++;
		
		tmp = n%(a+b);
		if (0<tmp && tmp<=a) dogN++;
		tmp = n%(c+d);
		if (0<tmp && tmp<=c) dogN++;
		
		System.out.println(dogP);
		System.out.println(dogM);
		System.out.println(dogN);
	}
}
