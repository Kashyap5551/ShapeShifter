package shapesort;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	List<Object> shapeList = shapeFactory();

	/**
	 * This method creates two rectangles
	 * 
	 * @return
	 */

	private Object shapeFactoryHelper(int cordsx, int cordsy) {
		Random num = new Random();
		int choice = num.nextInt(3);
		int rdw = num.nextInt(100);
		int rdh = num.nextInt(100);
		System.out.println(choice);
		Color randomcolor = new Color(num.nextInt(256), num.nextInt(256), num.nextInt(256));
		switch (choice) {
		case 0:
			// Generates Random Rectangle
			System.out.println(rdh + " " + rdw + " " + cordsx + " " + cordsy);
			// it is a rectangle so therefore length!= width
			return new MyRectangle(cordsx, cordsy, rdh, rdw, randomcolor);

		case 1:
			// Generates Random Square
			System.out.println(rdh + " " + rdw + " " + cordsx + " " + cordsy);
			return new MyRectangle(cordsx, cordsy, rdh, rdh, randomcolor);

		case 2:
			// Generates Random Circle
			System.out.println(rdh + " " + rdw + " " + cordsx + " " + cordsy);
			return new MyCircle(cordsx, cordsy, rdw, rdw, randomcolor);
		}
		return null;

	}

	private int[] shapeFactoryHelper2(Object shape) {
		int[] cor = new int[2];
		System.out.println(shape.getClass());
		if (shape.getClass().equals(MyCircle.class)) {
			MyCircle cshape = (MyCircle) shape;
			cor[1] = cshape.getHeight();
			cor[0] = cshape.getWidth();
		} else if (shape.getClass().equals(MyRectangle.class)) {
			MyRectangle rshape = (MyRectangle) shape;
			cor[1] = rshape.getHeight();
			cor[0] = rshape.getWidth();

		} else {
			System.out.println("Error: shapeFactoryHelper2");
		}

		return cor;

	}

	private List<Object> shapeFactory() {
		int startx = 0, starty = 0;
		List<Object> shapeList = new ArrayList<Object>();
		for (int i = 0; i < 10; i++) {
			Object shapetest = shapeFactoryHelper(startx, starty);
			int[] cor = shapeFactoryHelper2(shapetest);
			startx += cor[0];
			starty += cor[1];
			shapeList.add(shapetest);
		}

		return shapeList;
	}

	private List<Object> orderFactory() {
		int startx = 0, starty = 0;
		for (int i = 0; i < shapeList.size(); i++) {
			Object shape = shapeList.get(i);
			int[] cor = shapeFactoryHelper2(shapeList.get(i));
			if (shape.getClass().equals(shapesort.MyCircle.class)) {
				MyCircle cshape = (MyCircle) shape;
				cshape.setUpperX(startx);
				cshape.setUpperY(starty);
				shapeList.set(i, cshape);
			} else if (shape.getClass().equals(shapesort.MyRectangle.class)) {
				MyRectangle rshape = (MyRectangle) shape;
				rshape.setUpperX(startx);
				rshape.setUpperY(starty);
				shapeList.set(i, rshape);
			}
			startx += cor[0];
			starty += cor[1];
		}

		return shapeList;
	}

	public void paintList(List<Object> shapeList, Graphics2D g2d) {
		for (Object shape : shapeList) {
			System.out.println(shape.getClass());
			if (shape.getClass().equals(shapesort.MyCircle.class)) {
				System.out.println("Circle");
				MyCircle cshape = (MyCircle) shape;
				g2d.setColor(cshape.getColor());
				cshape.drawShape(g2d);
			} else if (shape.getClass().equals(MyRectangle.class)) {
				System.out.println("Rectangle");
				MyRectangle rshape = (MyRectangle) shape;
				g2d.setColor(rshape.getColor());
				rshape.drawShape(g2d);
			} else {
				System.out.println("Error");

			}
		}

	}

	/**
	 * This method displays the created rectangles.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// calling the method that creates two shapes (rectangles)
		paintList(shapeList, g2d);
	}

	/**
	 * This is the main method of the class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyPanel rects = new MyPanel();
		JFrame frame = new JFrame("Display two shapes (rectangles)");
		JButton buttonLoad = new JButton("Load Shapes");
		JButton buttonSort = new JButton("Sort Shapes");
		buttonLoad.setBounds(100, 20, 150, 50);
		buttonSort.setBounds(270, 20, 150, 50);
		buttonLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rects.newShapes();
				rects.repaint();

				// your actions
			}
		});

		buttonSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				rects.sort();
				rects.repaint();
				// your actions
			}
		});
		frame.add(buttonLoad);
		frame.add(buttonSort);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(rects);
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	protected void newShapes() {
		shapeList = shapeFactory();
		// TODO Auto-generated method stub
	}

	protected void sort() {
		// ARRAYS GO BRRR
		Object[] shapeLR = shapeList.toArray();
		System.out.println(Arrays.deepToString(shapeLR));
		quicksort(shapeLR, 0, shapeLR.length - 1);
		System.out.println(Arrays.deepToString(shapeLR));
		shapeList = Arrays.asList(shapeLR);
		orderFactory();
	}

	private <T> void quicksort(T[] items, int i, int j) {
		// TODO Auto-generated method stub
		if (i < j) {
			int l = partition(items, i, j);
			quicksort(items, i, l);
			quicksort(items, l + 1, j);
		}
	}

	private static <T> int partition(Object[] items, int p, int q) {
		Object x = items[p];
		int m = (p + q) / 2;

		if ((compare(items[p], items[m]) <= 0 && compare(items[m], items[q]) <= 0)
				|| (compare(items[q], items[m]) <= 0 && compare(items[m], items[p]) <= 0))
			x = items[m];
		if ((compare(items[p], items[q]) <= 0 && compare(items[q], items[m]) <= 0)
				|| (compare(items[m], items[q]) <= 0 && compare(items[q], items[p]) <= 0))
			x = items[q];
		int i = p - 1;
		int j = q + 1;
		while (true) {
			do
				i++;
			while (!(i > q || compare(items[i], x) >= 0));
			do
				j--;
			while (!(j < p || compare(items[j], x) <= 0));
			if (i < j)
				swap(items, i, j);
			else
				return j;
		}

	}

	private static <T extends Comparable<T>> void swap(Object[] a, int i, int j) {
		Object x;
		x = a[i];
		a[i] = a[j];
		a[j] = x;
	}

	public static int compare(Object a, Object o) {
		// TODO write the right Java code here to support the comparison
		int v = 0;
		if (a.getClass().equals(shapesort.MyCircle.class)) {
			v = ((MyCircle) a).compareTo(o);
		} else if (a.getClass().equals(shapesort.MyRectangle.class)) {
			v = ((MyRectangle) a).compareTo(o);
		}
		return v;
	}

}