package Calcul;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Correlation implements IMethodeMath {

  List<String> dataX;
  List<String> dataY;
  String correlation;
  double correlationValue;
  int n = 0;

  @Override
  public void calculer(List<String> listDonner, double inputValue) {

    dataX = new ArrayList<String>();
    dataY = new ArrayList<String>();

    try {
      n = Integer.parseInt(listDonner.get(0).replaceAll(";", "")); // Nombre de chiffres
      double sumX = 0.0; // Somme des X
      double sumY = 0.0; // Somme des Y
      double sumXY = 0.0; // Somme des X et Y
      double sumSquareX = 0.0; // Somme des carres de X
      double sumSquareY = 0.0; // Somme des carres de Y

      // Remplir les tableaux X et Y
      for (int i = 1; i <= n; i++) {
        String[] split = listDonner.get(i).split(";");
        dataX.add(split[0].replaceAll(";", "").replaceAll(",", "."));// Valeur X

        dataY.add(split[1].replaceAll(";", "").replaceAll(",", "."));// Valeur Y

      }

      // Calcuer la somme des X
      for (int x = 0; x < n; x++) {
        sumX += Double.parseDouble(dataX.get(x));
      }

      // Calcuer la somme des Y
      for (int y = 0; y < n; y++) {
        sumY += Double.parseDouble(dataY.get(y));
      }

      // Somme X * Y
      for (int i = 0; i < n; i++) {
        double x = Double.parseDouble(dataX.get(i));
        double y = Double.parseDouble(dataY.get(i));
        sumXY += x * y;
      }

      // Calcuer la somme des carres de X
      for (int x = 0; x < n; x++) {
        double value = Double.parseDouble(dataX.get(x));
        sumSquareX += value * value;
      }

      // Calcuer la somme des carres de Y
      for (int y = 0; y < n; y++) {
        double value = Double.parseDouble(dataY.get(y));
        sumSquareY += value * value;
      }



      // Calcul de la correlation
      double upper = (n * sumXY) - (sumX * sumY);
      double lower = sqrt((n * sumSquareX - (sumX * sumX)) * (n * sumSquareY - (sumY * sumY)));
      correlationValue = upper / lower;


    } catch (Exception ex) {
      correlationValue = 0.0;
    }

    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(5);
    correlation = df.format(correlationValue);
  }


  private double sqrt(double variance) {
    double t;

    double squareRoot = variance / 2;

    do {
      t = squareRoot;
      squareRoot = (t + (variance / t)) / 2;
    } while ((t - squareRoot) != 0);

    return squareRoot;
  }

  @Override
  public String getString() {

    return correlation;
  }


  @Override
  public double getValue() {
    return correlationValue;
  }

}
