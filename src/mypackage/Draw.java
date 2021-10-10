package mypackage;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw extends JPanel {

	public static void main(String s[]) {

		JFrame frame = new JFrame("Display shapes");

		frame.setSize(600, 600);

		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new Display());

		frame.setVisible(true);
	}
}
