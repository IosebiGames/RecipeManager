package Tools;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ResourceLoader {
	
  BufferedImage image;
	public BufferedImage getImage(String path) throws IOException {
         return image = ImageIO.read(getClass().getResourceAsStream(path));
	}
	public String getSoundFile(String path) {
	     return path;
	}
}
