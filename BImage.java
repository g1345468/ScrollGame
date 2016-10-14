import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.swing.ImageIcon;

public class BImage {

    public static Image getImage(String path) {
	try {
	    BufferedImage bufferedImage = ImageIO.read(new File(path));
	    int x = bufferedImage.getWidth();
	    int y = bufferedImage.getHeight();
	    return reduce(bufferedImage, x, y);
	} catch(IOException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public static Image getImage(String path, int width, int height) {
	try {
	    return reduce
		(ImageIO.read(new File(path)), width, height);
	} catch(IOException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public static Image getGif(String path) {
	try {
	    return  new ImageIcon(path).getImage();
	} catch(Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    static Image reduce(BufferedImage image, int width, int height) {
	return image.getScaledInstance
	    (width, height, Image.SCALE_AREA_AVERAGING);
    }

    
}
