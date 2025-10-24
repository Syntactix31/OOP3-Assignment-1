/**
 * 
 * 
 * 
 */

package utilities;

import java.util.Comparator;


public class InsertionSort {

    public InsertionSort() {
		// Default Constructor
    }

    /**
     * Sorts an array using the Insertion Sort algorithm with a comparator.
     *
     * @param <T>        The type of elements in the array
     * @param array      The array to sort
     * @param comparator The comparator defining the sorting order
     */
    public static <T> void sort(T[] array, Comparator<? super T> comparator) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(array[j], key) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}			
