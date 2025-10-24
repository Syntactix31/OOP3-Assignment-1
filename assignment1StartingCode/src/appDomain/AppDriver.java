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
		
		
		// Benchmarking variables initialization
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
		
		shapes = ShapeFileReader.readShapesFromFile(Paths.get("res", "shapes2.txt")); // Temporary hard-coded file read for testing
        

		// Bubble Sort Algorithm
        System.out.println("Original Array: ");
        
        for (Shape val : shapes) {
            System.out.println(val);
        }
        
        System.out.println();
        
        
        System.out.println("Sorted Array: ");
        
     // Bubble Sort Benchmarking
        start = System.currentTimeMillis();
        BubbleSort.sort(shapes, new BaseAreaComparator());
        stop = System.currentTimeMillis();
        
        
        for (Shape numbers : shapes) {
            System.out.println(numbers);
        }
        
		System.out.println( "\nAlotted time for Bubble Sort was: " + ( stop - start ) + " milliseconds\n" );
		System.out.println();
		
		
		// Selection Sort Algorithm
        System.out.println("Original Array: ");
        
        for (Shape val : shapes) {
            System.out.println(val);
        }
        
        System.out.println();
        
        System.out.println("Sorted Array: ");
        
     // Selection Sort Benchmarking
        start = System.currentTimeMillis();
        SelectionSort.sort(shapes, new VolumeComparator());
        stop = System.currentTimeMillis();
        
        for (Shape numbers : shapes) {
            System.out.println(numbers);
        } 
		System.out.println( "\nAlotted time for Selection Sort was: " + ( stop - start ) + " milliseconds\n" );
		System.out.println();
		
		
		// Merge Sort ALgorithm
		System.out.println("Original Array: ");
		for (Shape s : shapes) System.out.println(s);
		
	 // Merge Sort Benchmarking
		start = System.currentTimeMillis();
		utilities.MergeSort.sort(shapes, new BaseAreaComparator().reversed());	// THEO FIX TS
		stop = System.currentTimeMillis();
		
		System.out.println();
		System.out.println("Sorted Array (DESC): ");
		for (Shape s : shapes) System.out.println(s);

		System.out.println("\nAlotted time for Merge Sort was: " + (stop - start) + " milliseconds\n");
		System.out.println();
		
		
		// Insertion Sort Algorithm
        System.out.println("Original Array: ");
        for (Shape val : shapes) {
            System.out.println(val);
        }
        System.out.println();

        System.out.println("Sorted Array: ");
        
     // Insertion Sort Benchmarking
        start = System.currentTimeMillis();
        InsertionSort.sort(shapes, new BaseAreaComparator());
        stop = System.currentTimeMillis();
        
        for (Shape s : shapes) {
            System.out.println(s);
        }
        System.out.println("\nAlotted time for Insertion Sort was: " + (stop - start) + " milliseconds\n");
        System.out.println();
        

        //	Shell Sort Algorithm
        System.out.println("Original Array: ");
        for (Shape val : shapes) {
            System.out.println(val);
        }
        System.out.println();

        System.out.println("Sorted Array: ");
        
     // Shell Sort Benchmarking
        start = System.currentTimeMillis();
        ShellSort.sort(shapes, new VolumeComparator());
        stop = System.currentTimeMillis();
        
        for (Shape s : shapes) {
            System.out.println(s);
        }
        System.out.println("\nAlotted time for Shell Sort was: " + (stop - start) + " milliseconds\n");
        System.out.println();
        
        
        // Quick Sort Algorithm
        System.out.println("Original Array: ");
        for (Shape val : shapes) {
			System.out.println(val);
		}
        System.out.println();

		System.out.println("Sorted Array: ");
		
     // Quick Sort Benchmarking
		start = System.currentTimeMillis();
		QuickSort.sort(shapes, new BaseAreaComparator());
		stop = System.currentTimeMillis();
		
		for (Shape s : shapes) {
			System.out.println(s);
		}
		System.out.println("\nAlotted time for Quick Sort was: " + (stop - start) + " milliseconds\n");
		System.out.println();
        
        
		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
