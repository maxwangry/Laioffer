package com.laioffer.lab;

public class MergeSort {
	
	public static int[] mergeSort(int[] array) {
		
		// Corner cases
		if (array == null || array.length <= 1) return array;
		
		int left = 0, right = array.length - 1;
		int[] temp = new int[array.length];
		divideAndMerge(left, right, array, temp);
		return array;
	}
	
	private static void divideAndMerge(int left, int right, int[] array, int[] temp) {
		// Base case
		if (left == right) return;
		
		int mid = left + (right - left) / 2;
		divideAndMerge(left, mid, array, temp);
		divideAndMerge(mid + 1, right, array, temp);
		merge(left, mid, right, array, temp);
	}
	
	private static void merge(int left, int mid, int right, int[] array, int[] temp) {
		
		// Prepare the temp array
		for (int m = left; m <= right; m++) temp[m] = array[m];
		
		int i = left, j = mid + 1, k = left;
		while(i <= mid && j <= right) {
			if (temp[i] < temp[j]) array[k++] = temp[i++];
			else 				   array[k++] = temp[j++];
		}
		
		// Deal with the rest numbers
		while(i <= mid) array[k++] = temp[i++];
		while(j <= right) array[k++] = temp[j++];
	}

	public static void main(String[] args) {
		int[] array = new int[] {9,8,7,6,5,4,3,2,1,0};
		array = mergeSort(array);
		for (int i = 0; i < array.length; i++) System.out.println(array[i]);
	}

}
