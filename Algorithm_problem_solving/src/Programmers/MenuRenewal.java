package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MenuRenewal {
//	static String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
	static String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//	static String[] orders = {"XYZ", "XWY", "WXA"};
	static HashMap<String, Integer> menu;
//	static int[] course = {2,3,4};
	static int[] course = {2,3,5};
//	static int[] course = {2,3,4};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> menu2 = new HashMap<>();
		List<String> res = new ArrayList<>();
		for (int i=0;i<orders.length-1;i++) {
			for (int j=i+1;j<orders.length;j++) {
				menu=new HashMap<>();
				int len0 = orders[i].length();
				int len1 = orders[j].length();
				int min = len0>len1?len1:len0;
				
				for (int k=0;k<course.length;k++) {
					
					if (course[k]>min) break;
					combination(orders[i].toCharArray(), new char[course[k]], 0,0);
					combination(orders[j].toCharArray(), new char[course[k]], 0,0);
				}
				
				for (String m:menu.keySet()) {
					if (menu.get(m)>1) {
						if (menu2.get(m)!=null) menu2.put(m, menu2.get(m)+1);
						else menu2.put(m, 1);
					}
				}
			}
		}
		HashMap<Integer, Integer> check = new HashMap<>();
		for (String m:menu2.keySet()) {
			int len = m.length();
			if (check.get(len)==null) {
				check.put(len, menu2.get(m));
			}
			else {
				int a = check.get(len);
				int b = menu2.get(m);
				check.put(len, a>b?a:b);
			}
		}
		for (int i=0;i<course.length;i++) {
			if (check.get(course[i]) == null) continue;
			else {
				int len = check.get(course[i]);
				for (String m:menu2.keySet()) {
					if (m.length()==course[i]&&menu2.get(m)==len) {
						res.add(m);
					}
				}
			}
		}
		Object[] temp = res.toArray();
		String[] result = Arrays.copyOf(temp, temp.length,String[].class);
		Arrays.sort(result);
		System.out.println(Arrays.toString(result));
	}
	
	static public void combination(char[] arr, char[] sel, int idx, int depth) {
		if (depth==sel.length) {
			char[] temp = Arrays.copyOf(sel, sel.length);
			Arrays.sort(temp);
			String newMenu = new String(temp);
			Integer before = menu.get(newMenu);
			if (before!=null) menu.put(newMenu, before+1);
			else menu.put(newMenu, 1);
			return;
		}
		if (idx==arr.length) {
			return;
		}
		sel[depth] = arr[idx];
		combination(arr,sel,idx+1,depth+1);
		combination(arr,sel,idx+1,depth);
	}
}
