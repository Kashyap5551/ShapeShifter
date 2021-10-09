package mypackage;

public class Shape {
	int height, width, x, y;

	public Shape() {
	}

	public Shape(Shape s) {
		x = s.x;
		y = s.y;
		width = s.width;
		height = s.height;
	}

	public Shape(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
