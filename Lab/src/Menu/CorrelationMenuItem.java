package Menu;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import Listener.CorrelationListener;
import Main.CreateWindow;

public class CorrelationMenuItem extends JMenuItem {

  public CorrelationMenuItem(CreateWindow frame) {
    setText("TP3 - Caculer la correlation");
    addActionListener(new CorrelationListener(frame));
  }

}
