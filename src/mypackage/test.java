package mypackage;

import javax.swing.*;  
import java.awt.*;

public class test {  
    public static void main(String s[]) {  
        JFrame frame = new JFrame("Display shapes");  
        
        JPanel panel = new JPanel();  
        
        panel.setLayout(new FlowLayout());  
        
        JButton button = new JButton();  
        
        JButton button2 = new JButton(); 
        
        button.setText("Load shapes");  
        
        button2.setText("Sort shapes");  
        
        panel.add(button);  
        
        panel.add(button2); 
        
        frame.add(panel);  
        
        frame.setSize(600, 600);  
        
        frame.setLocationRelativeTo(null); 
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        frame.setVisible(true);  
    }  
}
