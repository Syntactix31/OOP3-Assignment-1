package comparators;
import java.util.Comparator;

import shapesAbstract.Shape;

public class VolumeComparator implements Comparator<Shape> {
	
	public VolumeComparator() {
		
	}
	
	@Override
	public int compare(Shape s1, Shape s2) {
    	return Double.compare(s1.calcVolume(), s2.calcVolume());
	}
	
	
}