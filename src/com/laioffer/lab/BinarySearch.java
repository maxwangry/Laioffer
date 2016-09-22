package com.laioffer.lab;

public class BinarySearch {
	public static int binarySearch(int[] array, int target) {
		if (array == null || array.length == 0) return -1;
		int left = 0, right = array.length - 1, mid = 0;
		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (array[mid] < target) left = mid;
			else if (array[mid] > target) right = mid;
			else return mid;
		}
		if (array[left] == target) return left;
		if (array[right] == target) return right;
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {0,2,5,3,5,7,8,5,6,5,};
		System.out.println(binarySearch(array, 5));
	}

}
