package utilities;

import java.util.Comparator;

public class QuickSort {
	private QuickSort() {}
	
	// Public method to sort an array using Quick Sort algorithm in descending order
    public static <T> void sort(T[] arr, Comparator<? super T> comp) {
        quickSort(arr, 0, arr.length - 1, comp); // Call the recursive quickSort method
    }

    // Recursive Quick Sort method
    private static <T> void quickSort(T[] arr, int low, int high, Comparator<? super T> comp) {
    	// Base case: If the array has one or no elements, it's already sorted
        if (low < high) {
        	// Partition the array and get the partition index
            int partitionIndex = partition(arr, low, high, comp);
            quickSort(arr, low, partitionIndex - 1, comp); // Recursively sort the left sub-array
            quickSort(arr, partitionIndex + 1, high, comp); // Recursively sort the right sub-array
        }
    }

    // Partition method to rearrange the array elements
    private static <T> int partition(T[] arr, int low, int high, Comparator<? super T> comp) {
        T pivot = arr[high]; // Choosing the last element as pivot
        int i = low - 1	; // Index of smaller element
        
        // Rearranging elements based on the pivot
        for (int j = low; j < high; j++) {
        	
            if (comp.compare(arr[j], pivot) > 0) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high); // Place the pivot in the correct position
        return i + 1;
    }

    // Method to swap two elements in the array
    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
