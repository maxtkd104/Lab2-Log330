package Menu;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import Listener.VarianceListener;
import Main.CreateWindow;

public class VarianceMenuItem extends JMenuItem {

  public VarianceMenuItem(CreateWindow frame) {
    setText("TP1 - Caculer la variance");
    addActionListener(new VarianceListener(frame));
  }

}
