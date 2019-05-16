package javaHomeWork;
import javax.swing.*;
import java.awt.*;

public class HomeWork_3 extends JFrame{
	
	void run() {
		Container c = getContentPane();
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.add(new Northpanel(), BorderLayout.NORTH);
		c.add(new Southpanel(), BorderLayout.SOUTH);
		c.add(new Centerpanel(), BorderLayout.CENTER);
		setSize(300,250);
		setVisible(true);
	}
	
	class Northpanel extends JPanel {
		public Northpanel() {
			setOpaque(true);
			setBackground(Color.gray);
			setLayout(new FlowLayout());
			add(new JLabel("수식입력"));
			add(new JTextField("\t\t"));
		}
	}
	
	class Southpanel extends JPanel {
		public Southpanel() {
			setOpaque(true);
			setBackground(Color.yellow);
			setLayout(new FlowLayout());
			add(new JLabel("계산결과"));
			add(new JTextField("\t\t"));
		}
	}

	class Centerpanel extends JPanel {
		public Centerpanel() {
			JButton[] j = {new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/")};
			setLayout(new GridLayout(4,4,2,2));
			
			for(int i=0;i<10;i++) {
				String temp = Integer.toString(i);
				add(new JButton(temp));
			}
			add(new JButton("CE"));
			add(new JButton("계산"));
	
			for(int i=0;i<4;i++) {
			j[i].setBackground(Color.cyan);
			add(j[i]);
			}
		}
	}
	public static void main(String[] args) {
		HomeWork_3 h3 = new HomeWork_3();
		h3.run();
	}
}
