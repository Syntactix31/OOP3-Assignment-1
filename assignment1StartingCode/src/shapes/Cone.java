package shapes;

import shapesAbstract.Shape;

public class Cone extends Shape
{
	
	public double radius;
	
	public Cone(double height, double radius) {
		super(height);
		// TODO Auto-generated constructor stub
		this.radius = radius;
	}	
	
	public double getRadius()
	{
		return radius;
	}
	
    @Override
    public double calcBaseArea() {
        return Math.PI * radius * radius ;
    }

    @Override
    public double calcVolume() {
        return (calcBaseArea() * height) / 3;
    }
	
	
}
