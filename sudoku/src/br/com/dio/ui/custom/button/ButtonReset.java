package ui.custom.button;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonReset extends JButton {
  public ButtonReset(final ActionListener actionListener){
    this.setText("Resetar");
    this.addActionListener(actionListener);
  }
}
