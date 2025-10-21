package appDomain;
import utilities.BubbleSort;
import utilities.SelectionSort;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * F2025 class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests
		
		
		// Bubble Sort Benchmarking (Replace test array with array from file read parse)
		long start, stop;
		
		start = System.currentTimeMillis();
        BubbleSort sortArray = new BubbleSort();
        
        double[] testArray = {15.445, 8.234, 5.679, 5.78, 11.3};
        System.out.println("Original Array: ");
        
        for (double val : testArray) {
            System.out.println(val);
        }
        
        System.out.println();
        
        System.out.println("Sorted Array: ");
        sortArray.sort(testArray);
        
        for (double numbers : testArray) {
            System.out.println(numbers);
        }
        
		stop = System.currentTimeMillis();
		System.out.println( "Alotted time for Bubble Sort was: " + ( stop - start ) + " milliseconds" );
		System.out.println();
		
		
		// Selection Sort Benchmarking (Replace test array with array from file read parse)
		start = System.currentTimeMillis();
        SelectionSort newArray = new SelectionSort();
        
        double[] testArray2 = {15.445, 8.234, 5.679, 5.78, 11.3, 8.234};
        System.out.println("Original Array: ");
        
        for (double val : testArray2) {
            System.out.println(val);
        }
        
        System.out.println();
        
        System.out.println("Sorted Array: ");
        newArray.sort(testArray2);
        
        for (double numbers : testArray2) {
            System.out.println(numbers);
        }
        
        stop = System.currentTimeMillis();
		System.out.println( "Alotted time for Selection Sort was: " + ( stop - start ) + " milliseconds" );
		System.out.println();
        
		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
