package Main;

import java.util.List;
import javax.swing.*;
import Calcul.*;
import Menu.MenuBar;

public class CreateWindow extends JFrame {

  private List<String> data;
  private IMethodeMath Correlation;
  private Regression Regression;
  private JPanel currentPanel;
  public int i = 0;

  public CreateWindow() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 600);
    setJMenuBar(new MenuBar(this));
  }

  public void setPanel(JPanel panel) {

    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

    if (currentPanel != null)
      getContentPane().remove(currentPanel);
    getContentPane().add(panel);
    currentPanel = panel;

    setVisible(true);
  }
}
