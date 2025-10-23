package utilities;

import java.util.Comparator;


/**
 * 
 */
public class SelectionSort {

	public SelectionSort() {
		// TODO Auto-generated constructor stub
	}
	
	public static <T> void sort(T[] array, Comparator<? super T> comparator) {
		// TODO Auto-generated method stub
		
		for(int i=0; i < array.length - 1; i++) {
			
			int max = i;
			
			for(int j=i+1; j < array.length; j++) {
				if(comparator.compare(array[j], array[max]) > 0)
				max = j;
			}
			
			if (max != i) {
				swap(array, max, i);
			}
		}
		
		
	}
	
	private static <T> void swap(T[] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
	}

}


