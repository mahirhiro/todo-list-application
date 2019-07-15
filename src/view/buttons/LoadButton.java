package view.buttons;

import controller.LoadAction;
import controller.SaveAction;
import model.App;
import view.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class LoadButton extends JMenuItem {

    private void setButtonProperties(){
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        setToolTipText("Save");
        setIconTextGap (-10);
        setPreferredSize(new Dimension(100,30));
    }

    public LoadButton(App application, AppPanel panel) {
        super(new LoadAction(application,panel));
        setButtonProperties();

    }
}
