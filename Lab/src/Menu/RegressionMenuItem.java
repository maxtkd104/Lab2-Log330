package Menu;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import Listener.RegressionListener;
import Listener.VarianceListener;
import Main.CreateWindow;

public class RegressionMenuItem extends JMenuItem {

  public RegressionMenuItem(CreateWindow frame) {
    setText("TP4 - Caculer la regression");
    addActionListener(new RegressionListener(frame));

  }

}
