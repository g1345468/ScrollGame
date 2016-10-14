import java.awt.event.KeyEvent;

class Util implements Common {
    static int convertKeyToDir(int keycode) {
	switch(keycode) {
	case KeyEvent.VK_UP:
	    return UP;
	case KeyEvent.VK_RIGHT:
	    return RIGHT;
	case KeyEvent.VK_DOWN:
	    return DOWN;
	case KeyEvent.VK_LEFT:
	    return LEFT;
	}
	return NO;
    }

    static boolean isOverlapX(Rect rect1, Rect rect2) {
	if((rect1.getX() < rect2.getX() + rect2.getWidth() &&
	    rect1.getX() + rect1.getWidth() > rect2.getX())
	   ||
	   (rect1.getX() > rect2.getX() + rect2.getWidth() &&
	    rect1.getX() + rect1.getWidth() < rect2.getX()) ) {
	    return true;
	} else {
	    return false;
	}
    }

    static boolean isOverlapY(Rect rect1, Rect rect2) {
	if((rect1.getY() < rect2.getY() + rect2.getHeight() &&
	    rect1.getY() + rect1.getHeight() > rect2.getY())
	   ||
	   (rect1.getY() > rect2.getY() + rect2.getHeight() &&
	    rect1.getY() + rect1.getHeight() < rect2.getY()) ) {
	    return true;
	} else {
	    return false;
	}
    }
}
