package Programmers;

import java.util.Arrays;
import java.util.HashMap;

public class BadUser {
//	static String[] user_ids = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//	static String[] banned_ids = {"fr*d*", "abc1**"};
//	static String[] user_ids = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//	static String[] banned_ids = {"*rodo", "*rodo", "******"};
	static String[] user_ids = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
	static String[] banned_ids = {"fr*d*", "*rodo", "******", "******"};
	static int[] typeNum=new int[9];
	public static void main(String[] args) {
//		user_ids = user_id;
//		banned_ids = banned_id;
		
		HashMap<Integer, String[]> bMap = new HashMap<>();
		HashMap<Integer, String[]> uMap = new HashMap<>();
		int[] len = new int[9]; 
		for (int i=0;i<user_ids.length;i++) {
			len[user_ids[i].length()]++;
		}
		for (int i=0;i<9;i++) {
			if (len[i]!=0) {
				String[] temp = new String[len[i]];
				int count=0;
				for (String s: user_ids) {
					if (s.length()==i) temp[count++] = s; 
				}
				uMap.put(i, temp);
			}
		}
		len = new int[9]; 
		for (int i=0;i<banned_ids.length;i++) {
			len[banned_ids[i].length()]++;
		}
		for (int i=0;i<9;i++) {
			if (len[i]!=0) {
				String[] temp = new String[len[i]];
				int count=0;
				for (String s: banned_ids) {
					if (s.length()==i) temp[count++] = s; 
				}
				bMap.put(i, temp);
			}
		}
		
		int[] nums = new int[uMap.keySet().size()];
		int count = 0;
		for (int i:uMap.keySet()) {
			String [] user = uMap.get(i);
		}
		for (int i:bMap.keySet()) {
			String [] ban = bMap.get(i);
		}
		for (int i:bMap.keySet()) {
			
			subset(bMap.get(i), uMap.get(i), new String[bMap.get(i).length], 0, 0);
		}
		
		int mul = 1;
		for (int n:typeNum) {
			if (n!=0) mul*=n;
		}
		System.out.println(mul);
	}
	
	public static void subset(String[] che, String[] arr, String[] sel, int idx, int depth) {
		if (depth==sel.length) {
			check(che, sel, 0, 0);
			return;
		}
		if (idx==arr.length) {
			return;
		}
		
		sel[depth] = arr[idx];
		subset(che, arr, sel, idx+1, depth+1);
		subset(che, arr, sel, idx+1, depth);
	}
	
	//sel이 얼마나 많은 che와 연관될 수 있는지 확인
	public static boolean check(String[] che, String[] sel, int idx, int bitmask) {
		if (Integer.bitCount(bitmask)==sel.length) {
			typeNum[che[0].length()]++;
			return true;
		}
		
		if (idx==che.length) return false;
		
		for (int i=0; i<sel.length; i++) {
			if ((bitmask&1<<i)==0) {
				if (equal(che[idx], sel[i])) {
					bitmask|=1<<i;
					if (check(che, sel, idx+1, bitmask)) return true;
					
					bitmask^=1<<i;
				}
			}
		}
		return false;
	}
	
	// 두 String 비교
	public static boolean equal(String c, String s) {
		boolean f = true;
		for (int i=0;i<s.length();i++) {
			if (c.charAt(i)==s.charAt(i)||c.charAt(i)=='*') continue;
			else {
				f = false; 
			}
		}
		if (f) return true;
		return false;
	}
}
