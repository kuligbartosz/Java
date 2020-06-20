package gui.menu;

import gui.actions.NumberEnteredListener;

import javax.swing.*;

public class EnterNumDialog {
    public static void show(String fieldTitle, int max, NumberEnteredListener listener) {
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, max, 1);
        JSpinner spinner = new JSpinner(model);

        int res = JOptionPane.showConfirmDialog(null, spinner, fieldTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == JOptionPane.OK_OPTION) {
            listener.onNumberEntered(model.getNumber().intValue());
        } else {
            System.out.println("not ok");
        }
    }
}
