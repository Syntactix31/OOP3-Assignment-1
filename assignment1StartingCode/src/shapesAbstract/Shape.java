/**
 * 
 */
package shapesAbstract;

/**
 * Shape.java
 *
 * @author Levi Moreau
 * @version 1.8 
 * 
 * Class Definition: Class to demonstrate abstraction and object sorting 
 * 		through the implementation of a comparable interface. 
 * 		This abstract class shape uses a universal child attribute
 * 		"height" to directly compare objects.
 * 
 */
public abstract class Shape implements Comparable<Shape>{

	//Attribute and abstract Method Declaration
	public double height;
	public abstract double calcVolume();
	public abstract double calcBaseArea();
	
	// Getter for indirect attribute manipulation
	public double getHeight()
	{
		return height;
	}
	
	public Shape(double height) {
		// Constructor accepts one key value: height that all child classes must integrate
		this.height = height;
	}

	// The comparison method inherited from the comparable interface to compare two objects with an intrinsic trait
	@Override
	public int compareTo(Shape that) {

		return Double.compare(that.getHeight(), this.getHeight());
	}
	
	// String formatting for output of each instance of the class (Note: getSimpleName() removed)
	@Override
    public String toString() {
        return this.getClass().getName()+ 
               ": Height=" + height + 
               ", BaseArea=" + calcBaseArea() + 
               ", Volume=" + calcVolume();
    }
	
}
