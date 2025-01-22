package Baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1244 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int switchNum = Integer.parseInt(br.readLine().trim());
		int[] switchState = new int[switchNum];
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i<switchNum;i++) {
			switchState[i] = Integer.parseInt(input[i]);
		}
		
		int studentNum = Integer.parseInt(br.readLine().trim());
		int[][] student = new int[studentNum][2];
		for (int i = 0; i<studentNum;i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j<2;j++) {
				student[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 0; i<studentNum;i++) {
			if (student[i][0]==1) {
				for (int j = student[i][1]-1;j<switchNum;j+=student[i][1]) {
					if (switchState[j] == 0) switchState[j]=1;
					else switchState[j]=0;
				}
			}
			else {
				int count = 0;
				int startIdx = student[i][1]-1;
				while (true) {
					if (count+startIdx<switchNum && startIdx-count>=0) {
						if (switchState[startIdx+count]==switchState[startIdx-count]) {
							count++;
							if (count+startIdx<switchNum && startIdx-count>=0 && switchState[count+startIdx] == switchState[startIdx-count])
								continue;
							else {
								count--;
								break;
							}
						}
						else break;
					}
					else break;
				}
				for (int j = startIdx-count;j<=startIdx+count;j++) {
					if (switchState[j]==0) switchState[j]=1;
					else switchState[j]=0;
				}
			}
		}
		for (int i = 0; i<switchNum/20+1;i++) {
			int flag = Math.min(switchNum-20*i,20);
			for (int j = 0; j<flag;j++) {
				if (j == flag-1) System.out.println(switchState[20*i+j]);
				else System.out.printf("%d ",switchState[20*i+j]);
			}
		}
	}
}
