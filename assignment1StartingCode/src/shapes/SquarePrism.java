package shapes;

import shapesAbstract.Prism;

public class SquarePrism extends Prism
{

	public SquarePrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * height;
	}

	@Override
	public double calcBaseArea() {
		return side * side;
	}

}