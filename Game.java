import java.awt.Graphics;
import java.awt.Color;

import java.awt.Image;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

class Game extends JPanel implements Common, Runnable {
    App app;
    Course course;
    Player player;
   
    boolean isGameFinished = false;

    Image gameOverImage;
    Image backImage;
  
    Game(App app, String courseName) {
	this.app = app;
	this.setBounds(0, 0, app.getWidth(), app.getHeight());
	this.setBackground(Color.WHITE);
	gameOverImage = BImage.getImage(PATH + "img/gameover.png");
	backImage = BImage.getImage(PATH + "img/nature.jpg");
	startGame(courseName);
    }
    
    public void run() {	
        while(!isGameFinished) {
	    player.update();		
	    repaint();
	    try {
		Thread.sleep(20);
	    } catch(InterruptedException e) {
		e.printStackTrace();
	    }
	}	
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(backImage, 0, 0, getWidth(), getHeight(), null);
	if(player != null && course != null) {
	    Rect playerLocate = player.getRect();
	    course.draw(g, -playerLocate.getX() + getWidth() / 2 - playerLocate.getWidth() / 2, 0);
	    player.draw(g);
	    if(isGameFinished) {
		g.drawImage(gameOverImage, 50, 80, getWidth() - 100, getHeight() - 160, null);
	    }
	}	
    }

    private void startGame(String courseName) {
	player = new Player(this, 3);
	course = new Course(courseName);
	app.addKeyListener(player);
	player.setCourse(course);
    }

    void gameClear() {
	app.transMenu();
	isGameFinished = true;
    }
    
    void gameOver() {
	app.transMenu();
	isGameFinished = true;
    }
    
}
