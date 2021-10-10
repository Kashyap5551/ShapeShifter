package shapesort;

import java.awt.Color;
import java.awt.Graphics;


public class MyRectangle implements Comparable <Object>{

	protected int upperX; 
	protected int upperY;
	protected int width;
	protected int height;
	protected Color shapeColor;
	
	/**
	 * Class's constructor
	 * @param upperX
	 * @param upperY
	 * @param width
	 * @param height
	 * @param shapeColor
	 */
	public MyRectangle (int upperX, int upperY, int width, int height, Color shapeColor) {
		this.upperX = upperX;
		this.upperY = upperY;
		this.width = width;
		this.height = height;
		this.shapeColor = shapeColor;
	}
	



	public int compareTo(MyRectangle o) {
		// TODO write the right Java code here to support the comparison
		return (int)( this.getArea() - o.getArea());
	}
	public int compareTo(MyCircle o) {
		// TODO write the right Java code here to support the comparison
		return  (int)(this.getArea() - o.getArea());
	}
	@Override
	public int compareTo(Object o) {
		int v = 0;
		if (o.getClass().equals(shapesort.MyCircle.class)) {
			v = this.compareTo((MyCircle)o);
		}else if (o.getClass().equals(shapesort.MyRectangle.class)) {
			v = this.compareTo((MyRectangle)o);
		}
		return v;
	}
	
	
	/**
	 * Method to draw a rectangle
	 * @param form
	 */
	public  void drawShape(Graphics	form) {
		form.fillRect(upperX, upperY, width, height);
	}
	
    
    //getters
    public Color getColor() {
		return shapeColor;
	}
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
    
	public int getUpperX() {
		return upperX;
	}
	
	public int getUpperY() {
		return upperY;
	}
	
	public int getArea() {
		return (int)((this.getHeight() * this.getWidth()));
	}
	
	//setters
	 public void setColor(Color aShapeColor) {
		 this.shapeColor = aShapeColor;
	 }
	 
	 public void setWidth( int width) {
		 this.width = width;
	 }
	    
	 public void setHeight(int height) {
		 this.height = height;
	 }
	 
	 public void setUpperX(int upperX) {
		 this.upperX = upperX;
	 }
		
	 public void setUpperY(int upperY) {
		 this.upperY = upperY;
	 }


}