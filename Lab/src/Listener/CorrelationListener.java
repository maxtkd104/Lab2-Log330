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

public class CorrelationListener implements ActionListener {

  JPanel panel;
  CreateWindow frame;
  CSVReader csvReader;
  IMethodeMath Correlation;
  AffichageHTML html;

  public CorrelationListener(CreateWindow frame) {
    this.frame = frame;
    csvReader = new CSVReader();
    Correlation = new Correlation();
    html = new AffichageHTML();
  }

  // Creation du panel d'affichage de la correlation
  @Override
  public void actionPerformed(ActionEvent e) {
    panel = new JPanel();

    List<String> data;


    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(2);

    try {
      data = csvReader.read(frame);
      if (csvReader.getRowCount() != 2) {
        throw new Exception("Fichier CSV Invalide");
      }

      Correlation.calculer(data, 0.0);
      ValeurCorrelation valeurCorrelation = new ValeurCorrelation();
      
      double correlationValue = Correlation.getValue();
      String valeurNomimal = valeurCorrelation.getNominalValue(Correlation.getValue());

      JLabel labelCorrelation = new JLabel("");
      JLabel labelDataList = new JLabel("");

      labelCorrelation.setText("<html>Correlation R:  " + Correlation.getString()
          + "<br>Correlation R<SUP>2</SUP>: " + String.valueOf(correlationValue * correlationValue)
          + "<br>Valeur nominal du lien: " + valeurNomimal + "</html>");

      labelDataList.setText(html.afficher(data, csvReader.getRowCount()));

      panel.add(labelCorrelation);
      panel.add(labelDataList);
      frame.setPanel(panel);

    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }


  }
}
