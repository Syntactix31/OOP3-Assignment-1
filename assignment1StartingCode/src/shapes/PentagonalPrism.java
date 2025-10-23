package shapes;

import shapesAbstract.Prism;

public class PentagonalPrism extends Prism
{

	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}

	@Override
	public double calcBaseArea() {
		return (5.0 * side * side) / (4.0 * Math.tan(Math.PI / 5.0));
	}

}