package ui.custom.button;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ButtonFinish extends JButton {
  public ButtonFinish(final ActionListener actionListener){
    this.setText("Concluir");
    this.addActionListener(actionListener);
  }
}