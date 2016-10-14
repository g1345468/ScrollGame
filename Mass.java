import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;

class Mass extends Sprite implements Common {
    static Image image;
    int imageNo;
    boolean isCrash;
    char kind;
  
    Mass(Rect rect, char kind) {
	super(rect);
	this.kind = kind;
	if(image == null) {
	    image = BImage.getImage(PATH + "img/mass.gif");
	}
	convert();
    }
    void draw(Graphics g, int initX, int initY) {
	g.drawImage(image,
		    rect.getX() + initX,
		    HEIGHT - rect.getY() - rect.getHeight() + initY,
		    rect.getX() + initX + MASS_SIZE,
		    HEIGHT - rect.getY() - rect.getHeight() + initY + MASS_SIZE,
		    (imageNo % 16) * CS,
		    (imageNo / 16) * CS,
		    (imageNo % 16) * CS + CS,
		    (imageNo / 16) * CS + CS,
		    null);
    }


    boolean isCrash() {
	return isCrash;
    }

    char getKind() {
	return kind;
    }

    void convert() {
	switch(kind) {
	case '1':
	    imageNo = 100;
	    isHit = true;
	    isCrash = false;
	    break;
	case 'G':
	    imageNo = 0;
	    isHit = false;
	    isCrash = false;
	    break;
	}
    }
}
