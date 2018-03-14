package Calcul;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Regression {

  List<String> dataX;
  List<String> dataY;
  String pente;
  String constante;
  int n;

  public void calculer(List<String> listDonner) {

    dataX = new ArrayList<String>();
    dataY = new ArrayList<String>();
    pente = "0.0";
    constante = "0.0";
    n = 0;

    IMethodeMath Moyenne = new Moyenne();

    try {
      n = Integer.parseInt(listDonner.get(0).replaceAll(";", "")); // Nombre de chiffres
      double sumXX = 0.0; // Somme des Xi^2
      double moyX = 0.0; // moyenne des X
      double moyY = 0.0; // moyenne des Y
      double sumXY = 0.0; // Somme des xi * yi
      double upperb1 = 0.0; // Partie superieur de la division pour b1
      double lowerb1 = 0.0; // Partie inferieur de la division pour b1

      // Assigne le nombre d'element a chaque liste dans l entete
      dataX.add(String.valueOf(n));
      dataY.add(String.valueOf(n));

      // Remplir les tableaux X et Y
      for (int i = 1; i <= n; i++) {
        String[] split = listDonner.get(i).split(";");

        dataX.add(split[0].replaceAll(";", ""));// Valeur X

        dataY.add(split[1].replaceAll(";", ""));// Valeur Y
      }

      // Moyenne X
      Moyenne.calculer(dataX, 0);
      moyX = Moyenne.getValue();

      // Moyenne Y
      Moyenne.calculer(dataY, 0);
      moyY = Moyenne.getValue();

      // Calcuer la somme des x carre
      for (int i = 1; i <= n; i++) {
        double x = Double.parseDouble(dataX.get(i));
        sumXX += x * x;
      }

      // Calcuer la partie superieur de b1
      for (int i = 1; i <= n; i++) {
        double x = Double.parseDouble(dataX.get(i));
        double y = Double.parseDouble(dataY.get(i));
        sumXY += x * y;
      }

      upperb1 = sumXY - n * moyX * moyY;

      // Calcuer la partie inferieur de b1
      lowerb1 += sumXX - n * moyX * moyX;

      double penteValue = upperb1 / lowerb1;
      double constanteValue = moyY - penteValue * moyX;

      pente = String.valueOf(penteValue);
      constante = String.valueOf(constanteValue);

      DecimalFormat df = new DecimalFormat();
      df.setMaximumFractionDigits(5);
      pente = df.format(penteValue).replaceAll(",", ".");
      constante = df.format(constanteValue).replaceAll(",", ".");

    } catch (Exception ex) {
      pente = "0.0";
      constante = "0.0";
    }
  }

  
  /**
   * Trouver la valeur de Y
   * @param x
   * @return
   */
  public String calculateYFromX(String x) {
    String ret = "";

    try {
      double xInteger = Double.parseDouble(x.replaceAll(",", "."));
      double penteValue = Double.parseDouble(pente);
      double constanteValue = Double.parseDouble(constante);

      DecimalFormat df = new DecimalFormat();
      df.setMaximumFractionDigits(5);
      ret = df.format(penteValue * xInteger + constanteValue).replaceAll(",", ".").replaceAll(" ","");
    } catch (Exception ex) {
      ret = "0.0";
    }

    return ret;
  }

  /**
   * Trouver la valeur de X
   * @param y
   * @return
   */
  public String calculateXFromY(String y) {
    String ret = "";

    try {
      double yInteger = Double.parseDouble(y.replaceAll(",", "."));
      double penteValue = Double.parseDouble(pente);
      double constanteValue = Double.parseDouble(constante);

      DecimalFormat df = new DecimalFormat();
      df.setMaximumFractionDigits(5);
      ret = df.format((yInteger - constanteValue) / penteValue).replaceAll(",", ".");
    } catch (Exception ex) {
      ret = "0.0";
    }

    return ret;
  }

  /**
   * 
   * @return B1
   */
  public String getPente() {
    return pente;
  }

  /**
   * 
   * @return B2
   */
  public String getConstante() {
    return constante;
  }

}
