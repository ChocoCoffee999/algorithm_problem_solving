import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon17413 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().trim().split("");
		int startIdx = 0;
		boolean f = true;
		for (int i=0;i<input.length;i++) {
			if (input[i].equals("<")) {
				for (int j=startIdx;j<startIdx+(i-startIdx+1)/2;j++) {
					String tmp = input[i-j+startIdx-1];
					input[i-j+startIdx-1]=input[j];
					input[j]=tmp;
				}
				f = false;
				continue;
			}
			if (input[i].equals(">")) {
				startIdx=i+1;
				f = true;
				continue;
			}
			if (f) {
				if (input[i].equals(" ")) {
					for (int j=startIdx;j<startIdx+(i-startIdx+1)/2;j++) {
						String tmp = input[i-j+startIdx-1];
						input[i-j+startIdx-1]=input[j];
						input[j]=tmp;
					}
					startIdx=i+1;
					continue;
				}
			}
			if (i==input.length-1) {
				for (int j=startIdx;j<startIdx+(i-startIdx+1)/2;j++) {
					String tmp = input[i-j+startIdx];
					input[i-j+startIdx]=input[j];
					input[j]=tmp;
				}
			}
		}
		System.out.println(String.join("", input));
	}
}
