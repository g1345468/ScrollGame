import javax.swing.JFrame;

class App extends JFrame implements Common {

    Game game;
    TopMenu menu;
    
    public static final int BAR = 22;
    
    public static void main(String[] args) {
	new App().run();
    }

    App() {
	this.getContentPane().setLayout(null);
	this.setSize(Common.WIDTH, Common.HEIGHT + BAR);
	this.setResizable(false);
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
    }

    void run() {
	menu = new TopMenu(this);
	this.add(menu);
	repaint();
    }

    void startGame(String courseName) {
	this.remove(menu);
	game = new Game(this, courseName);
	this.add(game);
	new Thread(game).start();
	repaint();
    }

    void transMenu() {
	this.remove(game);
	this.add(menu);
	repaint();
    }
}
