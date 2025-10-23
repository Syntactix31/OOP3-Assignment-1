/**
 * 
 */
package shapesAbstract;


/**
 * Jiro do this comparator
 */
public abstract class Prism {
	
	public double height;
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
		// TODO Auto-generated constructor stub
		this.height = height;
		this.side = side;
	}
	
	
	
	
}
