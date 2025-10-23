/**
 * 
 */
package shapesAbstract;


/**
 * Jiro do this comparator
 */
public abstract class Prism extends Shape {
	
	public double side;
	public abstract double calcVolume();
	public abstract double calcBaseArea();
	
	public double getHeight()
	{
		return height;
	}
	
	public double side()
	{
		return side;
	}
	
	
	public Prism(double height, double side) {
		super(height);
		this.side = side;
		
	}
	
	
	
	
}
