import java.awt.Graphics;

class Sprite {
    Rect rect;
    int vx;
    int vy;
    boolean isHit;

    Sprite(Rect rect, boolean isHit) {
	this.rect = rect;
	this.isHit = isHit;
    }

    Sprite(Rect rect) {
	this.rect = rect;
    }

    
    boolean isHit() {
	return isHit;
    }

    void draw(Graphics g) {
	//please override
    } 
  
    Rect getRect() {
	return rect;
    }
}
