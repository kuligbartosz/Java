package filters;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

// Helper class / set filter on image
public class ImageFilter {
    private BufferedImage originalImage;
    private BufferedImage filteredImage;
    private ImageFilterStrategy filter;

    public void setFilter(ImageFilterStrategy filter) {
        this.filter = filter;
    }

    public void setImage(BufferedImage img) {
        originalImage = img;
        filteredImage = img;
    }

    public BufferedImage applyFilter() throws Exception {
        if (originalImage == null) throw new Exception("You must choose an image before applying the filter");
        if (filter == null) throw new Exception("You must set filtering strategy before applying filter");

        filteredImage = cloneImage(originalImage);
        filter.applyFilter(filteredImage);
        return filteredImage;
    }

    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public BufferedImage getFilteredImage() {
        return filteredImage;
    }

    private static BufferedImage cloneImage(BufferedImage img) {
        ColorModel cm = img.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = img.copyData(img.getRaster().createCompatibleWritableRaster());
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

}
