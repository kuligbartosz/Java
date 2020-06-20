package filters;

import java.awt.image.BufferedImage;

public class BorderFilter implements ImageFilterStrategy {
    private int size;
    private Color color;

    public BorderFilter(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public void applyFilter(BufferedImage img) {
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                if (x < size || y < size || y > img.getHeight() - size || x > img.getWidth() - size) {
                    img.setRGB(x, y, color.toARGB());
                }
            }
        }
    }
}
