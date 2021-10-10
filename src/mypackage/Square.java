package mypackage;

public class Square implements Shape, Comparable<Object>{
	private int x;
	private int y;
	private int width;
	private int height;

	public Square() {
	}

	public Square(Square r) {
		this.x = r.x;
		this.y = r.y;
		this.width = r.width;
		this.height = r.height;
	}

	public Square(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public int getArea() {
		return (int) height * width;
	}
	
	@Override
	public int compareTo(Object o) {
		
		if (o.getClass().equals(mypackage.Circle.class)) {
			return  (int)(this.getArea() - ((Circle) o).getArea());
		}else if (o.getClass().equals(mypackage.Rectangle.class)) {
			return  (int)(this.getArea() - ((Rectangle) o).getArea());
		}else{
			return  (int)(this.getArea() - ((Square) o).getArea());
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
}
