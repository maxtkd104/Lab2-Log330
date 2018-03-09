package Calcul;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Cette classe permet de calculer la Variance a partir d'une liste
 * 
 * Elle utilise la variable input afin de recevoir la moyenne precedement calculer
 * 
 */
public class Variance implements IMethodeMath {

  private String Variance;
  private double VarianceValue;

  @Override
  public void calculer(List<String> listDonner, double inputValue) {
    double Distance = 0.0;
    int arraySize = Integer.parseInt(listDonner.get(0));
    try {


      /* VARIANCE */

      for (int i = 1; i <= arraySize; i++) {
        double value = (Integer.parseInt(listDonner.get(i)) - inputValue);

        Distance += value * value;
      }
      VarianceValue = (1.0 / (arraySize - 1)) * Distance;
    } catch (Exception e) {
      VarianceValue = 0.0;
    }

    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(5);
    Variance = df.format(VarianceValue);
  }


  @Override
  public String getString() {
    return Variance;
  }

  @Override
  public double getValue() {
    return VarianceValue;
  }

}
