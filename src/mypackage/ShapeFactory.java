package mypackage;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ShapeFactory {
	private List<Shape> shapes = new ArrayList<Shape>();

	public ShapeFactory() {
		int xCor = 10;
		int yCor = 10;

		Random randomNumber = new Random();

		for (int j = 0; j < 6; j++) {
			int i = randomNumber.nextInt(3);
			// System.out.println(i);
			int ranWidth = randomNumber.nextInt((60 - 30) + 1) + 30;
			int ranHeight = randomNumber.nextInt((60 - 30) + 1) + 30;
			Color ranColor = new Color(randomNumber.nextInt(256), randomNumber.nextInt(256), randomNumber.nextInt(256));
			if (i == 0) {
				// Rectangle
				Shape newRec = new Rectangle(xCor, yCor, ranWidth, ranHeight, ranColor);
				shapes.add(newRec);
			}

			if (i == 1) {
				// Square
				Shape newSqu = new Square(xCor, yCor, ranWidth, ranWidth, ranColor);
				shapes.add(newSqu);
			}

			if (i == 2) {
				// Circle
				Shape newCir = new Circle(xCor, yCor, ranWidth, ranHeight, ranColor);
				shapes.add(newCir);
			}
			xCor += 70;
			yCor += 70;
		}
	}

	public List<Shape> getShapes() {

		return shapes;
	}

}
