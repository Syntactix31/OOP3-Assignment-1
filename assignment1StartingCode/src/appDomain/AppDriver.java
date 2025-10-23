package appDomain;

import utilities.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import comparators.*;

import shapes.*;
import shapesAbstract.*;
import utilities.ShapeFileReader;
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
	 * @throws IOException 
	 */

	public static void main( String[] args ) throws IOException
	{
		// TODO Auto-generated method stub

		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests
		
		
		// Bubble Sort Benchmarking (Replace test array with array from file read parse)
		long start, stop;
		Shape[] shapes = null;
		
		// Parse command line arguments -- This works, just commented out for testing until file is ready
//		for (String arg : args) {
//			arg = arg.toLowerCase();
//			
//			if (arg.startsWith("-f")) {
//				String fileName = arg.substring(2);
//				shapes = ShapeFileReader.readShapesFromFile(Paths.get("res", fileName));
//			}
////			else if (arg.startsWith("-t")) { } type
////			else if (arg.startsWith("-s")) { } sort method
////			Also need to add error handling for invalid or missing args
//		}
		
		shapes = ShapeFileReader.readShapesFromFile(Paths.get("res", "shapes1.txt")); // Temporary hardcoded file read for testing
		
		start = System.currentTimeMillis();
        

		
        System.out.println("Original Array: ");
        
        for (Shape val : shapes) {
            System.out.println(val);
        }
        
        System.out.println();
        
        System.out.println("Sorted Array: ");
        BubbleSort.sort(shapes, new BaseAreaComparator());
        
        for (Shape numbers : shapes) {
            System.out.println(numbers);
        }
        
//      Non formatted output:  System.out.println(Arrays.toString(testArray));
        
        
		stop = System.currentTimeMillis();
		System.out.println( "\nAlotted time for Bubble Sort was: " + ( stop - start ) + " milliseconds\n" );
		System.out.println();
		
		
		// Selection Sort Benchmarking (Replace test array with array from file read parse)
		start = System.currentTimeMillis();
        
        
//        Shape[] shapes = {
//                new Cone(10, 3),
//                new Cone(5, 5),
//                new Cone(8, 4)
//            };
        System.out.println("Original Array: ");
        
        for (Shape val : shapes) {
            System.out.println(val);
        }
        
        System.out.println();
        
        System.out.println("Sorted Array: ");
        SelectionSort.sort(shapes, new VolumeComparator());
        
        for (Shape numbers : shapes) {
            System.out.println(numbers);
        }
        
        stop = System.currentTimeMillis();
		System.out.println( "\nAlotted time for Selection Sort was: " + ( stop - start ) + " milliseconds\n" );
		System.out.println();
		
		//Merge Sort (Replace shapesM with parsed array from the file)
		start = System.currentTimeMillis();

//		Shape[] shapes = {
//		    new Cone(10, 3),
//		    new Cone(5, 5),
//		    new Cone(8, 4)
//		};

		System.out.println("Original Array: ");
		for (Shape s : shapes) System.out.println(s);

		// DESCENDING by base area (as an example)
		utilities.MergeSort.sort(shapes, new BaseAreaComparator().reversed());

		System.out.println();
		System.out.println("Sorted Array (DESC): ");
		for (Shape s : shapes) System.out.println(s);

		stop = System.currentTimeMillis();
		System.out.println("\nAlotted time for Merge Sort was: " + (stop - start) + " milliseconds\n");
		System.out.println();
		
		// Insertion Sort Benchmarking (Replace shapesI with array from file read parse)
		start = System.currentTimeMillis();
//        Shape[] shapes = { new Cone(10, 3), new Cone(5, 5), new Cone(8, 4) };
        System.out.println("Original Array: ");
        for (Shape val : shapes) {
            System.out.println(val);
        }
        System.out.println();

        System.out.println("Sorted Array: ");
        InsertionSort.sort(shapes, new BaseAreaComparator());
        for (Shape s : shapes) {
            System.out.println(s);
        }

        stop = System.currentTimeMillis();
        System.out.println("\nAlotted time for Insertion Sort was: " + (stop - start) + " milliseconds\n");
        System.out.println();


        // Shell Sort Benchmarking (Replace shapesS with array from file read parse)
        start = System.currentTimeMillis();
//        Shape[] shapes = { new Cone(10, 3), new Cone(5, 5), new Cone(8, 4) };
        System.out.println("Original Array: ");
        for (Shape val : shapes) {
            System.out.println(val);
        }
        System.out.println();

        System.out.println("Sorted Array: ");
        ShellSort.sort(shapes, new VolumeComparator());
        for (Shape s : shapes) {
            System.out.println(s);
        }

        stop = System.currentTimeMillis();
        System.out.println("\nAlotted time for Shell Sort was: " + (stop - start) + " milliseconds\n");
        System.out.println();
        
        //Quick Sort Testing
        start = System.currentTimeMillis();
        
        System.out.println("Original Array: ");
        for (Shape val : shapes) {
			System.out.println(val);
		}
        System.out.println();

		System.out.println("Sorted Array: ");
		QuickSort.sort(shapes, new BaseAreaComparator());
		for (Shape s : shapes) {
			System.out.println(s);
		}

		stop = System.currentTimeMillis();
		System.out.println("\nAlotted time for Quick Sort was: " + (stop - start) + " milliseconds\n");
		System.out.println();
        
        
		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
