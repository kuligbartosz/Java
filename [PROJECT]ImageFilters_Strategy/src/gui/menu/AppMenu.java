package gui.menu;

import filters.*;
import gui.actions.ImageSelectedListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class AppMenu extends JMenuBar {
    private ImageSelectedListener imgSelectedListener;
    private ImageFilter imageFilter = new ImageFilter();

    public AppMenu(ImageSelectedListener listener) {
        imgSelectedListener = listener;
        initUI();
    }

    private void initUI() {
        ImagePicker imgPicker = new ImagePicker();

        JMenu fileMenu = new JMenu("File");

        JMenuItem openFile = new JMenuItem("Open");
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BufferedImage img = imgPicker.pickImage();
                if (img != null) {
                    imageFilter.setImage(img);
                    imgSelectedListener.onImageSelected(img);
                }
            }
        });
        fileMenu.add(openFile);

        JMenuItem saveFile = new JMenuItem("Save");
        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                imgPicker.saveImage(imageFilter.getFilteredImage());
            }
        });

        fileMenu.add(saveFile);
        add(fileMenu);

        JMenu filtersMenu = new JMenu("Filters");

        JMenuItem originalFilter = new JMenuItem("Original");
        originalFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                imgSelectedListener.onImageSelected(imageFilter.getOriginalImage());
            }
        });

        filtersMenu.add(originalFilter);

        JMenuItem invertFilter = new JMenuItem("Invert");
        invertFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                imageFilter.setFilter(new InvertFilter());
                applyFilter();
            }
        });

        filtersMenu.add(invertFilter);

        JMenuItem grayscaleFilter = new JMenuItem("Grayscale");
        grayscaleFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                imageFilter.setFilter(new GrayscaleFilter());
                applyFilter();
            }
        });

        filtersMenu.add(grayscaleFilter);

        JMenuItem blueYellowFilter = new JMenuItem("BlueYellowFilter");
        blueYellowFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                imageFilter.setFilter(new BlueYellowFilter());
                applyFilter();
            }
        });

        filtersMenu.add(grayscaleFilter);

        JMenuItem LSDFilter = new JMenuItem("LSDFilter");
        LSDFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                imageFilter.setFilter(new LSDFilter());
                applyFilter();
            }
        });

        filtersMenu.add(LSDFilter);

        JMenuItem borderFilter = new JMenuItem("Border");
        borderFilter.addActionListener((e) -> {
            BufferedImage img = imageFilter.getOriginalImage();
            int maxSize = Math.min(img.getWidth(), img.getHeight()) / 2;
            EnterNumDialog.show("Border size (0 - " + maxSize + ")", maxSize, (val) -> {
                imageFilter.setFilter(new BorderFilter(val, new Color(255, 0, 0, 0)));
                applyFilter();
            });
        });

        filtersMenu.add(borderFilter);

        add(filtersMenu);
    }

    private void applyFilter() {
        try {
            imgSelectedListener.onImageSelected(imageFilter.applyFilter());
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
