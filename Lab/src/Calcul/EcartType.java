package Calcul;

import java.text.DecimalFormat;
import java.util.List;


/**
 * Cette classe permet de calculer l'ecart-type a partir d'une liste
 * 
 * Elle utilise la variable input afin de recevoir la variance precedement calculer
 * 
 */
public class EcartType implements IMethodeMath {

  private String EcartType;
  private double EcartTypeValue;

  @Override
  public void calculer(List<String> listDonner, double inputValue) {

    try {
      DecimalFormat df = new DecimalFormat();
      df.setMaximumFractionDigits(2);
      if (inputValue != 0.0)
        EcartTypeValue = sqrt(inputValue);
      else
        EcartTypeValue = 0.0;
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      EcartTypeValue = 0.0;
    }

    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(5);
    EcartType = df.format(EcartTypeValue);
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
    return EcartType;
  }

  @Override
  public double getValue() {
    return EcartTypeValue;
  }

}

