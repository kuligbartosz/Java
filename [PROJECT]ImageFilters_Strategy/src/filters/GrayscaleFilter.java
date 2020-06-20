package filters;

import java.awt.image.BufferedImage;

public class GrayscaleFilter implements ImageFilterStrategy {
    @Override
    public void applyFilter(BufferedImage img) {
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color p = new Color(img.getRGB(x, y));
                int average = (p.r + p.g + p.b) / 3;
                p.r = p.g = p.b = average;
                img.setRGB(x, y, p.toARGB());
            }
        }
    }
}
