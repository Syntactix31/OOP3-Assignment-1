package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import shapes.*;
import shapesAbstract.Shape;  

public final class ShapeFileReader {
	 public static Shape[] readShapesFromFile(Path file) {
		 try (BufferedReader br = Files.newBufferedReader(file)) {
	            int numShapes = Integer.parseInt(br.readLine().trim());
	            Shape[] shapes = new Shape[numShapes];

	            for (int i = 0; i < numShapes; i++) {
	                String[] parts = br.readLine().split(" ");
	                String type = parts[0];
	                double height = Double.parseDouble(parts[1]);
	                double val2 = Double.parseDouble(parts[2]);

	                switch (type) {
	                    case "Cylinder":
	                        shapes[i] = new Cylinder(height, val2);
	                        break;
	                    case "Cone":
	                        shapes[i] = new Cone(height, val2);
	                        break;
	                    case "Pyramid":
	                        shapes[i] = new Pyramid(height, val2);
	                        break;
	                    case "SquarePrism":
	                        shapes[i] = new SquarePrism(height, val2);
	                        break;
	                    case "TriangularPrism":
	                        shapes[i] = new TriangularPrism(height, val2);
	                        break;
	                    case "PentagonalPrism":
	                        shapes[i] = new PentagonalPrism(height, val2);
	                        break;
	                    case "OctagonalPrism":
	                        shapes[i] = new OctagonalPrism(height, val2);
	                        break;
	                    default:
	                        System.out.println("Unknown shape type: " + type);
	                        break;
	                }
	            }
	            return shapes;
			} catch (IOException e) {
							e.printStackTrace();
			}
	        return null;
	    }
}
