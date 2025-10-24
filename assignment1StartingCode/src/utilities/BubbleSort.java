/**
 * BubbleSort.java
 *
 * @author Levi Moreau
 * @version 1.8 
 * 
 * Class Definition: Class to demonstrate a Bubble sort sorting algorithm using the comparator interface.
 * 					It accepts and constructs a comparison of object values within an array 
 * 					of any type using conventional standards. Time complexity of O(n^2) - worst case
 * 
 */
package utilities;

import java.util.Comparator;


public class BubbleSort {
	
	public BubbleSort() {
		// Default Constructor
	}
	

	public static <T> void sort(T[] array, Comparator<? super T> comparator) {
	    
		/**
	     * Sorts an array using the Bubble Sort algorithm with a comparator.
	     *
	     * @param <T>        The type of elements in the array
	     * @param array      The array to sort
	     * @param comparator The comparator defining the sorting order
	     */		
		for (int i=0; i < array.length - 1; i++) {
			// Loops through each index of an array while looping through the next index of each instance
			for (int j=1; j<array.length - i; j++) {
				// Compares an index value with the next immediate index value swapping the two if one is larger/smaller
				if (comparator.compare(array[j - 1], array[j]) < 0) {
					swap(array, j, j-1);
				}
			}
		}
	}	
	
	// External index value swapping and reassignment function for de-cluttered/cleaner code
	private static <T> void swap(T[] testArray, int index1, int index2) {
		T temp = testArray[index1];
		testArray[index1] = testArray[index2];
		testArray[index2] = temp;
	}

}

