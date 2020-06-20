package filters;

import java.awt.image.BufferedImage;

public class BlueYellowFilter implements ImageFilterStrategy {
    @Override
    public void applyFilter(BufferedImage img) {
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                Color p = new Color(img.getRGB(x, y));
                p.r = 255 - p.g;
                p.g = 255 - p.b;
                p.b = 255 - p.r;
                img.setRGB(x, y, p.toARGB());
            }
        }
    }
}
