package Tools;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ResourceLoader {
	public BufferedImage getImage(String path) throws IOException {
         return ImageIO.read(getClass().getResourceAsStream(path));
	}
	public static String getSoundFile(String path) {
	     return path;
	}
}
