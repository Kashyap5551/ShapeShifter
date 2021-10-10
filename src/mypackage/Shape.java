package mypackage;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable<Shape> {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color shapeColor;

	public Shape() {
	}

	public Shape(Shape r) {
		this.x = r.x;
		this.y = r.y;
		this.width = r.width;
		this.height = r.height;
		this.shapeColor = r.shapeColor;
	}

	public Shape(int x, int y, int width, int height, Color shapeColor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.shapeColor = shapeColor;
	}

	public abstract int getArea();

	public abstract void draw(Graphics g);

	@Override
	public int compareTo(Shape o) {

		if (o instanceof Rectangle) {
			int res = 0;
			if (this.getArea() < ((Rectangle) o).getArea()) {
				res = -1;
			}
			if (this.getArea() > ((Rectangle) o).getArea()) {
				res = 1;
			}

			return res;
		}
		if (o instanceof Circle) {
			int res = 0;
			if (this.getArea() < ((Circle) o).getArea()) {
				res = -1;
			}
			if (this.getArea() > ((Circle) o).getArea()) {
				res = 1;
			}

			return res;
		} else {
			int res = 0;
			if (this.getArea() < ((Square) o).getArea()) {
				res = -1;
			}
			if (this.getArea() > ((Square) o).getArea()) {
				res = 1;
			}

			return res;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getShapeColor() {
		return shapeColor;
	}

	public void setShapeColor(Color shapeColor) {
		this.shapeColor = shapeColor;
	}
}
