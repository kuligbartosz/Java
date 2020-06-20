package filters;

import java.awt.image.BufferedImage;

public class LSDFilter implements ImageFilterStrategy {
    @Override
    public void applyFilter(BufferedImage img) {
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color p = new Color(img.getRGB(x, y));
                p.r = p.r * 2;
                p.g = p.g * 2;
                p.b = p.b * 2;
                img.setRGB(x, y, p.toARGB());
            }
        }
    }
}
