package gui.menu;

import gui.actions.ImageSelectedListener;
import gui.menu.AppMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class App extends JFrame {
    private ImageIcon imageIcon = new ImageIcon();
    public App() {
        initUI();
    }

    private void initUI() {
        // Window config
        setTitle("Image filters");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Bar
        AppMenu appMenu = new AppMenu(new ImageSelectedListener(){
            @Override
            public void onImageSelected(BufferedImage image){
                imageIcon.setImage(image);
                validate();
                repaint();
            }
        });

        setJMenuBar(appMenu);

        // Image
        getContentPane().add(BorderLayout.CENTER, new JLabel(imageIcon));

        setVisible(true);
    }

}
