package Menu;

import javax.swing.JMenuItem;
import Listener.CorrelationEffortNoteListener;
import Main.CreateWindow;

public class CorrelationEffortNoteMenuItem extends JMenuItem {

  public CorrelationEffortNoteMenuItem(CreateWindow frame) {
    setText("TP5 - Correlation: Effort vs Note");
    addActionListener(new CorrelationEffortNoteListener(frame));
  }
}
