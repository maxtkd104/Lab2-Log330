package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.*;
import Main.AffichageHTML;
import Main.CreateWindow;
import Calcul.*;

public class VarianceListener implements ActionListener {

  JPanel panel;
  CreateWindow frame;
  CSVReader csvReader;
  IMethodeMath Moyenne;
  IMethodeMath Variance;
  IMethodeMath EcartType;
  AffichageHTML html;

  public VarianceListener(CreateWindow frame) {
    this.frame = frame;
    csvReader = new CSVReader();
    Moyenne = new Moyenne();
    Variance = new Variance();
    EcartType = new EcartType();
    html = new AffichageHTML();
  }

  // Creation du panel d'affichage de la variance
  @Override
  public void actionPerformed(ActionEvent e) {
    panel = new JPanel();

    List<String> data;

    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(5);

    try {
      data = csvReader.read(frame);


      if (csvReader.getRowCount() != 1) {
        throw new Exception("Fichier CSV Invalide");
      }

      JLabel labelMoyenne = new JLabel("");
      JLabel labelVariance = new JLabel("");
      JLabel labelEcartType = new JLabel("");
      JLabel labelDataList = new JLabel("");

      Moyenne.calculer(data, 0.0);
      Variance.calculer(data, Moyenne.getValue());
      EcartType.calculer(data, Variance.getValue());

      labelMoyenne.setText("Moyenne: " + Moyenne.getString());
      labelVariance.setText("Variance: " + Variance.getString());
      labelEcartType.setText("Ecart-Type: " + EcartType.getString());

      labelDataList.setText(html.afficher(data, csvReader.getRowCount()));

      panel.add(labelMoyenne);
      panel.add(labelVariance);
      panel.add(labelEcartType);
      panel.add(labelDataList);
      frame.setPanel(panel);

    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }

  }

}
