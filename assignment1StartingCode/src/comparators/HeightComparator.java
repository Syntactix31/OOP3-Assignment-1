package comparators;

import java.util.Comparator;

import shapesAbstract.Shape;

public class HeightComparator implements Comparator<Shape> {

	public HeightComparator() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compare(Shape s1, Shape s2) {
    	return Double.compare(s1.getHeight(), s2.getHeight());
	}

}
