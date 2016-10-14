import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.util.Set;
import java.util.HashSet;

class Player extends Chara implements Common, KeyListener {
    Game game;
    Course course;
    int vx, vy;
 
    boolean onGround = true;
    boolean isReleasedJumpButton = true;
    int runDistance = 0;
    
    BKey[] keys = new BKey[4];
 
    public static final int DEFAULT_VX = 6;
    public static final int DEFAULT_VY = 15;
    public static final int MAX_VY = DEFAULT_VY * 5 / 4;
    
    Player(Game game, int imageNo) {
	super(new Rect(MASS_SIZE, 100, MASS_SIZE / 3 , MASS_SIZE -  20), imageNo);
	this.game = game;
	
	for(int i = 0; i < 4; i++) {
	    keys[i] = new BKey(i);
	}
    }

    void draw(Graphics g) {	
	
	g.drawImage(image,
		    WIDTH / 2 - rect.getHeight() / 2,
		    HEIGHT - rect.getHeight() - rect.getY(),
		    WIDTH / 2 + rect.getHeight() / 2,
		    HEIGHT - rect.getY(),
		    (imageNo % 8) * (CS * 2),
		    (imageNo / 8) * (CS * 4) + direction * CS,
		    (imageNo % 8) * (CS * 2) + CS,
		    (imageNo / 8) * (CS * 4) + direction * CS + CS,
		    null);
    }

    void update() {
	updateX();
	updateY();
    }

    private void updateX() {
	
	if(keys[LEFT].isPressed()) {
	    if(direction == LEFT) {
		vx = -DEFAULT_VX;
	    } else {
		direction = LEFT;
	    }
	} else if(keys[RIGHT].isPressed()) {
	    if(direction == RIGHT) {
		vx = DEFAULT_VX;
	    } else {
		direction = RIGHT;
	    }
	} else {
	    vx = 0;
	    runDistance = 0;
	}

	Set<Sprite> hitSprites = course.getHitSprites(new Rect(rect.getX() + vx, rect.getY(), rect.getWidth(), rect.getHeight()));


	if(hitSprites.size() == 0) {
	    moveX(vx);
	} else {
	    for(Sprite hitSprite : hitSprites) {
		if(hitSprite instanceof Mass) {
		    Mass hitMass = (Mass)hitSprite;
		    if(hitMass.getKind() == 'G') {
			game.gameClear();
		    }
		}
		if(hitSprite.isHit()) {
		    Rect hitRect = hitSprite.getRect();
		    if(vx > 0) {
			moveX(hitRect.getX() - (rect.getX() + rect.getWidth()));
		    } else if(vx < 0) {  
			moveX((hitRect.getX() + hitRect.getWidth()) - rect.getX());
		    }
		    runDistance = 0;
		} else {
		    moveX(vx);
		}
	    }
	}
    
	if(rect.getX() < 0) {
	    rect.setX(0);
	}
    }

    private void moveX(int dx) {
	rect.moveX(dx);
	runDistance += Math.abs(dx);
    }

    private void updateY() {
	if(keys[UP].isPressed) {
	    if(onGround && isReleasedJumpButton) {
		onGround = false;
		vy = DEFAULT_VY + runDistance / MASS_SIZE;
		if(vy > MAX_VY) {
		    vy = MAX_VY;
		}
	    }
	    isReleasedJumpButton = false;
	}
	
	vy -= GRAVITY;	
	
	Set<Sprite> hitSprites = course.getHitSprites
	    (new Rect(rect.getX(), rect.getY() + vy, rect.getWidth(), rect.getHeight()));

	if(hitSprites.size() == 0) {
	    moveY(vy);
	    onGround = false;	    
	} else {
	    for(Sprite hitSprite : hitSprites) {
		if(hitSprite instanceof Mass) {
		    Mass hitMass = (Mass)hitSprite;
		    if(hitMass.getKind() == 'G') {
			game.gameClear();
		    }
		}
		if(hitSprite.isHit()) {
		    Rect hitRect = hitSprite.getRect();
		    if(vy > 0) {  // 上昇
			moveY(hitRect.getY() - (rect.getY() + rect.getHeight()));
		    } else if(vy < 0) {  // 下降
			moveY((hitRect.getY() + hitRect.getHeight()) - rect.getY());
			onGround = true;
		    }
		    vy = 0;
		} else {
		    moveY(vy);
		}
	    }
	}

	if(rect.getY() < -MASS_SIZE / 2) {
	    game.gameOver();
	}

    }

    private void moveY(int dy) {
	rect.moveY(dy);
    }

    void setCourse(Course course) {
	this.course = course;
    }

    public void keyPressed(KeyEvent event) {
	int code = event.getKeyCode();
	if(code >= 37 && code <= 40) {
	    keys[Util.convertKeyToDir(code)].pressed();
	}
    }
    
    public void keyReleased(KeyEvent event) {
	int code = event.getKeyCode();
	if(code >= 37 && code <= 40) {
	    keys[Util.convertKeyToDir(code)].released();
	}
	
	if(code == KeyEvent.VK_UP) {
	    isReleasedJumpButton = true;
	}
    }
    
    public void keyTyped(KeyEvent e) {
    }

    
}
