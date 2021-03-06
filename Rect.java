class Rect {
    int x;
    int y;
    int width;
    int height;
    Rect(int x, int y, int width, int height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
    }

    void moveX(int dx) {
	x += dx;
    }

    void moveY(int dy) {
	y += dy;
    }

    int getX() {
	return x;
    }

    int getY() {
	return y;
    }

    int getWidth() {
	return width;
    }

    int getHeight() {
	return height;
    }

    void setX(int x) {
	this.x = x;
    }

    void setY(int y) {
	this.y = y;
    }

    void setWidth(int width) {
	this.width = width;
    }

    void setHeight(int height) {
	this.height = height;
    }
}
