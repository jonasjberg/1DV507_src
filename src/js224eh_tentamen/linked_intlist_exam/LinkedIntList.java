/*
 * File: LinkedIntList.java
 * Author: Jonas Lundberg
 * Date: 15 mar 2016
 */
package js224eh_tentamen.linked_intlist_exam;

import java.util.Iterator;


/**
 * A single-linked implementation of the <code>IntList</code> interface.
 * This is a minimalistic implementation where no extra methods are
 * added to the public interface. The implementation makes use of 
 * two private inner classes (<code>Node</code> and <code>ListIterator</code>)
 * that are hidden and considered as implementation details.
 *  
 * @author jonasl
 *
 */
public class LinkedIntList {
	private int size = 0;
	private Node head = null;

	/** Creates an empty list. */
    public LinkedIntList() {}
    
	
	public void add(int n) {
		if (head == null)
			head = new Node(n);
		else {
			Node node = head;
			while (node.next != null)
				node = node.next;
			node.next = new Node(n);
		}
		size++;
	}

	
	public int get(int index) throws IndexOutOfBoundsException {
		checkIndex(index,size);
		Node node = head;
		for (int i=0;i<index;i++)
			node = node.next;
		return node.value;
	}


	
	public int indexOf(int n) {
		Node node = head;
		int index = 0;
		while (node != null) {
			if (node.value == n)
				return index;
			index++;
			node = node.next;
		}
		return -1;
	}

	
	public int size() {
		return size;
	}
	

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[ ");
		Node node = head;
		while (node != null) {
			buf.append(node.value +" ");
			node = node.next;
		}
		buf.append("]");
		return buf.toString();
	}
	
	
	public Iterator<Integer> iterator() {
		return new ListIterator();
	}

	/*
	 * Add element n and position index. It should not replace the existing 
	 * element at position index, it should  insert it at index and move the existing 
	 * elements at position >=index one step backwards. Exception if the position is 
	 * outside the range of valid/possible indices.
	 * 
	 */
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		Node newNode = new Node(n);
		if (index == 0) {
		    /* Trivial case where the new node replaces the head. */
			newNode.next = head;
			head = newNode;
		} else {
		    /* Traverse links to find the node situated just prior to the
		       position of the requested index. Node "preIndex" points to
		       each node in turn by continuously updating the next-pointer. */
			Node preIndex = head;
			for (int i = 0; i < index - 1; i++) {
				preIndex = preIndex.next;
			}

			/* Insert the new node "newNode" after the "preIndex" node. */
			newNode.next = preIndex.next;
			preIndex.next = newNode;
		}

		size++;
	}
	
	/*
	 * A method public boolean isLargerThan(LinkedIntList otherList) that compare this
	 * list with otherList. Starting from the head, we compare the two lists element by element.
	 * As soon as we find an element that is larger than the corresponding element in the other list
	 * we stop and declare the list with the largest element as “larger”. If they have the same initial
	 * sequence of elements but one list contains more elements, than the longer list is larger. 
	 * A few examples
	 * {4,3} vs {1,2,3,4,5} ==> {4,3} is larger since 4 > 1
	 * {1,2,3,4} vs {1,3,5} ==> {1,3,5} is larger since 3 > 2
	 * {1,2,3,4} vs {1,2,3} ==> {1,2,3,4} is larger since the first list is longer 
	 */
	public boolean isLargerThan(LinkedIntList otherList) {
		// To be implemented
		return true;
	}
	
	
	/*
	 * Reverses the content of the list by reversing the order of 
	 * the nodes in the list.
	 */
	public void reverse() {
		// To be implemented
	}
	
	/* 
	 * Private class members considered as implementation details. 
	 * 
	 */
	private void checkIndex(int index, int upper) throws IndexOutOfBoundsException {
		if (index < 0 || index >= upper) {
			String msg = "Index = "+index+", Upper boundary = "+upper;
			throw new IndexOutOfBoundsException(msg);
		}
	}
	
	class ListIterator implements Iterator<Integer> {
		private Node node = head;
		public Integer next() {
			int val = node.value;
			node = node.next;
			return val;
		}
		
		public boolean hasNext() {return node != null;}
		
		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}

	private class Node {
		int value;
		Node next = null;
		
		Node(int v) { value = v;}
	}
}
