package com.laioffer.lab;

public class QuickSort {
	
	public static int[] quickSort(int[] array) {
		
		// Corner cases
		if (array == null || array.length <= 1) return array;
		
		helper(0, array.length - 1, array);
		return array;
	}
	
	private static void helper(int left, int right, int[] array) {
		
		// Base case
		if (left >= right) return;
		
		int pivotIndex = findPivotIndex(left, right, array);
		helper(left, pivotIndex - 1, array);
		helper(pivotIndex + 1, right, array);
	}
	
	// Find the first half which are all less than pivot
	private static int findPivotIndex(int left, int right, int[] array) {
		
		// Pick the first element as pivot
		int pivot = array[left];
		
		int start = left + 1, end = right;
		while (start <= end) {
			if (array[start] < pivot) start++;
			else if (array[end] >= pivot) end--;
			else {
				// swap array[start] and array[end]
				swap(start, end, array);
				start++;
				end--;
			}
		}
		// Put the pivot into its correct positon
		swap(left, end, array);
		return end;
	}
	
	private static void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {4,2,-3,6,1};
		array = quickSort(array);
		for(int i = 0; i < array.length; i++) System.out.print(array[i]);
	}

}
