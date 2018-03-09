package Calcul;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Cette classe permet de calculer la moyenne a partir d'une liste
 * 
 * N'utilise pas la variable inputValue
 * 
 */
public class Moyenne implements IMethodeMath {

  private double MoyenneValue;
  private String Moyenne;

  @Override
  public void calculer(List<String> listDonner, double inputValue) {

    double somme = 0;
    double moyenne = 0.0;
    int arraySize = Integer.parseInt(listDonner.get(0));

    try {


      for (int i = 1; i <= arraySize; i++) {
        somme += Integer.parseInt(listDonner.get(i));
      }
      MoyenneValue = (1.0 / (arraySize)) * somme;
    } catch (Exception ex) {

      MoyenneValue = 0.0;
    }

    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(5);
    Moyenne = df.format(MoyenneValue);
  }

  @Override
  public String getString() {
    return Moyenne;
  }

  @Override
  public double getValue() {
    return MoyenneValue;
  }

}

