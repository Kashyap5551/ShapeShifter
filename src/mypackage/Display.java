package mypackage;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Display extends JPanel {

	private List<Shape> shapes = new ArrayList<Shape>();

	public Display() {
	//	setLayout(null);
		
		
		JButton button = new JButton("Load shapes");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShapeFactory newShapes = new ShapeFactory();
				shapes = newShapes.getShapes();
				revalidate();
				repaint();
			}
		});
		add(button);
		
		JButton button2 = new JButton("Sort shapes");

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Shape> newShapes = new ArrayList<Shape>();
			    newShapes = SortingTechnique.sortShapes(shapes);
			    shapes = newShapes;
			    revalidate();
				repaint();	
			}
		});
		add(button2);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Shape shape : shapes) {
			shape.draw(g);
		}
	}
}
