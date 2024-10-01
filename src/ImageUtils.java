import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtils {
    public static Image loadImageAndScale(String imagePath, int targetWidth, int targetHeight) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
            return scaledImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
