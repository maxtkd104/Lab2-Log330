package Calcul;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CorrelationEffortNote implements IMethodeMath {

  final private int startLineIndex = 2;
  final private int startColIndex = 1;
  List<String> dataX1;
  List<String> dataX2;
  List<String> dataX3;
  List<String> dataX4;
  List<String> dataX5;
  List<String> dataX6;
  List<String> dataY;
  String correlation;
  String[] listReturn;
  double correlationValue;
  int nLine = 0;
  int nCol = 6;
  List<String> listDonner;

  @Override
  public void calculer(List<String> listDonner, double inputValue) {

    dataX1 = new ArrayList<String>();
    dataX2 = new ArrayList<String>();
    dataX3 = new ArrayList<String>();
    dataX4 = new ArrayList<String>();
    dataX5 = new ArrayList<String>();
    dataX6 = new ArrayList<String>();
    dataY = new ArrayList<String>();
    this.listDonner = listDonner;
    listReturn = new String[nCol];
    nLine = listDonner.size() - startLineIndex; // Nombre de ligne

    try {
      listReturn[0] = calculationLoop(dataX1, 1);
      listReturn[1] = calculationLoop(dataX2, 2);
      listReturn[2] = calculationLoop(dataX3, 3);
      listReturn[3] = calculationLoop(dataX4, 4);
      listReturn[4] = calculationLoop(dataX5, 5);
      listReturn[5] = calculationLoop(dataX6, 6);
    } catch (Exception ex) {
      System.out.println(ex);
    }
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

  private String calculationLoop(List<String> list, int colIndex) {
    double sumX = 0.0; // Somme des X
    double sumY = 0.0; // Somme des Y
    double sumXY = 0.0; // Somme des X et Y
    double sumSquareX = 0.0; // Somme des carres de X
    double sumSquareY = 0.0; // Somme des carres de Y
    String retour = "0.0";

    try {
      // Remplir les tableaux X et Y
      for (int i = startLineIndex; i <= nLine + 1; i++) {
        String[] split = listDonner.get(i).split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        list.add(split[colIndex].replaceAll(";", "").replaceAll("\"", "").replaceAll(",", "."));// Valeur
                                                                                                // X

        dataY.add(split[7].replaceAll(";", "").replaceAll(",", ".").replaceAll("\"", ""));// Valeur
                                                                                          // Y

      }

      // Calcuer la somme des X
      for (int x = 0; x < nLine; x++) {
        sumX += Double.parseDouble(list.get(x));
      }

      // Calcuer la somme des Y
      for (int y = 0; y < nLine; y++) {
        sumY += Double.parseDouble(dataY.get(y));
      }

      // Somme X * Y
      for (int i = 0; i < nLine; i++) {
        double x = Double.parseDouble(list.get(i));
        double y = Double.parseDouble(dataY.get(i));
        sumXY += x * y;
      }

      // Calcuer la somme des carres de X
      for (int x = 0; x < nLine; x++) {
        double value = Double.parseDouble(list.get(x));
        sumSquareX += value * value;
      }

      // Calcuer la somme des carres de Y
      for (int y = 0; y < nLine; y++) {
        double value = Double.parseDouble(dataY.get(y));
        sumSquareY += value * value;
      }



      // Calcul de la correlation
      double upper = (nLine * sumXY) - (sumX * sumY);
      double lower =
          sqrt((nLine * sumSquareX - (sumX * sumX)) * (nLine * sumSquareY - (sumY * sumY)));

      correlationValue = upper / lower;
      DecimalFormat df = new DecimalFormat();
      df.setMaximumFractionDigits(5);
      retour = df.format(correlationValue);
    } catch (Exception ex) {
      retour = "0.0";
    }
    return retour;
  }


  @Override
  public String getString() {
    String ret = "";

    for (int i = 0; i < nCol; i++) {
      ret += listReturn[i] + ";";
    }

    return ret.replaceAll(",", ".");
  }


  @Override
  public double getValue() {
    return correlationValue;
  }

}
