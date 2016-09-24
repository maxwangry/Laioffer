/**
 * 
 */
package com.laioffer.lab;

import java.util.Stack;

/**
 * @author Ruoyu
 * Implement a queue by using two stacks.
 * The queue should provide size(), isEmpty(), offer(), poll() and peek() operations.
 * When the queue is empty, poll() and peek() should return null.
 */
public class Queue {
	private Stack<Integer> stackIn;
	private Stack<Integer> stackOut;
	
	public Queue() {
		stackIn = new Stack<Integer>();
		stackOut = new Stack<Integer>();
	}
	
	public Integer poll() {
		Integer result = peek();
		if (!isEmpty()) stackOut.pop();
		return result;
	}
	
	public void offer(int element) {
		stackIn.push(element);
	}
	
	public Integer peek() {
		if (!stackOut.isEmpty()) return stackOut.peek();
		if (stackOut.isEmpty() && !stackIn.isEmpty()) {
			while (!stackIn.isEmpty()) stackOut.push(stackIn.pop());
			return stackOut.peek();
		}
		return null;		
	}
	
	public int size() {
		return stackIn.size() + stackOut.size();
	}
	
	public boolean isEmpty() {
		return size() == 0 ? true : false;
	}

}