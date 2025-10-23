package utilities;

import java.util.Comparator;
import shapesAbstract.Shape;

public class QuickSort {

    public static void sort(Shape[] arr, Comparator<Shape> comp) {
        quickSort(arr, 0, arr.length - 1, comp);
    }

    private static void quickSort(Shape[] arr, int low, int high, Comparator<Shape> comp) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high, comp);
            quickSort(arr, low, partitionIndex - 1, comp);
            quickSort(arr, partitionIndex + 1, high, comp);
        }
    }

    
    private static int partition(Shape[] arr, int low, int high, Comparator<Shape> comp) {
        Shape pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
        	
            if (comp.compare(arr[j], pivot) > 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(Shape[] arr, int i, int j) {
        Shape temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
