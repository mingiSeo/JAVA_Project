package javaHomeWork;
import java.math.*;
import javax.swing.*;
import java.awt.*;
public class HomeWork_2 extends JFrame{
	void run() {
		setTitle("Random Label");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		for(int i=0;i<20;i++) {
			JLabel j = new JLabel();
			j.setSize(10, 10);
			int x = (int)(Math.random()*200)+50;
			int y = (int)(Math.random()*200)+50;
			j.setLocation(x,y);
			j.setOpaque(true);
			j.setBackground(Color.blue);
			c.add(j);
		}
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		HomeWork_2 h2 = new HomeWork_2();
		h2.run();
	}
}
