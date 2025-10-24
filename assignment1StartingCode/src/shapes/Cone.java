package shapes;

import shapesAbstract.Shape;

/**
 * Cone.java
 *
 * @author Levi Moreau
 * @version 1.8 
 * 
 * Class Definition: Class that inherits its Shape parent class and integrates mandatory attributes and methods 
 * 					 as well as provided additional class specific information.
 * 
 */

public class Cone extends Shape
{
	// Attribute declaration
	public double radius;
	
	// Constructor that accepts the radius and base class attribute height
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}	
	
	// Getter for radius attribute
	public double getRadius()
	{
		return radius;
	}
	
	// Implements mandatory method from parent class that calculates base area
    @Override
    public double calcBaseArea() {
        return Math.PI * radius * radius ;
    }

	// Implements mandatory method from parent class that calculates volume
    @Override
    public double calcVolume() {
        return (calcBaseArea() * height) / 3;
    }
	
	
}
