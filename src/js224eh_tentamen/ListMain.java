/**
 * ListMain.java
 * Date: 15 March 2016
 * Author: Jonas Lundberg
 */
package linked_intlist_exam;

import java.util.Iterator;

/**
 * A simple program demonstrating how to use most of the methods 
 * in the LinkedIntList class.
 *
 * @author jonasl
 *
 */
public class ListMain {


	public static void main(String[] args) {
		LinkedIntList list = new LinkedIntList();
		
		System.out.println("Testing "+list.getClass().getName());
		for (int i=0;i<10;i++)
			list.add(i*10);
		System.out.println(list);
		
		System.out.println("Size = "+list.size());
		System.out.println("At pos 5: = "+list.get(5));
		System.out.println("At pos 0: = "+list.get(0));
		System.out.println("At pos 9: = "+list.get(9));
		
		System.out.println("Index of 99: = "+list.indexOf(99));
		System.out.println("Index of 40: = "+list.indexOf(40));
		
		Iterator<Integer> it = list.iterator();
		while (it.hasNext())
			System.out.print("  "+it.next());
		System.out.println("\n\n");
		

	}

}
