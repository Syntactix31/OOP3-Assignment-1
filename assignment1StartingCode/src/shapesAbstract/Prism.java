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
public abstract class Prism extends Shape {
	
	//Attribute and abstract Method Declaration
	public double side;
	public abstract double calcVolume();
	public abstract double calcBaseArea();
	
	// Getters for indirect attribute manipulation
	public double getHeight()
	{
		return height;
	}
	
	public double getSide()
	{
		return side;
	}
	
	// Constructor accepts two key values: height and side that all child classes must integrate
	public Prism(double height, double side) {
		super(height);
		this.side = side;
		
	}
	
	
	
	
}
