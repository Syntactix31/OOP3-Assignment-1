package appDomain;

import utilities.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
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
		// Benchmarking variables initialization
		long start, stop;
		
		// Command line arguments parsing
		String filePath = null;
		Character compareKey = null; // 'h', 'v', 'a'
		Character sortKey = null; // 'b','s','i','m','q','z' 

		// Accept: -fX, -f X, -F"c:\path\file.txt", -ta, -Tv, -sQ, order-insensitive,
		// handles ASCII '-' and Unicode en/em dashes, and strips smart quotes.
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			if (arg == null || arg.length() < 2) continue;

			char dash = arg.charAt(0);
			if (dash != '-' && dash != '\u2013' && dash != '\u2014') continue; // -, – (en), — (em)

			char flag = Character.toLowerCase(arg.charAt(1));

			String value;
			if (arg.length() > 2) {
				value = arg.substring(2);
			} else {
				value = (i + 1 < args.length) ? args[++i] : "";
			}
			value = cleanValue(value);

			switch (flag) {
				case 'f': filePath = value; break;
				case 't': if (!value.isEmpty()) compareKey = Character.toLowerCase(value.charAt(0)); break;
				case 's': if (!value.isEmpty()) sortKey    = Character.toLowerCase(value.charAt(0)); break;
				default:  break;
			}
		}

		// Defaults so it runs even with no args
		if (filePath == null || filePath.trim().isEmpty()) filePath = "shapes1.txt";
		if (compareKey == null) compareKey = 'h';
		if (sortKey == null)    sortKey    = 'm';

		// Resolve the file path exactly as per the PDF examples (no double "res\res")
		Path path = resolvePath(filePath);
		if (!Files.exists(path)) {
			System.err.println("Could not find input file: " + filePath);
			return;
		}

		// Load shapes
		Shape[] shapes = ShapeFileReader.readShapesFromFile(path);
		if (shapes == null) {
			System.err.println("Could not read shapes from: " + path);
			return;
		}

		// Create comparator based on compareKey
		Comparator<Shape> cmp;
		switch (compareKey) {
		    case 'h': cmp = new comparators.HeightComparator(); break;
		    case 'v': cmp = new comparators.VolumeComparator(); break;
		    case 'a': cmp = new comparators.BaseAreaComparator(); break;
		    default:  cmp = new comparators.HeightComparator(); break;
		}

		// Run ONLY the algorithm chosen by -s
		start = System.currentTimeMillis();
		switch (sortKey) {
		    case 'b': utilities.BubbleSort.sort(shapes, cmp); break;
		    case 's': utilities.SelectionSort.sort(shapes, cmp); break;
		    case 'i': utilities.InsertionSort.sort(shapes, cmp); break;
		    case 'm': utilities.MergeSort.sort(shapes, cmp); break;
		    case 'q': utilities.QuickSort.sort(shapes, cmp); break;
		    case 'z': utilities.ShellSort.sort(shapes, cmp); break;
		    default:  utilities.MergeSort.sort(shapes, cmp); break;
		}
		stop = System.currentTimeMillis();

		System.out.println("Sorted Array:");
		printFirstEveryThousandLastMetric(shapes, compareKey);
		System.out.println();
		System.out.println(getSortName(sortKey) + " Sort run time was: " + (stop - start) + " milliseconds");
		System.out.println();

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

	private static String getSortName(Character sortKey) {
		if (sortKey == null) return "Merge";
		switch (Character.toLowerCase(sortKey)) {
			case 'b': return "Bubble";
			case 's': return "Selection";
			case 'i': return "Insertion";
			case 'm': return "Merge";
			case 'q': return "Quick";
			case 'z': return "Shell";
			default:  return "Merge";
		}
	}

	// Prints first element, every 1000-th element, and last element — one line each,
	// showing the METRIC requested by -t: h (height), v (volume), a (base area).
	private static void printFirstEveryThousandLastMetric(Shape[] a, char key) {
	    int n = (a == null) ? 0 : a.length;
	    if (n == 0) return;

	    final java.util.Locale L = java.util.Locale.ROOT;

	    // Parse metric from toString() to avoid depending on methods not on Shape
	    java.util.function.ToDoubleFunction<Shape> metric = s -> {
	        String t = s.toString(); // e.g. "shapes.Cone: Height=..., BaseArea=..., Volume=..."
	        try {
	            int i, j;
	            switch (key) {
	                case 'h': // Height=
	                    i = t.indexOf("Height="); if (i < 0) return Double.NaN;
	                    j = t.indexOf(',', i);
	                    return Double.parseDouble((j > i ? t.substring(i+7, j) : t.substring(i+7)).trim());
	                case 'a': // BaseArea=
	                    i = t.indexOf("BaseArea="); if (i < 0) return Double.NaN;
	                    j = t.indexOf(',', i);
	                    return Double.parseDouble((j > i ? t.substring(i+9, j) : t.substring(i+9)).trim());
	                case 'v': // Volume=
	                    i = t.indexOf("Volume="); if (i < 0) return Double.NaN;
	                    j = t.indexOf(',', i);
	                    return Double.parseDouble((j > i ? t.substring(i+7, j) : t.substring(i+7)).trim());
	                default:
	                    i = t.indexOf("Height="); if (i < 0) return Double.NaN;
	                    j = t.indexOf(',', i);
	                    return Double.parseDouble((j > i ? t.substring(i+7, j) : t.substring(i+7)).trim());
	            }
	        } catch (Exception e) {
	            return Double.NaN;
	        }
	    };

	    final String label = (key=='v') ? "Volume" : (key=='a') ? "Base area" : "Height";

	    java.util.function.BiConsumer<String, Integer> out = (prefix, idx) -> {
	        double v = metric.applyAsDouble(a[idx]);
	        String vStr = Double.isNaN(v)
	                ? "N/A"
	                : (key=='v' ? String.format(L, "%.15E", v) : String.format(L, "%.3f", v));
	        System.out.printf(
	            L,
	            "%-18s %-25s %s: %s%n",
	            prefix,
	            a[idx].getClass().getName(),
	            label,
	            vStr
	        );
	    };

	    out.accept("First element is:", 0);

	    for (int pos = 1000; pos <= n - 1; pos += 1000) {
	        int idx = pos - 1;
	        if (idx > 0 && idx < n - 1) {
	            out.accept(pos + "-th element:", idx);
	        }
	    }

	    out.accept("Last element is:", n - 1);
	}

	// ---------- helpers: robust CLI value cleaning & path resolution ----------

	private static String cleanValue(String s) {
		if (s == null) return null;
		s = s.trim();
		// normalize curly quotes to straight
		s = s.replace('\u201C','"').replace('\u201D','"')
		     .replace('\u2018','\'').replace('\u2019','\'');
		// strip wrapping quotes if present
		if (s.length() >= 2) {
			char first = s.charAt(0), last = s.charAt(s.length()-1);
			if ((first=='"' && last=='"') || (first=='\'' && last=='\'')) {
				s = s.substring(1, s.length()-1);
			}
		}
		return s;
	}

	private static Path resolvePath(String filePath) {
		// After cleaning, try as-is first (absolute or relative)
		String cleaned = cleanValue(filePath);
		Path p = Paths.get(cleaned);
		if (Files.exists(p)) return p;

		// If it already starts with "res/" or "res\", don't prepend "res" again
		String norm = cleaned.replace('\\','/');
		boolean startsWithRes = norm.regionMatches(true, 0, "res/", 0, 4);

		if (!startsWithRes) {
			Path underRes = Paths.get("res").resolve(cleaned);
			if (Files.exists(underRes)) return underRes;
		}

		// Last try: if caller actually passed something like quotes mid-token,
		// the shell will already have produced a proper string (handled above).
		return p; // will fail later and we print a friendly message
	}
}
