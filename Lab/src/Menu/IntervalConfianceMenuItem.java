package Menu;

import javax.swing.JMenuItem;
import Listener.CorrelationEffortNoteListener;
import Listener.IntervalConfianceListener;
import Main.CreateWindow;

public class IntervalConfianceMenuItem extends JMenuItem {

  public IntervalConfianceMenuItem(CreateWindow frame) {
    setText("TP6 - Interval de Confiance");
    addActionListener(new IntervalConfianceListener(frame));
  }
}
