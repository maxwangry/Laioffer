package com.laioffer.lab;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class KSmallest {
	
	// minHeap with whole array
	public static int[] kSmallest1(int[] array, int k) {
		if (array == null || array.length == 0 || k <= 0) {
			return new int[0];
		}
		int[] result = new int[k];
		int size = array.length;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < size; i++) {
			minHeap.offer(array[i]);
		}
		for (int i = 0; i < k; i++) {
			result[i] = minHeap.poll();
		}
		
		return result;
	}
	
	// maxHeap with k elements
	public static int[] kSmallest2(int[] array, int k) {
		if (array == null || array.length == 0 || k <= 0) {
			return new int[0];
		}
		
		int[] result = new int[k];
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1.equals(o2)) {
					return 0;
				}
				return o1 > o2 ? -1 : 1;
			}
		});
		
		for (int i = 0; i < k; i++) {
			maxHeap.offer(array[i]);
		}
		for (int i = k; i < array.length; i++) {
			if (array[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}
		for (int i = k - 1; i >= 0; i--) {
			result[i] = maxHeap.poll();
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(kSmallest1(array, 4)));
		System.out.println(Arrays.toString(kSmallest2(array, 4)));
	}

}
