package shapes;

import shapesAbstract.Shape;

public class Cylinder extends Shape
{
	
	public double radius;
	
	public Cylinder(double height, double radiusOrEdge) {
		super(height);
		// TODO Auto-generated constructor stub
	}	
	
	
	public double getRadius()
	{
		return radius;
	}


	@Override
	public double calcVolume() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double calcBaseArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}
