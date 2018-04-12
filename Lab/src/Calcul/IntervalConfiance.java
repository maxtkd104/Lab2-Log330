package Calcul;

import java.util.List;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class IntervalConfiance implements IMethodeMath {

  List<String> dataX;
  List<String> dataY;
  String interval90;
  String interval70;
  double upperValue90 = 0.0;
  double lowerValue90 = 0.0;
  double upperValue70 = 0.0;
  double lowerValue70 = 0.0;
  
  int n = 0;
  
  final int LOC = 900;
  double LOCPredit = 0.0;
  final double student90 = 1.86;
  final double student70 = 1.108;

  @Override
  public void calculer(List<String> listDonner, double inputValue) {

    dataX = new ArrayList<String>();
    dataY = new ArrayList<String>();

    try {
      n = Integer.parseInt(listDonner.get(0).replaceAll(";", "")); // Nombre de chiffres
      double sumX = 0.0; // Somme des X
      double sumY = 0.0; // Somme des Y
      double sumXY = 0.0; // Somme des X * Y
      double sumXX = 0.0; // Somme des X * X
      double sumSquareY = 0.0; // Somme des carres Y
      double sumSquareX = 0.0; // Somme des carres X

      double moyX = 0.0; // Moyenne des X
      double moyY = 0.0; // Moyenne des Y

      double variance = 0.0; // Variance
      double ecart = 0.0; // Ecart-type
      double racine = 0.0;
      
      double LOCpredit = 0.0;

      double b0 = 0.0; // B0
      double b1 = 0.0; // B1

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

      // Somme X * X
      for (int i = 0; i < n; i++) {
        double x = Double.parseDouble(dataX.get(i));
        sumXX += x * x;
      }

      moyX = sumX / n;
      moyY = sumY / n;

      b1 = (sumXY - 10.0 * moyX * moyY) / ((sumXX) - (10.0 * moyX * moyX));
      b0 = moyY - (b1 * moyX);



      /*-----------Etape 2-----------*/


      // Calcuer la somme des carres
      for (int i = 0; i < n; i++) {
        double xi = Double.parseDouble(dataX.get(i));
        double yi = Double.parseDouble(dataY.get(i));

        double b1xi = b1 * xi;
        double square = (yi - b0 - b1xi) * (yi - b0 - b1xi);

        sumSquareY += square;
      }

      
      variance = (1.0/(n-1))*sumSquareY;
      ecart = sqrt(variance);

      /*-----------Etape 3-----------*/
      // Calcuer la somme des carres
      for (int i = 0; i < n; i++) {
        double xi = Double.parseDouble(dataX.get(i));

        double xixmoy = xi-moyX;
        double square = xixmoy * xixmoy;

        sumSquareX += square;
      }

      
      racine = sqrt((1+(1.0/n))+((LOC-moyX)*(LOC-moyX)/sumSquareX));      
      LOCPredit = LOC * b1 + b0;
      double marge90 = student90 * ecart * racine;
      double marge70 = student70 * ecart * racine;
      lowerValue90 = LOCPredit - marge90;
      upperValue90 = LOCPredit + marge90;
      lowerValue70 = LOCPredit - marge70;
      upperValue70 = LOCPredit + marge70;
      

    } catch (Exception ex) {
      interval90 = "[0;0]";
      interval70 = "[0;0]";

    }

    DecimalFormat df = new DecimalFormat();
    DecimalFormatSymbols symbols = df.getDecimalFormatSymbols();
    symbols.setGroupingSeparator(' ');
    df.setDecimalFormatSymbols(symbols);
    df.setMaximumFractionDigits(2);
    interval90 = "[" + df.format(lowerValue90) + " ; " + df.format(upperValue90) + "]";
    interval70 = "[" + df.format(lowerValue70) + " ; " + df.format(upperValue70) + "]";
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

    return interval70 + "-" + interval90;
  }


  @Override
  public double getValue() {
    return 0.0;
  }

}
