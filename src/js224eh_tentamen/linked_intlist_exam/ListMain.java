/**
 * ListMain.java
 * Date: 15 March 2016
 * Author: Jonas Lundberg
 */
package js224eh_tentamen.linked_intlist_exam;

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


		System.out.println();
		System.out.println("Demonstrating addAt");
		System.out.println("-------------------");
		System.out.println("Initial list contents:");
		printListContents(list);

		list.addAt(42, 2);
		System.out.println("List contents after addAt(42, 2):");
		printListContents(list);

		list.addAt(420, 5);
		System.out.println("List contents after addAt(420, 5):");
		printListContents(list);



		System.out.println("\n\n");
		System.out.println("Demonstrating isLargerThan");
		System.out.println("--------------------------");

		LinkedIntList firstList = new LinkedIntList();
		LinkedIntList secondList = new LinkedIntList();
		firstList.add(4);
		firstList.add(3);
		for (int i = 1; i <= 5; i++) {
			secondList.add(i);
		}

		System.out.println("firstList: ");
		printListContents(firstList);
		System.out.println("secondList: ");
		printListContents(secondList);
		System.out.print("First list is larger: ");
		System.out.println(firstList.isLargerThan(secondList) ? "true": "false");


		System.out.println();
		firstList = new LinkedIntList();
		secondList = new LinkedIntList();
		for (int i = 1; i <= 4; i++) {
			firstList.add(i);
		}

		secondList.add(1);
		secondList.add(3);
		secondList.add(5);
		System.out.println("firstList: ");
		printListContents(firstList);
		System.out.println("secondList: ");
		printListContents(secondList);
		System.out.print("First list is larger: ");
		System.out.println(firstList.isLargerThan(secondList) ? "true": "false");


		System.out.println();
		firstList = new LinkedIntList();
		secondList = new LinkedIntList();
		for (int i = 1; i <= 4; i++) {
			firstList.add(i);
		}
		for (int i = 1; i <= 3; i++) {
			secondList.add(i);
		}

		System.out.println("firstList: ");
		printListContents(firstList);
		System.out.println("secondList: ");
		printListContents(secondList);
		System.out.print("First list is larger: ");
		System.out.println(firstList.isLargerThan(secondList) ? "true": "false");



		System.out.println();
		System.out.println("Demonstrating reverse");
		System.out.println("---------------------");
		System.out.println("Initial list contents:");
		printListContents(list);

		list.reverse();
		System.out.println("After reversing the list:");
		printListContents(list);
	}

	private static void printListContents(LinkedIntList list)
	{
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.print("  " + it.next());
		}
		System.out.println();
	}
}
