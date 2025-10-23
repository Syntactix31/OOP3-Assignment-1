package shapes;

import shapesAbstract.Shape;

public class Cylinder extends Shape
{
	
	public double radius;
	
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}	
	
	
	public double getRadius()
	{
		return radius;
	}


	@Override
	public double calcVolume() {
		return Math.PI * (radius * radius) * height;
	}


	@Override
	public double calcBaseArea() {
		return Math.PI * (radius * radius);
	}

}
