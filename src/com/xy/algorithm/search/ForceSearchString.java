package com.xy.algorithm.search;

import java.util.Objects;

public class ForceSearchString {

	/**
	 * Search index of pattern in str
	 * @param pattern
	 * @param str
	 * @return
	 */
	public static int search(String pattern, String str) {
		return search(pattern, str, 0);
	}
	
	/**
	 * 
	 * Search position of pattern in str
	 * 
	 * @param pattern
	 * @param str
	 * @param startIdx
	 * @return -1 not found
	 */
	public static int search(String pattern, String str, int startIdx) {

		int idx = -1;

		if (Objects.nonNull(str) && Objects.nonNull(pattern) && startIdx > idx && startIdx < str.length()
				&& pattern.length() < str.length()) {

			char[] pChs = pattern.toCharArray();
			char[] sChs = str.toCharArray();

			for (int i = startIdx; i < sChs.length; i++) {
				// optimized
				if (pChs.length > sChs.length - i) {
					break;
				}
				int k = i;
				int j = 0;
				//error code , one letter will j = 1 !
//				while (j < pChs.length /* && i < sChs.length */ && pChs[j++] == sChs[k++]) {
				
				while (j < pChs.length /* && i < sChs.length */ && pChs[j] == sChs[k]) {
					j++;
					k++;
				}

				if (j == pChs.length) {
					idx = k - pChs.length;
					break;
				}
			}

		}

		return idx;

	}	
	

	public static void main(String[] args) {
		String str = "JavaABCDDD,国中人";
		System.out.println(search("ABC", str));
		System.out.println(search("ABC", str, 4));
		System.out.println(search("ABC", str, 3));
		System.out.println(search("中", str, 0));
		System.out.println(search("国", str, -1));
		System.out.println(search("D", str, 6));
		System.out.println(search("国人", str));
		System.out.println(search(",", str));
		System.out.println(search("中", str));
		System.out.println(search("国人", str));
		System.out.println(search("人", str));
		System.out.println(str.substring(search("人", str)));
		System.out.println(str.substring(search("中", str)));
	}

}
