import java.awt.Graphics;

import java.util.Set;
import java.util.HashSet;

class Course implements Common {
    Set<Mass> map = new HashSet<Mass>();
    
    Course(String courseName) {

	BReader br = new BReader(PATH + "map/" + courseName + ".map");
	String str = br.readLine();
	String[] strs = str.split(" ");
	int x = Integer.parseInt(strs[0]);
	int y = Integer.parseInt(strs[1]);
	for(int j = y - 1; j >= 0; j--) {
	    str = br.readLine();
	    for(int i = 0; i < x; i++) {
		if(str.charAt(i) != '0') {
		    map.add(new Mass(new Rect(i * MASS_SIZE, j * MASS_SIZE, MASS_SIZE, MASS_SIZE),
				     str.charAt(i)));
		}
	    }
	    map.add(new Mass(new Rect(-1 * MASS_SIZE, j * MASS_SIZE, MASS_SIZE, MASS_SIZE), '1'));
	    map.add(new Mass(new Rect(x * MASS_SIZE, j * MASS_SIZE, MASS_SIZE, MASS_SIZE), '1'));
	}
    }

    void draw(Graphics g, int initX, int initY) {
	for(Mass mass : map) {
	    mass.draw(g, initX, initY);
	}
    }

    Set<Sprite> getHitSprites(Rect next) {
	Set<Sprite> hitMasses = new HashSet<Sprite>();
	for(Mass mass : map) {
	    if(Util.isOverlapX(mass.getRect(), next) && Util.isOverlapY(mass.getRect(), next)) {
		hitMasses.add(mass);
	    }
	}
	return hitMasses;
    }

   
}
