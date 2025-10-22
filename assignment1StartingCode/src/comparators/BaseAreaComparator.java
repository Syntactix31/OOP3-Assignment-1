package comparators;

import java.util.Comparator;

import shapesAbstract.Shape;

public class BaseAreaComparator implements Comparator<Shape> {
	
	public BaseAreaComparator () {
		
	}
	
    @Override
    public int compare(Shape s1, Shape s2) {
        return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
    }
}

