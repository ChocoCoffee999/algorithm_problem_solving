package Programmers;

import java.util.Arrays;

public class Candidate {
	static String[][] realations = {{"100","ryan","music","2"},
		{"200","apeach","math","2"},
		{"300","tube","computer","3"},
		{"400","con","computer","4"},
		{"500","muzi","music","3"},
		{"600","apeach","music","2"}};
	static int row = realations.length;
	static int col = realations[0].length;
	static boolean [] bitmasks = new boolean[(int) Math.pow(2, col)];
	static int Ans = 0;
	public static void main(String[] args) {
		subset(new boolean[col],0);
		for (int i=0;i<bitmasks.length;i++) {
		}
		checkMinimality();
		System.out.println(Ans);
	}
	
	public static void subset(boolean[] sel, int idx) {
		if (idx==sel.length) {
			int count = 0;
			int bitmask = 0;
			for (int i=0;i<sel.length;i++) {
				if (sel[i]) {
					count++;
					bitmask|=1<<i;
				}
			}
			if (count==0) return;
			
			String[][] subRealations = new String[realations.length][count++];
			
			for (int i=0;i<realations.length;i++) {
				count = 0;
				for (int j=0;j<col;j++) {
					if (sel[j]) {
						subRealations[i][count] = realations[i][j];
						count++;
					}
				}
			}
			bitmasks[bitmask] = checkUnique(subRealations);
			return;
		}
		sel[idx] = true;
		subset(sel, idx+1);
		sel[idx] = false;
		subset(sel, idx+1);
		
	}
	
	public static boolean checkUnique(String[][] sel) {
		for (int i=0;i<sel.length-1;i++) {
			for (int j=i+1;j<sel.length;j++) {
				if (Arrays.equals(sel[i],sel[j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void checkMinimality() {
		int bNum = (int)Math.pow(2, col);
		L:for (int i=0;i<bNum;i++) {
			if (bitmasks[i]) {
				if (Integer.bitCount(i)==1) Ans++;
				else {
					for (int j=0;j<bNum;j++) {
						if ((i&1<<j)==(1<<j)) {
							if (bitmasks[i^1<<j]) continue L;
						}
					}
					Ans++;
				}
			}
		}
	}
}
