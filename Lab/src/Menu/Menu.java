package Menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import Main.CreateWindow;

public class Menu extends JMenu {

  public Menu(CreateWindow frame) {
    setText("Menu");
    VarianceMenuItem menuVar = new VarianceMenuItem(frame);
    CorrelationMenuItem menuCor = new CorrelationMenuItem(frame);
    RegressionMenuItem menuReg = new RegressionMenuItem(frame);

    add(menuVar);
    add(menuCor);
    add(menuReg);
  }
}
