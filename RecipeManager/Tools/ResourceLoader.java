package Tools;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ResourceLoader {
	private BufferedImage image;
	
	public BufferedImage getImage(String path) {
         try {
        	 image = ImageIO.read(getClass().getResourceAsStream(path));
    	} catch (IOException e) {
			e.printStackTrace();
		}
        return image;
	}
	public static String getSoundFile(String path) {
	     return path;
	}
}
