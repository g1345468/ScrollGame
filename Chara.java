import java.awt.Image;
import java.awt.Graphics;

class Chara extends Sprite implements Common {
    static Image image;
    int imageNo;
    int direction;
    
    Chara(Rect rect, int imageNo) {
	super(rect, true);
	this.imageNo = imageNo;
	this.direction = LEFT;
	if(image == null) {
	    image = BImage.getImage(PATH + "img/chara.gif");
	}	
    }
    
    void update() {
	updateX();
	updateY();
    }

    private void updateX() {
	
    }

    private void updateY() {
	
    }
    


}
