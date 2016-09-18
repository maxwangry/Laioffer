package com.laioffer.lab;

public class SelectionSort {

	public static int[] solve(int[] array) {
		
		// Corner cases
		if (array == null || array.length <= 1) return array;
		
		int minIndex = 0, size = array.length;
		for (int i = 0; i < size - 1; i++) {
			minIndex = i;
			// Look for the min
			for (int j = i + 1; j < size; j++) if (array[j] < array[minIndex]) minIndex = j;
			// swap
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		return array;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {7,6,5,4,3,2,1,0};
		array = solve(array);
		for (int i = 0; i < array.length; i++) System.out.println(array[i]);
	}

}
