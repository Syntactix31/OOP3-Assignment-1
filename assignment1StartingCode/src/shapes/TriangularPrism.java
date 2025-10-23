package shapes;

import shapesAbstract.Prism;

public class TriangularPrism extends Prism
{

	public TriangularPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}

	@Override
	public double calcBaseArea() {
		return (Math.sqrt(3) / 4.0) * side * side;
	}

}