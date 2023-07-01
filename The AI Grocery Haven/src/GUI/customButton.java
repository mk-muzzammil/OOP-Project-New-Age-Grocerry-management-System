package GUI;

import javax.swing.*;
import java.awt.*;

public class customButton extends JButton {
    public customButton(String buttonName) {
        super(buttonName);
        this.setFocusable(false);
        this.setFont(new Font("Times New Roman", Font.BOLD, 16));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }
}