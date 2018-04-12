package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.*;
import Main.AffichageHTML;
import Main.CreateWindow;
import Main.ValeurCorrelation;
import Calcul.*;

public class IntervalConfianceListener implements ActionListener {

  JPanel panel;
  CreateWindow frame;
  CSVReader csvReader;
  IMethodeMath IntervalConfiance;
  AffichageHTML html;

  public IntervalConfianceListener(CreateWindow frame) {
    this.frame = frame;
    csvReader = new CSVReader();
    IntervalConfiance = new IntervalConfiance();
    html = new AffichageHTML();
  }

  // Creation du panel d'affichage de la correlation
  @Override
  public void actionPerformed(ActionEvent e) {
    panel = new JPanel();

    List<String> data;

    AffichageHTML html = new AffichageHTML();
    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(2);

    try {
      data = csvReader.read(frame);
      if (csvReader.getRowCount() != 2) {
        throw new Exception("Fichier CSV Invalide");
      }

      IntervalConfiance.calculer(data, 0.0);
      JLabel labelInterval = new JLabel("");
      
      
      labelInterval.setText(html.afficherInterval(IntervalConfiance.getString()));
     


      panel.add(labelInterval);
      frame.setPanel(panel);

    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }


  }
}
