package com.laioffer.lab;

import java.util.Dictionary;

public class UnknownSize {
/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/
	
	public int search(Dictionary dict, int target) {
		if (dict == null || dict.get(0) == null) return -1;
		int left = 0, right = 1;
		if (dict.get(left) == target) return left;
		
		while (dict.get(right) != null && dict.get(right) < target) {
			left = right + 1;
			right *= 10;
		}
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (dict.get(mid) == null || dict.get(mid) > target) right = mid - 1;
			else if (dict.get(mid) < target) left = mid + 1;
			else if (dict.get(mid) == target) return mid;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
