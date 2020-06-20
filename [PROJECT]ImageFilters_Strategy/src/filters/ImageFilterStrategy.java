package filters;

import java.awt.image.BufferedImage;

public interface ImageFilterStrategy {
    void applyFilter(BufferedImage img);
}
