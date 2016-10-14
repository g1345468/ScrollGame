import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class TopMenu extends JPanel implements Common {

    App app;
    Image logo;
    
    TopMenu(App app) {
	this.app = app;
	this.setBounds(0, 0, app.getWidth(), app.getHeight());
	this.setBackground(Color.WHITE);
	logo = BImage.getImage(PATH + "img/logo.png");
	setComponent();
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	// g.drawImage(logo, 20, 30, getWidth() - 40, 80, null);
    }

    private void setComponent() {

	JButton course1 = new JButton("1-1");
	course1.setBounds(50, 150, 100, 50);
	course1.setFocusable(false);
	course1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    app.startGame("1-1");
		}
	    });
	this.add(course1);

	JButton course2 = new JButton("1-2");
	course2.setBounds(50, 230, 100, 50);
	course2.setFocusable(false);
	course2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    app.startGame("1-2");
		}
	    });
	this.add(course2);

	JButton course3 = new JButton("1-3");
	course3.setBounds(50, 310, 100, 50);
	course3.setFocusable(false);
	course3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    app.startGame("1-3");
		}
	    });
	this.add(course3);

	JButton course4 = new JButton("2-1");
	course4.setBounds(200, 150, 100, 50);
	course4.setFocusable(false);
	course4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    app.startGame("2-1");
		}
	    });
	this.add(course4);

    }
}
