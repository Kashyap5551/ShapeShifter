package mypackage;

import javax.swing.*;  
import java.awt.*;  
public class test2 extends JFrame {  
  public test2() {  
    super("LayeredPane Example");  
    setSize(200, 200);  
    JLayeredPane pane = getLayeredPane();  
    //creating buttons  
    JButton top = new JButton();  
    top.setBackground(Color.white);  
    top.setBounds(20, 20, 50, 50);  
    JButton middle = new JButton();  
    middle.setBackground(Color.red);  
    middle.setBounds(70, 70, 50, 50);  
    JButton bottom = new JButton();  
    bottom.setBackground(Color.cyan);  
    bottom.setBounds(120, 120, 50, 50);  
    //adding buttons on pane  
    pane.add(bottom, new Integer(1));  
    pane.add(middle, new Integer(2));  
    pane.add(top, new Integer(3));  
  }  
  public static void main(String[] args) {  
      test2 panel = new  test2();  
      panel.setVisible(true);  
  }  
}  
