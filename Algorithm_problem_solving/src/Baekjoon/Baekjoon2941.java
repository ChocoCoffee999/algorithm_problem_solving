package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2941 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine().trim();
		
		input = input.replaceAll("c=", "C");
		input = input.replaceAll("c-", "C");
		input = input.replaceAll("dz=", "D");
		input = input.replaceAll("d-", "D");
		input = input.replaceAll("lj", "L");
		input = input.replaceAll("nj", "N");
		input = input.replaceAll("s=", "S");
		input = input.replaceAll("z=", "Z");
		
		System.out.println(input.length());
	}

}
