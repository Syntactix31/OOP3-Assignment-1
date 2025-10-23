package shapes;

import shapesAbstract.Prism;

public class Pyramid extends Prism
{

	public Pyramid(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcVolume() {
		return (1.0 / 3.0) * calcBaseArea() * height;
	}

	@Override
	public double calcBaseArea() {
		return side * side;
	}

}