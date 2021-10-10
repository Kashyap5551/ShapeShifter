package mypackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
			return (int) (this.getArea() - ((Rectangle) o).getArea());
		}
		if (o instanceof Circle) {
			return (int) (this.getArea() - ((Circle) o).getArea());
		} else {
			return (int) (this.getArea() - ((Square) o).getArea());
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
