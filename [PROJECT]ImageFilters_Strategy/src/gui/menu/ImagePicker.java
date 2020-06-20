package gui.menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePicker extends JFileChooser {
    private static String[] imageExtensions = new String[] { "png", "jpg" };

    private static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }

        return name.substring(lastIndexOf + 1);
    }

    private static boolean isFileExtCorrect(File file) {
        String fileExt = getFileExtension(file);
        for (String ext : imageExtensions) {
            if (fileExt.equals(ext)) return true;
        }

        return false;
    }

    private BufferedImage getBufferedImgFromFile(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            System.err.println(e);
        }

        return null;
    }

    public BufferedImage pickImage() {
        int returnVal = showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = getSelectedFile();

            if (isFileExtCorrect(file)) {
                return getBufferedImgFromFile(file);
            } else {
                JOptionPane.showMessageDialog(null, "Unsupported file extension", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return null;
    }


    public void saveImage(BufferedImage img) {
        if (img == null) return;

        int returnVal = showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = getSelectedFile();
            // sciezka do pliku
            String path = file.getAbsolutePath();
            if (path != null) {
                try {
                    File output_file = new File(path);
                    ImageIO.write(img, getFileExtension(output_file), output_file);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "An error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
