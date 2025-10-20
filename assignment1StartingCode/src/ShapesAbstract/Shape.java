/**
 * 
 */
package ShapesAbstract;

/**
 * 
 */
public abstract class Shape implements Comparable<Shape>{

	public double height;
	public abstract double calcVolume();
	public abstract double calcBaseArea();
	
	public double getHeight()
	{
		return height;
	}
	
	public Shape(double height) {
		// TODO Auto-generated constructor stub
		this.height = height;
	}

	
	@Override
	public int compareTo(Shape that) {

		return Double.compare(this.getHeight(), that.getHeight());
	}
	
	
}
