package utilities;

import java.util.Comparator;


/**
 * SelectionSort.java
 *
 * @author Levi Moreau
 * @version 1.8 
 * 
 * Class Definition: Class to demonstrate a selection sort sorting algorithm using the comparator interface.
 * 					 It accepts and constructs a comparison of object values within an array of any type. 
 * 					 Time complexity of O(n^2) - worst case
 * 
 */
public class SelectionSort {

	public SelectionSort() {
		// Default Constructor
	}
	
	public static <T> void sort(T[] array, Comparator<? super T> comparator) {
		
		/**
		* Sorts an array using the Selection Sort algorithm with a comparator.
		*
		* @param <T>        The type of elements in the array
	    * @param array      The array to sort
		* @param comparator The comparator defining the sorting order
		*/
		for(int i=0; i < array.length - 1; i++) {
			// Sets the temporary max value as the current index
			int max = i;
			
			/* Loops through to if the current max value at position 1 is less than the comparing value 
			   and assigns it as the new max value*/
			for(int j=i+1; j < array.length; j++) {
				if(comparator.compare(array[j], array[max]) > 0)
				max = j;
			}
			
			// Checks if the max value is not equal to i and calls swap() method (if i is the current max value it does not change)
			if (max != i) {
				swap(array, max, i);
			}
		}
		
		
	}
	
	// External index value swapping and reassignment function for de-cluttered/cleaner code
	private static <T> void swap(T[] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
	}

}


