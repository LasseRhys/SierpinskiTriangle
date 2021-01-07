package triangle;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class SierpinskiTriangle {
	public static int SIZE = 1000;
	private static int recX = 20;
	private static int recY = 20;

	JFrame frame;
	JPanel panel;

	@SuppressWarnings("serial")
	public void display() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				paintFrame(g, getSize());
				triangle(g, getSize());

			}
		};
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panel.repaint();
			}
		});
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setSize(SIZE, SIZE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SierpinskiTriangle triangle = new SierpinskiTriangle();
		triangle.display();
	}

	// zeichnet Rahmen
	public static void paintFrame(Graphics g, Dimension size) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.white);
		g2.clearRect(0, 0, size.width, size.height);
		g2.draw3DRect(recX, recY, size.width - recX*2, size.height - recY*2, true);
	}

	// zeichnet Dreieck
	/*public void paintSierpinskiTriangle(Graphics g, Dimension size) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.white);
		//Erstes Dreieck
		g2.drawLine(size.width/2, recY*2, size.width - recX*2, size.height - recY*2); 		//rechte Seite
		g2.drawLine(size.width/2, recY*2,  recX*2, size.height - recY*2);					//linke Seite
		g2.drawLine(recX*2, size.height - recY*2,  size.width - recX*2, size.height - recY*2);	//untere Seite

		g2.drawLine(size.width/4 + recX*2, size.height/2 - recY*2,  size.width/4*3 - recX*2, size.height/2 - recY*2);

	}*/

	public void triangle (Graphics g, Dimension size) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.white);
		int x1 = size.width/2;
		int y1 = recY*2;
		int x2 = size.width - recX*2;
		int y2 = size.height - recY*2;
		int x3 = recX*2;
		int y3 = size.height - recY*2;


		if(Math.sqrt((Math.pow(x2-x1, 2)) + (Math.pow(y2-y1, 2))) > 1) {
			//erstes Dreieck
			g2.drawLine(x1, y1, x2, y2);
			g2.drawLine(x2, y2, x3, y3);
			g2.drawLine(x3, y3, x1, y1);
		}

			//Variablen für Mittelpunkte
			int xa, ya, xb, yb, xc, yc;
			xa = (x1 + x2) / 2;
			ya = (y1 + y2) / 2;
			xb = (x1 + x3) / 2;
			yb = (y1 + y3) / 2;
			xc = (x2 + x3) / 2;
			yc = (y2 + y3) / 2;

			//Dreieck 1
			g2.drawLine(x1, y1, xa, ya);
			g2.drawLine(xa, ya, xb, yb);
			g2.drawLine(xb, yb, x1, y1);

			//Dreieck 2
			g2.drawLine(xa, ya, x2, y2);
			g2.drawLine(x2, y2, xc, yc);
			g2.drawLine(xc, yc, xa, ya);

			//Dreieck 3
			g2.drawLine(xb, yb, xc, yc);
			g2.drawLine(xc, yc, x3, y3);
			g2.drawLine(x3, y3, xb, yb);

	}


}
