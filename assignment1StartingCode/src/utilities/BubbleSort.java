/**
 * 
 */
package utilities;

import java.util.Comparator;

/**
 * 
 */
public class BubbleSort {

	/**
	 * 
	 */
	public BubbleSort() {
		// TODO Auto-generated constructor stub
	}
	
	public static <T> void sort(T[] array, Comparator<? super T> comparator) {
		
		for (int i=0; i < array.length - 1; i++) {
			for (int j=1; j<array.length - i; j++) {
				if (comparator.compare(array[j - 1], array[j]) < 0) {
					swap(array, j, j-1);
				}
			}
		}
	}	
	
	
	private static <T> void swap(T[] testArray, int index1, int index2) {
		T temp = testArray[index1];
		testArray[index1] = testArray[index2];
		testArray[index2] = temp;
	}
		

	// Got rid of this
//    public static void main(String[] args) {       
//        Shape[] shapes = {
//                new Cone(10, 3),
//                new Cone(5, 5),
//                new Cone(8, 4)
//            };
//        System.out.println("Original Array: ");
//        
//        for (Shape val : shapes) {
//            System.out.println(val);
//        }
//        
//        System.out.println();
//        
//        System.out.println("Sorted Array: ");
//        BubbleSort.sort(shapes, new VolumeComparator());
//        
//        for (Shape numbers : shapes) {
//            System.out.println(numbers);
//        }
        
//      Non formatted output:  System.out.println(Arrays.toString(testArray));
        
    } 
	
}

