package mypackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class Rectangle extends Shape {

	private int x;
	private int y;
	private int width;
	private int height;
	private Color shapeColor;

	public Rectangle() {
	}

	public Rectangle(Rectangle r) {
		this.x = r.x;
		this.y = r.y;
		this.width = r.width;
		this.height = r.height;
		this.shapeColor = r.shapeColor;
	}

	public Rectangle(int x, int y, int width, int height, Color shapeColor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.shapeColor = shapeColor;
	}

	public int getArea() {
		return (int) height * width;
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(shapeColor);
		g2.fillRect(x, y, width, height);
	}

	@Override
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Override
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
