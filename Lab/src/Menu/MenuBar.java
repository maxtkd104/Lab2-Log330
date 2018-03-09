package Menu;

import javax.swing.*;
import Main.CreateWindow;

public class MenuBar extends JMenuBar {

  public MenuBar(CreateWindow frame) {
    this.add(new Menu(frame));
  }

}
