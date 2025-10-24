package appDomain;

import utilities.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

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
		
		// Command line arguments parsing
		String filePath = null;
		Character compareKey = null; // 'h', 'v', 'a'
		Character sortKey = null;    // 'b','s','i','m','q','z' 

		for (String arg : args) {
			
		    if (arg.length() < 2 || arg.charAt(0) != '-') continue;

		    char flag = Character.toLowerCase(arg.charAt(1));
		    String argValue = arg.substring(2);

		    switch (flag) {
		        case 'f': // filepath
		            filePath = argValue;
		            break;

		        case 't': // compare type
		            if (argValue.isEmpty()) { 
		            	System.err.println("Use -th, -tv, or -ta"); 
		            	return; 
		            }
		            compareKey = argValue.charAt(0);
		            break;

		        case 's': // sort algorithm
		            if (argValue.isEmpty()) { 
		            	System.err.println("Use -sb, -ss, -si, -sm, -sq, or -sz"); 
		            	return; 
		            }
		            sortKey = argValue.charAt(0); // b/s/i/m/q/z
		            break;

		        default:
		            System.err.println("Unknown flag: " + arg + "\nExpected -f, -t, -s.");
		            return;
		    }
		}

		// Validation of command line arguments
		if (filePath == null) { System.err.println("Missing -f<file>. Example: -fres/shapes1.txt"); return; }
		if (compareKey == null) { System.err.println("Missing -t<h|v|a>. Example: -tv"); return; }
		if (sortKey == null) { System.err.println("Missing -s<b|s|i|m|q|z>. Example: -sq"); return; }

		// Load shapes
		Shape[] shapes = ShapeFileReader.readShapesFromFile(Paths.get("res", filePath));

		// Create comparator based on compareKey
		Comparator<Shape> cmp = null;
		switch (compareKey) {
		    case 'h': cmp = new comparators.HeightComparator(); break;
		    case 'v': cmp = new comparators.VolumeComparator(); break;
		    case 'a': cmp = new comparators.BaseAreaComparator(); break;
		    default: break;
		}
		
		// Display original results
		System.out.println("Original Array: ");
		for (Shape s : shapes) {
		    System.out.println(s);
		}
		System.out.println();
		
		// Start Benchmarking - And Perform Sort
		start = System.currentTimeMillis();
		switch (sortKey) {
		    case 'b': utilities.BubbleSort.sort(shapes, cmp); break;
		    case 's': utilities.SelectionSort.sort(shapes, cmp); break;
		    case 'i': utilities.InsertionSort.sort(shapes, cmp); break;
		    case 'm': utilities.MergeSort.sort(shapes, cmp); break;
		    case 'q': utilities.QuickSort.sort(shapes, cmp); break;
		    case 'z': utilities.ShellSort.sort(shapes, cmp); break;
		}
		stop = System.currentTimeMillis();
		
		// Display sorted results
		System.out.println("Sorted Array: ");
		for (Shape s : shapes) {
		    System.out.println(s);
		}
		System.out.println("\nAlotted time for Sort was: " + (stop - start) + " milliseconds\n");

//		// Bubble Sort Algorithm
//        System.out.println("Original Array: ");
//        
//        for (Shape val : shapes) {
//            System.out.println(val);
//        }
//        
//        System.out.println();
//        
//        
//        System.out.println("Sorted Array: ");
//        
//     // Bubble Sort Benchmarking
//        start = System.currentTimeMillis();
//        BubbleSort.sort(shapes, new BaseAreaComparator());
//        stop = System.currentTimeMillis();
//        
//        
//        for (Shape numbers : shapes) {
//            System.out.println(numbers);
//        }
//        
//		System.out.println( "\nAlotted time for Bubble Sort was: " + ( stop - start ) + " milliseconds\n" );
//		System.out.println();
//		
//		
//		// Selection Sort Algorithm
//        System.out.println("Original Array: ");
//        
//        for (Shape val : shapes) {
//            System.out.println(val);
//        }
//        
//        System.out.println();
//        
//        System.out.println("Sorted Array: ");
//        
//     // Selection Sort Benchmarking
//        start = System.currentTimeMillis();
//        SelectionSort.sort(shapes, new VolumeComparator());
//        stop = System.currentTimeMillis();
//        
//        for (Shape numbers : shapes) {
//            System.out.println(numbers);
//        } 
//		System.out.println( "\nAlotted time for Selection Sort was: " + ( stop - start ) + " milliseconds\n" );
//		System.out.println();
//		
//		
//		// Merge Sort ALgorithm
//		System.out.println("Original Array: ");
//		for (Shape s : shapes) System.out.println(s);
//		
//	 // Merge Sort Benchmarking
//		start = System.currentTimeMillis();
//		utilities.MergeSort.sort(shapes, new BaseAreaComparator().reversed());	// THEO FIX TS
//		stop = System.currentTimeMillis();
//		
//		System.out.println();
//		System.out.println("Sorted Array (DESC): ");
//		for (Shape s : shapes) System.out.println(s);
//
//		System.out.println("\nAlotted time for Merge Sort was: " + (stop - start) + " milliseconds\n");
//		System.out.println();
//		
//		
//		// Insertion Sort Algorithm
//        System.out.println("Original Array: ");
//        for (Shape val : shapes) {
//            System.out.println(val);
//        }
//        System.out.println();
//
//        System.out.println("Sorted Array: ");
//        
//     // Insertion Sort Benchmarking
//        start = System.currentTimeMillis();
//        InsertionSort.sort(shapes, new BaseAreaComparator());
//        stop = System.currentTimeMillis();
//        
//        for (Shape s : shapes) {
//            System.out.println(s);
//        }
//        System.out.println("\nAlotted time for Insertion Sort was: " + (stop - start) + " milliseconds\n");
//        System.out.println();
//        
//
//        //	Shell Sort Algorithm
//        System.out.println("Original Array: ");
//        for (Shape val : shapes) {
//            System.out.println(val);
//        }
//        System.out.println();
//
//        System.out.println("Sorted Array: ");
//        
//     // Shell Sort Benchmarking
//        start = System.currentTimeMillis();
//        ShellSort.sort(shapes, new VolumeComparator());
//        stop = System.currentTimeMillis();
//        
//        for (Shape s : shapes) {
//            System.out.println(s);
//        }
//        System.out.println("\nAlotted time for Shell Sort was: " + (stop - start) + " milliseconds\n");
//        System.out.println();
//        
//        
//        // Quick Sort Algorithm
//        System.out.println("Original Array: ");
//        for (Shape val : shapes) {
//			System.out.println(val);
//		}
//        System.out.println();
//
//		System.out.println("Sorted Array: ");
//		
//     // Quick Sort Benchmarking
//		start = System.currentTimeMillis();
//		QuickSort.sort(shapes, new BaseAreaComparator());
//		stop = System.currentTimeMillis();
//		
//		for (Shape s : shapes) {
//			System.out.println(s);
//		}
//		System.out.println("\nAlotted time for Quick Sort was: " + (stop - start) + " milliseconds\n");
//		System.out.println();
        
        
		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
