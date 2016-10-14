class BKey implements Common {
    static int pressedKey = NO;
    int kind;
    boolean isPressed = false;

    BKey(int kind) {
	this.kind = kind;
    }

    void pressed() {
	this.isPressed = true;
	pressedKey = kind;
    }

    void released() {
	this.isPressed = false;
	if(pressedKey == kind) {
	    pressedKey = NO;
	}
    }

    boolean isPressed() {
	return isPressed;
    }

    int getKind() {
	return kind;
    }
}
