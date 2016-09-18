package com.laioffer.lab;

import java.util.Arrays;

public class MoveZerosToEnd {

	public static int[] moveZero(int[] array) {
		
		if (array == null || array.length <= 1) return array;
		
		int start = 0, end = array.length - 1;
		while(start < end) {
			if (array[start] == 0) {
				array[start] = array[end];
				array[end] = 0;
				end--;
			} else {
				start++;
			}
		}
		
		return array;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array	= new int[] {1,0,-1,0,0,1};
		array = moveZero(array);
		System.out.println(Arrays.toString(array));
	}

}
