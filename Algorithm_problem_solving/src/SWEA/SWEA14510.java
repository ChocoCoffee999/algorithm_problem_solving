package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 접근
 * 나무의 최대 크기가 있고
 * 나머지 나무 중 하나를 선택해 홀수 날 +1 짝수 날 +2, 혹은 아무것도 안 할 수 있다.
 * 
 * 그러면 최대 크기 나무와 다른 나무들 사이의 차를 다루면 된다고 생각했다.
 * 그러면 만약 이 차가 짝수면 2 혹은 1 + 1 로 처리할 수 있고
 * 이 착다 홀수면 반드시 하루의 홀수 날이 필요하다.
 * 
 * 따라서 먼저 모든 나무의 크기를 저장 tree[]
 * 해당 나무중 가장 큰 나무의 크기를 저장 maxHeight
 * 다시 tree[] 에 최대크기 나무 - 어떤 나무의 크기 저장
 * 그러면 반드시 홀수 수 만큼의 홀수 일이 필요하기 때문에
 * 총 홀수 수 * 2 - 1 일 동안
 * 홀수 날은 홀수의 크기를 1감소 시키고
 * 짝수 날은 크기가 2 이상인 나무를 아무거나 2 감소시킨다.
 * 
 * 그러면 홀수 수 * 2 - 1 일이 지난 뒤
 * 남은 수 remain에 따라 이 후가 결정되는데
 * remain이 0이면 그날이 끝
 * remain이 2 이상이면 while문에 진입해서 remain을 줄여 준다.
 * 이 때, 짝수 물을 줄 수 있는건 2일 이후 짝수 날이기 때문에
 * countDay가 0이면 2일로, 홀숫날이면 +1일로 바꿔줘야 한다.
 * 그 뒤 remain이 6일 초과인 경우 remain - 6, countDay+4
 * remain이 6일인 경우 remain - 6, countDay+3 break;
 * remain이 4일인 경우 countDay+2 break;
 * remain이 2일인 경우 break;
 * 이제 countDay가 총 필요한 일수이다.
 */
public class SWEA14510 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] tree = new int[N];
			int maxHeight = 1;
			for (int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxHeight = maxHeight<tree[i] ? tree[i] : maxHeight;
			}
			
			int countOdd = 0;
			for (int i=0; i<N; i++) {
				tree[i] = maxHeight - tree[i];
				if (tree[i]%2==1) countOdd++;
			}
			int countDay = 0;
			
			for (int i=1; i<=countOdd*2-1;i++) {
				for (int j=0;j<N;j++) {
					if (i%2==1&&tree[j]%2==1) {
						tree[j]--;
						countDay++;
						break;
					}
					if (i%2==0&&tree[j]>1) {
						tree[j]-=2;
						countDay++;
						break;
					}
					if (j==N-1) {
						countDay++;
					}
				}
			}
			int remain = 0;
			for (int i=0;i<N;i++) {
				remain += tree[i];
			}
			if (remain==0) System.out.printf("#%d %d\n", test_case, countDay);
            else {
                if (countDay==0) countDay=2;
                if (countDay%2==1) countDay++;
                while (remain>0) {
                    if (remain>=6) {
                        remain-=6;
                        countDay+= remain==0? 3:4;
                        continue;
                    }
                    if (remain==4) {
                        countDay+=2;
                        break;
                    }
                    if (remain==2) {
                        break;
                    } 
                }
                System.out.printf("#%d %d\n", test_case, countDay);
			}
		}
	}
}
