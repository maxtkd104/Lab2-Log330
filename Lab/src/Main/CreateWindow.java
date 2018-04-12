package Main;

import javax.swing.*;
import Menu.MenuBar;

public class CreateWindow extends JFrame {
  private static final long serialVersionUID = 4566314871851767848L;
  private JPanel currentPanel;

  public CreateWindow() {
    setTitle("LOG330 - Maxime Pelletier");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 600);
    setJMenuBar(new MenuBar(this));
    setVisible(true);
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
